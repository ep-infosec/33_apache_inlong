/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.inlong.sort.cdc.mysql.table;

import org.apache.flink.configuration.ConfigOption;
import org.apache.flink.configuration.ReadableConfig;
import org.apache.flink.table.api.ValidationException;
import org.apache.flink.table.catalog.ResolvedSchema;
import org.apache.flink.table.connector.source.DynamicTableSource;
import org.apache.flink.table.factories.DynamicTableSourceFactory;
import org.apache.flink.table.factories.FactoryUtil;
import org.apache.flink.util.Preconditions;
import org.apache.inlong.sort.cdc.debezium.table.DebeziumOptions;
import org.apache.inlong.sort.cdc.mysql.source.config.MySqlSourceOptions;
import org.apache.inlong.sort.cdc.mysql.source.config.ServerIdRange;

import java.time.Duration;
import java.time.ZoneId;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import static org.apache.flink.util.Preconditions.checkState;
import static org.apache.inlong.sort.base.Constants.INLONG_AUDIT;
import static org.apache.inlong.sort.base.Constants.INLONG_METRIC;
import static org.apache.inlong.sort.cdc.debezium.table.DebeziumOptions.getDebeziumProperties;
import static org.apache.inlong.sort.cdc.mysql.source.config.MySqlSourceOptions.APPEND_MODE;
import static org.apache.inlong.sort.cdc.mysql.source.config.MySqlSourceOptions.CHUNK_META_GROUP_SIZE;
import static org.apache.inlong.sort.cdc.mysql.source.config.MySqlSourceOptions.CONNECTION_POOL_SIZE;
import static org.apache.inlong.sort.cdc.mysql.source.config.MySqlSourceOptions.CONNECT_MAX_RETRIES;
import static org.apache.inlong.sort.cdc.mysql.source.config.MySqlSourceOptions.CONNECT_TIMEOUT;
import static org.apache.inlong.sort.cdc.mysql.source.config.MySqlSourceOptions.DATABASE_NAME;
import static org.apache.inlong.sort.cdc.mysql.source.config.MySqlSourceOptions.HEARTBEAT_INTERVAL;
import static org.apache.inlong.sort.cdc.mysql.source.config.MySqlSourceOptions.HOSTNAME;
import static org.apache.inlong.sort.cdc.mysql.source.config.MySqlSourceOptions.MIGRATE_ALL;
import static org.apache.inlong.sort.cdc.mysql.source.config.MySqlSourceOptions.PASSWORD;
import static org.apache.inlong.sort.cdc.mysql.source.config.MySqlSourceOptions.PORT;
import static org.apache.inlong.sort.cdc.mysql.source.config.MySqlSourceOptions.ROW_KINDS_FILTERED;
import static org.apache.inlong.sort.cdc.mysql.source.config.MySqlSourceOptions.SCAN_INCREMENTAL_SNAPSHOT_CHUNK_SIZE;
import static org.apache.inlong.sort.cdc.mysql.source.config.MySqlSourceOptions.SCAN_INCREMENTAL_SNAPSHOT_ENABLED;
import static org.apache.inlong.sort.cdc.mysql.source.config.MySqlSourceOptions.SCAN_NEWLY_ADDED_TABLE_ENABLED;
import static org.apache.inlong.sort.cdc.mysql.source.config.MySqlSourceOptions.SCAN_SNAPSHOT_FETCH_SIZE;
import static org.apache.inlong.sort.cdc.mysql.source.config.MySqlSourceOptions.SCAN_STARTUP_MODE;
import static org.apache.inlong.sort.cdc.mysql.source.config.MySqlSourceOptions.SCAN_STARTUP_SPECIFIC_OFFSET_FILE;
import static org.apache.inlong.sort.cdc.mysql.source.config.MySqlSourceOptions.SCAN_STARTUP_SPECIFIC_OFFSET_POS;
import static org.apache.inlong.sort.cdc.mysql.source.config.MySqlSourceOptions.SCAN_STARTUP_TIMESTAMP_MILLIS;
import static org.apache.inlong.sort.cdc.mysql.source.config.MySqlSourceOptions.SERVER_ID;
import static org.apache.inlong.sort.cdc.mysql.source.config.MySqlSourceOptions.SERVER_TIME_ZONE;
import static org.apache.inlong.sort.cdc.mysql.source.config.MySqlSourceOptions.SPLIT_KEY_EVEN_DISTRIBUTION_FACTOR_LOWER_BOUND;
import static org.apache.inlong.sort.cdc.mysql.source.config.MySqlSourceOptions.SPLIT_KEY_EVEN_DISTRIBUTION_FACTOR_UPPER_BOUND;
import static org.apache.inlong.sort.cdc.mysql.source.config.MySqlSourceOptions.TABLE_NAME;
import static org.apache.inlong.sort.cdc.mysql.source.config.MySqlSourceOptions.USERNAME;
import static org.apache.inlong.sort.cdc.mysql.source.utils.ObjectUtils.doubleCompare;

/**
 * Factory for creating configured instance of {@link MySqlTableSource}.
 */
public class MySqlTableInlongSourceFactory implements DynamicTableSourceFactory {

    private static final String IDENTIFIER = "mysql-cdc-inlong";
    private static final String SCAN_STARTUP_MODE_VALUE_INITIAL = "initial";
    private static final String SCAN_STARTUP_MODE_VALUE_EARLIEST = "earliest-offset";
    private static final String SCAN_STARTUP_MODE_VALUE_LATEST = "latest-offset";
    private static final String SCAN_STARTUP_MODE_VALUE_SPECIFIC_OFFSET = "specific-offset";
    private static final String SCAN_STARTUP_MODE_VALUE_TIMESTAMP = "timestamp";

    private static StartupOptions getStartupOptions(ReadableConfig config) {
        String modeString = config.get(SCAN_STARTUP_MODE);

        switch (modeString.toLowerCase()) {
            case SCAN_STARTUP_MODE_VALUE_INITIAL:
                return StartupOptions.initial();

            case SCAN_STARTUP_MODE_VALUE_LATEST:
                return StartupOptions.latest();

            case SCAN_STARTUP_MODE_VALUE_EARLIEST:
            case SCAN_STARTUP_MODE_VALUE_SPECIFIC_OFFSET:
            case SCAN_STARTUP_MODE_VALUE_TIMESTAMP:
                throw new ValidationException(
                        String.format(
                                "Unsupported option value '%s', the options [%s, %s, %s] "
                                        + "are not supported correctly, "
                                        + "please do not use them until they're correctly supported",
                                modeString,
                                SCAN_STARTUP_MODE_VALUE_EARLIEST,
                                SCAN_STARTUP_MODE_VALUE_SPECIFIC_OFFSET,
                                SCAN_STARTUP_MODE_VALUE_TIMESTAMP));

            default:
                throw new ValidationException(
                        String.format(
                                "Invalid value for option '%s'. Supported values are [%s, %s], but was: %s",
                                SCAN_STARTUP_MODE.key(),
                                SCAN_STARTUP_MODE_VALUE_INITIAL,
                                SCAN_STARTUP_MODE_VALUE_LATEST,
                                modeString));
        }
    }

    @Override
    public DynamicTableSource createDynamicTableSource(Context context) {
        final FactoryUtil.TableFactoryHelper helper =
                FactoryUtil.createTableFactoryHelper(this, context);
        helper.validateExcept(
                DebeziumOptions.DEBEZIUM_OPTIONS_PREFIX, JdbcUrlUtils.PROPERTIES_PREFIX);

        final ReadableConfig config = helper.getOptions();
        final String inlongMetric = config.getOptional(INLONG_METRIC).orElse(null);
        final String inlongAudit = config.get(INLONG_AUDIT);
        final String hostname = config.get(HOSTNAME);
        final String username = config.get(USERNAME);
        final String password = config.get(PASSWORD);
        final String databaseName = config.get(DATABASE_NAME);
        validateRegex(DATABASE_NAME.key(), databaseName);
        final String tableName = config.get(TABLE_NAME);
        validateRegex(TABLE_NAME.key(), tableName);
        int port = config.get(PORT);
        int splitSize = config.get(SCAN_INCREMENTAL_SNAPSHOT_CHUNK_SIZE);
        int splitMetaGroupSize = config.get(CHUNK_META_GROUP_SIZE);
        int fetchSize = config.get(SCAN_SNAPSHOT_FETCH_SIZE);
        ZoneId serverTimeZone = ZoneId.of(config.get(SERVER_TIME_ZONE));

        ResolvedSchema physicalSchema = context.getCatalogTable().getResolvedSchema();
        String serverId = validateAndGetServerId(config);
        StartupOptions startupOptions = getStartupOptions(config);
        Duration connectTimeout = config.get(CONNECT_TIMEOUT);
        int connectMaxRetries = config.get(CONNECT_MAX_RETRIES);
        int connectionPoolSize = config.get(CONNECTION_POOL_SIZE);
        final boolean appendSource = config.get(APPEND_MODE);
        final boolean migrateAll = config.get(MIGRATE_ALL);
        double distributionFactorUpper = config.get(SPLIT_KEY_EVEN_DISTRIBUTION_FACTOR_UPPER_BOUND);
        double distributionFactorLower = config.get(SPLIT_KEY_EVEN_DISTRIBUTION_FACTOR_LOWER_BOUND);
        boolean scanNewlyAddedTableEnabled = config.get(SCAN_NEWLY_ADDED_TABLE_ENABLED);
        Duration heartbeatInterval = config.get(HEARTBEAT_INTERVAL);
        final String rowKindFiltered = config.get(ROW_KINDS_FILTERED).isEmpty()
                ? ROW_KINDS_FILTERED.defaultValue()
                : config.get(ROW_KINDS_FILTERED);
        boolean enableParallelRead = config.get(SCAN_INCREMENTAL_SNAPSHOT_ENABLED);
        if (enableParallelRead) {
            validatePrimaryKeyIfEnableParallel(physicalSchema);
            validateStartupOptionIfEnableParallel(startupOptions);
            validateIntegerOption(SCAN_INCREMENTAL_SNAPSHOT_CHUNK_SIZE, splitSize, 1);
            validateIntegerOption(CHUNK_META_GROUP_SIZE, splitMetaGroupSize, 1);
            validateIntegerOption(SCAN_SNAPSHOT_FETCH_SIZE, fetchSize, 1);
            validateIntegerOption(CONNECTION_POOL_SIZE, connectionPoolSize, 1);
            validateIntegerOption(CONNECT_MAX_RETRIES, connectMaxRetries, 0);
            validateDistributionFactorUpper(distributionFactorUpper);
            validateDistributionFactorLower(distributionFactorLower);
        }

        return new MySqlTableSource(
                physicalSchema,
                port,
                hostname,
                databaseName,
                tableName,
                username,
                password,
                serverTimeZone,
                getDebeziumProperties(context.getCatalogTable().getOptions()),
                serverId,
                enableParallelRead,
                splitSize,
                splitMetaGroupSize,
                fetchSize,
                connectTimeout,
                connectMaxRetries,
                connectionPoolSize,
                distributionFactorUpper,
                distributionFactorLower,
                appendSource,
                startupOptions,
                scanNewlyAddedTableEnabled,
                JdbcUrlUtils.getJdbcProperties(context.getCatalogTable().getOptions()),
                heartbeatInterval,
                migrateAll,
                inlongMetric,
                inlongAudit, rowKindFiltered);
    }

    @Override
    public String factoryIdentifier() {
        return IDENTIFIER;
    }

    @Override
    public Set<ConfigOption<?>> requiredOptions() {
        Set<ConfigOption<?>> options = new HashSet<>();
        options.add(HOSTNAME);
        options.add(USERNAME);
        options.add(PASSWORD);
        options.add(DATABASE_NAME);
        options.add(TABLE_NAME);
        return options;
    }

    @Override
    public Set<ConfigOption<?>> optionalOptions() {
        Set<ConfigOption<?>> options = new HashSet<>();
        options.add(PORT);
        options.add(SERVER_TIME_ZONE);
        options.add(SERVER_ID);
        options.add(SCAN_STARTUP_MODE);
        options.add(SCAN_STARTUP_SPECIFIC_OFFSET_FILE);
        options.add(SCAN_STARTUP_SPECIFIC_OFFSET_POS);
        options.add(SCAN_STARTUP_TIMESTAMP_MILLIS);
        options.add(SCAN_INCREMENTAL_SNAPSHOT_ENABLED);
        options.add(SCAN_INCREMENTAL_SNAPSHOT_CHUNK_SIZE);
        options.add(CHUNK_META_GROUP_SIZE);
        options.add(SCAN_SNAPSHOT_FETCH_SIZE);
        options.add(CONNECT_TIMEOUT);
        options.add(CONNECTION_POOL_SIZE);
        options.add(SPLIT_KEY_EVEN_DISTRIBUTION_FACTOR_UPPER_BOUND);
        options.add(SPLIT_KEY_EVEN_DISTRIBUTION_FACTOR_LOWER_BOUND);
        options.add(CONNECT_MAX_RETRIES);
        options.add(APPEND_MODE);
        options.add(MIGRATE_ALL);
        options.add(SCAN_NEWLY_ADDED_TABLE_ENABLED);
        options.add(HEARTBEAT_INTERVAL);
        options.add(INLONG_METRIC);
        options.add(INLONG_AUDIT);
        options.add(ROW_KINDS_FILTERED);
        return options;
    }

    private void validatePrimaryKeyIfEnableParallel(ResolvedSchema physicalSchema) {
        if (!physicalSchema.getPrimaryKey().isPresent()) {
            throw new ValidationException(
                    String.format(
                            "The primary key is necessary when enable '%s' to 'true'",
                            SCAN_INCREMENTAL_SNAPSHOT_ENABLED));
        }
    }

    private void validateStartupOptionIfEnableParallel(StartupOptions startupOptions) {
        // validate mode
        Preconditions.checkState(
                startupOptions.startupMode == StartupMode.INITIAL
                        || startupOptions.startupMode == StartupMode.LATEST_OFFSET,
                String.format(
                        "MySql Parallel Source only supports startup mode 'initial' and 'latest-offset',"
                                + " but actual is %s",
                        startupOptions.startupMode));
    }

    private String validateAndGetServerId(ReadableConfig configuration) {
        final String serverIdValue = configuration.get(MySqlSourceOptions.SERVER_ID);
        if (serverIdValue != null) {
            // validation
            try {
                ServerIdRange.from(serverIdValue);
            } catch (Exception e) {
                throw new ValidationException(
                        String.format(
                                "The value of option 'server-id' is invalid: '%s'", serverIdValue),
                        e);
            }
        }
        return serverIdValue;
    }

    /**
     * Checks the value of given integer option is valid.
     */
    private void validateIntegerOption(
            ConfigOption<Integer> option, int optionValue, int exclusiveMin) {
        checkState(
                optionValue > exclusiveMin,
                String.format(
                        "The value of option '%s' must larger than %d, but is %d",
                        option.key(), exclusiveMin, optionValue));
    }

    /**
     * Checks the given regular expression's syntax is valid.
     *
     * @param optionName the option name of the regex
     * @param regex The regular expression to be checked
     * @throws ValidationException If the expression's syntax is invalid
     */
    private void validateRegex(String optionName, String regex) {
        try {
            Pattern.compile(regex);
        } catch (Exception e) {
            throw new ValidationException(
                    String.format(
                            "The %s '%s' is not a valid regular expression", optionName, regex),
                    e);
        }
    }

    /**
     * Checks the value of given evenly distribution factor upper bound is valid.
     */
    private void validateDistributionFactorUpper(double distributionFactorUpper) {
        checkState(
                doubleCompare(distributionFactorUpper, 1.0d) >= 0,
                String.format(
                        "The value of option '%s' must larger than or equals %s, but is %s",
                        SPLIT_KEY_EVEN_DISTRIBUTION_FACTOR_UPPER_BOUND.key(),
                        1.0d,
                        distributionFactorUpper));
    }

    /**
     * Checks the value of given evenly distribution factor lower bound is valid.
     */
    private void validateDistributionFactorLower(double distributionFactorLower) {
        checkState(
                doubleCompare(distributionFactorLower, 0.0d) >= 0
                        && doubleCompare(distributionFactorLower, 1.0d) <= 0,
                String.format(
                        "The value of option '%s' must between %s and %s inclusively, but is %s",
                        SPLIT_KEY_EVEN_DISTRIBUTION_FACTOR_LOWER_BOUND.key(),
                        0.0d,
                        1.0d,
                        distributionFactorLower));
    }
}
