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

package org.apache.inlong.sort.base.metric;

import org.apache.inlong.sort.base.util.JdbcUrlUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test for validate jdbc url, see https://su18.org/post/jdbc-connection-url-attack/
 */
public class TestUrlValidate {

    @Test
    public void testJdbcUrlValid() {
        final String jdbcUrl = "jdbc:mysql://localhost:8066/dbtest?"
                + "detectCustomCollations=true&autoDeserialize=true";
        final String expectResult = "jdbc:mysql://localhost:8066/dbtest?"
                + "detectCustomCollations=true&autoDeserialize=false";
        Assert.assertEquals(expectResult, JdbcUrlUtils.replaceInvalidUrlProperty(jdbcUrl));

        final String jdbcUrlWithCase = "jdbc:mysql://localhost:8066/dbtest?"
                + "detectCustomCollations=true&autoDeserialize=tRue";
        final String expectResultWithoutCase = "jdbc:mysql://localhost:8066/dbtest?"
                + "detectCustomCollations=true&autoDeserialize=false";
        Assert.assertEquals(expectResultWithoutCase, JdbcUrlUtils.replaceInvalidUrlProperty(jdbcUrlWithCase));

    }

}
