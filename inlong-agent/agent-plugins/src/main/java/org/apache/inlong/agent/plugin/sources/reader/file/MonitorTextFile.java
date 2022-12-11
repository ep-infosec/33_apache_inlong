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

package org.apache.inlong.agent.plugin.sources.reader.file;

import org.apache.inlong.agent.common.AgentThreadFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static org.apache.inlong.agent.constant.JobConstants.INTERVAL_MILLISECONDS;
import static org.apache.inlong.agent.constant.JobConstants.JOB_FILE_MONITOR_DEFAULT_EXPIRE;
import static org.apache.inlong.agent.constant.JobConstants.JOB_FILE_MONITOR_EXPIRE;
import static org.apache.inlong.agent.constant.JobConstants.JOB_FILE_MONITOR_INTERVAL;

/**
 * Monitor for text files
 */
public final class MonitorTextFile {

    private static final Logger LOGGER = LoggerFactory.getLogger(MonitorTextFile.class);
    // monitor thread pool
    private static final ThreadPoolExecutor EXECUTOR_SERVICE = new ThreadPoolExecutor(
            0, Integer.MAX_VALUE,
            60L, TimeUnit.SECONDS,
            new SynchronousQueue<>(),
            new AgentThreadFactory("monitor-file"));

    private static volatile MonitorTextFile monitorTextFile = null;

    private MonitorTextFile() {

    }

    /**
     * Get a singleton instance of MonitorTextFile.
     *
     * @return monitor text file instance
     */
    public static MonitorTextFile getInstance() {
        if (monitorTextFile == null) {
            synchronized (MonitorTextFile.class) {
                if (monitorTextFile == null) {
                    monitorTextFile = new MonitorTextFile();
                }
            }
        }
        return monitorTextFile;
    }

    public void monitor(FileReaderOperator fileReaderOperator, TextFileReader textFileReader) {
        EXECUTOR_SERVICE.execute(new MonitorEventRunnable(fileReaderOperator, textFileReader));
    }

    /**
     * Runnable for monitor the file event
     */
    private static class MonitorEventRunnable implements Runnable {

        private static final int WAIT_TIME = 30;
        private final FileReaderOperator fileReaderOperator;
        private final TextFileReader textFileReader;
        private final Long interval;
        private final long startTime = System.currentTimeMillis();
        private long lastFlushTime = System.currentTimeMillis();
        private String path;

        // the last modify time of the file
        private BasicFileAttributes attributesBefore;

        public MonitorEventRunnable(FileReaderOperator readerOperator, TextFileReader textFileReader) {
            this.fileReaderOperator = readerOperator;
            this.textFileReader = textFileReader;
            this.interval = Long.parseLong(
                    readerOperator.jobConf.get(JOB_FILE_MONITOR_INTERVAL, INTERVAL_MILLISECONDS));
            try {
                this.attributesBefore = Files.readAttributes(readerOperator.file.toPath(), BasicFileAttributes.class);
                this.path = readerOperator.file.getCanonicalPath();
            } catch (IOException e) {
                LOGGER.error("get {} last modify time error:", readerOperator.file.getName(), e);
            }
        }

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(WAIT_TIME);
                LOGGER.info("start {} monitor", fileReaderOperator.file.getAbsolutePath());
                while (!fileReaderOperator.finished) {
                    long expireTime = Long.parseLong(
                            fileReaderOperator.jobConf.get(JOB_FILE_MONITOR_EXPIRE, JOB_FILE_MONITOR_DEFAULT_EXPIRE));
                    long currentTime = System.currentTimeMillis();
                    if (expireTime != Long.parseLong(JOB_FILE_MONITOR_DEFAULT_EXPIRE)
                            && currentTime - this.startTime > expireTime) {
                        break;
                    }
                    listen();
                    TimeUnit.MILLISECONDS.sleep(interval);
                }
            } catch (Exception e) {
                LOGGER.error(String.format("monitor %s error", fileReaderOperator.file.getName()), e);
            }
        }

        private void listen() throws IOException {
            BasicFileAttributes attributesAfter;
            String currentPath;
            File file = fileReaderOperator.file;
            try {
                attributesAfter = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
                currentPath = file.getCanonicalPath();
            } catch (Exception e) {
                // set position 0 when split file
                fileReaderOperator.position = 0;
                LOGGER.error(String.format("monitor file %s error, reset position to 0", file.getName()), e);
                return;
            }

            // if change symbolic links
            if (attributesAfter.isSymbolicLink() && !path.equals(currentPath)) {
                fileReaderOperator.position = 0;
                path = currentPath;
            }
            if (attributesBefore.lastModifiedTime().compareTo(attributesAfter.lastModifiedTime()) < 0) {
                // not triggered during data sending
                getFileData();
                attributesBefore = attributesAfter;
                return;
            }
            lastFlushData();
        }

        private void lastFlushData() throws IOException {
            long currentTime = System.currentTimeMillis();
            if (interval * 100 > currentTime - lastFlushTime) {
                return;
            }
            getFileData();
        }

        private void getFileData() throws IOException {
            if (fileReaderOperator.iterator != null && fileReaderOperator.iterator.hasNext()) {
                return;
            }
            this.textFileReader.getData();
            this.textFileReader.mergeData(this.fileReaderOperator);
            this.fileReaderOperator.iterator = fileReaderOperator.stream.iterator();
            this.lastFlushTime = System.currentTimeMillis();
        }
    }
}
