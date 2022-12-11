/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements. See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License. You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package org.apache.inlong.sort.iceberg.sink.multiple;

import org.apache.flink.api.common.state.ListState;
import org.apache.flink.api.common.state.ListStateDescriptor;
import org.apache.flink.api.common.typeinfo.TypeHint;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.runtime.state.FunctionInitializationContext;
import org.apache.flink.runtime.state.FunctionSnapshotContext;
import org.apache.flink.streaming.api.checkpoint.CheckpointedFunction;
import org.apache.flink.streaming.api.operators.BoundedOneInput;
import org.apache.flink.table.data.RowData;
import org.apache.flink.table.types.logical.RowType;
import org.apache.iceberg.FileFormat;
import org.apache.iceberg.Schema;
import org.apache.iceberg.Table;
import org.apache.iceberg.catalog.Catalog;
import org.apache.iceberg.catalog.TableIdentifier;
import org.apache.iceberg.flink.CatalogLoader;
import org.apache.iceberg.flink.FlinkSchemaUtil;
import org.apache.iceberg.flink.sink.TaskWriterFactory;
import org.apache.iceberg.types.Types.NestedField;
import org.apache.iceberg.util.PropertyUtil;
import org.apache.inlong.sort.base.dirty.DirtyOptions;
import org.apache.inlong.sort.base.dirty.sink.DirtySink;
import org.apache.inlong.sort.base.metric.MetricOption;
import org.apache.inlong.sort.base.metric.MetricOption.RegisteredMetric;
import org.apache.inlong.sort.base.metric.MetricState;
import org.apache.inlong.sort.base.metric.SinkMetricData;
import org.apache.inlong.sort.base.util.MetricStateUtils;
import org.apache.inlong.sort.base.sink.MultipleSinkOption;
import org.apache.inlong.sort.iceberg.sink.RowDataTaskWriterFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;
import java.io.Closeable;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import static org.apache.iceberg.TableProperties.DEFAULT_FILE_FORMAT;
import static org.apache.iceberg.TableProperties.DEFAULT_FILE_FORMAT_DEFAULT;
import static org.apache.iceberg.TableProperties.UPSERT_ENABLED;
import static org.apache.iceberg.TableProperties.UPSERT_ENABLED_DEFAULT;
import static org.apache.iceberg.TableProperties.WRITE_TARGET_FILE_SIZE_BYTES;
import static org.apache.iceberg.TableProperties.WRITE_TARGET_FILE_SIZE_BYTES_DEFAULT;
import static org.apache.inlong.sort.base.Constants.INLONG_METRIC_STATE_NAME;
import static org.apache.inlong.sort.base.Constants.NUM_BYTES_OUT;
import static org.apache.inlong.sort.base.Constants.NUM_RECORDS_OUT;

/**
 * Iceberg writer that can distinguish different sink tables and route and distribute data into different
 * IcebergStreamWriter.
 */
public class IcebergMultipleStreamWriter extends IcebergProcessFunction<RecordWithSchema, MultipleWriteResult>
        implements
            CheckpointedFunction,
            BoundedOneInput {

    private static final Logger LOG = LoggerFactory.getLogger(IcebergMultipleStreamWriter.class);

    private final boolean appendMode;
    private final CatalogLoader catalogLoader;
    private final MultipleSinkOption multipleSinkOption;

    private transient Catalog catalog;
    private transient Map<TableIdentifier, IcebergSingleStreamWriter<RowData>> multipleWriters;
    private transient Map<TableIdentifier, Table> multipleTables;
    private transient Map<TableIdentifier, Schema> multipleSchemas;
    private transient FunctionInitializationContext functionInitializationContext;

    // metric
    private final String inlongMetric;
    private final String auditHostAndPorts;
    @Nullable
    private transient SinkMetricData metricData;
    private transient ListState<MetricState> metricStateListState;
    private transient MetricState metricState;
    private final DirtyOptions dirtyOptions;
    private @Nullable final DirtySink<Object> dirtySink;

    public IcebergMultipleStreamWriter(
            boolean appendMode,
            CatalogLoader catalogLoader,
            String inlongMetric,
            String auditHostAndPorts,
            MultipleSinkOption multipleSinkOption,
            DirtyOptions dirtyOptions,
            @Nullable DirtySink<Object> dirtySink) {
        this.appendMode = appendMode;
        this.catalogLoader = catalogLoader;
        this.inlongMetric = inlongMetric;
        this.auditHostAndPorts = auditHostAndPorts;
        this.multipleSinkOption = multipleSinkOption;
        this.dirtyOptions = dirtyOptions;
        this.dirtySink = dirtySink;
    }

    @Override
    public void open(Configuration parameters) throws Exception {
        this.catalog = catalogLoader.loadCatalog();
        this.multipleWriters = new HashMap<>();
        this.multipleTables = new HashMap<>();
        this.multipleSchemas = new HashMap<>();

        // Initialize metric
        MetricOption metricOption = MetricOption.builder()
                .withInlongLabels(inlongMetric)
                .withInlongAudit(auditHostAndPorts)
                .withInitRecords(metricState != null ? metricState.getMetricValue(NUM_RECORDS_OUT) : 0L)
                .withInitBytes(metricState != null ? metricState.getMetricValue(NUM_BYTES_OUT) : 0L)
                .withRegisterMetric(RegisteredMetric.ALL)
                .build();
        if (metricOption != null) {
            metricData = new SinkMetricData(metricOption, getRuntimeContext().getMetricGroup());
        }
    }

    @Override
    public void close() throws Exception {
        if (catalog instanceof Closeable) {
            ((Closeable) catalog).close();
        }
    }

    @Override
    public void endInput() throws Exception {
        for (Entry<TableIdentifier, IcebergSingleStreamWriter<RowData>> entry : multipleWriters.entrySet()) {
            entry.getValue().endInput();
        }
    }

    @Override
    public void dispose() throws Exception {
        super.dispose();
        for (Entry<TableIdentifier, IcebergSingleStreamWriter<RowData>> entry : multipleWriters.entrySet()) {
            entry.getValue().dispose();
        }
        multipleWriters.clear();
        multipleTables.clear();
        multipleSchemas.clear();
    }

    @Override
    public void processElement(RecordWithSchema recordWithSchema) throws Exception {
        TableIdentifier tableId = recordWithSchema.getTableId();

        if (isSchemaUpdate(recordWithSchema)) {
            if (multipleTables.get(tableId) == null) {
                Table table = catalog.loadTable(recordWithSchema.getTableId());
                multipleTables.put(tableId, table);
            }

            // refresh some runtime table properties
            Table table = multipleTables.get(recordWithSchema.getTableId());
            Map<String, String> tableProperties = table.properties();
            boolean upsertMode = PropertyUtil.propertyAsBoolean(tableProperties,
                    UPSERT_ENABLED, UPSERT_ENABLED_DEFAULT);
            long targetFileSizeBytes = PropertyUtil.propertyAsLong(tableProperties,
                    WRITE_TARGET_FILE_SIZE_BYTES, WRITE_TARGET_FILE_SIZE_BYTES_DEFAULT);
            String formatString = tableProperties.getOrDefault(DEFAULT_FILE_FORMAT, DEFAULT_FILE_FORMAT_DEFAULT);
            FileFormat fileFormat = FileFormat.valueOf(formatString.toUpperCase(Locale.ENGLISH));
            List<Integer> equalityFieldIds = recordWithSchema.getPrimaryKeys().stream()
                    .map(pk -> recordWithSchema.getSchema().findField(pk).fieldId())
                    .collect(Collectors.toList());
            // if physical primary key not exist, put all field to logical primary key
            if (equalityFieldIds.isEmpty() && multipleSinkOption.isPkAutoGenerated()) {
                equalityFieldIds = recordWithSchema.getSchema().columns().stream()
                        .map(NestedField::fieldId)
                        .collect(Collectors.toList());
            }
            RowType flinkRowType = FlinkSchemaUtil.convert(recordWithSchema.getSchema());
            TaskWriterFactory<RowData> taskWriterFactory = new RowDataTaskWriterFactory(
                    table,
                    recordWithSchema.getSchema(),
                    flinkRowType,
                    targetFileSizeBytes,
                    fileFormat,
                    equalityFieldIds,
                    upsertMode,
                    appendMode);

            if (multipleWriters.get(tableId) == null) {
                IcebergSingleStreamWriter<RowData> writer = new IcebergSingleStreamWriter<>(
                        tableId.toString(), taskWriterFactory, null,
                        null, flinkRowType, dirtyOptions, dirtySink);
                writer.setup(getRuntimeContext(),
                        new CallbackCollector<>(
                                writeResult -> collector.collect(new MultipleWriteResult(tableId, writeResult))),
                        context);
                writer.initializeState(functionInitializationContext);
                writer.open(new Configuration());
                multipleWriters.put(tableId, writer);
            } else { // only if second times schema will evolute
                // Refresh new schema maybe cause previous file writer interrupted, so here should handle it
                multipleWriters.get(tableId).schemaEvolution(taskWriterFactory);
                multipleWriters.get(tableId).setFlinkRowType(flinkRowType);
            }

        }

        if (multipleWriters.get(tableId) != null) {
            for (RowData data : recordWithSchema.getData()) {
                multipleWriters.get(tableId).processElement(data);
                if (metricData != null) {
                    metricData.invokeWithEstimate(data);
                }
            }
        } else {
            LOG.error("Unregistered table schema for {}.", recordWithSchema.getTableId());
        }
    }

    @Override
    public void prepareSnapshotPreBarrier(long checkpointId) throws Exception {
        for (Entry<TableIdentifier, IcebergSingleStreamWriter<RowData>> entry : multipleWriters.entrySet()) {
            entry.getValue().prepareSnapshotPreBarrier(checkpointId);
        }
    }

    @Override
    public void snapshotState(FunctionSnapshotContext context) throws Exception {
        for (Entry<TableIdentifier, IcebergSingleStreamWriter<RowData>> entry : multipleWriters.entrySet()) {
            entry.getValue().snapshotState(context);
        }

        // metric
        if (metricData != null && metricStateListState != null) {
            MetricStateUtils.snapshotMetricStateForSinkMetricData(metricStateListState, metricData,
                    getRuntimeContext().getIndexOfThisSubtask());
        }
    }

    @Override
    public void initializeState(FunctionInitializationContext context) throws Exception {
        this.functionInitializationContext = context;

        // init metric state
        if (this.inlongMetric != null) {
            this.metricStateListState = context.getOperatorStateStore().getUnionListState(
                    new ListStateDescriptor<>(
                            INLONG_METRIC_STATE_NAME, TypeInformation.of(new TypeHint<MetricState>() {
                            })));
        }
        if (context.isRestored()) {
            metricState = MetricStateUtils.restoreMetricState(metricStateListState,
                    getRuntimeContext().getIndexOfThisSubtask(), getRuntimeContext().getNumberOfParallelSubtasks());
        }
    }

    private boolean isSchemaUpdate(RecordWithSchema recordWithSchema) {
        TableIdentifier tableId = recordWithSchema.getTableId();
        recordWithSchema.replaceSchema();
        if (multipleSchemas.get(tableId) != null
                && multipleSchemas.get(tableId).sameSchema(recordWithSchema.getSchema())) {
            return false;
        }
        LOG.info("Schema evolution with table {}, old schema: {}, new Schema: {}",
                tableId, multipleSchemas.get(tableId), recordWithSchema.getSchema());
        multipleSchemas.put(recordWithSchema.getTableId(), recordWithSchema.getSchema());
        return true;
    }
}
