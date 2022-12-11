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

package org.apache.inlong.agent.plugin.sources;

import org.apache.inlong.agent.conf.JobProfile;
import org.apache.inlong.agent.plugin.Reader;
import org.apache.inlong.agent.plugin.sources.reader.SQLServerReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * SQLServer source
 */
public class SQLServerSource extends AbstractSource {

    private static final Logger logger = LoggerFactory.getLogger(SQLServerSource.class);

    public SQLServerSource() {
    }

    @Override
    public List<Reader> split(JobProfile conf) {
        super.init(conf);
        Reader sqlServerReader = new SQLServerReader();
        List<Reader> readerList = new ArrayList<>();
        readerList.add(sqlServerReader);
        sourceMetric.sourceSuccessCount.incrementAndGet();
        return readerList;
    }
}
