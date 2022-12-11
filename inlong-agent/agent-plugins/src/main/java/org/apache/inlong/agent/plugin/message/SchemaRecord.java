/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.inlong.agent.plugin.message;

import io.debezium.document.Document;
import io.debezium.document.DocumentWriter;
import io.debezium.relational.history.HistoryRecord;
import io.debezium.relational.history.TableChanges.TableChange;

import java.io.IOException;

/**
 * The Record represents a schema change event, it contains either one {@link HistoryRecord} or
 * {@link TableChange}.
 */
public class SchemaRecord {

    private final HistoryRecord historyRecord;

    private final Document tableChangeDoc;

    public SchemaRecord(HistoryRecord historyRecord) {
        this.historyRecord = historyRecord;
        this.tableChangeDoc = null;
    }

    public SchemaRecord(Document document) {
        if (this.isHistoryRecordDocument(document)) {
            this.historyRecord = new HistoryRecord(document);
            this.tableChangeDoc = null;
        } else {
            this.tableChangeDoc = document;
            this.historyRecord = null;
        }

    }

    public HistoryRecord getHistoryRecord() {
        return this.historyRecord;
    }

    public Document getTableChangeDoc() {
        return this.tableChangeDoc;
    }

    public boolean isHistoryRecord() {
        return this.historyRecord != null;
    }

    public boolean isTableChangeRecord() {
        return this.tableChangeDoc != null;
    }

    public Document toDocument() {
        return this.historyRecord != null ? this.historyRecord.document() : this.tableChangeDoc;
    }

    public String toString() {
        try {
            return DocumentWriter.defaultWriter().write(this.toDocument());
        } catch (IOException var2) {
            return super.toString();
        }
    }

    private boolean isHistoryRecordDocument(Document document) {
        return (new HistoryRecord(document)).isValid();
    }
}
