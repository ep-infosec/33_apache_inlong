/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.inlong.sort.redis.common.config;

import org.apache.flink.configuration.ConfigOption;
import org.apache.flink.configuration.ConfigOptions;
import org.apache.inlong.sort.redis.common.descriptor.InlongRedisValidator;

/**
 * Redis options
 */
public class RedisOptions {

    /**
     * Redis mode, contains [cluster|sentinel|standalone]
     */
    public static final ConfigOption<String> REDIS_MODE = ConfigOptions
            .key("redis-mode")
            .stringType()
            .defaultValue(InlongRedisValidator.REDIS_STANDALONE)
            .withDescription("Optional redis-mode for connect to redis");
    /**
     * Redis database, used in [sentinel|standalone] redis-mode
     */
    public static final ConfigOption<Integer> DATABASE = ConfigOptions
            .key("database")
            .intType()
            .defaultValue(0)
            .withDescription("Optional database for connect to redis");
    /**
     * Redis command
     */
    public static final ConfigOption<String> COMMAND = ConfigOptions
            .key("command")
            .stringType()
            .noDefaultValue()
            .withDescription("Optional command for connect to redis");
    /**
     * Password used to connect redis
     */
    public static final ConfigOption<String> PASSWORD = ConfigOptions
            .key("password")
            .stringType()
            .noDefaultValue()
            .withDescription("Optional password for connect to redis");
    /**
     * Cluster nodes used to connect redis with cluster mode
     */
    public static final ConfigOption<String> CLUSTER_NODES = ConfigOptions
            .key(InlongRedisValidator.REDIS_NODES)
            .stringType()
            .noDefaultValue()
            .withDescription("Optional nodes for connect to redis cluster");
    /**
     * Whether to ignore delete events
     */
    public static final ConfigOption<Boolean> IGNORE_DELETE = ConfigOptions
            .key("ignore.delete")
            .booleanType()
            .defaultValue(false)
            .withDescription("Ignore delete where receive Retraction");
    /**
     * Additional key used in Hash or Sorted-Set
     */
    public static final ConfigOption<String> ADDITIONAL_KEY = ConfigOptions
            .key("additional.key")
            .stringType()
            .noDefaultValue()
            .withDescription("Optional additional key for connect to redis");
    /**
     * Key ttl
     */
    public static final ConfigOption<Integer> KEY_TTL = ConfigOptions
            .key("key.ttl")
            .intType()
            .noDefaultValue()
            .withDescription("Optional key ttl for connect to redis");
    /**
     * Timeout for connect to redis
     */
    public static final ConfigOption<Integer> TIMEOUT = ConfigOptions
            .key("timeout")
            .intType()
            .defaultValue(2000)
            .withDescription("Optional timeout for connect to redis");
    /**
     * Socket timeout for connect to redis
     */
    public static final ConfigOption<Integer> SOCKET_TIMEOUT = ConfigOptions
            .key("soTimeout")
            .intType()
            .defaultValue(2000)
            .withDescription("Optional soTimeout for redis");
    /**
     * Max total for connect to redis
     */
    public static final ConfigOption<Integer> MAX_TOTAL = ConfigOptions
            .key("maxTotal")
            .intType()
            .defaultValue(2)
            .withDescription("Optional maxTotal for connect to redis");
    /**
     * Max idle for connect to redis
     */
    public static final ConfigOption<Integer> MAXIDLE = ConfigOptions
            .key("maxIdle")
            .intType()
            .defaultValue(2)
            .withDescription("Optional maxIdle for connect to redis");
    /**
     * Min idle for connect to redis
     */
    public static final ConfigOption<Integer> MINIDLE = ConfigOptions
            .key("minIdle")
            .intType()
            .defaultValue(1)
            .withDescription("Optional minIdle for connect to redis");
    /**
     * Port for connect to redis used in standalone mode
     */
    public static final ConfigOption<Integer> PORT = ConfigOptions
            .key("port")
            .intType()
            .defaultValue(6379)
            .withDescription("Optional port for connect to redis");
    /**
     * Port for connect to redis used in standalone mode
     */
    public static final ConfigOption<String> HOST = ConfigOptions
            .key("host")
            .stringType()
            .noDefaultValue()
            .withDescription("Optional host for connect to redis");
    /**
     * Redis master name for connect to redis used in sentinel mode
     */
    public static final ConfigOption<String> REDIS_MASTER_NAME = ConfigOptions
            .key("master.name")
            .stringType()
            .noDefaultValue()
            .withDescription("Optional master.name for connect to redis sentinels");
    /**
     * Sentinels info for connect to redis used in sentinel mode
     */
    public static final ConfigOption<String> SENTINELS_INFO = ConfigOptions
            .key("sentinels.info")
            .stringType()
            .noDefaultValue()
            .withDescription("Optional sentinels.info for connect to redis sentinels");

    /**
     * Lookup cache max rows
     */
    public static final ConfigOption<Long> LOOKUP_CACHE_MAX_ROWS =
            ConfigOptions.key("lookup.cache.max-rows")
                    .longType()
                    .defaultValue(-1L)
                    .withDescription(
                            "The max number of rows of lookup cache, over this value, the oldest rows will "
                                    + "be eliminated. \"cache.max-rows\" and \"cache.ttl\" "
                                    + "options must all be specified if any of them is "
                                    + "specified.");
    /**
     * Lookup cache ttl
     */
    public static final ConfigOption<Long> LOOKUP_CACHE_TTL =
            ConfigOptions.key("lookup.cache.ttl")
                    .longType()
                    .defaultValue(10000L)
                    .withDescription("The cache time to live.");
    /**
     * Lookup max retries
     */
    public static final ConfigOption<Integer> LOOKUP_MAX_RETRIES =
            ConfigOptions.key("lookup.max-retries")
                    .intType()
                    .defaultValue(3)
                    .withDescription("The max retry times if lookup database failed.");
    /**
     * Lookup async
     */
    public static final ConfigOption<Boolean> LOOKUP_ASYNC =
            ConfigOptions.key("lookup.async")
                    .booleanType()
                    .defaultValue(false)
                    .withDescription("whether to set async lookup.");

    private RedisOptions() {
    }

}