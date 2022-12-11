/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.inlong.sort.elasticsearch;

import org.apache.flink.annotation.PublicEvolving;
import org.apache.flink.api.common.functions.Function;
import org.apache.flink.api.common.functions.RuntimeContext;
import org.apache.flink.runtime.state.FunctionInitializationContext;
import org.apache.flink.runtime.state.FunctionSnapshotContext;
import org.apache.flink.streaming.connectors.elasticsearch.RequestIndexer;
import org.elasticsearch.action.ActionRequest;

import java.io.Serializable;

/**
 * Creates multiple {@link ActionRequest ActionRequests} from an element in a stream.
 *
 * This is used by sinks to prepare elements for sending them to Elasticsearch.
 *
 *
 * @param <T> The type of the element handled by this {@code ElasticsearchSinkFunction}
 */
@PublicEvolving
public interface ElasticsearchSinkFunction<T> extends Serializable, Function {

    /**
     * Initialization method for the function. It is called once before the actual working process
     * methods.
     */
    default void open(RuntimeContext ctx) throws Exception {
    }

    /**
     * Tear-down method for the function. It is called when the sink closes.
     */
    default void close() throws Exception {
    }

    /**
     * Process the incoming element to produce multiple {@link ActionRequest ActionsRequests}. The
     * produced requests should be added to the provided {@link RequestIndexer}.
     *
     * @param element incoming element to process
     * @param ctx runtime context containing information about the sink instance
     * @param indexer request indexer that {@code ActionRequest} should be added to
     */
    void process(T element, RuntimeContext ctx, RequestIndexer indexer);

    default void initializeState(FunctionInitializationContext context) throws Exception {
        // no initialization needed
    }

    default void snapshotState(FunctionSnapshotContext context) throws Exception {

    }

    default void setRuntimeContext(RuntimeContext ctx) {

    }
}
