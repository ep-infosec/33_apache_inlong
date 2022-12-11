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

package org.apache.inlong.manager.pojo.group;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Statistics of inlong group status
 */
@Data
@ApiModel("Statistics of inlong group status")
public class InlongGroupCountResponse {

    @ApiModelProperty(value = "Total group number")
    private long totalCount;

    @ApiModelProperty(value = "The quantity to be allocated, which is the number of configuring groups")
    private long waitAssignCount;

    @ApiModelProperty(value = "Amount to be approved")
    private long waitApproveCount;

    @ApiModelProperty(value = "Quantity rejected")
    private long rejectCount;

}
