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

package org.apache.inlong.sort.cdc.postgres.table;

import com.ververica.cdc.connectors.postgres.table.PostgreSQLReadableMetadata;
import com.ververica.cdc.connectors.postgres.table.PostgresValueValidator;
import com.ververica.cdc.debezium.DebeziumDeserializationSchema;
import com.ververica.cdc.debezium.table.MetadataConverter;
import com.ververica.cdc.debezium.table.RowDataDebeziumDeserializeSchema;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.table.catalog.ResolvedSchema;
import org.apache.flink.table.connector.ChangelogMode;
import org.apache.flink.table.connector.source.DynamicTableSource;
import org.apache.flink.table.connector.source.ScanTableSource;
import org.apache.flink.table.connector.source.SourceFunctionProvider;
import org.apache.flink.table.connector.source.abilities.SupportsReadingMetadata;
import org.apache.flink.table.data.RowData;
import org.apache.flink.table.types.DataType;
import org.apache.flink.table.types.logical.RowType;
import org.apache.flink.types.RowKind;
import org.apache.inlong.sort.cdc.postgres.DebeziumSourceFunction;
import org.apache.inlong.sort.cdc.postgres.PostgreSQLSource;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.apache.flink.util.Preconditions.checkNotNull;

/**
 * A {@link DynamicTableSource} that describes how to create a PostgreSQL source from a logical
 * description.
 */
public class PostgreSQLTableSource implements ScanTableSource, SupportsReadingMetadata {

    private final ResolvedSchema physicalSchema;
    private final int port;
    private final String hostname;
    private final String database;
    private final String schemaName;
    private final String tableName;
    private final String username;
    private final String password;
    private final String pluginName;
    private final String slotName;
    private final Properties dbzProperties;
    private final String inlongMetric;
    private final String inlongAudit;

    // --------------------------------------------------------------------------------------------
    // Mutable attributes
    // --------------------------------------------------------------------------------------------

    /** Data type that describes the final output of the source. */
    protected DataType producedDataType;

    /** Metadata that is appended at the end of a physical source row. */
    protected List<String> metadataKeys;

    public PostgreSQLTableSource(
            ResolvedSchema physicalSchema,
            int port,
            String hostname,
            String database,
            String schemaName,
            String tableName,
            String username,
            String password,
            String pluginName,
            String slotName,
            Properties dbzProperties,
            String inlongMetric,
            String inlongAudit) {
        this.physicalSchema = physicalSchema;
        this.port = port;
        this.hostname = checkNotNull(hostname);
        this.database = checkNotNull(database);
        this.schemaName = checkNotNull(schemaName);
        this.tableName = checkNotNull(tableName);
        this.username = checkNotNull(username);
        this.password = checkNotNull(password);
        this.pluginName = checkNotNull(pluginName);
        this.slotName = slotName;
        this.dbzProperties = dbzProperties;
        this.producedDataType = physicalSchema.toPhysicalRowDataType();
        this.metadataKeys = Collections.emptyList();
        this.inlongMetric = inlongMetric;
        this.inlongAudit = inlongAudit;
    }

    @Override
    public ChangelogMode getChangelogMode() {
        return ChangelogMode.newBuilder()
                .addContainedKind(RowKind.INSERT)
                .addContainedKind(RowKind.UPDATE_BEFORE)
                .addContainedKind(RowKind.UPDATE_AFTER)
                .addContainedKind(RowKind.DELETE)
                .build();
    }

    @Override
    public ScanRuntimeProvider getScanRuntimeProvider(ScanContext scanContext) {
        RowType physicalDataType =
                (RowType) physicalSchema.toPhysicalRowDataType().getLogicalType();
        MetadataConverter[] metadataConverters = getMetadataConverters();
        TypeInformation<RowData> typeInfo = scanContext.createTypeInformation(producedDataType);

        DebeziumDeserializationSchema<RowData> deserializer =
                RowDataDebeziumDeserializeSchema.newBuilder()
                        .setPhysicalRowType(physicalDataType)
                        .setMetadataConverters(metadataConverters)
                        .setResultTypeInfo(typeInfo)
                        .setValueValidator(new PostgresValueValidator(schemaName, tableName))
                        .build();
        DebeziumSourceFunction<RowData> sourceFunction =
                PostgreSQLSource.<RowData>builder()
                        .hostname(hostname)
                        .port(port)
                        .database(database)
                        .schemaList(schemaName)
                        .tableList(schemaName + "." + tableName)
                        .username(username)
                        .password(password)
                        .decodingPluginName(pluginName)
                        .slotName(slotName)
                        .debeziumProperties(dbzProperties)
                        .deserializer(deserializer)
                        .inlongMetric(inlongMetric)
                        .inlongAudit(inlongAudit)
                        .build();
        return SourceFunctionProvider.of(sourceFunction, false);
    }

    private MetadataConverter[] getMetadataConverters() {
        if (metadataKeys.isEmpty()) {
            return new MetadataConverter[0];
        }

        return metadataKeys.stream()
                .map(
                        key -> Stream.of(PostgreSQLReadableMetadata.values())
                                .filter(m -> m.getKey().equals(key))
                                .findFirst()
                                .orElseThrow(IllegalStateException::new))
                .map(PostgreSQLReadableMetadata::getConverter)
                .toArray(MetadataConverter[]::new);
    }

    @Override
    public DynamicTableSource copy() {
        PostgreSQLTableSource source =
                new PostgreSQLTableSource(
                        physicalSchema,
                        port,
                        hostname,
                        database,
                        schemaName,
                        tableName,
                        username,
                        password,
                        pluginName,
                        slotName,
                        dbzProperties,
                        inlongMetric,
                        inlongAudit);
        source.metadataKeys = metadataKeys;
        source.producedDataType = producedDataType;
        return source;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PostgreSQLTableSource that = (PostgreSQLTableSource) o;
        return port == that.port
                && Objects.equals(physicalSchema, that.physicalSchema)
                && Objects.equals(hostname, that.hostname)
                && Objects.equals(database, that.database)
                && Objects.equals(schemaName, that.schemaName)
                && Objects.equals(tableName, that.tableName)
                && Objects.equals(username, that.username)
                && Objects.equals(password, that.password)
                && Objects.equals(pluginName, that.pluginName)
                && Objects.equals(slotName, that.slotName)
                && Objects.equals(dbzProperties, that.dbzProperties)
                && Objects.equals(producedDataType, that.producedDataType)
                && Objects.equals(metadataKeys, that.metadataKeys)
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
                schemaName,
                tableName,
                username,
                password,
                pluginName,
                slotName,
                dbzProperties,
                producedDataType,
                metadataKeys,
                inlongMetric,
                inlongAudit);
    }

    @Override
    public String asSummaryString() {
        return "PostgreSQL-CDC";
    }

    @Override
    public Map<String, DataType> listReadableMetadata() {
        return Stream.of(PostgreSQLReadableMetadata.values())
                .collect(
                        Collectors.toMap(
                                PostgreSQLReadableMetadata::getKey,
                                PostgreSQLReadableMetadata::getDataType));
    }

    @Override
    public void applyReadableMetadata(List<String> metadataKeys, DataType producedDataType) {
        this.metadataKeys = metadataKeys;
        this.producedDataType = producedDataType;
    }
}
