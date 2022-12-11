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

package org.apache.inlong.sort.protocol.transformation.function;

import com.google.common.base.Preconditions;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonCreator;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonTypeName;
import org.apache.inlong.sort.protocol.FieldInfo;
import org.apache.inlong.sort.protocol.transformation.FunctionParam;
import org.apache.inlong.sort.protocol.transformation.StringConstantParam;
import org.apache.inlong.sort.protocol.transformation.TimeUnitConstantParam;
import org.apache.inlong.sort.protocol.transformation.TimeWindowFunction;

import java.util.Arrays;
import java.util.List;

/**
 * return hop end of a time window function
 */
@JsonTypeName("hopEnd")
@Data
@NoArgsConstructor
public class HopEndFunction implements TimeWindowFunction {

    @JsonProperty("timeAttr")
    private FieldInfo timeAttr;
    @JsonProperty("interval")
    private StringConstantParam interval;
    @JsonProperty("timeUnit")
    private TimeUnitConstantParam timeUnit;

    @JsonCreator
    public HopEndFunction(@JsonProperty("timeAttr") FieldInfo timeAttr,
            @JsonProperty("interval") StringConstantParam interval,
            @JsonProperty("timeUnit") TimeUnitConstantParam timeUnit) {
        this.timeAttr = Preconditions.checkNotNull(timeAttr, "timeAttr is null");
        this.interval = Preconditions.checkNotNull(interval, "interval is null");
        this.timeUnit = Preconditions.checkNotNull(timeUnit, "timeUnit is null");
    }

    @Override
    public String format() {
        return String.format("%s(%s, INTERVAL %s %s)", getName(),
                timeAttr.format(), interval.format(), timeUnit.format());
    }

    @Override
    public List<FunctionParam> getParams() {
        return Arrays.asList(timeAttr, interval, timeUnit);
    }

    @Override
    public String getName() {
        return "HOP_END";
    }

}
