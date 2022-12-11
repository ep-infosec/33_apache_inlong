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

package org.apache.inlong.manager.service.stream;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.inlong.manager.common.consts.InlongConstants;
import org.apache.inlong.manager.common.enums.ErrorCodeEnum;
import org.apache.inlong.manager.common.enums.GroupStatus;
import org.apache.inlong.manager.common.enums.StreamStatus;
import org.apache.inlong.manager.common.exceptions.BusinessException;
import org.apache.inlong.manager.common.util.CommonBeanUtils;
import org.apache.inlong.manager.common.util.Preconditions;
import org.apache.inlong.manager.dao.entity.InlongGroupEntity;
import org.apache.inlong.manager.dao.entity.InlongStreamEntity;
import org.apache.inlong.manager.dao.entity.InlongStreamExtEntity;
import org.apache.inlong.manager.dao.entity.InlongStreamFieldEntity;
import org.apache.inlong.manager.dao.mapper.InlongGroupEntityMapper;
import org.apache.inlong.manager.dao.mapper.InlongStreamEntityMapper;
import org.apache.inlong.manager.dao.mapper.InlongStreamExtEntityMapper;
import org.apache.inlong.manager.dao.mapper.InlongStreamFieldEntityMapper;
import org.apache.inlong.manager.pojo.common.OrderFieldEnum;
import org.apache.inlong.manager.pojo.common.OrderTypeEnum;
import org.apache.inlong.manager.pojo.common.PageResult;
import org.apache.inlong.manager.pojo.sink.SinkBriefInfo;
import org.apache.inlong.manager.pojo.sink.StreamSink;
import org.apache.inlong.manager.pojo.source.StreamSource;
import org.apache.inlong.manager.pojo.stream.InlongStreamApproveRequest;
import org.apache.inlong.manager.pojo.stream.InlongStreamBriefInfo;
import org.apache.inlong.manager.pojo.stream.InlongStreamExtInfo;
import org.apache.inlong.manager.pojo.stream.InlongStreamInfo;
import org.apache.inlong.manager.pojo.stream.InlongStreamPageRequest;
import org.apache.inlong.manager.pojo.stream.InlongStreamRequest;
import org.apache.inlong.manager.pojo.stream.StreamField;
import org.apache.inlong.manager.service.sink.StreamSinkService;
import org.apache.inlong.manager.service.source.StreamSourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Inlong stream service layer implementation
 */
@Service
public class InlongStreamServiceImpl implements InlongStreamService {

    private static final Logger LOGGER = LoggerFactory.getLogger(InlongStreamServiceImpl.class);

    @Autowired
    private InlongStreamEntityMapper streamMapper;
    @Autowired
    private InlongStreamFieldEntityMapper streamFieldMapper;
    @Autowired
    private InlongStreamExtEntityMapper streamExtMapper;
    @Autowired
    private InlongGroupEntityMapper groupMapper;
    @Autowired
    private StreamSourceService sourceService;
    @Autowired
    private StreamSinkService sinkService;

    @Transactional(rollbackFor = Throwable.class)
    @Override
    public Integer save(InlongStreamRequest request, String operator) {
        LOGGER.debug("begin to save inlong stream info={}", request);
        Preconditions.checkNotNull(request, "inlong stream info is empty");
        String groupId = request.getInlongGroupId();
        String streamId = request.getInlongStreamId();
        Preconditions.checkNotNull(groupId, ErrorCodeEnum.GROUP_ID_IS_EMPTY.getMessage());
        Preconditions.checkNotNull(streamId, ErrorCodeEnum.STREAM_ID_IS_EMPTY.getMessage());

        // Check if it can be added
        checkGroupStatusIsTemp(groupId);

        // The streamId under the same groupId cannot be repeated
        Integer count = streamMapper.selectExistByIdentifier(groupId, streamId);
        if (count >= 1) {
            LOGGER.error("inlong stream id [{}] has already exists", streamId);
            throw new BusinessException(ErrorCodeEnum.STREAM_ID_DUPLICATE);
        }
        if (StringUtils.isEmpty(request.getMqResource())) {
            request.setMqResource(streamId);
        }
        // Processing inlong stream
        InlongStreamEntity streamEntity = CommonBeanUtils.copyProperties(request, InlongStreamEntity::new);
        streamEntity.setStatus(StreamStatus.NEW.getCode());
        streamEntity.setCreator(operator);
        streamEntity.setModifier(operator);

        streamMapper.insertSelective(streamEntity);
        saveField(groupId, streamId, request.getFieldList());
        if (CollectionUtils.isNotEmpty(request.getExtList())) {
            saveOrUpdateExt(groupId, streamId, request.getExtList());
        }

        LOGGER.info("success to save inlong stream info for groupId={}", groupId);
        return streamEntity.getId();
    }

    @Override
    public Boolean exist(String groupId, String streamId) {
        Preconditions.checkNotNull(groupId, ErrorCodeEnum.GROUP_ID_IS_EMPTY.getMessage());
        Preconditions.checkNotNull(groupId, ErrorCodeEnum.STREAM_ID_IS_EMPTY.getMessage());
        InlongStreamEntity streamEntity = streamMapper.selectByIdentifier(groupId, streamId);
        return streamEntity != null;
    }

    @Override
    public InlongStreamInfo get(String groupId, String streamId) {
        LOGGER.debug("begin to get inlong stream by groupId={}, streamId={}", groupId, streamId);
        Preconditions.checkNotNull(groupId, ErrorCodeEnum.GROUP_ID_IS_EMPTY.getMessage());
        Preconditions.checkNotNull(streamId, ErrorCodeEnum.STREAM_ID_IS_EMPTY.getMessage());

        InlongStreamEntity streamEntity = streamMapper.selectByIdentifier(groupId, streamId);
        if (streamEntity == null) {
            LOGGER.error("inlong stream not found by groupId={}, streamId={}", groupId, streamId);
            throw new BusinessException(ErrorCodeEnum.STREAM_NOT_FOUND);
        }

        InlongStreamInfo streamInfo = CommonBeanUtils.copyProperties(streamEntity, InlongStreamInfo::new);
        List<StreamField> streamFields = getStreamFields(groupId, streamId);
        streamInfo.setFieldList(streamFields);
        List<InlongStreamExtEntity> extEntities = streamExtMapper.selectByRelatedId(groupId, streamId);
        List<InlongStreamExtInfo> exts = CommonBeanUtils.copyListProperties(extEntities, InlongStreamExtInfo::new);
        streamInfo.setExtList(exts);
        List<StreamSink> sinkList = sinkService.listSink(groupId, streamId);
        streamInfo.setSinkList(sinkList);
        List<StreamSource> sourceList = sourceService.listSource(groupId, streamId);
        streamInfo.setSourceList(sourceList);
        LOGGER.info("success to get inlong stream for groupId={}", groupId);
        return streamInfo;
    }

    @Override
    public List<InlongStreamInfo> list(String groupId) {
        LOGGER.debug("begin to list inlong streams by groupId={}", groupId);
        List<InlongStreamEntity> inlongStreamEntityList = streamMapper.selectByGroupId(groupId);
        List<InlongStreamInfo> streamList = CommonBeanUtils.copyListProperties(inlongStreamEntityList,
                InlongStreamInfo::new);
        List<StreamField> streamFields = getStreamFields(groupId, null);
        Map<String, List<StreamField>> streamFieldMap = streamFields.stream().collect(
                Collectors.groupingBy(StreamField::getInlongStreamId,
                        HashMap::new,
                        Collectors.toCollection(ArrayList::new)));
        List<InlongStreamExtEntity> extEntities = streamExtMapper.selectByRelatedId(groupId, null);
        Map<String, List<InlongStreamExtInfo>> extInfoMap = extEntities.stream()
                .map(extEntity -> CommonBeanUtils.copyProperties(extEntity, InlongStreamExtInfo::new))
                .collect(Collectors.groupingBy(InlongStreamExtInfo::getInlongStreamId,
                        HashMap::new,
                        Collectors.toCollection(ArrayList::new)));
        streamList.forEach(streamInfo -> {
            String streamId = streamInfo.getInlongStreamId();
            List<StreamField> fieldInfos = streamFieldMap.get(streamId);
            streamInfo.setFieldList(fieldInfos);
            List<InlongStreamExtInfo> extInfos = extInfoMap.get(streamId);
            streamInfo.setExtList(extInfos);
            List<StreamSink> sinkList = sinkService.listSink(groupId, streamId);
            streamInfo.setSinkList(sinkList);
            List<StreamSource> sourceList = sourceService.listSource(groupId, streamId);
            streamInfo.setSourceList(sourceList);
        });
        return streamList;
    }

    /**
     * Query and set the extended information and data source fields of the inlong stream
     */
    private List<StreamField> getStreamFields(String groupId, String streamId) {
        List<InlongStreamFieldEntity> fieldEntityList = streamFieldMapper.selectByIdentifier(groupId, streamId);
        if (CollectionUtils.isEmpty(fieldEntityList)) {
            return Collections.emptyList();
        }
        return CommonBeanUtils.copyListProperties(fieldEntityList, StreamField::new);
    }

    @Override
    public PageResult<InlongStreamBriefInfo> listBrief(InlongStreamPageRequest request) {
        LOGGER.debug("begin to list inlong stream page by {}", request);

        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        OrderFieldEnum.checkOrderField(request);
        OrderTypeEnum.checkOrderType(request);
        Page<InlongStreamEntity> entityPage = (Page<InlongStreamEntity>) streamMapper.selectByCondition(request);
        List<InlongStreamBriefInfo> streamList = CommonBeanUtils.copyListProperties(entityPage,
                InlongStreamBriefInfo::new);

        PageResult<InlongStreamBriefInfo> pageResult = new PageResult<>(streamList,
                entityPage.getTotal(), entityPage.getPageNum(), entityPage.getPageSize());

        LOGGER.debug("success to list inlong stream info for groupId={}", request.getInlongGroupId());
        return pageResult;
    }

    @Override
    public PageResult<InlongStreamInfo> listAll(InlongStreamPageRequest request) {
        LOGGER.debug("begin to list full inlong stream page by {}", request);
        Preconditions.checkNotNull(request, "request is empty");
        String groupId = request.getInlongGroupId();
        Preconditions.checkNotNull(groupId, ErrorCodeEnum.GROUP_ID_IS_EMPTY.getMessage());
        InlongGroupEntity groupEntity = groupMapper.selectByGroupId(groupId);
        Preconditions.checkNotNull(groupEntity, "inlong group not found by groupId=" + groupId);

        // the person in charge of the inlong group has the authority of all inlong streams,
        // so do not filter by in charge person
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        Page<InlongStreamEntity> page = (Page<InlongStreamEntity>) streamMapper.selectByCondition(request);
        List<InlongStreamInfo> streamInfoList = CommonBeanUtils.copyListProperties(page, InlongStreamInfo::new);

        // Convert and encapsulate the paged results
        for (InlongStreamInfo streamInfo : streamInfoList) {
            // Set the field information of the inlong stream
            String streamId = streamInfo.getInlongStreamId();
            List<StreamField> streamFields = getStreamFields(groupId, streamId);
            streamInfo.setFieldList(streamFields);
            List<InlongStreamExtInfo> streamExtInfos = CommonBeanUtils.copyListProperties(
                    streamExtMapper.selectByRelatedId(groupId, streamId), InlongStreamExtInfo::new);
            streamInfo.setExtList(streamExtInfos);

            // query all valid stream sources
            List<StreamSource> sourceList = sourceService.listSource(groupId, streamId);
            streamInfo.setSourceList(sourceList);

            // query all valid stream sinks and its extended info, field info
            List<StreamSink> sinkList = sinkService.listSink(groupId, streamId);
            streamInfo.setSinkList(sinkList);
        }

        PageResult<InlongStreamInfo> pageResult = new PageResult<>(streamInfoList, page.getTotal(),
                page.getPageNum(), page.getPageSize());

        LOGGER.debug("success to list full inlong stream info by {}", request);
        return pageResult;
    }

    @Override
    public List<InlongStreamBriefInfo> listBriefWithSink(String groupId) {
        LOGGER.debug("begin to get inlong stream brief list by groupId={}", groupId);
        Preconditions.checkNotNull(groupId, ErrorCodeEnum.GROUP_ID_IS_EMPTY.getMessage());

        List<InlongStreamEntity> entityList = streamMapper.selectByGroupId(groupId);
        List<InlongStreamBriefInfo> briefInfoList = CommonBeanUtils
                .copyListProperties(entityList, InlongStreamBriefInfo::new);

        // query stream sinks based on groupId and streamId
        for (InlongStreamBriefInfo briefInfo : briefInfoList) {
            String streamId = briefInfo.getInlongStreamId();
            List<SinkBriefInfo> sinkList = sinkService.listBrief(groupId, streamId);
            briefInfo.setSinkList(sinkList);
        }

        LOGGER.info("success to get inlong stream brief list for groupId={}", groupId);
        return briefInfoList;
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public Boolean update(InlongStreamRequest request, String operator) {
        LOGGER.debug("begin to update inlong stream info={}", request);
        Preconditions.checkNotNull(request, "inlong stream request is empty");
        String groupId = request.getInlongGroupId();
        Preconditions.checkNotNull(groupId, ErrorCodeEnum.GROUP_ID_IS_EMPTY.getMessage());
        String streamId = request.getInlongStreamId();
        Preconditions.checkNotNull(streamId, ErrorCodeEnum.STREAM_ID_IS_EMPTY.getMessage());

        // Check if it can be modified
        this.checkGroupStatusIsTemp(groupId);

        return this.updateWithoutCheck(request, operator);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public Boolean updateWithoutCheck(InlongStreamRequest request, String operator) {
        LOGGER.debug("begin to update inlong stream without check, request={}", request);
        // make sure the stream was exists
        String groupId = request.getInlongGroupId();
        String streamId = request.getInlongStreamId();
        InlongStreamEntity streamEntity = streamMapper.selectByIdentifier(groupId, streamId);
        if (streamEntity == null) {
            LOGGER.error("inlong stream not found by groupId={}, streamId={}", groupId, streamId);
            throw new BusinessException(ErrorCodeEnum.STREAM_NOT_FOUND);
        }

        String errMsg = String.format("stream has already updated with groupId=%s, streamId=%s, curVersion=%s",
                streamEntity.getInlongGroupId(), streamEntity.getInlongStreamId(), request.getVersion());
        if (!Objects.equals(streamEntity.getVersion(), request.getVersion())) {
            LOGGER.error(errMsg);
            throw new BusinessException(ErrorCodeEnum.CONFIG_EXPIRED);
        }

        CommonBeanUtils.copyProperties(request, streamEntity, true);
        streamEntity.setModifier(operator);
        int rowCount = streamMapper.updateByIdentifierSelective(streamEntity);
        if (rowCount != InlongConstants.AFFECTED_ONE_ROW) {
            LOGGER.error(errMsg);
            throw new BusinessException(ErrorCodeEnum.CONFIG_EXPIRED);
        }
        // update stream fields
        updateField(groupId, streamId, request.getFieldList());
        // update stream extension infos
        saveOrUpdateExt(groupId, streamId, request.getExtList());

        LOGGER.info("success to update inlong stream without check for groupId={} streamId={}", groupId, streamId);
        return true;
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public Boolean delete(String groupId, String streamId, String operator) {
        LOGGER.debug("begin to delete inlong stream, groupId={}, streamId={}", groupId, streamId);
        Preconditions.checkNotNull(groupId, ErrorCodeEnum.GROUP_ID_IS_EMPTY.getMessage());
        Preconditions.checkNotNull(streamId, ErrorCodeEnum.STREAM_ID_IS_EMPTY.getMessage());

        // Check if it can be deleted
        this.checkGroupStatusIsTemp(groupId);

        InlongStreamEntity entity = streamMapper.selectByIdentifier(groupId, streamId);
        if (entity == null) {
            LOGGER.error("inlong stream not found by groupId={}, streamId={}", groupId, streamId);
            throw new BusinessException(ErrorCodeEnum.STREAM_NOT_FOUND);
        }

        // If there is undeleted stream source, the deletion fails
        Integer sourceCount = sourceService.getCount(groupId, streamId);
        if (sourceCount > 0) {
            LOGGER.error("inlong stream has undeleted sources, delete failed");
            throw new BusinessException(ErrorCodeEnum.STREAM_DELETE_HAS_SOURCE);
        }

        // If there is undeleted stream sink, the deletion fails
        int sinkCount = sinkService.getCount(groupId, streamId);
        if (sinkCount > 0) {
            LOGGER.error("inlong stream has undeleted sinks, delete failed");
            throw new BusinessException(ErrorCodeEnum.STREAM_DELETE_HAS_SINK);
        }

        entity.setIsDeleted(entity.getId());
        entity.setModifier(operator);
        int rowCount = streamMapper.updateByPrimaryKey(entity);
        if (rowCount != InlongConstants.AFFECTED_ONE_ROW) {
            LOGGER.error("stream has already updated with group id={}, stream id={}, curVersion={}",
                    entity.getInlongGroupId(), entity.getInlongStreamId(), entity.getVersion());
            throw new BusinessException(ErrorCodeEnum.CONFIG_EXPIRED);
        }
        // Logically delete the associated field table
        LOGGER.debug("begin to delete inlong stream field, streamId={}", streamId);
        streamFieldMapper.logicDeleteAllByIdentifier(groupId, streamId);
        streamExtMapper.logicDeleteAllByRelatedId(groupId, streamId);

        LOGGER.info("success to delete inlong stream, ext property and fields for groupId={}", groupId);
        return true;
    }

    @Transactional(rollbackFor = Throwable.class)
    @Override
    public Boolean logicDeleteAll(String groupId, String operator) {
        LOGGER.debug("begin to delete all inlong stream by groupId={}", groupId);
        Preconditions.checkNotNull(groupId, ErrorCodeEnum.GROUP_ID_IS_EMPTY.getMessage());

        // Check if it can be deleted
        this.checkGroupStatusIsTemp(groupId);

        List<InlongStreamEntity> entityList = streamMapper.selectByGroupId(groupId);
        if (CollectionUtils.isEmpty(entityList)) {
            LOGGER.info("inlong stream not found by groupId={}", groupId);
            return true;
        }

        for (InlongStreamEntity entity : entityList) {
            entity.setIsDeleted(entity.getId());
            entity.setModifier(operator);

            int rowCount = streamMapper.updateByIdentifierSelective(entity);
            if (rowCount != InlongConstants.AFFECTED_ONE_ROW) {
                LOGGER.error("stream has already updated with group id={}, stream id={}, curVersion={}",
                        entity.getInlongGroupId(), entity.getInlongStreamId(), entity.getVersion());
                throw new BusinessException(ErrorCodeEnum.CONFIG_EXPIRED);
            }
            String streamId = entity.getInlongStreamId();
            // Logically delete the associated field, source and sink info
            streamFieldMapper.logicDeleteAllByIdentifier(groupId, streamId);
            streamExtMapper.logicDeleteAllByRelatedId(groupId, streamId);
            sourceService.logicDeleteAll(groupId, streamId, operator);
            sinkService.logicDeleteAll(groupId, streamId, operator);
        }

        LOGGER.info("success to delete all inlong stream, ext property and fields by groupId={}", groupId);
        return true;
    }

    @Override
    public int selectCountByGroupId(String groupId) {
        LOGGER.debug("begin to get count by groupId={}", groupId);
        if (StringUtils.isEmpty(groupId)) {
            return 0;
        }
        int count = streamMapper.selectCountByGroupId(groupId);
        LOGGER.info("success to get count");
        return count;
    }

    @Override
    public List<InlongStreamBriefInfo> getTopicList(String groupId) {
        LOGGER.debug("begin bo get topic list by group id={}", groupId);
        Preconditions.checkNotNull(groupId, ErrorCodeEnum.GROUP_ID_IS_EMPTY.getMessage());

        List<InlongStreamBriefInfo> topicList = streamMapper.selectBriefList(groupId);
        LOGGER.debug("success to get topic list by groupId={}, result size={}", groupId, topicList.size());
        return topicList;
    }

    @Override
    public boolean updateAfterApprove(List<InlongStreamApproveRequest> streamApproveList, String operator) {
        if (CollectionUtils.isEmpty(streamApproveList)) {
            return true;
        }

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("begin to update stream after approve={}", streamApproveList);
        }

        String groupId = null;
        for (InlongStreamApproveRequest info : streamApproveList) {
            groupId = info.getInlongGroupId(); // these groupIds are all the same
            // Modify the inlong stream info after approve
            InlongStreamEntity streamEntity = streamMapper.selectByIdentifier(groupId, info.getInlongStreamId());
            streamEntity.setStatus(StreamStatus.CONFIG_ING.getCode());

            int rowCount = streamMapper.updateByIdentifierSelective(streamEntity);
            if (rowCount != InlongConstants.AFFECTED_ONE_ROW) {
                LOGGER.error("stream has already updated with group id={}, stream id={}, curVersion={}",
                        streamEntity.getInlongGroupId(), streamEntity.getInlongStreamId(), streamEntity.getVersion());
                throw new BusinessException(ErrorCodeEnum.CONFIG_EXPIRED);
            }
            // Modify the sink info after approve, such as update cluster info
            sinkService.updateAfterApprove(info.getSinkList(), operator);
        }

        LOGGER.info("success to update stream after approve for groupId={}", groupId);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public boolean updateStatus(String groupId, String streamId, Integer status, String operator) {
        streamMapper.updateStatusByIdentifier(groupId, streamId, status, operator);
        LOGGER.info("success to update stream after approve for groupId=" + groupId + ", streamId=" + streamId);
        return true;
    }

    @Override
    public void insertDlqOrRlq(String groupId, String topicName, String operator) {
        Integer count = streamMapper.selectExistByIdentifier(groupId, topicName);
        if (count >= 1) {
            LOGGER.error("DLQ/RLQ topic already exists with name={}", topicName);
            throw new BusinessException(ErrorCodeEnum.STREAM_ID_DUPLICATE, "DLQ/RLQ topic already exists");
        }

        InlongStreamEntity streamEntity = new InlongStreamEntity();
        streamEntity.setInlongGroupId(groupId);
        streamEntity.setInlongStreamId(topicName);
        streamEntity.setMqResource(topicName);
        streamEntity.setDescription("This is DLQ / RLQ topic created by SYSTEM");
        streamEntity.setDailyRecords(1000);
        streamEntity.setDailyStorage(1000);
        streamEntity.setPeakRecords(1000);
        streamEntity.setMaxLength(1000);

        streamEntity.setStatus(StreamStatus.CONFIG_SUCCESSFUL.getCode());
        streamEntity.setCreator(operator);
        streamEntity.setModifier(operator);

        streamMapper.insert(streamEntity);
    }

    @Override
    public void logicDeleteDlqOrRlq(String groupId, String topicName, String operator) {
        streamMapper.logicDeleteDlqOrRlq(groupId, topicName, operator);
        LOGGER.info("success to logic delete dlq or rlq by groupId={}, topicName={}", groupId, topicName);
    }

    /**
     * Update field information
     * <p/>
     * First physically delete the existing field information, and then add the field information of this batch
     */
    @Transactional(rollbackFor = Throwable.class)
    void updateField(String groupId, String streamId, List<StreamField> fieldList) {
        LOGGER.debug("begin to update inlong stream field, groupId={}, streamId={}, field={}", groupId, streamId,
                fieldList);
        try {
            streamFieldMapper.deleteAllByIdentifier(groupId, streamId);
            saveField(groupId, streamId, fieldList);
            LOGGER.info("success to update inlong stream field for groupId={}", groupId);
        } catch (Exception e) {
            LOGGER.error("failed to update inlong stream field: ", e);
            throw new BusinessException(ErrorCodeEnum.STREAM_FIELD_SAVE_FAILED);
        }
    }

    @Transactional(rollbackFor = Throwable.class)
    void saveField(String groupId, String streamId, List<StreamField> infoList) {
        if (CollectionUtils.isEmpty(infoList)) {
            return;
        }
        infoList.forEach(streamField -> streamField.setId(null));
        List<InlongStreamFieldEntity> list = CommonBeanUtils.copyListProperties(infoList,
                InlongStreamFieldEntity::new);
        for (InlongStreamFieldEntity entity : list) {
            entity.setInlongGroupId(groupId);
            entity.setInlongStreamId(streamId);
            entity.setIsDeleted(InlongConstants.UN_DELETED);
        }
        streamFieldMapper.insertAll(list);
    }

    @Transactional(rollbackFor = Throwable.class)
    void saveOrUpdateExt(String groupId, String streamId, List<InlongStreamExtInfo> exts) {
        LOGGER.info("begin to save or update inlong stream ext info, groupId={}, streamId={}, ext={}", groupId,
                streamId, exts);
        if (CollectionUtils.isEmpty(exts)) {
            return;
        }

        List<InlongStreamExtEntity> entityList = CommonBeanUtils.copyListProperties(exts, InlongStreamExtEntity::new);
        entityList.forEach(streamEntity -> {
            streamEntity.setInlongGroupId(groupId);
            streamEntity.setInlongStreamId(streamId);
        });
        streamExtMapper.insertOnDuplicateKeyUpdate(entityList);
        LOGGER.info("success to save or update inlong stream ext for groupId={}", groupId);
    }

    /**
     * Check whether the inlong group status is temporary
     *
     * @param groupId inlong group id
     * @return inlong group entity
     */
    private InlongGroupEntity checkGroupStatusIsTemp(String groupId) {
        InlongGroupEntity entity = groupMapper.selectByGroupId(groupId);
        Preconditions.checkNotNull(entity, "groupId is invalid");
        // Add/modify/delete is not allowed under temporary inlong group status
        GroupStatus curState = GroupStatus.forCode(entity.getStatus());
        if (GroupStatus.isTempStatus(curState)) {
            LOGGER.error("inlong groupId={} status={} was not allowed to add/update/delete stream", groupId, curState);
            throw new BusinessException(ErrorCodeEnum.STREAM_OPT_NOT_ALLOWED);
        }

        return entity;
    }

}
