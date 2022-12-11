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

package org.apache.inlong.dataproxy.config;

import com.google.common.base.Splitter;
import org.apache.inlong.dataproxy.config.holder.ConfigUpdateCallback;
import org.apache.inlong.dataproxy.consts.AttrConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.apache.inlong.dataproxy.config.ConfigManager.CONFIG_HOLDER_LIST;

public abstract class ConfigHolder {

    public static final Splitter.MapSplitter MAP_SPLITTER = Splitter.on(AttrConstants.SEPARATOR)
            .trimResults().withKeyValueSeparator(AttrConstants.KEY_VALUE_SEPARATOR);
    private static final Logger LOG = LoggerFactory.getLogger(ConfigHolder.class);
    private final String fileName;
    private final AtomicBoolean fileChanged = new AtomicBoolean(false);
    // list of callbacks for this holder
    private final List<ConfigUpdateCallback> callbackList = new ArrayList<>();
    private long lastModifyTime;
    private String filePath;
    private File configFile;

    public ConfigHolder(String fileName) {
        this.fileName = fileName;
        setFilePath(fileName);
        CONFIG_HOLDER_LIST.add(this);
        if (configFile != null) {
            this.lastModifyTime = configFile.lastModified();
        }
    }

    /**
     * add callback
     *
     * @param callback - callback
     */
    public void addUpdateCallback(ConfigUpdateCallback callback) {
        callbackList.add(callback);
    }

    /**
     * execute callbacks
     */
    public void executeCallbacks() {
        for (ConfigUpdateCallback callback : callbackList) {
            callback.update();
        }
    }

    /**
     * load from file to holder
     */
    public abstract void loadFromFileToHolder();

    /**
     * check updater
     *
     * @return - true if updated
     */
    public boolean checkAndUpdateHolder() {
        if (fileChanged.compareAndSet(true, false)
                || (configFile != null && configFile.lastModified() != this.lastModifyTime)) {
            if (configFile != null) {
                this.lastModifyTime = configFile.lastModified();
            }
            LOG.info("file {} has changed, reload from local file agent", getFileName());
            loadFromFileToHolder();
            return true;
        }
        return false;
    }

    public String getFileName() {
        return fileName;
    }

    /**
     * get file name
     *
     * @return file name with prefix
     */
    public String getNextBackupFileName() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateStr = format.format(new Date(System.currentTimeMillis()));
        return getFilePath() + "." + dateStr;
    }

    /**
     * file name with base path.
     */
    public String getFilePath() {
        return filePath;
    }

    private void setFilePath(String fileName) {
        URL url = getClass().getClassLoader().getResource(fileName);
        if (url != null) {
            this.filePath = url.getPath();
            this.configFile = new File(this.filePath);
            LOG.info("set file path lastTime: {}, currentTime: {}",
                    lastModifyTime, configFile.lastModified());
        }
    }

    public AtomicBoolean getFileChanged() {
        return fileChanged;
    }
}
