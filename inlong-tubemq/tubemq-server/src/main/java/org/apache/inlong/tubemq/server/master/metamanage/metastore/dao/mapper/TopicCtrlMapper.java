/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.inlong.tubemq.server.master.metamanage.metastore.dao.mapper;

import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.inlong.tubemq.corebase.rv.ProcessResult;
import org.apache.inlong.tubemq.server.master.metamanage.metastore.dao.entity.TopicCtrlEntity;

public interface TopicCtrlMapper extends AbstractMapper {

    /**
     * Add a new topic control configure info into store
     *
     * @param entity   need add record
     * @param strBuff  the string buffer
     * @param result   process result with old value
     * @return  the process result
     */
    boolean addTopicCtrlConf(TopicCtrlEntity entity,
            StringBuilder strBuff, ProcessResult result);

    /**
     * Update a topic control configure info into store
     *
     * @param entity   need update record
     * @param strBuff  the string buffer
     * @param result   process result with old value
     * @return  the process result
     */
    boolean updTopicCtrlConf(TopicCtrlEntity entity,
            StringBuilder strBuff, ProcessResult result);

    /**
     * delete topic control configure info from store
     *
     * @param topicName  the topic name to be deleted
     * @param strBuff  the string buffer
     * @param result    the process result
     * @return          whether success
     */
    boolean delTopicCtrlConf(String topicName, StringBuilder strBuff, ProcessResult result);

    /**
     * get topic control configure info from store
     *
     * @param topicName    the topic name to be queried
     * @return result, only read
     */
    TopicCtrlEntity getTopicCtrlConf(String topicName);

    /**
     * get topic control configure info from store
     *
     * @param qryEntity    the query conditions
     * @return result, only read
     */
    List<TopicCtrlEntity> getTopicCtrlConf(TopicCtrlEntity qryEntity);

    /**
     * get topic control configure info from store
     *
     * @param topicNameSet  need matched topic name set
     * @param qryEntity     need matched properties
     * @return result, only read
     */
    Map<String, TopicCtrlEntity> getTopicCtrlConf(Set<String> topicNameSet,
            TopicCtrlEntity qryEntity);

    /**
     * get topic max message size configure info from store
     *
     * @param defMaxMsgSizeInB  the default max message size in B
     * @param topicNameSet  need matched topic name set
     * @return result, only read
     */
    Map<String, Integer> getMaxMsgSizeInBByTopics(int defMaxMsgSizeInB,
            Set<String> topicNameSet);
}
