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

package org.apache.inlong.agent.common;

import org.apache.inlong.agent.utils.AgentUtils;
import org.apache.inlong.agent.utils.ThreadUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * AgentThreadFactory, used for creating thread.
 */
public class AgentThreadFactory implements ThreadFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(AgentThreadFactory.class);

    private final AtomicInteger mThreadNum = new AtomicInteger(1);

    private final String threadType;

    public AgentThreadFactory(String threadType) {
        this.threadType = threadType;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, threadType + "-running-thread-" + mThreadNum.getAndIncrement());
        if (AgentUtils.enableOOMExit()) {
            t.setUncaughtExceptionHandler(ThreadUtils::threadThrowableHandler);
        }
        LOGGER.debug("{} created", t.getName());
        return t;
    }
}