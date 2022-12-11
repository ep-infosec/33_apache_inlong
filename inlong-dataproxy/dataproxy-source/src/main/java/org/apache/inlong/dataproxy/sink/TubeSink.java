/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.inlong.dataproxy.sink;

import static org.apache.inlong.dataproxy.consts.AttrConstants.SEP_HASHTAG;
import static org.apache.inlong.dataproxy.consts.ConfigConstants.MAX_MONITOR_CNT;

import com.google.common.base.Preconditions;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.collections.SetUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.flume.Channel;
import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.EventDeliveryException;
import org.apache.flume.FlumeException;
import org.apache.flume.Transaction;
import org.apache.flume.conf.Configurable;
import org.apache.flume.sink.AbstractSink;
import org.apache.flume.source.shaded.guava.RateLimiter;
import org.apache.inlong.common.enums.DataProxyErrCode;
import org.apache.inlong.common.metric.MetricRegister;
import org.apache.inlong.common.monitor.LogCounter;
import org.apache.inlong.common.monitor.MonitorIndex;
import org.apache.inlong.common.monitor.MonitorIndexExt;
import org.apache.inlong.common.msg.AttributeConstants;
import org.apache.inlong.common.util.NetworkUtils;
import org.apache.inlong.dataproxy.base.HighPriorityThreadFactory;
import org.apache.inlong.dataproxy.base.SinkRspEvent;
import org.apache.inlong.dataproxy.config.ConfigManager;
import org.apache.inlong.dataproxy.config.holder.ConfigUpdateCallback;
import org.apache.inlong.dataproxy.config.pojo.MQClusterConfig;
import org.apache.inlong.dataproxy.consts.ConfigConstants;
import org.apache.inlong.dataproxy.metrics.DataProxyMetricItemSet;
import org.apache.inlong.dataproxy.metrics.audit.AuditUtils;
import org.apache.inlong.dataproxy.sink.common.MsgDedupHandler;
import org.apache.inlong.dataproxy.sink.common.TubeProducerHolder;
import org.apache.inlong.dataproxy.sink.common.TubeUtils;
import org.apache.inlong.dataproxy.utils.DateTimeUtils;
import org.apache.inlong.dataproxy.utils.FailoverChannelProcessorHolder;
import org.apache.inlong.dataproxy.utils.MessageUtils;
import org.apache.inlong.tubemq.client.exception.TubeClientException;
import org.apache.inlong.tubemq.client.producer.MessageProducer;
import org.apache.inlong.tubemq.client.producer.MessageSentCallback;
import org.apache.inlong.tubemq.client.producer.MessageSentResult;
import org.apache.inlong.tubemq.corebase.TErrCodeConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TubeSink extends AbstractSink implements Configurable {

    private static final Logger logger = LoggerFactory.getLogger(TubeSink.class);
    private static final MsgDedupHandler MSG_DEDUP_HANDLER = new MsgDedupHandler();
    private TubeProducerHolder producerHolder = null;
    private volatile boolean canSend = false;
    private volatile boolean isOverFlow = false;
    private ConfigManager configManager;
    private Map<String, String> topicProperties;
    private MQClusterConfig tubeConfig;
    private String usedMasterAddr = null;
    private Set<String> masterHostAndPortLists;
    // statistic info log
    private int maxMonitorCnt = 300000;
    private int statIntervalSec = 60;
    private MonitorIndex monitorIndex;
    private MonitorIndexExt monitorIndexExt;
    private static final String KEY_SINK_DROPPED = "TUBE_SINK_DROPPED";
    private static final String KEY_SINK_SUCCESS = "TUBE_SINK_SUCCESS";
    private static final String KEY_SINK_FAILURE = "TUBE_SINK_FAILURE";
    private static final String KEY_SINK_EXP = "TUBE_SINK_EXP";
    // used for RoundRobin different cluster while send message
    private RateLimiter diskRateLimiter;
    private Thread[] sinkThreadPool;
    private DataProxyMetricItemSet metricItemSet;
    private final AtomicBoolean started = new AtomicBoolean(false);
    private static final LogCounter LOG_SINK_TASK_PRINTER =
            new LogCounter(10, 100000, 60 * 1000);
    private LinkedBlockingQueue<Event> eventQueue;
    private LinkedBlockingQueue<EventStat> resendQueue;
    private final AtomicLong cachedMsgCnt = new AtomicLong(0);
    private final AtomicLong takenMsgCnt = new AtomicLong(0);
    private final AtomicLong resendMsgCnt = new AtomicLong(0);
    private final AtomicLong blankTopicDiscardMsgCnt = new AtomicLong(0);
    private final AtomicLong frozenTopicDiscardMsgCnt = new AtomicLong(0);
    private final AtomicLong dupDiscardMsgCnt = new AtomicLong(0);
    private final AtomicLong inflightMsgCnt = new AtomicLong(0);
    private final AtomicLong successMsgCnt = new AtomicLong(0);
    // statistic thread
    private static final ScheduledExecutorService SCHEDULED_EXECUTOR_SERVICE = Executors
            .newScheduledThreadPool(1, new HighPriorityThreadFactory("tubeSink-Printer-thread"));

    {
        SCHEDULED_EXECUTOR_SERVICE.scheduleWithFixedDelay(new TubeStatsTask(), 30L,
                60L, TimeUnit.SECONDS);
        logger.info("success to start performance statistic task!");
    }

    @Override
    public void configure(Context context) {
        logger.info(getName() + " configure from context: {}", context);
        // initial parameters
        configManager = ConfigManager.getInstance();
        tubeConfig = configManager.getMqClusterConfig();
        topicProperties = configManager.getTopicProperties();
        masterHostAndPortLists = configManager.getMqClusterUrl2Token().keySet();
        // only use first cluster address now
        usedMasterAddr = getFirstClusterAddr(masterHostAndPortLists);
        // create producer holder
        if (usedMasterAddr != null) {
            producerHolder = new TubeProducerHolder(getName(),
                    usedMasterAddr, configManager.getMqClusterConfig());
        }
        // start message deduplication handler
        MSG_DEDUP_HANDLER.start(tubeConfig.getClientIdCache(),
                tubeConfig.getMaxSurvivedTime(), tubeConfig.getMaxSurvivedSize());
        // get statistic configure items
        maxMonitorCnt = context.getInteger(MAX_MONITOR_CNT, 300000);
        statIntervalSec = tubeConfig.getStatIntervalSec();
        Preconditions.checkArgument(statIntervalSec >= 0, "statIntervalSec must be >= 0");
        // initial TubeMQ configure
        // initial resend queue size
        int badEventQueueSize = tubeConfig.getBadEventQueueSize();
        Preconditions.checkArgument(badEventQueueSize > 0, "badEventQueueSize must be > 0");
        resendQueue = new LinkedBlockingQueue<>(badEventQueueSize);
        // initial sink thread pool
        int threadNum = tubeConfig.getThreadNum();
        Preconditions.checkArgument(threadNum > 0, "threadNum must be > 0");
        sinkThreadPool = new Thread[threadNum];
        // initial event queue size
        int eventQueueSize = tubeConfig.getEventQueueSize();
        Preconditions.checkArgument(eventQueueSize > 0, "eventQueueSize must be > 0");
        eventQueue = new LinkedBlockingQueue<>(eventQueueSize);
        // initial disk rate limiter
        if (tubeConfig.getDiskIoRatePerSec() != 0) {
            diskRateLimiter = RateLimiter.create(tubeConfig.getDiskIoRatePerSec());
        }
        // register configure change callback functions
        configManager.getTopicConfig().addUpdateCallback(new ConfigUpdateCallback() {

            @Override
            public void update() {
                diffSetPublish(new HashSet<>(topicProperties.values()),
                        new HashSet<>(configManager.getTopicProperties().values()));
            }
        });
        configManager.getMqClusterHolder().addUpdateCallback(new ConfigUpdateCallback() {

            @Override
            public void update() {
                diffUpdateTubeClient(masterHostAndPortLists,
                        configManager.getMqClusterUrl2Token().keySet());
            }
        });
    }

    @Override
    public void start() {
        if (!this.started.compareAndSet(false, true)) {
            logger.info("Duplicated call, " + getName() + " has started!");
            return;
        }
        // initial monitors
        if (statIntervalSec > 0) {
            // switch for lots of metrics
            monitorIndex = new MonitorIndex("Tube_Sink", statIntervalSec, maxMonitorCnt);
            monitorIndexExt = new MonitorIndexExt("Tube_Sink_monitors#" + this.getName(),
                    statIntervalSec, maxMonitorCnt);
        }
        // register metrics
        ConfigManager configManager = ConfigManager.getInstance();
        String clusterId =
                configManager.getCommonProperties().getOrDefault(
                        ConfigConstants.PROXY_CLUSTER_NAME,
                        ConfigConstants.DEFAULT_PROXY_CLUSTER_NAME);
        this.metricItemSet = new DataProxyMetricItemSet(clusterId, this.getName());
        MetricRegister.register(metricItemSet);
        // create tube connection
        if (producerHolder != null) {
            try {
                producerHolder.start(new HashSet<>(topicProperties.values()));
                ConfigManager.getInstance().updMqClusterStatus(true);
                logger.info("[{}] MQ Cluster service status ready!", getName());
            } catch (FlumeException e) {
                logger.error("Unable to start TubeMQ client. Exception follows.", e);
                super.stop();
                return;
            }
        }
        // start the cleaner thread
        super.start();
        this.canSend = true;
        for (int i = 0; i < sinkThreadPool.length; i++) {
            sinkThreadPool[i] = new Thread(new TubeSinkTask(),
                    getName() + "_tube_sink_sender-" + i);
            sinkThreadPool[i].start();
        }
        logger.info(getName() + " started!");
    }

    @Override
    public void stop() {
        if (!this.started.compareAndSet(true, false)) {
            logger.info("Duplicated call, " + getName() + " has stopped!");
            return;
        }
        // waiting inflight message processed
        int waitCount = 0;
        while (takenMsgCnt.get() > 0 && waitCount++ < 10) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                logger.info("Stop thread has been interrupt!");
                break;
            }
        }
        // close sink thread pool
        if (sinkThreadPool != null) {
            for (Thread thread : sinkThreadPool) {
                if (thread == null) {
                    continue;
                }
                thread.interrupt();
            }
        }
        // close producer holder
        if (producerHolder != null) {
            producerHolder.stop();
        }
        // stop statistic thread stop
        SCHEDULED_EXECUTOR_SERVICE.shutdown();
        // stop monitor index output
        if (statIntervalSec > 0) {
            try {
                monitorIndex.shutDown();
            } catch (Exception e) {
                logger.warn("Stats runner interrupted");
            }
        }
        super.stop();
        logger.info(getName() + " stopped!");
    }

    @Override
    public Status process() throws EventDeliveryException {
        if (!this.started.get()) {
            return Status.BACKOFF;
        }
        Status status = Status.READY;
        Channel channel = getChannel();
        Transaction tx = channel.getTransaction();
        tx.begin();
        try {
            Event event = channel.take();
            if (event != null) {
                if (diskRateLimiter != null) {
                    diskRateLimiter.acquire(event.getBody().length);
                }
                if (eventQueue.offer(event, 3 * 1000, TimeUnit.MILLISECONDS)) {
                    tx.commit();
                    cachedMsgCnt.incrementAndGet();
                } else {
                    tx.rollback();
                }
            } else {
                status = Status.BACKOFF;
                tx.commit();
            }
        } catch (Throwable t) {
            logger.error("Process event failed!" + this.getName(), t);
            try {
                tx.rollback();
            } catch (Throwable e) {
                logger.error("meta sink transaction rollback exception", e);
            }
        } finally {
            tx.close();
        }
        return status;
    }

    private class TubeSinkTask implements Runnable {

        public TubeSinkTask() {
            // ignore
        }

        @Override
        public void run() {
            Event event = null;
            EventStat es = null;
            String topic = null;
            boolean bChangedInflightValue = false;
            logger.info("sink task {} started.", Thread.currentThread().getName());
            while (canSend) {
                try {
                    if (!started.get() && cachedMsgCnt.get() <= 0) {
                        logger.info("Found started is false and taken message count is zero, braek!");
                        break;
                    }
                    if (isOverFlow) {
                        isOverFlow = false;
                        Thread.sleep(30);
                    }
                    // get event from queues
                    if (resendQueue.isEmpty()) {
                        event = eventQueue.poll(2000, TimeUnit.MILLISECONDS);
                        if (event == null) {
                            continue;
                        }
                        cachedMsgCnt.decrementAndGet();
                        takenMsgCnt.incrementAndGet();
                        es = new EventStat(event);
                    } else {
                        es = resendQueue.poll();
                        if (es == null) {
                            continue;
                        }
                        resendMsgCnt.decrementAndGet();
                        event = es.getEvent();
                    }
                    topic = event.getHeaders().get(ConfigConstants.TOPIC_KEY);
                    // valid event status
                    if (StringUtils.isBlank(topic)) {
                        blankTopicDiscardMsgCnt.incrementAndGet();
                        takenMsgCnt.decrementAndGet();
                        if (statIntervalSec > 0) {
                            monitorIndexExt.incrementAndGet(KEY_SINK_DROPPED);
                        }
                        if (LOG_SINK_TASK_PRINTER.shouldPrint()) {
                            logger.error("No topic specified, just discard the event, event header is "
                                    + event.getHeaders().toString());
                        }
                        continue;
                    }
                    // send message
                    bChangedInflightValue = sendMessage(es, topic);
                } catch (InterruptedException e) {
                    logger.info("Thread {} has been interrupted!", Thread.currentThread().getName());
                    return;
                } catch (Throwable t) {
                    resendEvent(es, bChangedInflightValue,
                            DataProxyErrCode.SEND_REQUEST_TO_MQ_FAILURE, t.getMessage());
                    if (t instanceof TubeClientException) {
                        String message = t.getMessage();
                        if (message != null && (message.contains("No available queue for topic")
                                || message.contains("The brokers of topic are all forbidden"))) {
                            isOverFlow = true;
                        }
                    }
                    if (LOG_SINK_TASK_PRINTER.shouldPrint()) {
                        logger.error(
                                "Sink task fail to send the message, finished = {}, sink.name = {},event.headers= {}",
                                bChangedInflightValue, Thread.currentThread().getName(),
                                es.getEvent().getHeaders(), t);
                    }
                }
            }
            logger.info("sink task {} stopped!", Thread.currentThread().getName());
        }

        private boolean sendMessage(EventStat es, String topic) throws Exception {
            String errMsg = "";
            Event event = es.getEvent();
            MessageProducer producer = producerHolder.getProducer(topic);
            if (producer == null) {
                frozenTopicDiscardMsgCnt.incrementAndGet();
                takenMsgCnt.decrementAndGet();
                if (statIntervalSec > 0) {
                    monitorIndexExt.incrementAndGet(KEY_SINK_DROPPED);
                }
                errMsg = "Get producer failed for " + topic;
                if (MessageUtils.isSinkRspType(event)) {
                    MessageUtils.sinkReturnRspPackage((SinkRspEvent) event,
                            DataProxyErrCode.PRODUCER_IS_NULL, errMsg);
                }
                if (LOG_SINK_TASK_PRINTER.shouldPrint()) {
                    logger.error(errMsg);
                }
                return false;
            }
            if (MSG_DEDUP_HANDLER.judgeDupAndPutMsgSeqId(
                    event.getHeaders().get(ConfigConstants.SEQUENCE_ID))) {
                dupDiscardMsgCnt.incrementAndGet();
                takenMsgCnt.decrementAndGet();
                if (statIntervalSec > 0) {
                    monitorIndexExt.incrementAndGet(KEY_SINK_DROPPED);
                }
                errMsg = "Duplicated message discard, by uuid = "
                        + event.getHeaders().get(ConfigConstants.SEQUENCE_ID);
                if (MessageUtils.isSinkRspType(event)) {
                    MessageUtils.sinkReturnRspPackage((SinkRspEvent) event,
                            DataProxyErrCode.DUPLICATED_MESSAGE, errMsg);
                }
                logger.info("{} agent package {} existed,just discard.",
                        Thread.currentThread().getName(),
                        event.getHeaders().get(ConfigConstants.SEQUENCE_ID));
                return false;
            } else {
                producer.sendMessage(TubeUtils.buildMessage(topic, event), new MyCallback(es));
                inflightMsgCnt.incrementAndGet();
                return true;
            }
        }
    }

    private class MyCallback implements MessageSentCallback {

        private EventStat myEventStat;
        private long sendTime;

        public MyCallback(EventStat eventStat) {
            this.myEventStat = eventStat;
            this.sendTime = System.currentTimeMillis();
        }

        @Override
        public void onMessageSent(final MessageSentResult result) {
            if (result.isSuccess()) {
                successMsgCnt.incrementAndGet();
                inflightMsgCnt.decrementAndGet();
                takenMsgCnt.decrementAndGet();
                this.addStatistics(myEventStat.getEvent(), true, false, sendTime);
                if (MessageUtils.isSinkRspType(myEventStat.getEvent())) {
                    MessageUtils.sinkReturnRspPackage((SinkRspEvent) myEventStat.getEvent(),
                            DataProxyErrCode.SUCCESS, "");
                }
            } else {
                this.addStatistics(myEventStat.getEvent(), false, false, 0);
                if (result.getErrCode() == TErrCodeConstants.FORBIDDEN) {
                    logger.warn("Send message failed, error message: {}, resendQueue size: {}, event:{}",
                            result.getErrMsg(), resendQueue.size(),
                            myEventStat.getEvent().hashCode());
                    return;
                } else if (result.getErrCode() != TErrCodeConstants.SERVER_RECEIVE_OVERFLOW
                        && LOG_SINK_TASK_PRINTER.shouldPrint()) {
                    logger.warn("Send message failed, error message: {}, resendQueue size: {}, event:{}",
                            result.getErrMsg(), resendQueue.size(),
                            myEventStat.getEvent().hashCode());
                }
                resendEvent(myEventStat, true, DataProxyErrCode.MQ_RETURN_ERROR,
                        result.getErrCode() + "#" + result.getErrMsg());
            }
        }

        @Override
        public void onException(final Throwable e) {
            addStatistics(myEventStat.getEvent(), false, true, 0);
            resendEvent(myEventStat, true, DataProxyErrCode.UNKNOWN_ERROR, e.getMessage());
        }

        /**
         * Add statistics information
         *
         * @param event   the statistic event
         * @param isSuccess  is processed successfully
         * @param isException is exception when failure processed
         * @param sendTime   the send time when success processed
         */
        private void addStatistics(Event event, boolean isSuccess,
                boolean isException, long sendTime) {
            if (event == null) {
                return;
            }
            // add jmx metric items;
            TubeSink.this.metricItemSet.fillSinkSendMetricItemsByEvent(
                    event, sendTime, isSuccess, event.getBody().length);
            // add audit items;
            if (isSuccess) {
                AuditUtils.add(AuditUtils.AUDIT_ID_DATAPROXY_SEND_SUCCESS, event);
            }
            if (statIntervalSec <= 0) {
                return;
            }
            // add monitor items base file storage
            String topic = event.getHeaders().get(ConfigConstants.TOPIC_KEY);
            String streamId = event.getHeaders().get(AttributeConstants.STREAM_ID);
            String nodeIp = event.getHeaders().get(ConfigConstants.REMOTE_IP_KEY);
            int intMsgCnt = Integer.parseInt(
                    event.getHeaders().get(ConfigConstants.MSG_COUNTER_KEY));
            long dataTimeL = Long.parseLong(
                    event.getHeaders().get(AttributeConstants.DATA_TIME));
            Pair<Boolean, String> evenProcType =
                    MessageUtils.getEventProcType("", "");
            // build statistic key
            StringBuilder newBase = new StringBuilder(512)
                    .append(getName()).append(SEP_HASHTAG).append(topic)
                    .append(SEP_HASHTAG).append(streamId).append(SEP_HASHTAG)
                    .append(nodeIp).append(SEP_HASHTAG).append(NetworkUtils.getLocalIp())
                    .append(SEP_HASHTAG).append(evenProcType.getRight()).append(SEP_HASHTAG)
                    .append(DateTimeUtils.ms2yyyyMMddHHmm(dataTimeL));
            // count data
            if (isSuccess) {
                monitorIndex.addAndGet(newBase.toString(),
                        intMsgCnt, 1, event.getBody().length, 0);
                monitorIndexExt.incrementAndGet(KEY_SINK_SUCCESS);
            } else {
                monitorIndex.addAndGet(newBase.toString(),
                        0, 0, 0, intMsgCnt);
                monitorIndexExt.incrementAndGet(KEY_SINK_FAILURE);
                if (isException) {
                    monitorIndexExt.incrementAndGet(KEY_SINK_EXP);
                }
            }
        }
    }

    private class TubeStatsTask implements Runnable {

        @Override
        public void run() {
            if (!started.get()) {
                return;
            }
            logger.info(getName() + "[TubeSink Stats] cachedMsgCnt=" + cachedMsgCnt.get()
                    + ", takenMsgCnt=" + takenMsgCnt.get()
                    + ", resendMsgCnt=" + resendMsgCnt.get()
                    + ", blankTopicDiscardMsgCnt=" + blankTopicDiscardMsgCnt.get()
                    + ", frozenTopicDiscardMsgCnt=" + frozenTopicDiscardMsgCnt.get()
                    + ", dupDiscardMsgCnt=" + dupDiscardMsgCnt.get()
                    + ", inflightMsgCnt=" + inflightMsgCnt.get()
                    + ", successMsgCnt=" + successMsgCnt.get());
        }
    }

    /**
     * resend event
     */
    private void resendEvent(EventStat es, boolean sendFinished,
            DataProxyErrCode errCode, String errMsg) {
        try {
            if (sendFinished) {
                inflightMsgCnt.decrementAndGet();
            }
            if (es == null || es.getEvent() == null) {
                takenMsgCnt.decrementAndGet();
                return;
            }
            MSG_DEDUP_HANDLER.invalidMsgSeqId(es.getEvent()
                    .getHeaders().get(ConfigConstants.SEQUENCE_ID));
            if (MessageUtils.isSinkRspType(es.getEvent())) {
                MessageUtils.sinkReturnRspPackage((SinkRspEvent) es.getEvent(), errCode, errMsg);
            } else {
                if (resendQueue.offer(es)) {
                    resendMsgCnt.incrementAndGet();
                } else {
                    FailoverChannelProcessorHolder.getChannelProcessor().processEvent(es.getEvent());
                    takenMsgCnt.decrementAndGet();
                    if (LOG_SINK_TASK_PRINTER.shouldPrint()) {
                        logger.error(Thread.currentThread().getName()
                                + " Channel --> Tube --> ResendQueue(full) -->"
                                + "FailOverChannelProcessor(current code point),"
                                + " Resend queue is full,Check if Tube server or network is ok.");
                    }
                }
            }
        } catch (Throwable throwable) {
            takenMsgCnt.decrementAndGet();
            if (statIntervalSec > 0) {
                monitorIndexExt.incrementAndGet(KEY_SINK_DROPPED);
            }
            if (LOG_SINK_TASK_PRINTER.shouldPrint()) {
                logger.error(getName() + " Discard msg because put events to both of queue and "
                        + "fileChannel fail,current resendQueue.size = "
                        + resendQueue.size(), throwable);
            }
        }
    }

    /**
     * Differentiate unpublished topic sets and publish them
     * attention: only append added topics
     *
     * @param curTopicSet   the current used topic set
     * @param newTopicSet   the latest configured topic set
     */
    private void diffSetPublish(Set<String> curTopicSet, Set<String> newTopicSet) {
        if (!this.started.get()) {
            logger.info(getName() + " not started, ignore this change!");
        }
        if (SetUtils.isEqualSet(curTopicSet, newTopicSet)) {
            return;
        }
        // filter unpublished topics
        Set<String> addedTopics = new HashSet<>();
        for (String topic : newTopicSet) {
            if (StringUtils.isBlank(topic)) {
                continue;
            }
            if (!curTopicSet.contains(topic)) {
                addedTopics.add(topic);
            }
        }
        // publish them
        if (!addedTopics.isEmpty()) {
            if (producerHolder != null) {
                try {
                    producerHolder.createProducersByTopicSet(addedTopics);
                } catch (Throwable e) {
                    logger.info(getName() + "'s publish new topic set fail.", e);
                }
            }
            logger.info(getName() + "'s topics set has changed, trigger diff publish for {}",
                    addedTopics);
            topicProperties = configManager.getTopicProperties();
        }
    }

    /**
     * When masterUrlLists change, update tubeClient
     * Requirement: when switching the Master cluster,
     * the DataProxy node must not do the data reporting service
     *
     * @param curClusterSet previous masterHostAndPortList set
     * @param newClusterSet new masterHostAndPortList set
     */
    private void diffUpdateTubeClient(Set<String> curClusterSet,
            Set<String> newClusterSet) {
        if (!this.started.get()) {
            logger.info(getName() + " not started, ignore this change!");
        }
        if (newClusterSet == null || newClusterSet.isEmpty()
                || SetUtils.isEqualSet(curClusterSet, newClusterSet)
                || newClusterSet.contains(usedMasterAddr)) {
            return;
        }
        String newMasterAddr = getFirstClusterAddr(newClusterSet);
        if (newMasterAddr == null) {
            return;
        }
        TubeProducerHolder newProducerHolder = new TubeProducerHolder(getName(),
                newMasterAddr, configManager.getMqClusterConfig());
        try {
            newProducerHolder.start(new HashSet<>(configManager.getTopicProperties().values()));
        } catch (Throwable e) {
            logger.error(getName() + " create new producer holder for " + newMasterAddr
                    + " failure, throw exception is  {}", e.getMessage());
            return;
        }
        // replace current producer holder
        final String tmpMasterAddr = usedMasterAddr;
        TubeProducerHolder tmpProducerHolder = producerHolder;
        producerHolder = newProducerHolder;
        usedMasterAddr = newMasterAddr;
        // close old producer holder
        if (tmpProducerHolder == null) {
            diffSetPublish(new HashSet<>(),
                    new HashSet<>(configManager.getTopicProperties().values()));
        } else {
            tmpProducerHolder.stop();
        }
        if (!ConfigManager.getInstance().isMqClusterReady()) {
            ConfigManager.getInstance().updMqClusterStatus(true);
            logger.info("[{}] MQ Cluster service status ready!", getName());
        }
        logger.info(getName() + " switch cluster from "
                + tmpMasterAddr + " to " + usedMasterAddr);
    }

    /**
     * Get first cluster address
     *
     * @param clusterSet  cluster set configure
     * @return  the selected cluster address
     *          null if set is empty or if items are all blank
     */
    private String getFirstClusterAddr(Set<String> clusterSet) {
        String tmpMasterAddr = null;
        for (String masterAddr : clusterSet) {
            if (StringUtils.isBlank(masterAddr)) {
                continue;
            }
            tmpMasterAddr = masterAddr;
            break;
        }
        return tmpMasterAddr;
    }
}
