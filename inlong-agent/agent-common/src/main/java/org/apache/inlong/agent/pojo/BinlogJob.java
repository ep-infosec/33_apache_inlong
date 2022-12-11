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

package org.apache.inlong.agent.pojo;

import lombok.Data;

@Data
public class BinlogJob {

    private String user;
    private String password;
    private String hostname;
    private String tableWhiteList;
    private String databaseWhiteList;
    private String ddl;
    private String port;
    private String schema;
    private String serverTimezone;
    private String offsets;

    private Snapshot snapshot;
    private Offset offset;
    private History history;

    @Data
    public static class Offset {

        private String intervalMs;
        private String filename;
        private String specificOffsetFile;
        private String specificOffsetPos;
    }

    @Data
    public static class Snapshot {

        private String mode;
    }

    @Data
    public static class History {

        private String filename;

    }

    @Data
    public static class BinlogJobTaskConfig {

        private String user;
        private String password;
        private String hostname;
        private String port;
        private String includeSchema;

        private String databaseWhiteList;
        private String tableWhiteList;
        private String serverTimezone;
        private String intervalMs;
        private String offsetFilename;
        private String historyFilename;
        private String snapshotMode;
        private String monitoredDdl;
        private String specificOffsetFile;
        private String specificOffsetPos;
    }

}
