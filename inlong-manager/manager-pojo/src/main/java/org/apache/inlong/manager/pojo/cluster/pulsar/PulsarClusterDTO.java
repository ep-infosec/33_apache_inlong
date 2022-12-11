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

package org.apache.inlong.manager.pojo.cluster.pulsar;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.inlong.manager.common.enums.ErrorCodeEnum;
import org.apache.inlong.manager.common.exceptions.BusinessException;
import org.apache.inlong.manager.common.util.JsonUtils;

import javax.validation.constraints.NotNull;

/**
 * Pulsar cluster info
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("Pulsar cluster info")
public class PulsarClusterDTO {

    @ApiModelProperty(value = "Pulsar admin URL, such as: http://127.0.0.1:8080", notes = "Pulsar service URL is the 'url' field of the cluster")
    private String adminUrl;

    @ApiModelProperty(value = "Pulsar tenant, default is 'public'")
    @Builder.Default
    private String tenant = "public";

    @Builder.Default
    private String messageQueueHandler = "org.apache.inlong.dataproxy.sink.mq.pulsar.PulsarHandler";

    private String serviceUrl;

    /**
     * Get the dto instance from the request
     */
    public static PulsarClusterDTO getFromRequest(PulsarClusterRequest request) {
        return PulsarClusterDTO.builder()
                .adminUrl(request.getAdminUrl())
                .tenant(request.getTenant())
                .build();
    }

    /**
     * Get the dto instance from the JSON string.
     */
    public static PulsarClusterDTO getFromJson(@NotNull String extParams) {
        try {
            return JsonUtils.parseObject(extParams, PulsarClusterDTO.class);
        } catch (Exception e) {
            throw new BusinessException(ErrorCodeEnum.CLUSTER_INFO_INCORRECT.getMessage() + ": " + e.getMessage());
        }
    }

}
