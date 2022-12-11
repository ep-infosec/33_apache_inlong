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

/**
 * The error code enumeration.
 */
public enum ErrorCodeEnum {

    AUTHORIZATION_FAILED(2001, "Authentication failed"),
    INVALID_PARAMETER(2002, "The parameter is invalid"),
    PERMISSION_REQUIRED(2003, "The current user does not have operation authority"),
    AUTHENTICATION_REQUIRED(2004, "Authentication failed"),
    CONFIG_EXPIRED(2005, "The config has expired, please refresh the page or re-fetch the data and try again"),

    ID_IS_EMPTY(101, "Primary key is empty"),
    GROUP_ID_IS_EMPTY(102, "Inlong group id is empty"),
    STREAM_ID_IS_EMPTY(103, "Inlong stream id is empty"),
    REQUEST_IS_EMPTY(104, "Request is empty"),
    REQUEST_COMPONENT_EMPTY(105, "Component is empty"),
    REQUEST_INSTANCE_EMPTY(106, "Instance is empty"),
    USER_IS_NOT_MANAGER(110, "%s is not the manager, please contact %s"),

    GROUP_NOT_FOUND(1001, "Inlong group does not exist/no operation authority"),
    GROUP_DUPLICATE(1002, "Inlong group already exists"),
    GROUP_INFO_INCORRECT(1003, "Group info was incorrect"),
    GROUP_SAVE_FAILED(1004, "Failed to save/update inlong group"),
    GROUP_PERMISSION_DENIED(1005, "No permission to access this inlong group"),
    GROUP_UPDATE_NOT_ALLOWED(1006, "The current inlong group status does not support modification"),
    GROUP_DELETE_NOT_ALLOWED(1007, "The current inlong group status does not support deletion"),
    GROUP_DELETE_HAS_STREAM(1008, "The inlong group contains inlong streams and is not allowed to be deleted"),

    GROUP_ID_UPDATE_NOT_ALLOWED(1010, "The current status does not support modifying the inlong group id"),
    GROUP_MIDDLEWARE_UPDATE_NOT_ALLOWED(1011, "The current status does not support modifying the MQ type"),
    GROUP_NAME_UPDATE_NOT_ALLOWED(1012, "The current inlong group status does not support modifying the name"),
    GROUP_INFO_INCONSISTENT(1013, "The inlong group info is inconsistent, please contact the administrator"),
    GROUP_MODE_UNSUPPORTED(1014, "The current inlong group mode only support lightweight or standard"),

    OPT_NOT_ALLOWED_BY_STATUS(1021, "InlongGroup status %s was not allowed to add/update/delete related info"),

    MQ_TYPE_NOT_SUPPORTED(1022, "MQ type '%s' not supported"),
    MQ_TYPE_NOT_SAME(1023, "Expected MQ type is '%s', but found '%s'"),

    CLUSTER_NOT_FOUND(1101, "Cluster information does not exist"),
    CLUSTER_TYPE_NOT_SUPPORTED(1102, "Cluster type '%s' not supported"),
    CLUSTER_INFO_INCORRECT(1103, "Cluster info was incorrect"),

    DATA_NODE_NOT_FOUND(1150, "Data node information does not exist"),
    DATA_NODE_TYPE_NOT_SUPPORTED(1151, "Data node type '%s' not supported"),

    STREAM_NOT_FOUND(1201, "Inlong stream does not exist/no operation permission"),
    STREAM_ID_DUPLICATE(1202, "The current inlong group has a inlong stream with the same ID"),
    STREAM_OPT_NOT_ALLOWED(1203,
            "The current inlong group status does not allow adding/modifying/deleting inlong streams"),
    STREAM_ID_UPDATE_NOT_ALLOWED(1205,
            "The current inlong group status does not allow to modify the group or stream id"),
    STREAM_SOURCE_UPDATE_NOT_ALLOWED(1206,
            "The current inlong group status does not allow to modify the stream source type of the inlong stream"),
    STREAM_EXT_SAVE_FAILED(1207, "Failed to save/update inlong stream extension information"),
    STREAM_FIELD_SAVE_FAILED(1208, "Failed to save/update inlong stream field"),
    STREAM_DELETE_HAS_SOURCE(1209, "The inlong stream contains source info and is not allowed to be deleted"),
    STREAM_DELETE_HAS_SINK(1210, "The inlong stream contains sink info and is not allowed to be deleted"),

    SOURCE_TYPE_IS_NULL(1300, "Source type is null"),
    SOURCE_TYPE_NOT_SUPPORT(1301, "Source type '%s' not support"),
    SOURCE_INFO_NOT_FOUND(1302, "Source information does not exist/no operation authority"),
    SOURCE_INFO_INCORRECT(1303, "Source information was incorrect"),
    SOURCE_ALREADY_EXISTS(1304, "Source already exist with the groupId and streamId"),
    SOURCE_SAVE_FAILED(1305, "Failed to save or update source info"),
    SOURCE_OPT_NOT_ALLOWED(1306, "Current status does not allow add/modification/delete source info"),
    SOURCE_TYPE_NOT_SAME(1307, "Expected source type is %s, but found %s"),
    SOURCE_NAME_IS_NULL(1308, "Source name is null"),

    HIVE_OPERATION_FAILED(1311, "Hive operation failed"),

    SINK_TYPE_IS_NULL(1400, "Sink type is null"),
    SINK_TYPE_NOT_SUPPORT(1401, "Sink type '%s' not support"),
    SINK_INFO_NOT_FOUND(1402, "Sink information does not exist/no operation authority"),
    SINK_INFO_INCORRECT(1403, "Sink information was incorrect"),
    SINK_ALREADY_EXISTS(1404, "Sink already exist with the groupId and streamId"),
    SINK_SAVE_FAILED(1405, "Failed to save or update sink info"),
    SINK_FIELD_SAVE_FAILED(1406, "Failed to save or update sink field"),
    SINK_OPT_NOT_ALLOWED(1407, "Current status does not allow add/modification/delete sink info"),
    SINK_DB_NAME_UPDATE_NOT_ALLOWED(1408, "Current status does not allow modification the database name"),
    SINK_TB_NAME_UPDATE_NOT_ALLOWED(1409, "Current status does not allow modification the table name"),
    SINK_FIELD_UPDATE_NOT_ALLOWED(1410, "Current status not allowed to modification/delete field"),
    SINK_FIELD_LIST_IS_EMPTY(1411, "Sink field list is not allow empty"),
    PARTITION_FIELD_NAME_IS_EMPTY(1412, "Partition field name cannot be empty"),
    PARTITION_FIELD_NOT_FOUND(1413, "Sink partition field [%s] not found in sink field list"),
    PARTITION_FIELD_NO_SOURCE_FIELD(1414, "Sink partition field [%s] must have a related source field name"),
    SINK_TYPE_NOT_SAME(1415, "Expected sink type is %s, but found %s"),
    SINK_NAME_IS_NULL(1416, "Sink name is null"),

    TRANSFORM_TYPE_IS_NULL(1500, "Transform type is null"),
    TRANSFORM_NAME_IS_NULL(1501, "Transform name is null"),
    TRANSFORM_NOT_FOUND(1502, "Transform does not exist"),

    MQ_TYPE_IS_NULL(1600, "MQ type is null"),
    MQ_TYPE_NOT_SUPPORT(1601, "MQ type '%s' not support"),

    WORKFLOW_EXE_FAILED(4000, "Workflow execution exception"),
    WORKFLOW_APPROVER_NOT_FOUND(4001, "Workflow approver does not exist/no operation authority"),

    CONSUMER_GROUP_DUPLICATED(2600, "The consumer group already exists"),
    CONSUMER_GROUP_CREATE_FAILED(2601, "Failed to create TubeMQ consumer group"),
    TUBE_GROUP_CREATE_FAILED(2602, "Create TubeMQ consumer group failed"),
    PULSAR_GROUP_CREATE_FAILED(2603, "Create Pulsar consumer group failed"),
    TUBE_TOPIC_CREATE_FAILED(2604, "Create TubeMQ Topic failed"),
    PULSAR_TOPIC_CREATE_FAILED(2605, "Create Pulsar Topic failed"),
    PULSAR_DLQ_RLQ_ERROR(2606, "Wrong config for the RLQ and DLQ: RLQ was enabled, but the DLQ was disabled"),
    PULSAR_DLQ_DUPLICATED(2607, "DLQ topic already exists under the inlong group"),
    PULSAR_RLQ_DUPLICATED(2608, "RLQ topic already exists under the inlong group"),
    CONSUMER_INFO_INCORRECT(2609, "Consumer info was incorrect"),
    CONSUMER_NOR_FOUND(2609, "Consumer not found"),

    CONSUME_NOT_FOUND(3001, "Inlong consume does not exist/no operation authority"),
    CONSUME_DUPLICATE(3002, "Inlong consume already exists"),
    CONSUME_INFO_INCORRECT(3003, "Inlong consume info was incorrect"),
    CONSUME_SAVE_FAILED(3004, "Failed to save/update inlong consume"),
    CONSUME_PERMISSION_DENIED(3005, "No permission to access this inlong consume"),

    ;

    private final int code;
    private final String message;

    ErrorCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
