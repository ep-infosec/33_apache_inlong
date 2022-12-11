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

package org.apache.inlong.dataproxy.dispatch;

import org.apache.inlong.sdk.commons.protocol.ProxySdk.ResultCode;
import org.apache.inlong.sdk.commons.protocol.SourceCallback;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * DispatchProfileCallback
 * 
 */
public class DispatchProfileCallback {

    private AtomicInteger ackingCount;
    private SourceCallback callback;

    /**
     * Constructor
     * @param totalCount
     * @param callback
     */
    public DispatchProfileCallback(int totalCount, SourceCallback callback) {
        this.ackingCount = new AtomicInteger(totalCount);
        this.callback = callback;
    }

    /**
     * ack
     * @param eventCount
     */
    public void ack(int eventCount) {
        int currentCount = this.ackingCount.addAndGet(-eventCount);
        if (currentCount <= 0) {
            this.callback.callback(ResultCode.SUCCUSS);
        }
    }

    /**
     * fail
     */
    public void fail() {
        this.callback.callback(ResultCode.ERR_REJECT);
    }
}
