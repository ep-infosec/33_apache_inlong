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

package org.apache.inlong.manager.common.enums;

import org.apache.inlong.manager.common.exceptions.WorkflowException;

/**
 * Logging event status
 */
public enum EventStatus {

    /**
     * Executing
     */
    EXECUTING(0),

    /**
     * Success
     */
    SUCCESS(1),

    /**
     * Failed
     */
    FAILED(-1);

    int status;

    EventStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    EventStatus fromStatus(int status) {
        switch (status) {
            case 0:
                return EXECUTING;
            case 1:
                return SUCCESS;
            case -1:
                return FAILED;
            default:
                throw new WorkflowException("unknown status: " + status);
        }
    }
}
