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

package org.apache.inlong.manager.plugin.flink.enums;

/**
 * Constants info, including properties, dataflow info and rest api url info.
 */
public class Constants {

    // properties
    public static final String ADDRESS = "flink.rest.address";

    public static final String PORT = "flink.rest.port";

    public static final String JOB_MANAGER_PORT = "flink.jobmanager.port";

    public static final String PARALLELISM = "flink.parallelism";

    public static final String SAVEPOINT_DIRECTORY = "flink.savepoint.directory";

    public static final String DRAIN = "flink.drain";

    public static final String METRICS_AUDIT_PROXY_HOSTS = "metrics.audit.proxy.hosts";

    // dataflow
    public static final String SOURCE_INFO = "source_info";

    public static final String SINK_INFO = "sink_info";

    public static final String TYPE = "type";

    public static final String ENTRYPOINT_CLASS = "org.apache.inlong.sort.Entrance";

    public static final String INLONG = "INLONG_";

    public static final String RESOURCE_ID = "resource_id";

    // REST API URL
    public static final String JOB_URL = "/jobs";

    public static final String SUSPEND_URL = "/stop";

    public static final String JARS_URL = "/jars";

    public static final String UPLOAD = "/upload";

    public static final String RUN_URL = "/run";

    public static final String SAVEPOINT = "/savepoints";

    public static final String HTTP_URL = "http://";

    public static final String URL_SEPARATOR = "/";

    public static final String SEPARATOR = ":";

}
