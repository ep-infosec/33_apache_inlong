/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.inlong.dataproxy.sink.mqzone.impl.kafkazone;

import org.apache.inlong.dataproxy.sink.mqzone.AbstactZoneWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * KafkaZoneWorker
 */
public class KafkaZoneWorker extends AbstactZoneWorker {

    public static final Logger LOG = LoggerFactory.getLogger(KafkaZoneWorker.class);

    /**
     * Constructor
     * 
     * @param sinkName
     * @param workerIndex
     * @param context
     */
    public KafkaZoneWorker(String sinkName, int workerIndex, KafkaZoneSinkContext context) {
        super(sinkName, workerIndex, context,
                new KafkaZoneProducer(sinkName + "-worker-" + workerIndex, context));

    }

    /**
     * run
     */
    @Override
    public void run() {
        LOG.info(String.format("start KafkaZoneWorker:%s", this.workerName));
        super.run();
    }
}
