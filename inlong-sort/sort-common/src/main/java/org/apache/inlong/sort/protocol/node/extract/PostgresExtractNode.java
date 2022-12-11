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

package org.apache.inlong.sort.protocol.node.extract;

import com.google.common.base.Preconditions;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.StringUtils;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonCreator;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonTypeName;
import org.apache.inlong.common.enums.MetaField;
import org.apache.inlong.sort.protocol.FieldInfo;
import org.apache.inlong.sort.protocol.InlongMetric;
import org.apache.inlong.sort.protocol.Metadata;
import org.apache.inlong.sort.protocol.constant.PostgresConstant;
import org.apache.inlong.sort.protocol.node.ExtractNode;
import org.apache.inlong.sort.protocol.transformation.WatermarkField;

import java.io.Serializable;
import java.util.EnumSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * Postgres extract node for extract data from postgres
 */
@EqualsAndHashCode(callSuper = true)
@JsonTypeName("postgresExtract")
@Data
public class PostgresExtractNode extends ExtractNode implements Metadata, InlongMetric, Serializable {

    private static final long serialVersionUID = 1L;
    @JsonProperty("primaryKey")
    private String primaryKey;
    @JsonProperty("tableNames")
    private List<String> tableNames;
    @JsonProperty("hostname")
    private String hostname;
    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
    private String password;
    @JsonProperty("database")
    private String database;
    @JsonProperty("schema")
    private String schema;
    @JsonProperty("port")
    private Integer port;
    @JsonProperty("decodingPluginName")
    private String decodingPluginName;

    @JsonCreator
    public PostgresExtractNode(@JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("fields") List<FieldInfo> fields,
            @JsonProperty("watermark_field") WatermarkField watermarkField,
            @JsonProperty("properties") Map<String, String> properties,
            @JsonProperty("primaryKey") String primaryKey,
            @JsonProperty("tableNames") List<String> tableNames,
            @JsonProperty("hostname") String hostname,
            @JsonProperty("username") String username,
            @JsonProperty("password") String password,
            @JsonProperty("database") String database,
            @JsonProperty("schema") String schema,
            @JsonProperty("port") Integer port,
            @JsonProperty("decodingPluginName") String decodingPluginName) {
        super(id, name, fields, watermarkField, properties);
        this.primaryKey = primaryKey;
        this.tableNames = Preconditions.checkNotNull(tableNames, "tableNames is null");
        this.hostname = Preconditions.checkNotNull(hostname, "hostname is null");
        this.username = Preconditions.checkNotNull(username, "username is null");
        this.password = Preconditions.checkNotNull(password, "password is null");
        this.database = Preconditions.checkNotNull(database, "database is null");
        this.schema = Preconditions.checkNotNull(schema, "schema is null");
        this.port = Preconditions.checkNotNull(port, "port is null");
        this.decodingPluginName = decodingPluginName;
    }

    /**
     * generate table options
     *
     * @return options
     * @see <a href="https://ververica.github.io/flink-cdc-connectors/master/content/connectors/postgres-cdc.html">postgres
     * cdc</a>
     */
    @Override
    public Map<String, String> tableOptions() {
        Map<String, String> options = super.tableOptions();
        options.put(PostgresConstant.CONNECTOR, PostgresConstant.POSTGRES_CDC);
        options.put(PostgresConstant.HOSTNAME, hostname);
        options.put(PostgresConstant.USERNAME, username);
        options.put(PostgresConstant.PASSWORD, password);
        options.put(PostgresConstant.DATABASE_NAME, database);
        options.put(PostgresConstant.SCHEMA_NAME, schema);
        options.put(PostgresConstant.PORT, port.toString());
        String formatTable =
                tableNames.size() == 1 ? tableNames.get(0) : String.format("(%s)", StringUtils.join(tableNames, "|"));
        options.put(PostgresConstant.TABLE_NAME, String.format("%s", formatTable));
        String decodingPluginNameOption;
        if (StringUtils.isNotEmpty(decodingPluginName)) {
            decodingPluginNameOption = decodingPluginName;
        } else {
            decodingPluginNameOption = PostgresConstant.PGOUTPUT;
        }
        options.put(PostgresConstant.DECODING_PLUGIN_NAME, decodingPluginNameOption);
        options.put(PostgresConstant.SLOT_NAME, UUID.randomUUID().toString().toLowerCase(Locale.ROOT).replaceAll(
                "[\\-\\d]", ""));
        return options;
    }

    @Override
    public String genTableName() {
        return String.format("table_%s", super.getId());
    }

    @Override
    public String getPrimaryKey() {
        return primaryKey;
    }

    @Override
    public boolean isVirtual(MetaField metaField) {
        return true;
    }

    @Override
    public Set<MetaField> supportedMetaFields() {
        return EnumSet.of(MetaField.PROCESS_TIME, MetaField.TABLE_NAME, MetaField.DATABASE_NAME,
                MetaField.SCHEMA_NAME, MetaField.OP_TS);
    }
}
