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

package org.apache.inlong.agent.plugin.trigger;

import org.apache.inlong.agent.conf.JobProfile;
import org.apache.inlong.agent.conf.TriggerProfile;
import org.apache.inlong.agent.plugin.Trigger;

/**
 * Generate job by crontab expression.
 */
public class CronTrigger implements Trigger {

    @Override
    public void init(TriggerProfile profile) {

    }

    @Override
    public void run() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public JobProfile fetchJobProfile() {
        return null;
    }

    @Override
    public TriggerProfile getTriggerProfile() {
        return null;
    }
}
