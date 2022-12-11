#!/usr/bin/env sh
#
# Licensed to the Apache Software Foundation (ASF) under one or more
# contributor license agreements.  See the NOTICE file distributed with
# this work for additional information regarding copyright ownership.
# The ASF licenses this file to You under the Apache License, Version 2.0
# (the "License"); you may not use this file except in compliance with
# the License.  You may obtain a copy of the License at
#
#    http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

# the parameters for init cluster
TUBE_MANAGER_IP=127.0.0.1
TUBE_MANAGER_PORT=8089
TUBE_MASTER_ID=1
TUBE_MASTER_IP=127.0.0.1
TUBE_MASTER_STANDBY=fasle
TUBE_MASTER_PORT=8715
TUBE_MASTER_WEB_PORT=8080
TUBE_MASTER_TOKEN=abc


# execute curl to add cluster, note that this command only need to execute once
curl --header "Content-Type: application/json" --request POST --data \
'{"id":0,"masterEntries":[{"id":1,"ip":"'"$TUBE_MASTER_IP"'","port":"'"$TUBE_MASTER_PORT"'","webPort":"'"$TUBE_MASTER_WEB_PORT"'","standby":"'"$TUBE_MASTER_STANDBY"'","token":"'"$TUBE_MASTER_TOKEN"'","clusterId":0}],"clusterName":"inlong","createUser":"manager","token":"'"$TUBE_MASTER_TOKEN"'","reloadBrokerSize":1}' \
http://"$TUBE_MANAGER_IP":"$TUBE_MANAGER_PORT"/v1/cluster?method=add