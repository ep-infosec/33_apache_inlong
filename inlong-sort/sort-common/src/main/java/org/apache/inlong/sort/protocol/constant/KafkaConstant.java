/*
 *   Licensed to the Apache Software Foundation (ASF) under one
 *   or more contributor license agreements.  See the NOTICE file
 *   distributed with this work for additional information
 *   regarding copyright ownership.  The ASF licenses this file
 *   to you under the Apache License, Version 2.0 (the
 *   "License"); you may not use this file except in compliance
 *   with the License.  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package org.apache.inlong.sort.protocol.constant;

/**
 * kafka option constant
 */
public class KafkaConstant {

    public static final String TOPIC = "topic";

    public static final String PROPERTIES_BOOTSTRAP_SERVERS = "properties.bootstrap.servers";

    public static final String PROPERTIES_GROUP_ID = "properties.group.id";

    public static final String CONNECTOR = "connector";

    public static final String SCAN_STARTUP_MODE = "scan.startup.mode";

    public static final String KAFKA = "kafka-inlong";

    public static final String SCAN_STARTUP_SPECIFIC_OFFSETS = "scan.startup.specific-offsets";

    public static final String SCAN_STARTUP_TIMESTAMP_MILLIS = "scan.startup.timestamp-millis";

    /**
     * upsert-kafka
     *
     * @see <a href="https://nightlies.apache.org/flink/flink-docs-release-1.13/zh/docs/connectors/table/upsert-kafka/">
     *         Upsert Kafka</a>
     */
    public static final String UPSERT_KAFKA = "upsert-kafka-inlong";

    /**
     * The Raw Data Hash Partitioner is used to extract partition from raw data(bytes array):
     * It needs a partitionPattern used to parse the pattern and a format 'canal-jon' or 'debezium-json'
     * to deserialization the raw data(bytes array)
     * This partitioner will extract primary key from raw data as the partition key used hash if the 'partitionPattern'
     * equals 'PRIMARY_KEY' else it will parse partition key from raw data.
     */
    public static final String RAW_HASH = "raw-hash";

    /**
     * The parallelism of sink
     */
    public static final String SINK_PARALLELISM = "sink.parallelism";

    /**
     * Ignore the changelog of sink
     */
    public static final String SINK_IGNORE_CHANGELOG = "sink.ignore.changelog";

    /**
     * The multiple format of sink
     */
    public static final String SINK_MULTIPLE_FORMAT = "sink.multiple.format";

    /**
     * The partitioner of sink
     */
    public static final String SINK_PARTITIONER = "sink.partitioner";

    /**
     * The topic pattern of sink
     */
    public static final String TOPIC_PATTERN = "topic-pattern";

    /**
     * The multiple partition pattern of sink
     */
    public static final String SINK_MULTIPLE_PARTITION_PATTERN = "sink.multiple.partition-pattern";
}
