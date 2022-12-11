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

package org.apache.inlong.common.enums;

/**
 * Enum of pull job type.
 */
public enum PullJobTypeEnum {

    NEW(0), NEVER(1);

    private final int type;

    PullJobTypeEnum(int type) {
        this.type = type;
    }

    public static PullJobTypeEnum getPullJobType(int type) {
        switch (type) {
            case 0:
                return NEW;
            case 1:
                return NEVER;
            default:
                throw new RuntimeException("such pull job type doesn't exist");
        }
    }

    public int getType() {
        return type;
    }
}
