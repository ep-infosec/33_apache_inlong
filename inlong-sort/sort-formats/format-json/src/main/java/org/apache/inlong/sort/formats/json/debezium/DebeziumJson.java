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

package org.apache.inlong.sort.formats.json.debezium;

import io.debezium.relational.history.TableChanges;
import java.util.List;
import java.util.Map;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DebeziumJson {

    private Map<String, String> before;
    private Map<String, Object> after;
    private Source source;
    private TableChanges.TableChange tableChange;
    private long tsMs;
    private String op;

    @Builder
    @Data
    public static class Source {

        private String name;
        private String db;
        private String table;
        private List<String> pkNames;
        private Map<String, Integer> sqlType;
        private Map<String, String> mysqlType;
    }

}
