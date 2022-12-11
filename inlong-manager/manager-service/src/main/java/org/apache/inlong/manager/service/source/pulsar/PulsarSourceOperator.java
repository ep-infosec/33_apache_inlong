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

package org.apache.inlong.manager.service.source.pulsar;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.apache.inlong.common.enums.DataTypeEnum;
import org.apache.inlong.manager.common.consts.InlongConstants;
import org.apache.inlong.manager.common.consts.SourceType;
import org.apache.inlong.manager.common.enums.ClusterType;
import org.apache.inlong.manager.common.enums.ErrorCodeEnum;
import org.apache.inlong.manager.common.exceptions.BusinessException;
import org.apache.inlong.manager.common.util.CommonBeanUtils;
import org.apache.inlong.manager.dao.entity.StreamSourceEntity;
import org.apache.inlong.manager.pojo.cluster.ClusterInfo;
import org.apache.inlong.manager.pojo.cluster.pulsar.PulsarClusterInfo;
import org.apache.inlong.manager.pojo.group.InlongGroupInfo;
import org.apache.inlong.manager.pojo.source.SourceRequest;
import org.apache.inlong.manager.pojo.source.StreamSource;
import org.apache.inlong.manager.pojo.source.kafka.KafkaSource;
import org.apache.inlong.manager.pojo.source.pulsar.PulsarSource;
import org.apache.inlong.manager.pojo.source.pulsar.PulsarSourceDTO;
import org.apache.inlong.manager.pojo.source.pulsar.PulsarSourceRequest;
import org.apache.inlong.manager.pojo.stream.InlongStreamInfo;
import org.apache.inlong.manager.pojo.stream.StreamField;
import org.apache.inlong.manager.service.cluster.InlongClusterService;
import org.apache.inlong.manager.service.source.AbstractSourceOperator;
import org.apache.inlong.sort.protocol.enums.PulsarScanStartupMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static org.apache.inlong.manager.common.consts.InlongConstants.DATA_TYPE_RAW_PREFIX;

/**
 * Pulsar stream source operator
 */
@Service
public class PulsarSourceOperator extends AbstractSourceOperator {

    private static final String AUTH_CLASSNAME_KEY = "properties.auth-plugin-classname";
    private static final String AUTH_CLASSNAME_VALUE = "org.apache.pulsar.client.impl.auth.AuthenticationToken";
    private static final String AUTH_PARAMS_KEY = "properties.auth-params";
    // the %s must be replaced by the actual value
    private static final String AUTH_PARAMS_VALUE = "token:%s";

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private InlongClusterService clusterService;

    @Override
    public Boolean accept(String sourceType) {
        return SourceType.PULSAR.equals(sourceType);
    }

    @Override
    protected String getSourceType() {
        return SourceType.PULSAR;
    }

    @Override
    protected void setTargetEntity(SourceRequest request, StreamSourceEntity targetEntity) {
        PulsarSourceRequest sourceRequest = (PulsarSourceRequest) request;
        CommonBeanUtils.copyProperties(sourceRequest, targetEntity, true);
        try {
            PulsarSourceDTO dto = PulsarSourceDTO.getFromRequest(sourceRequest);
            targetEntity.setExtParams(objectMapper.writeValueAsString(dto));
        } catch (Exception e) {
            throw new BusinessException(ErrorCodeEnum.SOURCE_INFO_INCORRECT.getMessage() + ": " + e.getMessage());
        }
    }

    @Override
    public StreamSource getFromEntity(StreamSourceEntity entity) {
        PulsarSource source = new PulsarSource();
        if (entity == null) {
            return source;
        }

        PulsarSourceDTO dto = PulsarSourceDTO.getFromJson(entity.getExtParams());
        CommonBeanUtils.copyProperties(entity, source, true);
        CommonBeanUtils.copyProperties(dto, source, true);

        List<StreamField> sourceFields = super.getSourceFields(entity.getId());
        source.setFieldList(sourceFields);
        return source;
    }

    @Override
    public Map<String, List<StreamSource>> getSourcesMap(InlongGroupInfo groupInfo,
            List<InlongStreamInfo> streamInfos, List<StreamSource> streamSources) {
        ClusterInfo clusterInfo = clusterService.getOne(groupInfo.getInlongClusterTag(), null, ClusterType.PULSAR);
        PulsarClusterInfo pulsarCluster = (PulsarClusterInfo) clusterInfo;
        String adminUrl = pulsarCluster.getAdminUrl();
        String serviceUrl = pulsarCluster.getUrl();
        String tenant = StringUtils.isEmpty(pulsarCluster.getTenant())
                ? InlongConstants.DEFAULT_PULSAR_TENANT
                : pulsarCluster.getTenant();

        Map<String, List<StreamSource>> sourceMap = Maps.newHashMap();
        streamInfos.forEach(streamInfo -> {
            PulsarSource pulsarSource = new PulsarSource();
            String streamId = streamInfo.getInlongStreamId();
            pulsarSource.setSourceName(streamId);
            pulsarSource.setTenant(tenant);
            pulsarSource.setNamespace(groupInfo.getMqResource());
            pulsarSource.setTopic(streamInfo.getMqResource());
            pulsarSource.setAdminUrl(adminUrl);
            pulsarSource.setServiceUrl(serviceUrl);
            pulsarSource.setInlongComponent(true);

            // CSV: InLong message type whose message body is raw CSV
            // Raw-CSV: messages are separated by a specific separator
            pulsarSource.setWrapWithInlongMsg(streamInfo.getDataType().startsWith(DATA_TYPE_RAW_PREFIX));

            // set the token info
            if (StringUtils.isNotBlank(pulsarCluster.getToken())) {
                Map<String, Object> properties = pulsarSource.getProperties();
                properties.putIfAbsent(AUTH_CLASSNAME_KEY, AUTH_CLASSNAME_VALUE);
                properties.putIfAbsent(AUTH_PARAMS_KEY, String.format(AUTH_PARAMS_VALUE, pulsarCluster.getToken()));
            }

            for (StreamSource sourceInfo : streamSources) {
                if (!Objects.equal(streamId, sourceInfo.getInlongStreamId())) {
                    continue;
                }
                if (StringUtils.isEmpty(pulsarSource.getSerializationType())
                        && StringUtils.isNotEmpty(sourceInfo.getSerializationType())) {
                    pulsarSource.setSerializationType(sourceInfo.getSerializationType());
                }
                // currently, only reuse the primary key from Kafka source
                if (SourceType.KAFKA.equals(sourceInfo.getSourceType())) {
                    pulsarSource.setPrimaryKey(((KafkaSource) sourceInfo).getPrimaryKey());
                }
            }

            // if the SerializationType is still null, set it to the CSV
            if (StringUtils.isEmpty(pulsarSource.getSerializationType())) {
                pulsarSource.setSerializationType(DataTypeEnum.CSV.getType());
            }
            if (DataTypeEnum.CSV.getType().equalsIgnoreCase(pulsarSource.getSerializationType())) {
                pulsarSource.setDataSeparator(streamInfo.getDataSeparator());
                if (StringUtils.isEmpty(pulsarSource.getDataSeparator())) {
                    pulsarSource.setDataSeparator(String.valueOf((int) ','));
                }
            }
            pulsarSource.setScanStartupMode(PulsarScanStartupMode.EARLIEST.getValue());
            pulsarSource.setFieldList(streamInfo.getFieldList());
            sourceMap.computeIfAbsent(streamId, key -> Lists.newArrayList()).add(pulsarSource);
        });

        return sourceMap;
    }

}
