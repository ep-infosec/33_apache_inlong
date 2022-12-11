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

import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.table.catalog.ResolvedSchema;
import org.apache.flink.table.connector.ChangelogMode;
import org.apache.flink.table.connector.source.DynamicTableSource;
import org.apache.flink.table.connector.source.ScanTableSource;
import org.apache.flink.table.connector.source.SourceFunctionProvider;
import org.apache.flink.table.connector.source.SourceProvider;
import org.apache.flink.table.connector.source.abilities.SupportsReadingMetadata;
import org.apache.flink.table.data.RowData;
import org.apache.flink.table.types.DataType;
import org.apache.flink.table.types.logical.RowType;
import org.apache.flink.types.RowKind;
import org.apache.inlong.sort.cdc.debezium.DebeziumDeserializationSchema;
import org.apache.inlong.sort.cdc.debezium.DebeziumSourceFunction;
import org.apache.inlong.sort.cdc.debezium.table.MetadataConverter;
import org.apache.inlong.sort.cdc.debezium.table.RowDataDebeziumDeserializeSchema;
import org.apache.inlong.sort.base.filter.RowKindValidator;
import org.apache.inlong.sort.cdc.mysql.source.MySqlSource;

import javax.annotation.Nullable;
import java.time.Duration;
import java.time.ZoneId;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.apache.flink.util.Preconditions.checkNotNull;

/**
 * A {@link DynamicTableSource} that describes how to create a MySQL binlog source from a logical
 * description.
 */
public class MySqlTableSource implements ScanTableSource, SupportsReadingMetadata {

    private final ResolvedSchema physicalSchema;
    private final int port;
    private final String hostname;
    private final String database;
    private final String username;
    private final String password;
    private final String serverId;
    private final String tableName;
    private final ZoneId serverTimeZone;
    private final Properties dbzProperties;
    private final boolean enableParallelRead;
    private final int splitSize;
    private final int splitMetaGroupSize;
    private final int fetchSize;
    private final Duration connectTimeout;
    private final int connectionPoolSize;
    private final int connectMaxRetries;
    private final double distributionFactorUpper;
    private final double distributionFactorLower;
    private final StartupOptions startupOptions;
    private final boolean appendSource;
    private final boolean scanNewlyAddedTableEnabled;
    private final String rowKindsFiltered;
    private final Properties jdbcProperties;
    private final Duration heartbeatInterval;
    private final boolean migrateAll;
    private final String inlongMetric;
    private final String inlongAudit;
    // --------------------------------------------------------------------------------------------
    // Mutable attributes
    // --------------------------------------------------------------------------------------------

    /**
     * Data type that describes the final output of the source.
     */
    protected DataType producedDataType;

    /**
     * Metadata that is appended at the end of a physical source row.
     */
    protected List<String> metadataKeys;

    /**
     * Constructor of MySqlTableSource.
     */
    public MySqlTableSource(
            ResolvedSchema physicalSchema,
            int port,
            String hostname,
            String database,
            String tableName,
            String username,
            String password,
            ZoneId serverTimeZone,
            Properties dbzProperties,
            @Nullable String serverId,
            boolean enableParallelRead,
            int splitSize,
            int splitMetaGroupSize,
            int fetchSize,
            Duration connectTimeout,
            int connectMaxRetries,
            int connectionPoolSize,
            double distributionFactorUpper,
            double distributionFactorLower,
            boolean appendSource,
            StartupOptions startupOptions,
            Duration heartbeatInterval,
            boolean migrateAll,
            String inlongMetric,
            String inlongAudit,
            String rowKindsFiltered) {
        this(
                physicalSchema,
                port,
                hostname,
                database,
                tableName,
                username,
                password,
                serverTimeZone,
                dbzProperties,
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
                false,
                new Properties(),
                heartbeatInterval,
                migrateAll,
                inlongMetric,
                inlongAudit,
                rowKindsFiltered);
    }

    /**
     * Constructor of MySqlTableSource.
     */
    public MySqlTableSource(
            ResolvedSchema physicalSchema,
            int port,
            String hostname,
            String database,
            String tableName,
            String username,
            String password,
            ZoneId serverTimeZone,
            Properties dbzProperties,
            @Nullable String serverId,
            boolean enableParallelRead,
            int splitSize,
            int splitMetaGroupSize,
            int fetchSize,
            Duration connectTimeout,
            int connectMaxRetries,
            int connectionPoolSize,
            double distributionFactorUpper,
            double distributionFactorLower,
            boolean appendSource,
            StartupOptions startupOptions,
            boolean scanNewlyAddedTableEnabled,
            Properties jdbcProperties,
            Duration heartbeatInterval,
            boolean migrateAll,
            String inlongMetric,
            String inlongAudit,
            String rowKindsFiltered) {
        this.physicalSchema = physicalSchema;
        this.port = port;
        this.hostname = checkNotNull(hostname);
        this.database = checkNotNull(database);
        this.tableName = checkNotNull(tableName);
        this.username = checkNotNull(username);
        this.password = checkNotNull(password);
        this.serverId = serverId;
        this.serverTimeZone = serverTimeZone;
        this.dbzProperties = dbzProperties;
        this.enableParallelRead = enableParallelRead;
        this.splitSize = splitSize;
        this.splitMetaGroupSize = splitMetaGroupSize;
        this.fetchSize = fetchSize;
        this.connectTimeout = connectTimeout;
        this.connectMaxRetries = connectMaxRetries;
        this.connectionPoolSize = connectionPoolSize;
        this.distributionFactorUpper = distributionFactorUpper;
        this.distributionFactorLower = distributionFactorLower;
        this.startupOptions = startupOptions;
        this.appendSource = appendSource;
        this.scanNewlyAddedTableEnabled = scanNewlyAddedTableEnabled;
        this.jdbcProperties = jdbcProperties;
        // Mutable attributes
        this.producedDataType = physicalSchema.toPhysicalRowDataType();
        this.metadataKeys = Collections.emptyList();
        this.heartbeatInterval = heartbeatInterval;
        this.migrateAll = migrateAll;
        this.inlongMetric = inlongMetric;
        this.inlongAudit = inlongAudit;
        this.rowKindsFiltered = rowKindsFiltered;
    }

    @Override
    public ChangelogMode getChangelogMode() {
        final ChangelogMode.Builder builder =
                ChangelogMode.newBuilder().addContainedKind(RowKind.INSERT);
        if (!appendSource) {
            builder.addContainedKind(RowKind.UPDATE_BEFORE)
                    .addContainedKind(RowKind.UPDATE_AFTER)
                    .addContainedKind(RowKind.DELETE);
        }
        return builder.build();
    }

    @Override
    public ScanRuntimeProvider getScanRuntimeProvider(ScanContext scanContext) {
        RowType physicalDataType =
                (RowType) physicalSchema.toPhysicalRowDataType().getLogicalType();
        MetadataConverter[] metadataConverters = getMetadataConverters(physicalDataType);
        final TypeInformation<RowData> typeInfo =
                scanContext.createTypeInformation(producedDataType);

        DebeziumDeserializationSchema<RowData> deserializer =
                RowDataDebeziumDeserializeSchema.newBuilder()
                        .setPhysicalRowType(physicalDataType)
                        .setMetadataConverters(metadataConverters)
                        .setResultTypeInfo(typeInfo)
                        .setServerTimeZone(serverTimeZone)
                        .setAppendSource(appendSource)
                        .setValidator(new RowKindValidator(rowKindsFiltered))
                        .setUserDefinedConverterFactory(
                                MySqlDeserializationConverterFactory.instance())
                        .setMigrateAll(migrateAll)
                        .build();
        if (enableParallelRead) {
            MySqlSource<RowData> parallelSource =
                    MySqlSource.<RowData>builder()
                            .hostname(hostname)
                            .port(port)
                            .databaseList(database)
                            .tableList(tableName)
                            .username(username)
                            .password(password)
                            .serverTimeZone(serverTimeZone.toString())
                            .serverId(serverId)
                            .splitSize(splitSize)
                            .splitMetaGroupSize(splitMetaGroupSize)
                            .distributionFactorUpper(distributionFactorUpper)
                            .distributionFactorLower(distributionFactorLower)
                            .fetchSize(fetchSize)
                            .connectTimeout(connectTimeout)
                            .connectMaxRetries(connectMaxRetries)
                            .connectionPoolSize(connectionPoolSize)
                            .debeziumProperties(dbzProperties)
                            .startupOptions(startupOptions)
                            .deserializer(deserializer)
                            .scanNewlyAddedTableEnabled(scanNewlyAddedTableEnabled)
                            .jdbcProperties(jdbcProperties)
                            .heartbeatInterval(heartbeatInterval)
                            .inlongMetric(inlongMetric)
                            .inlongAudit(inlongAudit)
                            .build();
            return SourceProvider.of(parallelSource);
        } else {
            org.apache.inlong.sort.cdc.mysql.MySqlSource.Builder<RowData> builder =
                    org.apache.inlong.sort.cdc.mysql.MySqlSource.<RowData>builder()
                            .hostname(hostname)
                            .port(port)
                            .databaseList(database)
                            .tableList(tableName)
                            .username(username)
                            .password(password)
                            .serverTimeZone(serverTimeZone.toString())
                            .debeziumProperties(dbzProperties)
                            .startupOptions(startupOptions)
                            .inlongMetric(inlongMetric)
                            .inlongAudit(inlongAudit)
                            .migrateAll(migrateAll)
                            .deserializer(deserializer);
            Optional.ofNullable(serverId)
                    .ifPresent(serverId -> builder.serverId(Integer.parseInt(serverId)));
            DebeziumSourceFunction<RowData> sourceFunction = builder.build();
            return SourceFunctionProvider.of(sourceFunction, false);
        }
    }

    protected MetadataConverter[] getMetadataConverters(RowType physicalDataType) {
        if (metadataKeys.isEmpty()) {
            return new MetadataConverter[0];
        }

        return metadataKeys.stream()
                .map(
                        key -> Stream.of(MySqlReadableMetadata.values())
                                .filter(m -> m.getKey().equals(key))
                                .findFirst()
                                .orElseThrow(IllegalStateException::new))
                .map(
                        m -> m == MySqlReadableMetadata.OLD
                                ? new OldFieldMetadataConverter(
                                        physicalDataType, serverTimeZone)
                                : m.getConverter())
                .toArray(MetadataConverter[]::new);
    }

    @Override
    public Map<String, DataType> listReadableMetadata() {
        return Stream.of(MySqlReadableMetadata.values())
                .collect(
                        Collectors.toMap(
                                MySqlReadableMetadata::getKey, MySqlReadableMetadata::getDataType));
    }

    @Override
    public void applyReadableMetadata(List<String> metadataKeys, DataType producedDataType) {
        this.metadataKeys = metadataKeys;
        this.producedDataType = producedDataType;
    }

    @Override
    public DynamicTableSource copy() {
        MySqlTableSource source =
                new MySqlTableSource(
                        physicalSchema,
                        port,
                        hostname,
                        database,
                        tableName,
                        username,
                        password,
                        serverTimeZone,
                        dbzProperties,
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
                        jdbcProperties,
                        heartbeatInterval,
                        migrateAll,
                        inlongMetric,
                        inlongAudit, rowKindsFiltered);
        source.metadataKeys = metadataKeys;
        source.producedDataType = producedDataType;
        return source;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MySqlTableSource)) {
            return false;
        }
        MySqlTableSource that = (MySqlTableSource) o;
        return port == that.port
                && enableParallelRead == that.enableParallelRead
                && splitSize == that.splitSize
                && splitMetaGroupSize == that.splitMetaGroupSize
                && fetchSize == that.fetchSize
                && distributionFactorUpper == that.distributionFactorUpper
                && distributionFactorLower == that.distributionFactorLower
                && scanNewlyAddedTableEnabled == that.scanNewlyAddedTableEnabled
                && Objects.equals(physicalSchema, that.physicalSchema)
                && Objects.equals(hostname, that.hostname)
                && Objects.equals(database, that.database)
                && Objects.equals(username, that.username)
                && Objects.equals(password, that.password)
                && Objects.equals(serverId, that.serverId)
                && Objects.equals(tableName, that.tableName)
                && Objects.equals(serverTimeZone, that.serverTimeZone)
                && Objects.equals(dbzProperties, that.dbzProperties)
                && Objects.equals(connectTimeout, that.connectTimeout)
                && Objects.equals(connectMaxRetries, that.connectMaxRetries)
                && Objects.equals(connectionPoolSize, that.connectionPoolSize)
                && Objects.equals(startupOptions, that.startupOptions)
                && Objects.equals(producedDataType, that.producedDataType)
                && Objects.equals(metadataKeys, that.metadataKeys)
                && Objects.equals(jdbcProperties, that.jdbcProperties)
                && Objects.equals(inlongMetric, that.inlongMetric)
                && Objects.equals(inlongAudit, that.inlongAudit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                physicalSchema,
                port,
                hostname,
                database,
                username,
                password,
                serverId,
                tableName,
                serverTimeZone,
                dbzProperties,
                enableParallelRead,
                splitSize,
                splitMetaGroupSize,
                fetchSize,
                connectTimeout,
                connectMaxRetries,
                connectionPoolSize,
                distributionFactorUpper,
                distributionFactorLower,
                startupOptions,
                producedDataType,
                metadataKeys,
                scanNewlyAddedTableEnabled,
                jdbcProperties,
                inlongMetric,
                inlongAudit);
    }

    @Override
    public String asSummaryString() {
        return "MySQL-CDC";
    }
}
