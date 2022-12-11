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

package org.apache.inlong.tubemq.server.common.fileconfig;

public class ZKMetaConfig extends ZKConfig {

    private long zkMasterCheckPeriodMs = 5000L;

    public ZKMetaConfig() {

    }

    public long getZkMasterCheckPeriodMs() {
        return zkMasterCheckPeriodMs;
    }

    public void setZkMasterCheckPeriodMs(long zkMasterCheckPeriodMs) {
        this.zkMasterCheckPeriodMs = zkMasterCheckPeriodMs;
    }

    @Override
    public String toString() {
        return new StringBuilder(512)
                .append("\"ZKMetaConfig\":{\"zkServerAddr\":\"").append(getZkServerAddr())
                .append("\",\"zkNodeRoot\":\"").append(getZkNodeRoot())
                .append("\",\"zkSessionTimeoutMs\":").append(getZkSessionTimeoutMs())
                .append(",\"zkConnectionTimeoutMs\":").append(getZkConnectionTimeoutMs())
                .append(",\"zkSyncTimeMs\":").append(getZkSyncTimeMs())
                .append(",\"zkCommitPeriodMs\":").append(getZkCommitPeriodMs())
                .append(",\"zkCommitFailRetries\":").append(getZkCommitFailRetries())
                .append(",\"zkMasterCheckPeriodMs\":").append(zkMasterCheckPeriodMs)
                .append(",\"zkRequestTimeoutMs\":").append(getZkRequestTimeoutMs())
                .append("}").toString();
    }
}
