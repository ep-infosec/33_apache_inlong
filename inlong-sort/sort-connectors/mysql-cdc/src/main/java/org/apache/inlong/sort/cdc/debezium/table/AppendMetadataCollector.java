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

package org.apache.inlong.sort.cdc.debezium.table;

import io.debezium.relational.history.TableChanges.TableChange;
import org.apache.flink.annotation.Internal;
import org.apache.flink.table.data.GenericRowData;
import org.apache.flink.table.data.RowData;
import org.apache.flink.table.data.utils.JoinedRowData;
import org.apache.flink.util.Collector;
import org.apache.kafka.connect.source.SourceRecord;

import java.io.Serializable;

/**
 * Emits a row with physical fields and metadata fields.
 */
@Internal
public final class AppendMetadataCollector implements Collector<RowData>, Serializable {

    private static final long serialVersionUID = 1L;

    private final MetadataConverter[] metadataConverters;

    public transient SourceRecord inputRecord;
    public transient Collector<RowData> outputCollector;
    private boolean migrateAll;

    public AppendMetadataCollector(MetadataConverter[] metadataConverters, boolean migrateAll) {
        this.metadataConverters = metadataConverters;
        this.migrateAll = migrateAll;
    }

    public void collect(RowData physicalRow, TableChange tableSchema) {
        GenericRowData metaRow = new GenericRowData(metadataConverters.length);
        for (int i = 0; i < metadataConverters.length; i++) {
            Object meta = metadataConverters[i].read(inputRecord, tableSchema, physicalRow);
            metaRow.setField(i, meta);
        }
        if (migrateAll) {
            // all data are put into meta row, set physicalRow to empty
            physicalRow = new GenericRowData(0);
        }
        RowData outRow = new JoinedRowData(physicalRow.getRowKind(), physicalRow, metaRow);
        outputCollector.collect(outRow);
    }

    @Override
    public void collect(RowData record) {
        collect(record, null);
    }

    @Override
    public void close() {
        // nothing to do
    }
}
