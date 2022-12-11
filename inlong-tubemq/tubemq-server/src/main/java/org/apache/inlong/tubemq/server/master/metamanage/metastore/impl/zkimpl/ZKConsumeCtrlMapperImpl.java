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

package org.apache.inlong.tubemq.server.master.metamanage.metastore.impl.zkimpl;

import java.lang.reflect.Type;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.inlong.tubemq.corebase.TokenConstants;
import org.apache.inlong.tubemq.corebase.rv.ProcessResult;
import org.apache.inlong.tubemq.corebase.utils.TStringUtils;
import org.apache.inlong.tubemq.server.broker.stats.BrokerSrvStatsHolder;
import org.apache.inlong.tubemq.server.common.exception.LoadMetaException;
import org.apache.inlong.tubemq.server.common.zookeeper.ZKUtil;
import org.apache.inlong.tubemq.server.common.zookeeper.ZooKeeperWatcher;
import org.apache.inlong.tubemq.server.master.metamanage.DataOpErrCode;
import org.apache.inlong.tubemq.server.master.metamanage.metastore.dao.entity.GroupConsumeCtrlEntity;
import org.apache.inlong.tubemq.server.master.metamanage.metastore.impl.AbsConsumeCtrlMapperImpl;
import org.apache.zookeeper.KeeperException;

public class ZKConsumeCtrlMapperImpl extends AbsConsumeCtrlMapperImpl {

    private final ZooKeeperWatcher zkWatcher;
    private final String csmCtrlRootDir;

    public ZKConsumeCtrlMapperImpl(String metaNodePrefix,
            ZooKeeperWatcher zkWatcher,
            StringBuilder strBuff) {
        super();
        this.zkWatcher = zkWatcher;
        this.csmCtrlRootDir = strBuff.append(metaNodePrefix)
                .append(TokenConstants.SLASH).append(TZKNodeKeys.ZK_LEAF_CONSUME_CTRL_CONFIG).toString();
        strBuff.delete(0, strBuff.length());
    }

    @Override
    public void close() {
        clearCachedData();
        logger.info("[ZK Impl] close consume control configure failure finished!");
    }

    @Override
    public void loadConfig(StringBuilder strBuff) throws LoadMetaException {
        long totalCnt = 0L;
        logger.info("[ZK Impl] load consume control configure start...");
        List<String> childNodes = ZKUtil.getChildren(zkWatcher, csmCtrlRootDir);
        if (childNodes == null) {
            logger.info("[ZK Impl] Not found consume control configure from ZooKeeper");
            return;
        }
        String recordStr;
        Gson gson = new Gson();
        Type type = new TypeToken<GroupConsumeCtrlEntity>() {
        }.getType();
        for (String itemKey : childNodes) {
            if (TStringUtils.isEmpty(itemKey)) {
                continue;
            }
            try {
                recordStr = ZKUtil.readDataMaybeNull(zkWatcher, strBuff.append(csmCtrlRootDir)
                        .append(TokenConstants.SLASH).append(itemKey).toString());
                strBuff.delete(0, strBuff.length());
            } catch (KeeperException e) {
                BrokerSrvStatsHolder.incZKExcCnt();
                logger.error("KeeperException during load consume control configure from ZooKeeper", e);
                throw new LoadMetaException(e.getMessage());
            }
            if (recordStr == null) {
                continue;
            }
            putRecord2Caches(gson.fromJson(recordStr, type));
            totalCnt++;
        }
        logger.info(strBuff.append("[ZK Impl] loaded ").append(totalCnt)
                .append(" consume control configure successfully...").toString());
        strBuff.delete(0, strBuff.length());
    }

    protected boolean putConfig2Persistent(GroupConsumeCtrlEntity entity,
            StringBuilder strBuff, ProcessResult result) {
        String entityStr = entity.toString();
        String confNode = strBuff.append(csmCtrlRootDir)
                .append(TokenConstants.SLASH).append(entity.getRecordKey()).toString();
        strBuff.delete(0, strBuff.length());
        try {
            ZKUtil.updatePersistentPath(zkWatcher, confNode, entityStr);
        } catch (Throwable t) {
            BrokerSrvStatsHolder.incZKExcCnt();
            logger.error("[ZK Impl] put consume control configure failure ", t);
            result.setFailResult(DataOpErrCode.DERR_STORE_ABNORMAL.getCode(),
                    strBuff.append("Put consume control configure failure: ")
                            .append(t.getMessage()).toString());
            strBuff.delete(0, strBuff.length());
            return result.isSuccess();
        }
        result.setSuccResult(null);
        return result.isSuccess();
    }

    protected boolean delConfigFromPersistent(String recordKey, StringBuilder strBuff) {
        ZKUtil.delZNode(this.zkWatcher, strBuff.append(csmCtrlRootDir)
                .append(TokenConstants.SLASH).append(recordKey).toString());
        strBuff.delete(0, strBuff.length());
        return true;
    }
}
