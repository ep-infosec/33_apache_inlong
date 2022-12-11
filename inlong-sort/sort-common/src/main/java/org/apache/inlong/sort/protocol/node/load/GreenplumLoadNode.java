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

package org.apache.inlong.sort.protocol.node.load;

import com.google.common.base.Preconditions;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonCreator;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonTypeName;
import org.apache.inlong.sort.protocol.FieldInfo;
import org.apache.inlong.sort.protocol.InlongMetric;
import org.apache.inlong.sort.protocol.constant.PostgresConstant;
import org.apache.inlong.sort.protocol.enums.FilterStrategy;
import org.apache.inlong.sort.protocol.node.LoadNode;
import org.apache.inlong.sort.protocol.transformation.FieldRelation;
import org.apache.inlong.sort.protocol.transformation.FilterFunction;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Greenplum load node can load data into Greenplum
 */
@EqualsAndHashCode(callSuper = true)
@JsonTypeName("greenplumLoad")
@Data
@NoArgsConstructor
public class GreenplumLoadNode extends LoadNode implements InlongMetric, Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * jdbc:postgresql://host:port/database
     */
    @JsonProperty("url")
    private String url;
    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
    private String password;
    @JsonProperty("tableName")
    private String tableName;
    /**
     * Please declare primary key for sink table when query contains update/delete record if your version support
     * upsert. You can change source stream mode is "append" if your version can't support upsert.
     */
    @JsonProperty("primaryKey")
    private String primaryKey;

    @JsonCreator
    public GreenplumLoadNode(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("fields") List<FieldInfo> fields,
            @JsonProperty("fieldRelations") List<FieldRelation> fieldRelations,
            @JsonProperty("filters") List<FilterFunction> filters,
            @JsonProperty("filterStrategy") FilterStrategy filterStrategy,
            @JsonProperty("sinkParallelism") Integer sinkParallelism,
            @JsonProperty("properties") Map<String, String> properties,
            @JsonProperty("url") String url,
            @JsonProperty("username") String username,
            @JsonProperty("password") String password,
            @JsonProperty("tableName") String tableName,
            @JsonProperty("primaryKey") String primaryKey) {
        super(id, name, fields, fieldRelations, filters, filterStrategy, sinkParallelism, properties);
        this.url = Preconditions.checkNotNull(url, "url is null");
        this.username = Preconditions.checkNotNull(username, "username is null");
        this.password = Preconditions.checkNotNull(password, "password is null");
        this.tableName = Preconditions.checkNotNull(tableName, "tableName is null");
        this.primaryKey = primaryKey;
    }

    @Override
    public Map<String, String> tableOptions() {
        Map<String, String> options = super.tableOptions();
        options.put(PostgresConstant.CONNECTOR, PostgresConstant.JDBC_INLONG);
        options.put(PostgresConstant.URL, url);
        options.put("dialect-impl", "org.apache.inlong.sort.jdbc.dialect.GreenplumDialect");
        options.put(PostgresConstant.USERNAME, username);
        options.put(PostgresConstant.PASSWORD, password);
        options.put(PostgresConstant.TABLE_NAME, tableName);
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
}
