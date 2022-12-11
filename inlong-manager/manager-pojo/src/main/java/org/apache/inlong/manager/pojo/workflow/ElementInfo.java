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

package org.apache.inlong.manager.pojo.workflow;

import com.google.common.collect.Lists;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.inlong.manager.common.enums.TaskStatus;

import java.util.List;

/**
 * Workflow element info
 */
@Data
@ApiModel("Workflow element info")
public class ElementInfo {

    @ApiModelProperty(value = "Node name")
    private String name;

    @ApiModelProperty(value = "Node display name")
    private String displayName;

    @ApiModelProperty(value = "Approvers name")
    private List<String> approvers;

    @ApiModelProperty(value = "Status of the current node")
    private TaskStatus status;

    @ApiModelProperty(value = "Next approval node")
    private List<ElementInfo> next = Lists.newArrayList();

}
