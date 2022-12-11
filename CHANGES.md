# InLong Changelog

<!---
# Licensed to the Apache Software Foundation (ASF) under one
# or more contributor license agreements.  See the NOTICE file
# distributed with this work for additional information
# regarding copyright ownership.  The ASF licenses this file
# to you under the Apache License, Version 2.0 (the
# "License"); you may not use this file except in compliance
# with the License.  You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

# Be careful doing manual edits in this file. Do not change format
# of release header or remove the below marker. This file is generated.
# DO NOT REMOVE THIS MARKER; FOR INTERPOLATING CHANGES!-->


## Release InLong 1.4.0 - Released (as of 2022-11-07)

### Agent
| ISSUE                                                       | Summary                                                                                          |
|:------------------------------------------------------------|:-------------------------------------------------------------------------------------------------|
| [INLONG-6376](https://github.com/apache/inlong/issues/6376) | [Improve][Agent] Refactor sink and complement send metric                                        |
| [INLONG-6366](https://github.com/apache/inlong/issues/6366) | [Bug][Agent] Missing position update operation when data is successfully sent in order-send mode |
| [INLONG-6332](https://github.com/apache/inlong/issues/6332) | [Bug][Agent]  Reboot will reset file position                                                    |
| [INLONG-6251](https://github.com/apache/inlong/issues/6251) | [Bug][Agent] The unit test occurred ConcurrentModification error                                 |
| [INLONG-6207](https://github.com/apache/inlong/issues/6207) | [Improve][Agent] Optimize the unit test for TestSQLServerReader                                  |
| [INLONG-6197](https://github.com/apache/inlong/issues/6197) | [Improve][Agent] Remove useless configuration in agent.properties                                |
| [INLONG-6194](https://github.com/apache/inlong/issues/6194) | [Feature][Agent] Support parsing metrics for different components                                |
| [INLONG-6181](https://github.com/apache/inlong/issues/6181) | [Feature][Agent][DataProxy][Manager] Support query and management for cluster protocol type      |
| [INLONG-6131](https://github.com/apache/inlong/issues/6131) | [Feature][Agent]  Support file filtering by condition                                            |
| [INLONG-6115](https://github.com/apache/inlong/issues/6115) | [Bug][Agent] Prometheus listeners miss some metrics                                              |
| [INLONG-6047](https://github.com/apache/inlong/issues/6047) | [Bug][Agent] File could not be matched in the k8s                                                |
| [INLONG-6033](https://github.com/apache/inlong/issues/6033) | [Improve][Agent] Support for hidden directories                                                  |
| [INLONG-6022](https://github.com/apache/inlong/issues/6022) | [Bug][Agent] Lost metrics values with send and read                                              |
| [INLONG-6009](https://github.com/apache/inlong/issues/6009) | [Improve][Agent] Report data size to InLong Audit                                                |
| [INLONG-5988](https://github.com/apache/inlong/issues/5988) | [Improve][Agent] Add the Partition Key settings for file source                                  |
| [INLONG-5948](https://github.com/apache/inlong/issues/5948) | [Improve][Agent][DataProxy] Add the enable audit environment                                     |
| [INLONG-5909](https://github.com/apache/inlong/issues/5909) | [Bug][Agent] WatchService is no effect in the k8s                                                |
| [INLONG-5874](https://github.com/apache/inlong/issues/5874) | [Improve][Agent] Add msgTime attribute in PackProxyMessage                                       |
| [INLONG-5861](https://github.com/apache/inlong/issues/5861) | [Improve][Agent] Support symbolic links for file                                                 |
| [INLONG-5828](https://github.com/apache/inlong/issues/5828) | [Bug][Agent] Merge data error when collect nonstandard log of k8s                                |
| [INLONG-5803](https://github.com/apache/inlong/issues/5803) | [Bug][Agent] NPE when collect file data                                                          |
| [INLONG-5743](https://github.com/apache/inlong/issues/5743) | [Feature][Agent] Read file data continuously through the monitoring file                         |
| [INLONG-5741](https://github.com/apache/inlong/issues/5741) | [Improve][Agent] Keep the docker config of Agent consistent with physical machine                |
| [INLONG-5722](https://github.com/apache/inlong/issues/5722) | [Feature][Agent] Support Redis Source                                                            |
| [INLONG-5720](https://github.com/apache/inlong/issues/5720) | [Bug][Agent] The data file cannot be fetched                                                     |
| [INLONG-5675](https://github.com/apache/inlong/issues/5675) | [Improve][Agent] Support custom fixed ip for Agent                                               |
| [INLONG-5045](https://github.com/apache/inlong/issues/5045) | [Feature][Agent] Support collect data from MongoDB                                               |
| [INLONG-4986](https://github.com/apache/inlong/issues/4986) | [Feature][Agent] Support MQTT Source                                                             |
| [INLONG-6327](https://github.com/apache/inlong/issues/6327) | [Improve][Agent] Support collect data from SQLServer by Debezium                                 |
| [INLONG-6176](https://github.com/apache/inlong/issues/6176) | [Feature][Agent] Support collect data from Oracle                                                |

### DataProxy
| ISSUE                                                       | Summary                                                                                     |
|:------------------------------------------------------------|:--------------------------------------------------------------------------------------------|
| [INLONG-6439](https://github.com/apache/inlong/issues/6439) | [Improve][DataProxy] Added service status and load fields in heartbeat request              |
| [INLONG-6406](https://github.com/apache/inlong/issues/6406) | [Improve][DataProxy] Should support creating sink dynamically after started                 |
| [INLONG-6369](https://github.com/apache/inlong/issues/6369) | [Improve][DataProxy] Use the defined message attribute key value in InLong-Common           |
| [INLONG-6331](https://github.com/apache/inlong/issues/6331) | [Bug][DataProxy] Unable to obtain prometheus metrics correctly                              |
| [INLONG-6329](https://github.com/apache/inlong/issues/6329) | [Improve][DataProxy] Add proxy-send mode message logic                                      |
| [INLONG-6324](https://github.com/apache/inlong/issues/6324) | [Improve][DataProxy] Optimize DataProxy's message processing on the source side             |
| [INLONG-6316](https://github.com/apache/inlong/issues/6316) | [Bug][DataProxy] Heartbeat information is null                                              |
| [INLONG-6285](https://github.com/apache/inlong/issues/6285) | [Improve][DataProxy] Add authorization info while reporting heartbeat to Manager            |
| [INLONG-6278](https://github.com/apache/inlong/issues/6278) | [Improve][DataProxy] Needless to sleep() for order event                                    |
| [INLONG-6266](https://github.com/apache/inlong/issues/6266) | [Improve][Manager][DataProxy]  Change the heartbeat configuration                           |
| [INLONG-6234](https://github.com/apache/inlong/issues/6234) | [Improve][DataProxy] Adjust the source report information acquisition source                |
| [INLONG-6228](https://github.com/apache/inlong/issues/6228) | [Improve][DataProxy] Modify the default values of the dataproxy-tube.conf file              |
| [INLONG-6217](https://github.com/apache/inlong/issues/6217) | [Improve][DataProxy] Delete the cluster.id in the common.properties file                    |
| [INLONG-6181](https://github.com/apache/inlong/issues/6181) | [Feature][Agent][DataProxy][Manager] Support query and management for cluster protocol type |
| [INLONG-6156](https://github.com/apache/inlong/issues/6156) | [Bug][DataProxy] Twice event write when topic is empty                                      |
| [INLONG-6065](https://github.com/apache/inlong/issues/6065) | [Bug][DataProxy] Delete the Pulsar client synchronously when deleting a topic               |
| [INLONG-6052](https://github.com/apache/inlong/issues/6052) | [Bug][DataProxy] Wrong value set in PulsarClientService                                     |
| [INLONG-6049](https://github.com/apache/inlong/issues/6049) | [Improve][DataProxy] Optimize exception stack information is not printed in some scenes     |
| [INLONG-6040](https://github.com/apache/inlong/issues/6040) | [Bug][DataProxy] DataProxy does not fully update the configurations                         |
| [INLONG-6012](https://github.com/apache/inlong/issues/6012) | [Bug][DataProxy] Adjust the fields statistics unit in DataProxyMetricItemSet                |
| [INLONG-6005](https://github.com/apache/inlong/issues/6005) | [Bug][DataProxy] Bug with metics values                                                     |
| [INLONG-5948](https://github.com/apache/inlong/issues/5948) | [Improve][Agent][DataProxy] Add the enable audit environment                                |
| [INLONG-5917](https://github.com/apache/inlong/issues/5917) | [Improve][DataProxy] Optimize TubeSink class                                                |
| [INLONG-5899](https://github.com/apache/inlong/issues/5899) | [Improve][DataProxy] Optimize Http's SimpleMessageHandler class                             |
| [INLONG-5880](https://github.com/apache/inlong/issues/5880) | [Improve][DataProxy] Add data reporting time process logic                                  |
| [INLONG-5834](https://github.com/apache/inlong/issues/5834) | [Bug][DataProxy] The sink metric in MQ Zone has some mistakes                               |
| [INLONG-5830](https://github.com/apache/inlong/issues/5830) | [Bug][DataProxy] Required parameter topic exception                                         |
| [INLONG-5788](https://github.com/apache/inlong/issues/5788) | [Bug][DataProxy] Incorrect readFailSize metric value                                        |
| [INLONG-5770](https://github.com/apache/inlong/issues/5770) | [Improve][DataProxy] Optimize the method of obtaining the local IP address                  |
| [INLONG-5723](https://github.com/apache/inlong/issues/5723) | [Bug][DataProxy] Source and sink metrics are incorrect when msgType=5                       |
| [INLONG-5718](https://github.com/apache/inlong/issues/5718) | [Bug][Manager][DataProxy] Fix the conflict of %m and %mask in the log4j2.xml                |
| [INLONG-5658](https://github.com/apache/inlong/issues/5658) | [Bug][DataProxy] Docker script error                                                        |
| [INLONG-4962](https://github.com/apache/inlong/issues/4962) | [Improve][DataProxy] Unify the Usage of Message Queue                                       |
| [INLONG-1959](https://github.com/apache/inlong/issues/1959) | [Feature][Manager][DataProxy] Support register DataProxy IP to the Manager automatically    |

### TubeMQ
| ISSUE                                                       | Summary                                                                                                |
|:------------------------------------------------------------|:-------------------------------------------------------------------------------------------------------|
| [INLONG-6446](https://github.com/apache/inlong/issues/6446) | [Bug][TubeMQ] Fix misuse of SECT_TOKEN_BROKER                                                          |
| [INLONG-6422](https://github.com/apache/inlong/issues/6422) | [Bug][TubeMQ] Deleting the topic was unsuccessful                                                      |
| [INLONG-6421](https://github.com/apache/inlong/issues/6421) | [Bug][TubeMQ] Host should not be blank                                                                 |
| [INLONG-6419](https://github.com/apache/inlong/issues/6419) | [Bug][TubeMQ] Correct some misuse of META_DEFAULT_BROKER_PORT                                          |
| [INLONG-6303](https://github.com/apache/inlong/issues/6303) | [Improve][TubeMQ] Unify the guava version for the TubeMQ manager                                       |
| [INLONG-6158](https://github.com/apache/inlong/issues/6158) | [Improve][TubeMQ] Add ZooKeeper request timeout configuration                                          |
| [INLONG-6142](https://github.com/apache/inlong/issues/6142) | [Improve][TubeMQ] Added client-balanced consumer group control API                                     |
| [INLONG-6138](https://github.com/apache/inlong/issues/6138) | [Improve][TubeMQ] Update the API called by the js files in the resource                                |
| [INLONG-6133](https://github.com/apache/inlong/issues/6133) | [Improve][TubeMQ] Add query parameter groupName in method admin_query_consumer_regmap                  |
| [INLONG-6126](https://github.com/apache/inlong/issues/6126) | [Improve][TubeMQ] Optimize StoreRepairAdmin logic                                                      |
| [INLONG-6124](https://github.com/apache/inlong/issues/6124) | [Improve][TubeMQ] Small optimizations about the implementation of metadata logic                       |
| [INLONG-6117](https://github.com/apache/inlong/issues/6117) | [Improve][TubeMQ] Optimize the implementation of adminQueryBrokerTopicCfgAndRunInfo                    |
| [INLONG-6110](https://github.com/apache/inlong/issues/6110) | [Improve][TubeMQ] Optimize the implementation logic of adding or modifying TopicCtrlEntity records     |
| [INLONG-6108](https://github.com/apache/inlong/issues/6108) | [Improve][TubeMQ] Added booked consume group query APIs                                                |
| [INLONG-6098](https://github.com/apache/inlong/issues/6098) | [Improve][TubeMQ] Add preprocessing condition check                                                    |
| [INLONG-6096](https://github.com/apache/inlong/issues/6096) | [Improve][TubeMQ] Optimize some code styles under the nodeconsumer module                              |
| [INLONG-6092](https://github.com/apache/inlong/issues/6092) | [Bug][TubeMQ] Change the way to obtain the modifyUser  and modifyDate                                  |
| [INLONG-6038](https://github.com/apache/inlong/issues/6038) | [Improve][TubeMQ] Optimize FlowCtrlRuleHandler.updateFlowCtrlInfo()                                    |
| [INLONG-6035](https://github.com/apache/inlong/issues/6035) | [Improve][TubeMQ] Add Broker's message append and file refresh delay statistics                        |
| [INLONG-6019](https://github.com/apache/inlong/issues/6019) | [Improve][TubeMQ] Modify the name of variables and APIs in Broker statistics related classes           |
| [INLONG-5946](https://github.com/apache/inlong/issues/5946) | [Improve][TubeMQ] AbstractDaemonService implementation optimization                                    |
| [INLONG-5907](https://github.com/apache/inlong/issues/5907) | [Improve][TubeMQ] Replace the while-sleep with ScheduledExecutorService for tube server loopProcess    |
| [INLONG-5867](https://github.com/apache/inlong/issues/5867) | [Improve][TubeMQ] Add registered partition information printing                                        |
| [INLONG-5859](https://github.com/apache/inlong/issues/5859) | [Improve][TubeMQ] Optimize redundant code in DefaultOffsetManager                                      |
| [INLONG-5848](https://github.com/apache/inlong/issues/5848) | [Bug][TubeMQ] Get duplicated call when calling TubeMQConsumer::Start()                                 |
| [INLONG-5795](https://github.com/apache/inlong/issues/5795) | [Improve][TubeMQ]Optimize the implementation of ConsumerEvent.toStrBuilder()                           |
| [INLONG-5748](https://github.com/apache/inlong/issues/5748) | [Improve][TubeMQ] Remove the virtual keyword of the destructor of the TubeMQTDMsg and DataItem classes |
| [INLONG-5700](https://github.com/apache/inlong/issues/5700) | [Bug][TubeMQ] Core file generated while the C++ consumer is closed                                     |
| [INLONG-5687](https://github.com/apache/inlong/issues/5687) | [Improve][TubeMQ] Missing log content in the tests directory                                           |
| [INLONG-5681](https://github.com/apache/inlong/issues/5681) | [Bug][TubeMQ] The C++ SDK does not switch after the active Master node hangs up                        |

### Manager
| ISSUE                                                       | Summary                                                                                                                         |
|:------------------------------------------------------------|:--------------------------------------------------------------------------------------------------------------------------------|
| [INLONG-6415](https://github.com/apache/inlong/issues/6415) | [Bug][Manager] JSON serialization failure in SortSourceService                                                                  |
| [INLONG-6412](https://github.com/apache/inlong/issues/6412) | [Improve][Manager] Add a parameter to control whether to initiate the process for StreamSink                                    |
| [INLONG-6410](https://github.com/apache/inlong/issues/6410) | [Bug][Manager] The extension parameters of group and stream cannot be saved to ext_params                                       |
| [INLONG-6399](https://github.com/apache/inlong/issues/6399) | [Feature][Manager] Support adding extension params for InLong Group and InLong Stream                                           |
| [INLONG-6395](https://github.com/apache/inlong/issues/6395) | [Bug][Manager] Wrong annotation in the delete method of InlongStreamApi                                                         |
| [INLONG-6387](https://github.com/apache/inlong/issues/6387) | [Improve][Manager] Adapt auto-push source type status and fix source field update                                               |
| [INLONG-6371](https://github.com/apache/inlong/issues/6371) | [Bug][Manager] Lack of topic and cache zone properties in getSortSource method                                                  |
| [INLONG-6361](https://github.com/apache/inlong/issues/6361) | [Bug][Manager] Fix the deserialization error below jackson version 2.13                                                         |
| [INLONG-6352](https://github.com/apache/inlong/issues/6352) | [Improve][Manager] Add a global config for whether to use ZooKeeper to manage the Sort task                                     |
| [INLONG-6349](https://github.com/apache/inlong/issues/6349) | [Feature][Manager] Support update and delete StreamSink by key in Client                                                        |
| [INLONG-6347](https://github.com/apache/inlong/issues/6347) | [Bug][Manager] MQ type is missing from the getSortSource method and NPE should not be thrown                                    |
| [INLONG-6343](https://github.com/apache/inlong/issues/6343) | [Bug][Manager] Get NullPointerException when bind cluster                                                                       |
| [INLONG-6297](https://github.com/apache/inlong/issues/6297) | [Feature][Manager] Refactor the PollerPlugin and SortPoller interfaces                                                          |
| [INLONG-6288](https://github.com/apache/inlong/issues/6288) | [Feature][Manager] Refactor getSortClusterConfig by using MyBatis Cursor                                                        |
| [INLONG-6282](https://github.com/apache/inlong/issues/6282) | [Bug][Manager] The client deletes the sources or sinks not working                                                              |
| [INLONG-6276](https://github.com/apache/inlong/issues/6276) | [Bug][Manager] The data separator is a number when submitting the Sort task                                                     |
| [INLONG-6268](https://github.com/apache/inlong/issues/6268) | [Improve][Manager] Support raw format for Load nodes                                                                            |
| [INLONG-6266](https://github.com/apache/inlong/issues/6266) | [Improve][Manager][DataProxy]  Change the heartbeat configuration                                                               |
| [INLONG-6248](https://github.com/apache/inlong/issues/6248) | [Feature][Manager] Optimize task status management                                                                              |
| [INLONG-6232](https://github.com/apache/inlong/issues/6232) | [Feature][Manager] Support Apache Doris load node management                                                                    |
| [INLONG-6222](https://github.com/apache/inlong/issues/6222) | [Bug][Manager] Parse the source type error in Command tools                                                                     |
| [INLONG-6220](https://github.com/apache/inlong/issues/6220) | [Improve][Manager] Support query cluster nodes by the manager client                                                            |
| [INLONG-6216](https://github.com/apache/inlong/issues/6216) | [Feature][Manager] Support getting topic and backup topic for InlongGroup                                                       |
| [INLONG-6209](https://github.com/apache/inlong/issues/6209) | [Improve][Manager] Clean and reuse code for DataNode                                                                            |
| [INLONG-6192](https://github.com/apache/inlong/issues/6192) | [Improve][Manager] Clean and reuse code for StreamSink                                                                          |
| [INLONG-6188](https://github.com/apache/inlong/issues/6188) | [Bug][Manager] Join transform node should supports more than one fields to join                                                 |
| [INLONG-6181](https://github.com/apache/inlong/issues/6181) | [Feature][Agent][DataProxy][Manager] Support query and management for cluster protocol type                                     |
| [INLONG-6179](https://github.com/apache/inlong/issues/6179) | [Feature][Manager] Add RAW dataformat enum                                                                                      |
| [INLONG-6171](https://github.com/apache/inlong/issues/6171) | [Bug][Manager] Fix the lightweight group node relation compatibility error                                                      |
| [INLONG-6159](https://github.com/apache/inlong/issues/6159) | [Bug][Manager] Heartbeat update failed but return success                                                                       |
| [INLONG-6154](https://github.com/apache/inlong/issues/6154) | [Feature][Manager] Support to get audit data from the ClickHouse                                                                |
| [INLONG-6151](https://github.com/apache/inlong/issues/6151) | [Feature][Manager] Add logically deleted group purging                                                                          |
| [INLONG-6146](https://github.com/apache/inlong/issues/6146) | [Bug][Manager] Using error jackson dependency when build dataflow json string                                                   |
| [INLONG-6136](https://github.com/apache/inlong/issues/6136) | [Bug][Manager] Cannot find manager-web.log in docker mode                                                                       |
| [INLONG-6121](https://github.com/apache/inlong/issues/6121) | [Bug][Manager] Stream source list not assigned when list stream info                                                            |
| [INLONG-6105](https://github.com/apache/inlong/issues/6105) | [Umbrella] [Manager]  Manager support delete/update by unique key                                                               |
| [INLONG-6104](https://github.com/apache/inlong/issues/6104) | [Feature][Manager] Support getting backup info in getSortSource                                                                 |
| [INLONG-6101](https://github.com/apache/inlong/issues/6101) | [Feature][Manager] Support updating and deleting inlong cluster by key                                                          |
| [INLONG-6089](https://github.com/apache/inlong/issues/6089) | [Feature][Manager][Sort] Kafka extract node supports raw format and timestamp scan mode                                         |
| [INLONG-6088](https://github.com/apache/inlong/issues/6088) | [Improve][Sort][Manager] Scan mode support timestamp for Kafka extract node                                                     |
| [INLONG-6086](https://github.com/apache/inlong/issues/6086) | [Feature][Manager] Support updating and deleting stream sink by key                                                             |
| [INLONG-6085](https://github.com/apache/inlong/issues/6085) | [Improve][Manager] Remove the unused data consumption related classes                                                           |
| [INLONG-6080](https://github.com/apache/inlong/issues/6080) | [Bug][Manager] Change the unused DataNodeResponse to DataNodeInfo                                                               |
| [INLONG-6078](https://github.com/apache/inlong/issues/6078) | [Improve][Manager][Sort] Add VarBinary data type and extend binary for supporting length                                        |
| [INLONG-6068](https://github.com/apache/inlong/issues/6068) | [Improve][Manager] Optimize the usage of ObjectMapper                                                                           |
| [INLONG-6063](https://github.com/apache/inlong/issues/6063) | [Feature][Manager] Use the data node info for ClickHouse and Iceberg                                                            |
| [INLONG-6042](https://github.com/apache/inlong/issues/6042) | [Feature][Manager] Support updating and deleting DataNode by key                                                                |
| [INLONG-6018](https://github.com/apache/inlong/issues/6018) | [Improve][Manager] Using the Hive data node when creating group resources                                                       |
| [INLONG-6014](https://github.com/apache/inlong/issues/6014) | [Bug][Manager] Int type cannot be compared with null using ==                                                                   |
| [INLONG-6004](https://github.com/apache/inlong/issues/6004) | [Feature][Manager] Command tools add CRUD for inlong cluster node                                                               |
| [INLONG-6003](https://github.com/apache/inlong/issues/6003) | [Bug][Manager] The transform source node relation is incorrect under standard mode                                              |
| [INLONG-6001](https://github.com/apache/inlong/issues/6001) | [Improve][Manager] Workflow cannot be triggered when a new sink is created under a successful stream                            |
| [INLONG-6000](https://github.com/apache/inlong/issues/6000) | [Feature][Manager] Abstract Topic info to facilitate the expansion of different MQ                                              |
| [INLONG-5998](https://github.com/apache/inlong/issues/5998) | [Bug][Manager] Sub-source suffix name not consistent with the validation rule                                                   |
| [INLONG-5996](https://github.com/apache/inlong/issues/5996) | [Improve][Manager] Add a previous status field for InlongConsume                                                                |
| [INLONG-5990](https://github.com/apache/inlong/issues/5990) | [Feature][Manager] Command tools add CRUD for inlong cluster tag                                                                |
| [INLONG-5984](https://github.com/apache/inlong/issues/5984) | [Improve][Manager] Optimize the logic related to the InlongConsume process                                                      |
| [INLONG-5978](https://github.com/apache/inlong/issues/5978) | [Feature][Manager] Add protocol type in cluster nodes                                                                           |
| [INLONG-5975](https://github.com/apache/inlong/issues/5975) | [Bug][Manager] Unify transform node processing in both lightweight and standard modes                                           |
| [INLONG-5962](https://github.com/apache/inlong/issues/5962) | [Improve][Manager] Add additional parameters for the Agent cluster                                                              |
| [INLONG-5956](https://github.com/apache/inlong/issues/5956) | [Feature][Manager] Support MySQL node configuration                                                                             |
| [INLONG-5953](https://github.com/apache/inlong/issues/5953) | [Bug][Manager] DataProxy nodes are not filtered by status when necessary                                                        |
| [INLONG-5936](https://github.com/apache/inlong/issues/5936) | [Bug][Manager] Wrong return type in cluster API                                                                                 |
| [INLONG-5919](https://github.com/apache/inlong/issues/5919) | [Bug][Manager] Failed to obtain the group information of mq type kafka                                                          |
| [INLONG-5904](https://github.com/apache/inlong/issues/5904) | [Bug][Manager] Manager client and client tools missing some packages                                                            |
| [INLONG-5897](https://github.com/apache/inlong/issues/5897) | [Feature][Manager] Support query audit data by user role                                                                        |
| [INLONG-5885](https://github.com/apache/inlong/issues/5885) | [Improve][Manager] Refactor the task issue logic to simply code complexity                                                      |
| [INLONG-5881](https://github.com/apache/inlong/issues/5881) | [Improve][Manager] JDBC URL of MySQL was vulnerable to security attacks                                                         |
| [INLONG-5876](https://github.com/apache/inlong/issues/5876) | [Feature][Manager] Remove the check of data separator to support custom it                                                      |
| [INLONG-5875](https://github.com/apache/inlong/issues/5875) | [Bug][Manager] Sub source version is incorrectly copied from template entity                                                    |
| [INLONG-5863](https://github.com/apache/inlong/issues/5863) | [Feature][Manager] Extend Redis extract node                                                                                    |
| [INLONG-5849](https://github.com/apache/inlong/issues/5849) | [Bug][Manager] The inlong group ext info was not updated by the client                                                          |
| [INLONG-5846](https://github.com/apache/inlong/issues/5846) | [Bug][Manager] SQL exception to check if consumer exists                                                                        |
| [INLONG-5844](https://github.com/apache/inlong/issues/5844) | [Bug][Manager] Sub sources should be filtered when querying task status                                                         |
| [INLONG-5836](https://github.com/apache/inlong/issues/5836) | [Bug][Manager] Stream source status related behavior problem fix                                                                |
| [INLONG-5825](https://github.com/apache/inlong/issues/5825) | [Bug][Manager] SortSourceService should not limit the MQ type of group                                                          |
| [INLONG-5824](https://github.com/apache/inlong/issues/5824) | [Bug][Manager] Logging is broken due to log4j conflicts                                                                         |
| [INLONG-5820](https://github.com/apache/inlong/issues/5820) | [Bug][Manager] AutoPush source task cannot be deleted properly                                                                  |
| [INLONG-5812](https://github.com/apache/inlong/issues/5812) | [Bug][Manager] If the data groupfails to be executed after approval it cannot be executed again                                 |
| [INLONG-5810](https://github.com/apache/inlong/issues/5810) | [Feature][Manager] Supplement the workflow event API in the manager client                                                      |
| [INLONG-5799](https://github.com/apache/inlong/issues/5799) | [Bug][Manager] The stream source task is unable to be stopped/deleted/restarted                                                 |
| [INLONG-5781](https://github.com/apache/inlong/issues/5781) | [Feature][Manager] Support creating consumer groups for all sinks                                                               |
| [INLONG-5775](https://github.com/apache/inlong/issues/5775) | [Improve][Manager] Add unit tests for the Inlong Consume                                                                        |
| [INLONG-5769](https://github.com/apache/inlong/issues/5769) | [Bug][Manager] Unsupported type=FILE for SourceOperateListener                                                                  |
| [INLONG-5765](https://github.com/apache/inlong/issues/5765) | [Feature][Manager] Supplement the heartbeat API in the manager client                                                           |
| [INLONG-5756](https://github.com/apache/inlong/issues/5756) | [Improve][Manager] Change the accept condition for SortConfigListener                                                           |
| [INLONG-5752](https://github.com/apache/inlong/issues/5752) | [Improve][Manager] Change the text type to medium text to avoid saving long data failed                                         |
| [INLONG-5739](https://github.com/apache/inlong/issues/5739) | [Feature][Manager] Supplement the anno API in the manager client                                                                |
| [INLONG-5729](https://github.com/apache/inlong/issues/5729) | [Bug][Manager] Suspend the agent sources failed as the inlong group cannot be updated                                           |
| [INLONG-5726](https://github.com/apache/inlong/issues/5726) | [Improve][Manager] Remove unused DB and File source classes                                                                     |
| [INLONG-5718](https://github.com/apache/inlong/issues/5718) | [Bug][Manager][DataProxy] Fix the conflict of %m and %mask in the log4j2.xml                                                    |
| [INLONG-5705](https://github.com/apache/inlong/issues/5705) | [Bug][Manager] The PageInfo was deprecated in the pagination quey                                                               |
| [INLONG-5703](https://github.com/apache/inlong/issues/5703) | [Feature][Manager] Add separator-related fields for File/Kafka and Pulsar sources                                               |
| [INLONG-5701](https://github.com/apache/inlong/issues/5701) | [Feature][Manager][Sort] Support raw format                                                                                     |
| [INLONG-5698](https://github.com/apache/inlong/issues/5698) | [Bug][Manager] The DataProxy cluster tag was restored after restarting the manager                                              |
| [INLONG-5694](https://github.com/apache/inlong/issues/5694) | [Bug][Manager] Get the inlong group failed when the Init-Sort task execution failed                                             |
| [INLONG-5691](https://github.com/apache/inlong/issues/5691) | [Bug][Manager] Database field length is too small for agent_ip                                                                  |
| [INLONG-5689](https://github.com/apache/inlong/issues/5689) | [Feature][Manager] PulsarSource support set fieldDelimiter when use CSV format                                                  |
| [INLONG-5680](https://github.com/apache/inlong/issues/5680) | [Bug][Manager][Sort] Fix field relation object generate error cause generate union SQL throw NPE                                |
| [INLONG-5670](https://github.com/apache/inlong/issues/5670) | [Bug][Manager] Mask sensitive message in Java stack traces                                                                      |
| [INLONG-5650](https://github.com/apache/inlong/issues/5650) | [Improve][Manager] Remove the non-null check of the Pulsar adminURL                                                             |
| [INLONG-5611](https://github.com/apache/inlong/issues/5611) | [Bug][Manager] Wrong sink status after updating the sink info when the inlong group was not submitted                           |
| [INLONG-5302](https://github.com/apache/inlong/issues/5302) | [Feature][Manager] Supports the extension of data consumption for different MQs                                                 |
| [INLONG-5290](https://github.com/apache/inlong/issues/5290) | [Improve][Manager] Optimize the objects returned by paging queries                                                              |
| [INLONG-5102](https://github.com/apache/inlong/issues/5102) | [Feature][Manager] Support CRUD for inlong cluster                                                                              |
| [INLONG-5049](https://github.com/apache/inlong/issues/5049) | [Feature][Manager] Improve user management                                                                                      |
| [INLONG-5043](https://github.com/apache/inlong/issues/5043) | [Feature][Manager] Add Apache Doris load node management                                                                        |
| [INLONG-4976](https://github.com/apache/inlong/issues/4976) | [Feature][Manager] Support Kafka                                                                                                |
| [INLONG-1959](https://github.com/apache/inlong/issues/1959) | [Feature][Manager][DataProxy] Support register DataProxy IP to the Manager automatically                                        |
| [INLONG-5776](https://github.com/apache/inlong/issues/5776) | [Improve][Manager] Add tenant param for Pulsar info                                                                             |
| [INLONG-5024](https://github.com/apache/inlong/issues/5024) | [Bug][Manager] The error message is not right when deleting a successful inlong group                                           |

### Sort
| ISSUE                                                       | Summary                                                                                                        |
|:------------------------------------------------------------|:---------------------------------------------------------------------------------------------------------------|
| [INLONG-6402](https://github.com/apache/inlong/issues/6402) | [Improve][Sort] Modify the metadata field of Oracle connector                                                  |
| [INLONG-6401](https://github.com/apache/inlong/issues/6401) | [Bug][Sort] Schema update is stuck in an endless loop and causes stack overflow in multiple sink scenes        |
| [INLONG-6382](https://github.com/apache/inlong/issues/6382) | [Bug][Sort] Iceberg data is messed up when the source table has no primary key in multiple sink scenes         |
| [INLONG-6379](https://github.com/apache/inlong/issues/6379) | [Bug][Sort] Iceberg misses metric data in multiple sink scenes                                                 |
| [INLONG-6373](https://github.com/apache/inlong/issues/6373) | [Bug][Sort] The time value is wrong when the data type is datetime and timestamp                               |
| [INLONG-6370](https://github.com/apache/inlong/issues/6370) | [Bug][Sort] The debezium format supported by all-db-migration should be 'u' or 'update'                        |
| [INLONG-6356](https://github.com/apache/inlong/issues/6356) | [Bug][Sort] Verify all field types for Oracle connector                                                        |
| [INLONG-6353](https://github.com/apache/inlong/issues/6353) | [Bug][Sort] Fix delete event handle error for doris connector                                                  |
| [INLONG-6345](https://github.com/apache/inlong/issues/6345) | [Bug][Sort] Add metrics for Doris connector                                                                    |
| [INLONG-6335](https://github.com/apache/inlong/issues/6335) | [Bug][Sort] MySql all migrate not support blob and binary data                                                 |
| [INLONG-6326](https://github.com/apache/inlong/issues/6326) | [Improve][Sort] Incorrect log type in the all migrate converter                                                |
| [INLONG-6322](https://github.com/apache/inlong/issues/6322) | [Bug][Sort] Fix write data incorrect for doris connector with  sink multiple scenario                          |
| [INLONG-6318](https://github.com/apache/inlong/issues/6318) | [Improve][Sort] MySQL connector supports snapshots and restores the metric state                               |
| [INLONG-6311](https://github.com/apache/inlong/issues/6311) | [Bug][Sort] Missing fields error for the old Canal JSON data in multiple sink scenes                           |
| [INLONG-6307](https://github.com/apache/inlong/issues/6307) | [Improve][Sort] Add whether to ignore single-table error policy processing for multiple sink of DorisLoadNode  |
| [INLONG-6301](https://github.com/apache/inlong/issues/6301) | [Bug][Sort] Add metrics and strategies for the Doris connector                                                 |
| [INLONG-6296](https://github.com/apache/inlong/issues/6296) | [Improve][Sort] Split one record to multiple records when the physical data has more records for KafkaLoadNode |
| [INLONG-6283](https://github.com/apache/inlong/issues/6283) | [Bug][Sort] JAR conflict between sort-dist and sort-connector                                                  |
| [INLONG-6274](https://github.com/apache/inlong/issues/6274) | [Feature][Sort] Support multiple sink for IcebergLoadNode                                                      |
| [INLONG-6271](https://github.com/apache/inlong/issues/6271) | [Bug][Sort] Unhandled update_before data in canal json in multiple sink scene                                  |
| [INLONG-6256](https://github.com/apache/inlong/issues/6256) | [Feature][Sort] Support  debezium-json format with schema parse for DebeziumJsonDynamicSchemaFormat            |
| [INLONG-6250](https://github.com/apache/inlong/issues/6250) | [Bug][Sort] MySQL -> Iceberg exception when data is timestamp                                                  |
| [INLONG-6246](https://github.com/apache/inlong/issues/6246) | [Feature][Sort] Import multiple sink option  and schema update handle policy                                   |
| [INLONG-6243](https://github.com/apache/inlong/issues/6243) | [Feature][Sort] Support custom name for Sort job                                                               |
| [INLONG-6214](https://github.com/apache/inlong/issues/6214) | [Feature][Sort]  Import schema and data parsing ability for DynamicSchemaFormat                                |
| [INLONG-6212](https://github.com/apache/inlong/issues/6212) | [Feature][Sort] Support multiple sink for DorisLoadNode                                                        |
| [INLONG-6174](https://github.com/apache/inlong/issues/6174) | [Feature][Sort] MySQL connector support meta data with debezium format                                         |
| [INLONG-6166](https://github.com/apache/inlong/issues/6166) | [Bug][Sort] Fix can not get pkNames  metadata for MySqlExtractNode                                             |
| [INLONG-6160](https://github.com/apache/inlong/issues/6160) | [Feature][Sort] Support dynamic partition for KafkaLoadNode                                                    |
| [INLONG-6152](https://github.com/apache/inlong/issues/6152) | [Feature][Sort] MySQL connector support filtering kinds of row data                                            |
| [INLONG-6149](https://github.com/apache/inlong/issues/6149) | [Bug][Sort] Iceberg delete key cause ArrayIndexOutOfBoundsException                                            |
| [INLONG-6116](https://github.com/apache/inlong/issues/6116) | [Feature][Sort] Support dynamic topic for KafkaLoadNode                                                        |
| [INLONG-6113](https://github.com/apache/inlong/issues/6113) | [Feature][Sort] Mysql cdc connector support read table schema when using debezium function                     |
| [INLONG-6089](https://github.com/apache/inlong/issues/6089) | [Feature][Manager][Sort] Kafka extract node supports raw format and timestamp scan mode                        |
| [INLONG-6088](https://github.com/apache/inlong/issues/6088) | [Improve][Sort][Manager] Scan mode support timestamp for Kafka extract node                                    |
| [INLONG-6078](https://github.com/apache/inlong/issues/6078) | [Improve][Manager][Sort] Add VarBinary data type and extend binary for supporting length                       |
| [INLONG-6045](https://github.com/apache/inlong/issues/6045) | [Feature][Sort] Support all migrate for Oracle connector                                                       |
| [INLONG-6027](https://github.com/apache/inlong/issues/6027) | [Bug][Sort] Dlc did not restore metric data successfully                                                       |
| [INLONG-6016](https://github.com/apache/inlong/issues/6016) | [Bug][Sort] Serialization failed when submit load DLC sort job                                                 |
| [INLONG-5992](https://github.com/apache/inlong/issues/5992) | [Bug][Sort] Fix runtimeContext  not initialized in JDBC and ES when reload metric status                       |
| [INLONG-5971](https://github.com/apache/inlong/issues/5971) | [Feature][Sort] Support metrics state restore for dlc-iceberg connector                                        |
| [INLONG-5970](https://github.com/apache/inlong/issues/5970) | [Feature][Sort] Support metrics state restore for iceberg connector                                            |
| [INLONG-5969](https://github.com/apache/inlong/issues/5969) | [Feature][Sort] Support metrics state restore for hive connector                                               |
| [INLONG-5959](https://github.com/apache/inlong/issues/5959) | [Feature][Sort] Support metric state recovery for filesystem                                                   |
| [INLONG-5955](https://github.com/apache/inlong/issues/5955) | [Feature][Sort] Support metric state recovery for HBase                                                        |
| [INLONG-5952](https://github.com/apache/inlong/issues/5952) | [Feature][Sort] Support metrics state restore for Pulsar connector without adminurl                            |
| [INLONG-5950](https://github.com/apache/inlong/issues/5950) | [Feature][Sort] Support metric state recovery for mongodb-cdc                                                  |
| [INLONG-5944](https://github.com/apache/inlong/issues/5944) | [Improve][Sort] Add metric state for es6 and es7                                                               |
| [INLONG-5943](https://github.com/apache/inlong/issues/5943) | [Improve][Sort] Add metric state for JDBC                                                                      |
| [INLONG-5940](https://github.com/apache/inlong/issues/5940) | [Improve][Sort] Compatible with the old version of sort protocol with mysql and kafka extract node             |
| [INLONG-5933](https://github.com/apache/inlong/issues/5933) | [Feature][Sort] Support metric state recovery for mongodb-cdc                                                  |
| [INLONG-5930](https://github.com/apache/inlong/issues/5930) | [Feature][Sort] Support metric state recovery for sqlserver-cdc                                                |
| [INLONG-5922](https://github.com/apache/inlong/issues/5922) | [Improve][Sort] Add metric state for Kafka and modify mysql metric init                                        |
| [INLONG-5913](https://github.com/apache/inlong/issues/5913) | [Improve][Sort] Add metric state for Oracle                                                                    |
| [INLONG-5903](https://github.com/apache/inlong/issues/5903) | [Improve][Sort] Make InLong metric constructs factory more cohesive                                            |
| [INLONG-5889](https://github.com/apache/inlong/issues/5889) | [Bug][Sort] Fix MySQL node JDBC for RCE vulnerability                                                          |
| [INLONG-5822](https://github.com/apache/inlong/issues/5822) | [Bug][Sort] The metric is empty for Elasticsearch                                                              |
| [INLONG-5818](https://github.com/apache/inlong/issues/5818) | [Bug][Sort] Wrong metric computing for Pulsar connector                                                        |
| [INLONG-5784](https://github.com/apache/inlong/issues/5784) | [Improve][Sort] Add metric state for PostgreSQL                                                                |
| [INLONG-5767](https://github.com/apache/inlong/issues/5767) | [Improve][Sort] IOUtils interface is incompatible in jdk17                                                     |
| [INLONG-5762](https://github.com/apache/inlong/issues/5762) | [Bug][Sort] The computing of Pulsar source metric was wrong                                                    |
| [INLONG-5754](https://github.com/apache/inlong/issues/5754) | [Bug][Sort] Fix Pulsar connecotr deserialize complex format with multiple data will cause data loss            |
| [INLONG-5746](https://github.com/apache/inlong/issues/5746) | [Feature][Sort] Add SPI path for Inlong PB msg                                                                 |
| [INLONG-5737](https://github.com/apache/inlong/issues/5737) | [Bug][Sort] InLongMsg with inner format raw deserialize will throw NullPointException                          |
| [INLONG-5733](https://github.com/apache/inlong/issues/5733) | [Bug][Sort] Slf4j class conflict in Hive connector                                                             |
| [INLONG-5712](https://github.com/apache/inlong/issues/5712) | [Bug][Sort] Fix class not found in Elasticsearch 6 connector for producting                                    |
| [INLONG-5701](https://github.com/apache/inlong/issues/5701) | [Feature][Manager][Sort] Support raw format                                                                    |
| [INLONG-5680](https://github.com/apache/inlong/issues/5680) | [Bug][Manager][Sort] Fix field relation object generate error cause generate union SQL throw NPE               |
| [INLONG-5637](https://github.com/apache/inlong/issues/5637) | [Bug][Sort] Fix kafka  load node npe error                                                                     |
| [INLONG-5613](https://github.com/apache/inlong/issues/5613) | [Feature][Sort] Add interval join support for FlinkSqlParser                                                   |
| [INLONG-5608](https://github.com/apache/inlong/issues/5608) | [Improve][Sort] Reformat connector codes for reporting metrics                                                 |
| [INLONG-5599](https://github.com/apache/inlong/issues/5599) | [Feature][Sort] Add temporal join support for mysql                                                            |
| [INLONG-5469](https://github.com/apache/inlong/issues/5469) | [Feature][Sort] Add metric for Hive with Flink metrics group and audit SDK                                     |
| [INLONG-5193](https://github.com/apache/inlong/issues/5193) | [Feature][Sort] Dlc load data support auto compact file                                                        |

### Audit
| ISSUE                                                       | Summary                                                                              |
|:------------------------------------------------------------|:-------------------------------------------------------------------------------------|
| [INLONG-6309](https://github.com/apache/inlong/issues/6309) | [Bug][Audit] Druid connection pool still init when the store mode is not MySQL       |
| [INLONG-6289](https://github.com/apache/inlong/issues/6289) | [Feature][Docker][Audit] Add configuration to choose starting proxy or store or both |
| [INLONG-6069](https://github.com/apache/inlong/issues/6069) | [Bug][Audit] Not initialized the service before ClickHouse starts                    |
| [INLONG-6031](https://github.com/apache/inlong/issues/6031) | [Improve][Audit] Clean code for InLong Audit                                         |
| [INLONG-6026](https://github.com/apache/inlong/issues/6026) | [Bug][Audit] SQL file executed error for ClickHouse in Audit                         |
| [INLONG-6024](https://github.com/apache/inlong/issues/6024) | [Bug][Audit] Invalid default value for 'sdk_ts'                                      |
| [INLONG-5963](https://github.com/apache/inlong/issues/5963) | [Bug][Audit] Solve the sdk memory leak problem                                       |
| [INLONG-5772](https://github.com/apache/inlong/issues/5772) | [Improve][Audit] The config is missing the comment on ClickHoue option               |
| [INLONG-5710](https://github.com/apache/inlong/issues/5710) | [Bug][Audit] The clickhouse storage service is not initialized properly              |

### Dashboard
| ISSUE                                                       | Summary                                                                              |
|:------------------------------------------------------------|:-------------------------------------------------------------------------------------|
| [INLONG-6397](https://github.com/apache/inlong/issues/6397) | [Feature][Dashboard] Support management for MySQL data node                          |
| [INLONG-6391](https://github.com/apache/inlong/issues/6391) | [Feature][Dashboard] Supports deep merge of field decorator                          |
| [INLONG-6375](https://github.com/apache/inlong/issues/6375) | [Feature][Dashboard] Cluster supports new Kafka type                                 |
| [INLONG-6365](https://github.com/apache/inlong/issues/6365) | [Improve][Dashboard] Modify the options of the data type and modify some file names  |
| [INLONG-6363](https://github.com/apache/inlong/issues/6363) | [Feature][Dashboard] InLong Group supports Kafka MQ                                  |
| [INLONG-6359](https://github.com/apache/inlong/issues/6359) | [Improve][Dashboard] The utils method adds null data compatibility                   |
| [INLONG-6330](https://github.com/apache/inlong/issues/6330) | [Improve][Dashboard] Other sinks support asynchronous loading of plugins             |
| [INLONG-6315](https://github.com/apache/inlong/issues/6315) | [Feature][Dashboard] Support Doris sink                                              |
| [INLONG-6273](https://github.com/apache/inlong/issues/6273) | [Umbrella][Dashboard] Ability to load plugins asynchronously                         |
| [INLONG-6185](https://github.com/apache/inlong/issues/6185) | [Bug][Dashboard] The suffix configuration function will only be executed once        |
| [INLONG-6163](https://github.com/apache/inlong/issues/6163) | [Bug][Dashboard] Form will lose old data when data changes are merged                |
| [INLONG-5986](https://github.com/apache/inlong/issues/5986) | [Improve][Dashboard] Support fieldType field to set length                           |
| [INLONG-5938](https://github.com/apache/inlong/issues/5938) | [Bug][Dashboard] The API parameter of calling to get the topic is lost               |
| [INLONG-5931](https://github.com/apache/inlong/issues/5931) | [Improve][Dashboard] Support query audit data by user role                           |
| [INLONG-5926](https://github.com/apache/inlong/issues/5926) | [Improve][Dashboard] Change the consume related config to adapt the Manager module   |
| [INLONG-5911](https://github.com/apache/inlong/issues/5911) | [Improve][Dashboard] Modify the data group name to the data stream group             |
| [INLONG-5901](https://github.com/apache/inlong/issues/5901) | [Improve][Dashboard] Unified sinks type definition                                   |
| [INLONG-5832](https://github.com/apache/inlong/issues/5832) | [Improve][Dashboard] Unified sources type definition                                 |
| [INLONG-5814](https://github.com/apache/inlong/issues/5814) | [Bug][Dashboard] Supports setting the precision of a field when adding a table field |
| [INLONG-5798](https://github.com/apache/inlong/issues/5798) | [Improve][Dashboard] Support stream fields extends                                   |
| [INLONG-5761](https://github.com/apache/inlong/issues/5761) | [Feature][Dashboard] Add agent type to cluster management                            |
| [INLONG-5749](https://github.com/apache/inlong/issues/5749) | [Bug][Dashboard] Bad node public params                                              |
| [INLONG-5735](https://github.com/apache/inlong/issues/5735) | [Improve][Dashboard] Optimize the development environment and enable vite            |
| [INLONG-5731](https://github.com/apache/inlong/issues/5731) | [Feature][Dashboard] Add data node management                                        |
| [INLONG-5696](https://github.com/apache/inlong/issues/5696) | [Bug][Dashboard] EditableTable value update error when columns change                |
| [INLONG-5122](https://github.com/apache/inlong/issues/5122) | [Bug][Dashboard] The whitelist input format of binlog source need to be optimized    |

### Other
| ISSUE                                                       | Summary                                                                                                                |
|:------------------------------------------------------------|:-----------------------------------------------------------------------------------------------------------------------|
| [INLONG-6190](https://github.com/apache/inlong/issues/6190) | [Improve][SDK] Add protocolType field in DataProxy config                                                              |
| [INLONG-6182](https://github.com/apache/inlong/issues/6182) | [Bug][SDK] RequestTimeoutMillis initialization value error                                                             |
| [INLONG-6119](https://github.com/apache/inlong/issues/6119) | [Improve][SDK] Avoid printing a lot of useless logs                                                                    |
| [INLONG-5808](https://github.com/apache/inlong/issues/5808) | [Feature][SDK] SortSdk support InlongMsg                                                                               |
| [INLONG-5796](https://github.com/apache/inlong/issues/5796) | [Improve][SDK] Optimize fetcher builders                                                                               |
| [INLONG-5665](https://github.com/apache/inlong/issues/5665) | [Improve][SDK] Invoke callback in each MQ message                                                                      |
| [INLONG-5642](https://github.com/apache/inlong/issues/5642) | [Improve][SDK] Change SDK(cpp) logger framework                                                                        |
| [INLONG-5623](https://github.com/apache/inlong/issues/5623) | [Feature][SDK] Support multi-topic fetcher for Kafka                                                                   |
| [INLONG-5621](https://github.com/apache/inlong/issues/5621) | [Feature][SDK] Support multi-topic fetcher for Pulsar                                                                  |
| [INLONG-5495](https://github.com/apache/inlong/issues/5495) | [Feature][SDK] Support multi-topic manager                                                                             |
| [INLONG-5437](https://github.com/apache/inlong/issues/5437) | [Feature][SDK] Support initializing SDK(cpp) by ClientConfig object                                                    |
| [INLONG-6389](https://github.com/apache/inlong/issues/6389) | [Bug][Docker] Configuration file name is different with MQ_TYPE                                                        |
| [INLONG-6341](https://github.com/apache/inlong/issues/6341) | [Improve][Docker] Update the default cluster name for Agent                                                            |
| [INLONG-6339](https://github.com/apache/inlong/issues/6339) | [Improve][Docker] Add a global variable to define the InLong version                                                   |
| [INLONG-6289](https://github.com/apache/inlong/issues/6289) | [Feature][Docker][Audit] Add configuration to choose starting proxy or store or both                                   |
| [INLONG-6280](https://github.com/apache/inlong/issues/6280) | [Feature][Docker] Add tools for dashboard image                                                                        |
| [INLONG-6241](https://github.com/apache/inlong/issues/6241) | [Feature][Docker] Add manager and audit database name configuration                                                    |
| [INLONG-6169](https://github.com/apache/inlong/issues/6169) | [Improve][Docker] Make the topic and address configurable for the audit store                                          |
| [INLONG-6140](https://github.com/apache/inlong/issues/6140) | [Bug][Docker] Docker compose yml config type error                                                                     |
| [INLONG-5890](https://github.com/apache/inlong/issues/5890) | [Bug][Docker] Can not connect the MySQL deployed by Docker                                                             |
| [INLONG-5870](https://github.com/apache/inlong/issues/5870) | [Bug][Docker] Build arm images failed                                                                                  |
| [INLONG-5816](https://github.com/apache/inlong/issues/5816) | [Bug][Docker] CI build images lost aarch64 arch                                                                        |
| [INLONG-5652](https://github.com/apache/inlong/issues/5652) | [Bug][Docker] Push aarch64 images failed                                                                               |
| [INLONG-6291](https://github.com/apache/inlong/issues/6291) | [Improve][CVE] Denial of Service (DoS) risks of the org.ini4j                                                          |
| [INLONG-6263](https://github.com/apache/inlong/issues/6263) | [Improve][CVE] Upgrade com.google.guava to 30.0-jre                                                                    |
| [INLONG-6236](https://github.com/apache/inlong/issues/6236) | [Improve][CVE] Resource exhaustion can occur because of a lack of a check in primitive value for jackson-databind      |
| [INLONG-6231](https://github.com/apache/inlong/issues/6231) | [Improve][CVE] There are 1 security vulnerabilities found in org.apache.hive:hive-exec 3.1.2                           |
| [INLONG-5789](https://github.com/apache/inlong/issues/5789) | [Improve][CVE] Apache Hadoop argument injection vulnerability                                                          |
| [INLONG-5786](https://github.com/apache/inlong/issues/5786) | [Improve][CVE] PostgreSQL JDBC Driver SQL Injection in ResultSet.refreshRow() with malicious column names              |
| [INLONG-5647](https://github.com/apache/inlong/issues/5647) | [Bug][CVE] There is a vulnerability in Jetty 9.4.44.v20210927: Java based HTTP/1.x HTTP/2 / Servlet / WebSocket Server |
| [INLONG-5645](https://github.com/apache/inlong/issues/5645) | [Bug][CVE] There is a vulnerability in pagehelper  5.3.0                                                               |
| [INLONG-6082](https://github.com/apache/inlong/issues/6082) | [Bug][CI] The greeting action runs failed                                                                              |
| [INLONG-5724](https://github.com/apache/inlong/issues/5724) | [Improve][CI] Skip the apache-rat-plugin when building the docker-compose                                              |

## Release InLong 1.3.0 - Released (as of 2022-08-23)

### Agent
| ISSUE                                                       | Summary                                                                                   |
|:------------------------------------------------------------|:------------------------------------------------------------------------------------------|
| [INLONG-5540](https://github.com/apache/inlong/issues/5540) | [Bug][Agent] MySQL binlog reader has NPE error                                            |
| [INLONG-5533](https://github.com/apache/inlong/issues/5533) | [Improve][Agent] Support structured output in the Kubernetes                              |
| [INLONG-5474](https://github.com/apache/inlong/issues/5474) | [Improve][Manager][Agent] Add metadata  parameter                                         |
| [INLONG-5466](https://github.com/apache/inlong/issues/5466) | [Improve][Agent] Add Manager Open API  secret config                                      |
| [INLONG-5428](https://github.com/apache/inlong/issues/5428) | [Improve][Agent] Abstract metrics interface to be easier to extend                        |
| [INLONG-5382](https://github.com/apache/inlong/issues/5382) | [Improve][Manager][Agent] Optimized the file collection configuration                     |
| [INLONG-5362](https://github.com/apache/inlong/issues/5362) | [Feature][Agent] Supports the collection of data splicing metadata information            |
| [INLONG-5347](https://github.com/apache/inlong/issues/5347) | [Feature][Agent] Incremental and full reads of file contents                              |
| [INLONG-5277](https://github.com/apache/inlong/issues/5277) | [Bug][Agent] The getManagerIpList request method should change to POST                    |
| [INLONG-5272](https://github.com/apache/inlong/issues/5272) | [Improve][Agent] Change agent.sh format                                                   |
| [INLONG-5224](https://github.com/apache/inlong/issues/5224) | [Improve][Agent][DataProxy] Remove unused StreamConfigLog related classes                 |
| [INLONG-5222](https://github.com/apache/inlong/issues/5222) | [Improve][Manager][Agent][DataProxy] Add heartbeat mechanism for Inlong component cluster |
| [INLONG-5164](https://github.com/apache/inlong/issues/5164) | [Bug][Agent] The agent receive count is zero but the send count not                       |
| [INLONG-5149](https://github.com/apache/inlong/issues/5149) | [Bug][Agent][DataProxy] The log directory for the unit test was incorrect                 |
| [INLONG-5054](https://github.com/apache/inlong/issues/5054) | [Bug][Agent] Agent can not import old job after reboot                                    |
| [INLONG-5046](https://github.com/apache/inlong/issues/5046) | [Feature][Agent] Support collect data from PostgreSQL                                     |
| [INLONG-4824](https://github.com/apache/inlong/issues/4824) | [Improve][Agent] Log output has no line numbers                                           |
| [INLONG-4821](https://github.com/apache/inlong/issues/4821) | [Bug][Agent] The error of null value for key job.instance.id                              |
| [INLONG-4535](https://github.com/apache/inlong/issues/4535) | [Feature][Agent] Support configurable automatic exit function when OOM happens            |
| [INLONG-4233](https://github.com/apache/inlong/issues/4233) | [Feature][Umbrella] Support collect data from a specified position for MySQL binlog       |
| [INLONG-4232](https://github.com/apache/inlong/issues/4232) | [Feature][Agent][Manager] Support collect data from a specified position for MySQL binlog |
| [INLONG-3407](https://github.com/apache/inlong/issues/3407) | [Feature] Make sure job send all messages before it stops                                 |
| [INLONG-3266](https://github.com/apache/inlong/issues/3266) | [Improve][Agent] Get local IP when IP in config is not present                            |
| [INLONG-5601](https://github.com/apache/inlong/issues/5601) | [Improve][Agent] The default triggering policy for file collection is FULL                |
| [INLONG-5259](https://github.com/apache/inlong/issues/5259) | [Feature][Agent] File data sources support custom end-of-line symbols                     |
| [INLONG-5393](https://github.com/apache/inlong/issues/5393) | [Bug][Agent] Docker image of agent stuck in starting                                      |
| [INLONG-5000](https://github.com/apache/inlong/issues/5000) | [Bug][Agent] The forked VM terminated without properly saying goodbye                     |
| [INLONG-4998](https://github.com/apache/inlong/issues/4998) | [Bug][Agent] Create PrometheusMetric repeatedly                                           |
| [INLONG-4854](https://github.com/apache/inlong/issues/4854) | [Improve][Agent] Report metrics at inongGroupId and inlongStreamId                        |
| [INLONG-5589](https://github.com/apache/inlong/issues/5589) | [Improve][Agent] To extend type of file data for k8s log                                  |


### Audit
| ISSUE                                                       | Summary                                                             |
|:------------------------------------------------------------|:--------------------------------------------------------------------|
| [INLONG-4983](https://github.com/apache/inlong/issues/4983) | [Bug][Audit] Unable to start audit proxy using proxy-start.sh       |
| [INLONG-4921](https://github.com/apache/inlong/issues/4921) | [Improve][Audit] Set the configuration file to an absolute path     |
| [INLONG-4579](https://github.com/apache/inlong/issues/4579) | [Feature][Audit] Delete redundant configuration in channel and sink |
| [INLONG-4559](https://github.com/apache/inlong/issues/4559) | [Feature][Audit] Support select channels by random routing          |
| [INLONG-4919](https://github.com/apache/inlong/issues/4919) | [Bug][Audit] Delete the wrong driver-class-name                     |
| [INLONG-4741](https://github.com/apache/inlong/issues/4741) | [Feature][Audit] AuditStore support ClickHouse sink                 |
| [INLONG-5402](https://github.com/apache/inlong/issues/5402) | [Bug][Audit] store-start.sh startup script exception                |


### Dashboard
| ISSUE                                                       | Summary                                                                                         |
|:------------------------------------------------------------|:------------------------------------------------------------------------------------------------|
| [INLONG-5596](https://github.com/apache/inlong/issues/5596) | [Improve][Dashboard] Support locales extends                                                    |
| [INLONG-5592](https://github.com/apache/inlong/issues/5592) | [Improve][Dashboard] HighSelect support addonAfter prop                                         |
| [INLONG-5574](https://github.com/apache/inlong/issues/5574) | [Improve][Dashboard] Support extended consumption fields                                        |
| [INLONG-5565](https://github.com/apache/inlong/issues/5565) | [Improve][Dashboard] Support extended group fields                                              |
| [INLONG-5523](https://github.com/apache/inlong/issues/5523) | [Improve][Dashboard] Support menu permission control                                            |
| [INLONG-5522](https://github.com/apache/inlong/issues/5522) | [Improve][Dashboard] Disable editing of user roles and names                                    |
| [INLONG-5520](https://github.com/apache/inlong/issues/5520) | [Improve][Dashboard] Move cluster config to metas                                               |
| [INLONG-5508](https://github.com/apache/inlong/issues/5508) | [Improve][Dashboard] Adaptive naming conventions                                                |
| [INLONG-5479](https://github.com/apache/inlong/issues/5479) | [Improve][Dashboard] Optimize the group configuration process and use meta management           |
| [INLONG-5456](https://github.com/apache/inlong/issues/5456) | [Improve][Dashboard] Support source/sink metadata management                                    |
| [INLONG-5391](https://github.com/apache/inlong/issues/5391) | [Improve][Dashboard] Unified consumption creation/management logic                              |
| [INLONG-5355](https://github.com/apache/inlong/issues/5355) | [Bug][Dashboard] SinkType config error                                                          |
| [INLONG-5345](https://github.com/apache/inlong/issues/5345) | [Improve][Dashboard] Group approval supports partial field modification                         |
| [INLONG-5340](https://github.com/apache/inlong/issues/5340) | [Bug][Dashboard] 404 error is reported when accessing the dashboard container                   |
| [INLONG-5330](https://github.com/apache/inlong/issues/5330) | [Improve][Dashboard] Stream page optimization adjustment, remove collapse mode                  |
| [INLONG-5319](https://github.com/apache/inlong/issues/5319) | [Bug][Dashboard] An error occurred while creating the  dataproxy cluster                        |
| [INLONG-5234](https://github.com/apache/inlong/issues/5234) | [Bug][Dashboard] Some fields are missing when creating a new stream                             |
| [INLONG-5213](https://github.com/apache/inlong/issues/5213) | [Improve][Dashboard] Adapt to the new data structure of the stream list API                     |
| [INLONG-5142](https://github.com/apache/inlong/issues/5142) | [Improve][Dashboard] Change API paths and parameters to adapt the Manager module                |
| [INLONG-5120](https://github.com/apache/inlong/issues/5120) | [Feature][Dashboard] The list page of stream, source and sink supports status filtering         |
| [INLONG-5082](https://github.com/apache/inlong/issues/5082) | [Bug][Dashboard] Elasticsearch fields cannot be saved                                           |
| [INLONG-5077](https://github.com/apache/inlong/issues/5077) | [Bug][Dashboard] Cannot read properties of undefined (reading 'version')                        |
| [INLONG-5076](https://github.com/apache/inlong/issues/5076) | [Feature][Dashboard] Support  HBase sink                                                        |
| [INLONG-5059](https://github.com/apache/inlong/issues/5059) | [Bug][Dashboard] Unable to get total number                                                     |
| [INLONG-5056](https://github.com/apache/inlong/issues/5056) | [Bug][Dashboard] Unable to get stream list when creating                                        |
| [INLONG-5004](https://github.com/apache/inlong/issues/5004) | [Feature][Dashboard] Support PostgreSQL sink                                                    |
| [INLONG-4997](https://github.com/apache/inlong/issues/4997) | [Improve][Dashboard] Support cluster tag bind and unbind                                        |
| [INLONG-4989](https://github.com/apache/inlong/issues/4989) | [Improve][Dashboard] Modify MySQL sink parameters                                               |
| [INLONG-4953](https://github.com/apache/inlong/issues/4953) | [Improve][Dashboard] Modify Greenplum sink parameters                                           |
| [INLONG-4906](https://github.com/apache/inlong/issues/4906) | [Feature][Dashboard] Support Oracle sink                                                        |
| [INLONG-4902](https://github.com/apache/inlong/issues/4902) | [Improve][Dashboard] Supports audit queries with different time precisions                      |
| [INLONG-4888](https://github.com/apache/inlong/issues/4888) | [Feature][Dashboard] Support MySQL sink                                                         |
| [INLONG-4885](https://github.com/apache/inlong/issues/4885) | [Feature][Dashboard] Support Greenplum Sink                                                     |
| [INLONG-4876](https://github.com/apache/inlong/issues/4876) | [Improve][Dashboard] Added prompt information on tag modification and deletion                  |
| [INLONG-4857](https://github.com/apache/inlong/issues/4857) | [Bug][Dashboard] Unable to get stream information                                               |
| [INLONG-4850](https://github.com/apache/inlong/issues/4850) | [Improve][Dashboard] Add prompt information for some fields in cluster management               |
| [INLONG-4845](https://github.com/apache/inlong/issues/4845) | [Improve][Dashboard] Update the Tube configuration form                                         |
| [INLONG-4809](https://github.com/apache/inlong/issues/4809) | [Improve][Dashboard] Remove and optimize some old logic                                         |
| [INLONG-4752](https://github.com/apache/inlong/issues/4752) | [Bug][Dashboard] Keyword param error                                                            |
| [INLONG-4739](https://github.com/apache/inlong/issues/4739) | [Bug][Dashboard] The pagination of the execution log of the group is invalid                    |
| [INLONG-4668](https://github.com/apache/inlong/issues/4668) | [Feature][Dashboard] Support the config management of the Elasticsearch sink                    |
| [INLONG-5406](https://github.com/apache/inlong/issues/5406) | [Bug][Dashboard] No restrictions are added to the input of port numbers, such as dataproxy node |
| [INLONG-5349](https://github.com/apache/inlong/issues/5349) | [Bug][Dashboard] Failed to create stream                                                        |
| [INLONG-5035](https://github.com/apache/inlong/issues/5035) | [Improve][Dashboard] Support version control for backend APIs                                   |
| [INLONG-4865](https://github.com/apache/inlong/issues/4865) | [Bug][Dashboard] The storage config can still be modified after submitting for approval         |
| [INLONG-4820](https://github.com/apache/inlong/issues/4820) | [Feature][Dashboard] Support cluster tag manage                                                 |


### DataProxy
| ISSUE                                                       | Summary                                                                                            |
|:------------------------------------------------------------|:---------------------------------------------------------------------------------------------------|
| [INLONG-5551](https://github.com/apache/inlong/issues/5551) | [Improve][DataProxy] Add metric log output information in TubeSink                                 |
| [INLONG-5538](https://github.com/apache/inlong/issues/5538) | [Improve][DataProxy] Optimize the Producer construction logic in TubeSink                          |
| [INLONG-5489](https://github.com/apache/inlong/issues/5489) | [Improve][DataProxy] Optimize message deduplication logic                                          |
| [INLONG-5433](https://github.com/apache/inlong/issues/5433) | [Improve][DataProxy] Select the corresponding configuration parameters according to the type of MQ |
| [INLONG-5238](https://github.com/apache/inlong/issues/5238) | [Bug][DataProxy] Error metric params in PulsarZoneSinkContext::addSendFailMetric                   |
| [INLONG-5192](https://github.com/apache/inlong/issues/5192) | [Improve][DataProxy] Added unit tests for the TubeMQ sink                                          |
| [INLONG-5163](https://github.com/apache/inlong/issues/5163) | [Bug][DataProxy] Dataproxy can not send data to pulsar as topic NotFoundException                  |
| [INLONG-5161](https://github.com/apache/inlong/issues/5161) | [Improve][SDK] Remove the redundant annotation for the author                                      |
| [INLONG-5055](https://github.com/apache/inlong/issues/5055) | [Bug][DataProxy] Data send failed due to Pulsar client error                                       |
| [INLONG-4816](https://github.com/apache/inlong/issues/4816) | [Bug][DataProxy] Caught IllegalStateException: No tube service url specified                       |
| [INLONG-4803](https://github.com/apache/inlong/issues/4803) | [Bug][DataProxy] Caught IllegalStateException: No pulsar server url specified                      |

### Manager
| ISSUE                                                       | Summary                                                                                                                      |
|:------------------------------------------------------------|:-----------------------------------------------------------------------------------------------------------------------------|
| [INLONG-5585](https://github.com/apache/inlong/issues/5585) | [Bug][Manager] Some errors of inlong stream API and user API                                                                 |
| [INLONG-5577](https://github.com/apache/inlong/issues/5577) | [Feature][Manager][Sort] Support function fieldType                                                                          |
| [INLONG-5570](https://github.com/apache/inlong/issues/5570) | [Improve][Manager] Add manager client packages into the lib directory                                                        |
| [INLONG-5559](https://github.com/apache/inlong/issues/5559) | [Feature][Manager] Supplement the workflow approver API in the manager client                                                |
| [INLONG-5555](https://github.com/apache/inlong/issues/5555) | [Bug][Manager] Fix missing heartbeat fields and stream source subtask creation                                               |
| [INLONG-5536](https://github.com/apache/inlong/issues/5536) | [Bug][Manager]  Client api version missing on stream info update                                                             |
| [INLONG-5529](https://github.com/apache/inlong/issues/5529) | [Bug][Manager] Fix the error of version not set before updating operation                                                    |
| [INLONG-5517](https://github.com/apache/inlong/issues/5517) | [Bug][Manager] Manager client does not write back the version when updating info                                             |
| [INLONG-5515](https://github.com/apache/inlong/issues/5515) | [Bug][Manager] Repair type of form_data when data too long                                                                   |
| [INLONG-5501](https://github.com/apache/inlong/issues/5501) | [Bug][Manager] Repair type of workflow_process.form_data when data too long                                                  |
| [INLONG-5499](https://github.com/apache/inlong/issues/5499) | [Bug][Manager] The data source is successful, but the status always is issued or added                                       |
| [INLONG-5497](https://github.com/apache/inlong/issues/5497) | [Bug][Manager] DataProxyConfigRepository get error field name                                                                |
| [INLONG-5493](https://github.com/apache/inlong/issues/5493) | [Feature][Manager] Supplement the user API in the manager client                                                             |
| [INLONG-5491](https://github.com/apache/inlong/issues/5491) | [Bug][Manager] Pulsar failed to configure non partitioned topic                                                              |
| [INLONG-5476](https://github.com/apache/inlong/issues/5476) | [Bug][Manager] Heartbeat is not functioning properly under sparse report                                                     |
| [INLONG-5452](https://github.com/apache/inlong/issues/5452) | [Improve][Manager] Change creating resource after group approval to be asynchronous                                          |
| [INLONG-5432](https://github.com/apache/inlong/issues/5432) | [Improve][Manager] Return the type of the MQ cluster when processing the getConfig method                                    |
| [INLONG-5424](https://github.com/apache/inlong/issues/5424) | [Bug][Manager] JSON serialization error for Authentication when getting inlongGroupInfo                                      |
| [INLONG-5419](https://github.com/apache/inlong/issues/5419) | [Bug][Manager] Pulsar creates a specified queue model's error                                                                |
| [INLONG-5411](https://github.com/apache/inlong/issues/5411) | [Improve][Manager] Optimize the creation code of databases and tables of PostgreSQL                                          |
| [INLONG-5409](https://github.com/apache/inlong/issues/5409) | [Bug][Manager] Fix JSON serialization for class BaseSortConf                                                                 |
| [INLONG-5401](https://github.com/apache/inlong/issues/5401) | [Bug][Manager] Fix the problem that StreamSinkFieldEntity and SinkField fields do not match                                  |
| [INLONG-5397](https://github.com/apache/inlong/issues/5397) | [Feature][Manager] Add delete resource in manager client                                                                     |
| [INLONG-5394](https://github.com/apache/inlong/issues/5394) | [Feature][Manager] Support batch task for Inlong group                                                                       |
| [INLONG-5387](https://github.com/apache/inlong/issues/5387) | [Feature][Manager][Sort] Support encrypt records                                                                             |
| [INLONG-5380](https://github.com/apache/inlong/issues/5380) | [Feature][Manager] Modify the saving function of the data node                                                               |
| [INLONG-5369](https://github.com/apache/inlong/issues/5369) | [Improve][Manager] Optimize the user service related function to support third party authentication and authorization plugin |
| [INLONG-5368](https://github.com/apache/inlong/issues/5368) | [Bug][Manager] Update workflow approver error                                                                                |
| [INLONG-5359](https://github.com/apache/inlong/issues/5359) | [Improve][Manager] Add query workflow approver API                                                                           |
| [INLONG-5337](https://github.com/apache/inlong/issues/5337) | [Improve][Manager] Add Agent cluster info and operator                                                                       |
| [INLONG-5335](https://github.com/apache/inlong/issues/5335) | [Improve][Manager] Unserialize Sort config when getting GroupInfo                                                            |
| [INLONG-5333](https://github.com/apache/inlong/issues/5333) | [Improve][Manager] Add array, map, struct, and decimal format                                                                |
| [INLONG-5324](https://github.com/apache/inlong/issues/5324) | [Improve][Manager] Optimize configuration files and scripts                                                                  |
| [INLONG-5308](https://github.com/apache/inlong/issues/5308) | [Improve][Dashboard] Change MQ and cluster type to adapt the Manager module                                                  |
| [INLONG-5305](https://github.com/apache/inlong/issues/5305) | [Improve][Manager] Change the type enum that needs to be extended to a string constant                                       |
| [INLONG-5296](https://github.com/apache/inlong/issues/5296) | [Improve][Manager] Add fields for DataProxy cluster info                                                                     |
| [INLONG-5286](https://github.com/apache/inlong/issues/5286) | [Improve][Manager] Move pojo classes into the manager-pojo module                                                            |
| [INLONG-5285](https://github.com/apache/inlong/issues/5285) | [Improve][Manager] Support custom query for group, stream, source and sink                                                   |
| [INLONG-5283](https://github.com/apache/inlong/issues/5283) | [Improve][Manager] OpenAPI authentication should not be mandatory                                                            |
| [INLONG-5279](https://github.com/apache/inlong/issues/5279) | [Improve][Manager] Optimize the creation code of databases and tables, including Oracle and MySQL                            |
| [INLONG-5269](https://github.com/apache/inlong/issues/5269) | [Feature][Manager] Workflow supports rapid scaling of MQ resources                                                           |
| [INLONG-5264](https://github.com/apache/inlong/issues/5264) | [Improve][Manager] Remove unused StreamConfigLog related classes and tables                                                  |
| [INLONG-5246](https://github.com/apache/inlong/issues/5246) | [Bug][Manager] Agent gets dataproxy list and always returns empty                                                            |
| [INLONG-5245](https://github.com/apache/inlong/issues/5245) | [Improve][Manager] Optimize the URI paths of the WebAPI and OpenAPI                                                          |
| [INLONG-5240](https://github.com/apache/inlong/issues/5240) | [Improve][Manager] Unify the workflow approver and process classes and tables                                                |
| [INLONG-5232](https://github.com/apache/inlong/issues/5232) | [Improve][Manager] Unify the user and role tables                                                                            |
| [INLONG-5228](https://github.com/apache/inlong/issues/5228) | [Feature][Manager] Support create SQLServer databases and tables                                                             |
| [INLONG-5219](https://github.com/apache/inlong/issues/5219) | [Bug][Manager] The inlong group is still pending approval after approval                                                     |
| [INLONG-5212](https://github.com/apache/inlong/issues/5212) | [Feature][Manager] Merge the Selector classes into their related Listeners                                                   |
| [INLONG-5203](https://github.com/apache/inlong/issues/5203) | [Improve][Manager] Refactor the user interface                                                                               |
| [INLONG-5201](https://github.com/apache/inlong/issues/5201) | [Bug][Manager] The inlong group cannot be updated normally after the approval is successful                                  |
| [INLONG-5194](https://github.com/apache/inlong/issues/5194) | [Improve][Manager] Update MD5 hashing to SHA-256                                                                             |
| [INLONG-5188](https://github.com/apache/inlong/issues/5188) | [Bug][Manager] Create group workflow fail                                                                                    |
| [INLONG-5184](https://github.com/apache/inlong/issues/5184) | [Improve][Manager] Add more info for some error logs                                                                         |
| [INLONG-5178](https://github.com/apache/inlong/issues/5178) | [Improve][Manager] There is so much Warning info when compiling the Manager module                                           |
| [INLONG-5175](https://github.com/apache/inlong/issues/5175) | [Improve][Manager] Remove redundant StreamSinkExt table and classes                                                          |
| [INLONG-5167](https://github.com/apache/inlong/issues/5167) | [Feature][Manager] OpenAPI authentication support                                                                            |
| [INLONG-5166](https://github.com/apache/inlong/issues/5166) | [Bug][Manager] Cluster tags are not separated by commas when querying clusters                                               |
| [INLONG-5165](https://github.com/apache/inlong/issues/5165) | [Bug][Manager] Getting Sort source collects wrong topic properties of each stream                                            |
| [INLONG-5157](https://github.com/apache/inlong/issues/5157) | [Bug][Manager] Failed to build Sort config as the relations is empty                                                         |
| [INLONG-5148](https://github.com/apache/inlong/issues/5148) | [Improve][Manager] Handle the lightweight and standard inlong groups differently in workflow                                 |
| [INLONG-5144](https://github.com/apache/inlong/issues/5144) | [Bug][Manager] Fail to execute Group-InitSort                                                                                |
| [INLONG-5137](https://github.com/apache/inlong/issues/5137) | [Bug][Manager] The API to get the group list loses the mqType field                                                          |
| [INLONG-5136](https://github.com/apache/inlong/issues/5136) | [Improve][Manager] Update the get DataProxy cluster nodes API                                                                |
| [INLONG-5127](https://github.com/apache/inlong/issues/5127) | [Improve][Manager] Rename second_xxx to backup_xxx in sort-standalone management interface                                   |
| [INLONG-5112](https://github.com/apache/inlong/issues/5112) | [Improve][Manager] Improve creating Pulsar topic by using the lookups method                                                 |
| [INLONG-5104](https://github.com/apache/inlong/issues/5104) | [Improve][Manager] Update Flink address environment for Sort Flink plugin                                                    |
| [INLONG-5103](https://github.com/apache/inlong/issues/5103) | [Feature][Manager] Add constant field support for stream source and transform node                                           |
| [INLONG-5088](https://github.com/apache/inlong/issues/5088) | [Feature][Manager] Support only consumes the MQ cluster with the same tag                                                    |
| [INLONG-5086](https://github.com/apache/inlong/issues/5086) | [Feature][Manager] Support create Oracle databases and tables                                                                |
| [INLONG-5085](https://github.com/apache/inlong/issues/5085) | [Feature][Manager] Support create MySQL databases and tables                                                                 |
| [INLONG-5070](https://github.com/apache/inlong/issues/5070) | [Feature][Manager] Add more parameter settings support for stream source                                                     |
| [INLONG-5066](https://github.com/apache/inlong/issues/5066) | [Improve][Manager] Remove the LightGroup-related workflow listener and definitions                                           |
| [INLONG-5052](https://github.com/apache/inlong/issues/5052) | [Bug][Manager] The workflow that failed to execute still failed, but returned success                                        |
| [INLONG-5031](https://github.com/apache/inlong/issues/5031) | [Improve][Manager] Encryption saves all password fields                                                                      |
| [INLONG-5026](https://github.com/apache/inlong/issues/5026) | [Improve][Manager] The unit test code contains a real IP address                                                             |
| [INLONG-5018](https://github.com/apache/inlong/issues/5018) | [Feature][Manager]  Support for Tube data sources                                                                            |
| [INLONG-4993](https://github.com/apache/inlong/issues/4993) | [Improve][Manager] Return details when querying a list of StreamSources                                                      |
| [INLONG-4974](https://github.com/apache/inlong/issues/4974) | [Umbrella][Manager] Support create sink resource                                                                             |
| [INLONG-4965](https://github.com/apache/inlong/issues/4965) | [Improve][Manager] Eliminate NullPointerException on user management                                                         |
| [INLONG-4951](https://github.com/apache/inlong/issues/4951) | [Bug][Manger] Unable to save the change when updating the chargers of cluster tag                                            |
| [INLONG-4949](https://github.com/apache/inlong/issues/4949) | [Feature][Manager] Support to extend different types of Sort protocol                                                        |
| [INLONG-3922](https://github.com/apache/inlong/issues/3922) | [Feature][Manager] Fetch source failed and update task status through heartbeat                                              |
| [INLONG-5442](https://github.com/apache/inlong/issues/5442) | [Bug][Manager] Fix accept logic error for SortConfigListener                                                                 |
| [INLONG-5299](https://github.com/apache/inlong/issues/5299) | [Improve][Manager] Remove redundant configuration and class files                                                            |
| [INLONG-5371](https://github.com/apache/inlong/issues/5371) | [Feature][Manager] Supplement the data node API in the manager client                                                        |
| [INLONG-5029](https://github.com/apache/inlong/issues/5029) | [Umbrella][Manager] Unify the InlongGroup workflow                                                                           |
| [INLONG-5020](https://github.com/apache/inlong/issues/5020) | [Improve][Manager] Refactoring InnerInlongManagerClient of manager client                                                    |
| [INLONG-5007](https://github.com/apache/inlong/issues/5007) | [Feature][Manager] Client supports getting sink details by id                                                                |
| [INLONG-5006](https://github.com/apache/inlong/issues/5006) | [Improve][Manager] Return details when querying a list of StreamSinks                                                        |
| [INLONG-4897](https://github.com/apache/inlong/issues/4897) | [Improve][Manager] Change length of field name                                                                               |                                                          |
| [INLONG-4928](https://github.com/apache/inlong/issues/4928) | [Feature][Manager] Supplement or modify the inlong stream api in the manager client                                          |

### Sort
| ISSUE                                                       | Summary                                                                                                             |
|:------------------------------------------------------------|:--------------------------------------------------------------------------------------------------------------------|
| [INLONG-5580](https://github.com/apache/inlong/issues/5580) | [Feature][Sort] Add InlongMetric interface for extract and load nodes                                               |
| [INLONG-5576](https://github.com/apache/inlong/issues/5576) | [Feature][Sort] Add redis extract node and support temporal join                                                    |
| [INLONG-5488](https://github.com/apache/inlong/issues/5488) | [Feature][Sort] Add metric for Iceberg and DLC with Flink metrics group and audit SDK                               |
| [INLONG-5485](https://github.com/apache/inlong/issues/5485) | [Feature][Sort] Support JSON UDF getter and JSON getter function                                                    |
| [INLONG-5484](https://github.com/apache/inlong/issues/5484) | [Feature][Sort] Add audit info for Elasticsearch 6 connector and report metric when delete mode                     |
| [INLONG-5478](https://github.com/apache/inlong/issues/5478) | [Improve][Sort] MySQL connector lost inlong metric feature for no primary key table                                 |
| [INLONG-5470](https://github.com/apache/inlong/issues/5470) | [Bug][Sort] Fix compile error                                                                                       |
| [INLONG-5464](https://github.com/apache/inlong/issues/5464) | [Improve][Sort] Optimize the implementation of the sort-connector-base metric common abstract                       |
| [INLONG-5463](https://github.com/apache/inlong/issues/5463) | [Feature][Sort] Add audit for HBase load node                                                                       |
| [INLONG-5462](https://github.com/apache/inlong/issues/5462) | [Feature][Sort] Add audit for Oracle extract Node                                                                   |
| [INLONG-5461](https://github.com/apache/inlong/issues/5461) | [Feature][Sort] Add audit for MongoDB extract node                                                                  |
| [INLONG-5460](https://github.com/apache/inlong/issues/5460) | [Feature][Sort] Add audit for PostgreSQL extract node                                                               |
| [INLONG-5448](https://github.com/apache/inlong/issues/5448) | [Improve][Sort] Optimize cls callback when send failed                                                              |
| [INLONG-5447](https://github.com/apache/inlong/issues/5447) | [Feature][Sort] Add lookup support for Redis                                                                        |
| [INLONG-5423](https://github.com/apache/inlong/issues/5423) | [Feature][SortStandalone] Revise invalid partition time when dispatch messages                                      |
| [INLONG-5404](https://github.com/apache/inlong/issues/5404) | [Bug][Sort] Fix EncryptFunction checkstyle                                                                          |
| [INLONG-5377](https://github.com/apache/inlong/issues/5377) | [Feature][Sort] Add reporting metrics for kafka connector sink                                                      |
| [INLONG-5375](https://github.com/apache/inlong/issues/5375) | [Improve][Sort] Iceberg-inlong connector lose its meta-inf                                                          |
| [INLONG-5352](https://github.com/apache/inlong/issues/5352) | [Feature][Sort] Add audit report for Pulsar source                                                                  |
| [INLONG-5327](https://github.com/apache/inlong/issues/5327) | [Bug][Sort] Lack of service file of Inlong Pb format msg                                                            |
| [INLONG-5262](https://github.com/apache/inlong/issues/5262) | [Feature][Sort] Add metric report for Pulsar source                                                                 |
| [INLONG-5242](https://github.com/apache/inlong/issues/5242) | [Feature][Sort] Add metric computing for Oracle and MongoDB                                                         |
| [INLONG-5215](https://github.com/apache/inlong/issues/5215) | [Bug][TubeMQ] Initialization script init-tube-cluster.sh execution error                                            |
| [INLONG-5211](https://github.com/apache/inlong/issues/5211) | [Improve][Sort] Replace 1.3.0-snapshot with inlong-version                                                          |
| [INLONG-5210](https://github.com/apache/inlong/issues/5210) | [Feature][Sort] Add reporting metrics for Elasticsearch 7 connector and audit SDK                                   |
| [INLONG-5205](https://github.com/apache/inlong/issues/5205) | [Feature][Sort] Add reporting metrics for Elasticsearch 6 connector                                                 |
| [INLONG-5169](https://github.com/apache/inlong/issues/5169) | [Bug][Sort] Metrics of HBaseSinkFunction are not collected accurately                                               |
| [INLONG-5158](https://github.com/apache/inlong/issues/5158) | [Feature][Sort] Add metric for Kafka source with Flink metrics group and audit SDK                                  |
| [INLONG-5156](https://github.com/apache/inlong/issues/5156) | [Feature][Sort] Add metric for SQLServer source with Flink metrics group and audit SDK                              |
| [INLONG-5152](https://github.com/apache/inlong/issues/5152) | [Feature][Manager][Sort] Add  union  parse support for FlinkSqlParser                                               |
| [INLONG-5119](https://github.com/apache/inlong/issues/5119) | [Feature][Sort] Import all changelog mode data ingest into Kafka                                                    |
| [INLONG-5117](https://github.com/apache/inlong/issues/5117) | [Feature][Sort-Standalone] Support specify component type from remote config                                        |
| [INLONG-5100](https://github.com/apache/inlong/issues/5100) | [Feature][Sort] Add reporting metrics for JDBC                                                                      |
| [INLONG-5094](https://github.com/apache/inlong/issues/5094) | [Feature][SortStandalone] Implements time interval interceptor                                                      |
| [INLONG-5072](https://github.com/apache/inlong/issues/5072) | [Feature][Sort] Add metric computing of MySQL and PostgreSQL and HBase for user query metric by label               |
| [INLONG-5068](https://github.com/apache/inlong/issues/5068) | [Bug][Sort] Fix RegexpReplace replacing uncorrectly                                                                 |
| [INLONG-4892](https://github.com/apache/inlong/issues/4892) | [Bug][Sort] Sort connector package without own Factory files                                                        |
| [INLONG-4858](https://github.com/apache/inlong/issues/4858) | [Bug][Sort] Building connectors twice without clean command causes failures                                         |
| [INLONG-4815](https://github.com/apache/inlong/issues/4815) | [Improve][Sort] Supporting field type cast when sinking data to HBase                                               |
| [INLONG-4808](https://github.com/apache/inlong/issues/4808) | [Feature][InLong] Extract end-to-end testing capabilities                                                           |
| [INLONG-4807](https://github.com/apache/inlong/issues/4807) | [Feature][Sort] CSV deserialization schema support process data whose input field length unmatch the register table |
| [INLONG-4806](https://github.com/apache/inlong/issues/4806) | [Feature][Sort] Sort support pb format deserializationSchema                                                        |
| [INLONG-4751](https://github.com/apache/inlong/issues/4751) | [Improve][Sort] Optimize the metadata implementation of Extract Nodes and Load Nodes                                |
| [INLONG-4735](https://github.com/apache/inlong/issues/4735) | [Improve][Sort] Add precision support for DecimalFormatInfo,TimeFormatInfo                                          |
| [INLONG-4732](https://github.com/apache/inlong/issues/4732) | [Bug][Sort] Table not found when Iceberg commit Hive table                                                          |
| [INLONG-4730](https://github.com/apache/inlong/issues/4730) | [Bug] [Sort] Fix meta field format is null when parse json to sql                                                   |
| [INLONG-4693](https://github.com/apache/inlong/issues/4693) | [Bug] [Sort] Fix DLC connector maven package problem                                                                |
| [INLONG-4685](https://github.com/apache/inlong/issues/4685) | [Improve][Sort] Add data type convert implicitly support                                                            |
| [INLONG-4678](https://github.com/apache/inlong/issues/4678) | [Improve][Sort] Add util class of parsing meta info for data node                                                   |
| [INLONG-4665](https://github.com/apache/inlong/issues/4665) | [Improve][Sort] The primary key of the MongoDB CDC connector must be _id                                            |
| [INLONG-4659](https://github.com/apache/inlong/issues/4659) | [Feature][Sort] Support routing field for Elasticsearch connector                                                   |
| [INLONG-4650](https://github.com/apache/inlong/issues/4650) | [Bug][Sort] Iceberg connector not found the Hive classpath                                                          |
| [INLONG-4431](https://github.com/apache/inlong/issues/4431) | [Feature][Sort] Sort lightwieght support load data to DLC                                                           |
| [INLONG-4166](https://github.com/apache/inlong/issues/4166) | [Feature][Sort] Add metrics test                                                                                    |
| [INLONG-4894](https://github.com/apache/inlong/issues/4894) | [Feature][Sort] Add TubeMQ extract node                                                                             |
| [INLONG-4890](https://github.com/apache/inlong/issues/4890) | [Feature][Sort] Support TubeMQ connector                                                                            |
| [INLONG-5315](https://github.com/apache/inlong/issues/5315) | [Feature][Sort] Import all changelog mode data ingest into JDBC                                                     |
| [INLONG-5312](https://github.com/apache/inlong/issues/5312) | [Feature][Sort] Add unified inlong.metric parameter injection support for nodes                                     |
| [INLONG-5451](https://github.com/apache/inlong/issues/5451) | [Improve][Sort] kafka sink use customized partitioner                                                               |
| [INLONG-5446](https://github.com/apache/inlong/issues/5446) | [Feature][Sort] Add reporting metric from JDBC to audit SDK and refactor according to connector-base                |
| [INLONG-5353](https://github.com/apache/inlong/issues/5353) | [Bug][Sort] Fix HBase connector packaging problem and inlong metrics delimiter problem                              |
| [INLONG-5217](https://github.com/apache/inlong/issues/5217) | [Feature][Sort]  Add connector-base component for common code                                                       |
| [INLONG-5074](https://github.com/apache/inlong/issues/5074) | [Improve][Sort] KafkaExtractNode support more StartupMode                                                           |
| [INLONG-5012](https://github.com/apache/inlong/issues/5012) | [Improve][Sort] Remove the duplicate declaration of elasticsearch7                                                  |
| [INLONG-4943](https://github.com/apache/inlong/issues/4943) | [Improve][Sort] Remove redundant information in licenses                                                            |
| [INLONG-4726](https://github.com/apache/inlong/issues/4726) | [Feature][SortStandalone] Support ClickHouse sink                                                                   |
| [INLONG-4763](https://github.com/apache/inlong/issues/4763) | [Feature][Sort] Import sort end2end unit test with sql file input                                                   |
| [INLONG-4670](https://github.com/apache/inlong/issues/4670) | [Improve][Sort] Update the README.md for the sort                                                                   |
| [INLONG-4777](https://github.com/apache/inlong/issues/4777) | [Feature][Sort-Standalone] Change ack policy from checking message count to checking every message                  |

### SDK
| ISSUE                                                       | Summary                                                                                              |
|:------------------------------------------------------------|:-----------------------------------------------------------------------------------------------------|
| [INLONG-5496](https://github.com/apache/inlong/issues/5496) | [Improve][SDK] Refactor single topic manager in Sort SDK                                             |
| [INLONG-5418](https://github.com/apache/inlong/issues/5418) | [Feature][SDK] Sort SDK support seek topic or partitions to a given timestamp                        |
| [INLONG-5270](https://github.com/apache/inlong/issues/5270) | [Feature][SDK] Add unit tests and manual for DataProxy C++ SDK                                       |
| [INLONG-5267](https://github.com/apache/inlong/issues/5267) | [Feature][SDK] Add config file and demo for DataProxy C++ SDK                                        |
| [INLONG-5265](https://github.com/apache/inlong/issues/5265) | [Feature][SDK] Build config for DataProxy C++ SDK                                                    |
| [INLONG-5256](https://github.com/apache/inlong/issues/5256) | [Feature][SDK] Support network operation and management for DataProxy C++ SDK                        |
| [INLONG-5253](https://github.com/apache/inlong/issues/5253) | [Feature][SDK] Support buffer manager for DataProxy C++ SDK                                          |
| [INLONG-5251](https://github.com/apache/inlong/issues/5251) | [Feature][SDK] Add proxy client config and proxylist manager for DataProxy SDK(C++)                  |
| [INLONG-5249](https://github.com/apache/inlong/issues/5249) | [Feature][SDK] Add DataProxy SDK(C++) utils file                                                     |
| [INLONG-5160](https://github.com/apache/inlong/issues/5160) | [Improve][DataProxy-SDK] Update DataProxy cluster API and response parsing method                    |
| [INLONG-5095](https://github.com/apache/inlong/issues/5095) | [Feature][SortSDK] Support consume stream from a certain time                                        |
| [INLONG-5092](https://github.com/apache/inlong/issues/5092) | [Feature][SDK] Change Kafka default partition assignment strategy to RangeAssignor                   |
| [INLONG-4995](https://github.com/apache/inlong/issues/4995) | [Improve][SDK] The md5 digest is not secure and triggers a CodeQL warning.                           |
| [INLONG-4884](https://github.com/apache/inlong/issues/4884) | [Bug][SortSDK] Fix data duplicated problem when default ackTimeout value of Pulsar consumer is not 0 |
| [INLONG-4871](https://github.com/apache/inlong/issues/4871) | [Bug][SDK] The generateMd5 method generate md2 not md5                                               |
| [INLONG-4790](https://github.com/apache/inlong/issues/4790) | [Improve][DataProxySDK] Replace DES with a more secure encryption algorithm                          |
| [INLONG-5258](https://github.com/apache/inlong/issues/5258) | [Feature][SDK] Add core interface for DataProxy C++ SDK                                              |

### TubeMQ
| ISSUE                                                       | Summary                                                                                                                |
|:------------------------------------------------------------|:-----------------------------------------------------------------------------------------------------------------------|
| [INLONG-5567](https://github.com/apache/inlong/issues/5567) | [Bug][TubeMQ] Master start failed with NullPointerException                                                            |
| [INLONG-5435](https://github.com/apache/inlong/issues/5435) | [TubeMQ] Adjust the parameter requirements in Audit and Prometheus sections                                            |
| [INLONG-5386](https://github.com/apache/inlong/issues/5386) | [Feature][TubeMQ] Supports reporting metrics data through Prometheus                                                   |
| [INLONG-5373](https://github.com/apache/inlong/issues/5373) | [Feature][TubeMQ] Supports outputting traffic information through the audit SDK                                        |
| [INLONG-5314](https://github.com/apache/inlong/issues/5314) | [Bug][TubeMQ] When a non-master node is configured in the first position of the address, the service cannot be started |
| [INLONG-5303](https://github.com/apache/inlong/issues/5303) | [Improve][TubeMQ] Simplify flush check for appendMsg in FileMsgStore                                                   |
| [INLONG-5281](https://github.com/apache/inlong/issues/5281) | [Bug][TubeMQ] After running for a period of time, it has been unable to connect to the broker                          |
| [INLONG-5138](https://github.com/apache/inlong/issues/5138) | [Bug][TubeMQ] compile error with gcc >= 8.0 on rapidjson                                                               |
| [INLONG-5097](https://github.com/apache/inlong/issues/5097) | [Bug][TubeMQ] The protocol from 1.1.0 and later is not smoothly compatible with previous versions                      |
| [INLONG-5087](https://github.com/apache/inlong/issues/5087) | [Bug][TubeMQ] In MySQL 5.7 initialize the database failure: Unknown collation 'utf8mb4_0900_ai_ci'                     |
| [INLONG-4942](https://github.com/apache/inlong/issues/4942) | [Improve][TubeMQ] Add the display of the IP address of consumer                                                        |
| [INLONG-4934](https://github.com/apache/inlong/issues/4934) | [Bug][TubeMQ] Reversed value for admin_enable_stats methods                                                            |
| [INLONG-4927](https://github.com/apache/inlong/issues/4927) | [TubeMQ] Add version info in history offset record                                                                     |
| [INLONG-4924](https://github.com/apache/inlong/issues/4924) | [TubeMQ] Add admin_get_methods method                                                                                  |
| [INLONG-4883](https://github.com/apache/inlong/issues/4883) | [TubeMQ] No error report for incorrect topic subscription                                                              |
| [INLONG-4805](https://github.com/apache/inlong/issues/4805) | [Bug][TubeMQ] Tube-Manager startup failed                                                                              |
| [INLONG-4721](https://github.com/apache/inlong/issues/4721) | [TubeMQ] Remove the "incubat*" tag in the tubemq-go-sdk code                                                           |
| [INLONG-4664](https://github.com/apache/inlong/issues/4664) | [Feature][TubeMQ] Add GroupController and TopicBackendWorker                                                           |
| [INLONG-4551](https://github.com/apache/inlong/issues/4551) | [Feature][TubeMQ] Batch delete consumer groups and authorized consumer groups from the blacklist                       |
| [INLONG-4123](https://github.com/apache/inlong/issues/4123) | [BUG][TubeMQ] All images can not work when using go example                                                            |
| [INLONG-5282](https://github.com/apache/inlong/issues/5282) | [TubeMQ] An error when deploying tubemq-manager according to the documentation on the official website                 |

### Other
| ISSUE                                                       | Summary                                                                                                |
|:------------------------------------------------------------|:-------------------------------------------------------------------------------------------------------|
| [INLONG-5583](https://github.com/apache/inlong/issues/5583) | [Improve][K8S] Add timezone to helm chart                                                              |
| [INLONG-5553](https://github.com/apache/inlong/issues/5553) | [Imporve][Common] Adjust the log output level of MetricListenerRunnable                                |
| [INLONG-5527](https://github.com/apache/inlong/issues/5527) | [Improve][Docker] Add configmap.yaml for MySQL                                                         |
| [INLONG-5439](https://github.com/apache/inlong/issues/5439) | [Bug][Docker] Fix arm docker build script                                                              |
| [INLONG-5294](https://github.com/apache/inlong/issues/5294) | [Improve][CVE] Upgrade gson version due to CVE                                                         |
| [INLONG-5292](https://github.com/apache/inlong/issues/5292) | [Improve][CVE] Upgrade shiro version due to CVE                                                        |
| [INLONG-5207](https://github.com/apache/inlong/issues/5207) | [Improve][K8S] Add components for helm chart                                                           |
| [INLONG-5190](https://github.com/apache/inlong/issues/5190) | [Bug][Build] The build of InLong is missing some packages                                              |
| [INLONG-5182](https://github.com/apache/inlong/issues/5182) | [Improve][CI] Upgrade apache-rat-plugin to compatible with parallel builds                             |
| [INLONG-5179](https://github.com/apache/inlong/issues/5179) | [Bug][K8S] External mysql information has not been used in manager                                     |
| [INLONG-5154](https://github.com/apache/inlong/issues/5154) | [Improve][Doc] Update the architecture image                                                           |
| [INLONG-5124](https://github.com/apache/inlong/issues/5124) | [Improve] Add initial sort connectors to the manager docker image                                      |
| [INLONG-5115](https://github.com/apache/inlong/issues/5115) | [Improve][Pom] There are redundant agent dependencies in Distribution                                  |
| [INLONG-5098](https://github.com/apache/inlong/issues/5098) | [Improve][CI] Use maven parallel build feature to improve project workflow build speed                 |
| [INLONG-5064](https://github.com/apache/inlong/issues/5064) | [Improve][CI] Decrease Vulnerabilities Scan run time                                                   |
| [INLONG-5016](https://github.com/apache/inlong/issues/5016) | [Improve][CI] Improve Vulnerabilities Scan build speed                                                 |
| [INLONG-5009](https://github.com/apache/inlong/issues/5009) | [Bug][Docker] Dataproxy proc cannot startup                                                            |
| [INLONG-4991](https://github.com/apache/inlong/issues/4991) | [Improve] Update the lables for CI/CD workflows                                                        |
| [INLONG-4977](https://github.com/apache/inlong/issues/4977) | [Bug][K8s] Divide persistent volume claim by statefulsets                                              |
| [INLONG-4910](https://github.com/apache/inlong/issues/4910) | [Improve][CI] CI_docker runs time too long                                                             |
| [INLONG-4862](https://github.com/apache/inlong/issues/4862) | [Improve][Docker] Add publish images by arch and push manifest script                                  |
| [INLONG-4838](https://github.com/apache/inlong/issues/4838) | [Improve][Docker] Add MQ Type environment for Audit and DataProxy                                      |
| [INLONG-4827](https://github.com/apache/inlong/issues/4827) | [Improve][Kubernets] Add Flink config into the YAML files                                              |
| [INLONG-4826](https://github.com/apache/inlong/issues/4826) | [Bug][K8s] Helm upgrade inlong failed                                                                  |
| [INLONG-4769](https://github.com/apache/inlong/issues/4769) | [Bug][CI] Error trigger conditions in the docker workflow                                              |
| [INLONG-4758](https://github.com/apache/inlong/issues/4758) | [Improve][Doc] Command-line codes in README should remove the leading $ sign                           |
| [INLONG-4746](https://github.com/apache/inlong/issues/4746) | [Website] Modify the how-to-vote-a-committer-pmc file                                                  |
| [INLONG-4737](https://github.com/apache/inlong/issues/4737) | [Doc] Remove "(Incubating)" tag in licenses dirs                                                       |
| [INLONG-4727](https://github.com/apache/inlong/issues/4727) | [Doc] Update InLong project link in readme and  pom.xml                                                |
| [INLONG-4724](https://github.com/apache/inlong/issues/4724) | [Pom] Change version to 1.3.0-SNAPSHOT                                                                 |
| [INLONG-4719](https://github.com/apache/inlong/issues/4719) | [Improve][All] Remove commons-lang 2.6 dependency                                                      |
| [INLONG-4717](https://github.com/apache/inlong/issues/4717) | [Doc] Remove DISCLAIMER file                                                                           |
| [INLONG-4716](https://github.com/apache/inlong/issues/4716) | [Bug][Doc] 404 issue for document links in guides                                                      |
| [INLONG-4710](https://github.com/apache/inlong/issues/4710) | [Improve][Website] Modify how to release and verify                                                    |
| [INLONG-4708](https://github.com/apache/inlong/issues/4708) | [Website] Modify the "(incubating)" tag associated with the link                                       |
| [INLONG-4702](https://github.com/apache/inlong/issues/4702) | [Umbrella][Website][Doc] Remove incubation related content information                                 |
| [INLONG-4698](https://github.com/apache/inlong/issues/4698) | [Improve][Doc] Update the definitions and features to make them accurate                               |
| [INLONG-4696](https://github.com/apache/inlong/issues/4696) | [Improve][Doc] Update the supported data nodes                                                         |
| [INLONG-4673](https://github.com/apache/inlong/issues/4673) | [Feature][Docker] Support for building Docker images for the ARM architecture                          |
| [INLONG-4653](https://github.com/apache/inlong/issues/4653) | [Improve][CI] Add concurrency support on GitHub Actions                                                |
| [INLONG-4636](https://github.com/apache/inlong/issues/4636) | [Feature][CI] Add check PR title workflow                                                              |
| [INLONG-4616](https://github.com/apache/inlong/issues/4616) | [Improve][Office-Website] Set Apache events on footer                                                  |
| [INLONG-4606](https://github.com/apache/inlong/issues/4606) | [Improve][CI] Improve the trigger conditions of the Docker image build                                 |
| [INLONG-2440](https://github.com/apache/inlong/issues/2440) | [Improve] add a workflow to Scan InLong common vulnerabilities                                         |
| [INLONG-1831](https://github.com/apache/inlong/issues/1831) | [Feature] Add official website content search button                                                   |

## Release InLong 1.2.0-incubating - Released (as of 2022-06-08)

### Agent
| ISSUE                                                                 | Summary                                                                                                |
|:----------------------------------------------------------------------|:-------------------------------------------------------------------------------------------------------|
| [INLONG-4483](https://github.com/apache/incubator-inlong/issues/4483) | [Bug][Agent] Many ConnectException logs in unit test of Kafka source                                   |
| [INLONG-4193](https://github.com/apache/incubator-inlong/issues/4193) | [Improve][Agent] Add Java docs                                                                         |
| [INLONG-4112](https://github.com/apache/incubator-inlong/issues/4112) | [Feature][Agent] Support collect data from a specified position for MySQL binlog                       |
| [INLONG-2563](https://github.com/apache/incubator-inlong/issues/2563) | [Feature][Agent] Move public domain from agent to agent-common                                         |
| [INLONG-4397](https://github.com/apache/incubator-inlong/issues/4397) | [Feature][Agent] Supports collect of full data for file type                                           |
| [INLONG-4359](https://github.com/apache/incubator-inlong/issues/4359) | [Improve][Agent] Simplify agent process commands                                                       |
| [INLONG-4292](https://github.com/apache/incubator-inlong/issues/4292) | [Improve][Agent][TubeMQ][Sort] Upgrade the property file for all modules from log4j to log4j2          |
| [INLONG-4283](https://github.com/apache/incubator-inlong/issues/4283) | [Bug][Agent] The kafka-clients with 3.0.0 does not package to the jar                                  |
| [INLONG-4235](https://github.com/apache/incubator-inlong/issues/4235) | [Bug][Agent] Config the log info for unit tests of the agent plugin                                    |

### Audit
| ISSUE                                                                 | Summary                                                                                                |
|:----------------------------------------------------------------------|:-------------------------------------------------------------------------------------------------------|
| [INLONG-4594](https://github.com/apache/incubator-inlong/issues/4594) | [Improve][Audit] Make Elasticsearch authentication configurable                                        |
| [INLONG-4520](https://github.com/apache/incubator-inlong/issues/4520) | [Improve][Audit] Audit-proxy supports Pulsar authenticate                                              |
| [INLONG-4477](https://github.com/apache/incubator-inlong/issues/4477) | [Improve][Audit] Audit-store supports Pulsar authenticate                                              |
| [INLONG-3895](https://github.com/apache/incubator-inlong/issues/3895) | [Bug][Audit] Proxy store startup script log path error                                                 |
| [INLONG-3853](https://github.com/apache/incubator-inlong/issues/3853) | [Bug][Audit] audit can not start for script bug                                                        |

### Dashboard
| ISSUE                                                                 | Summary                                                                                                |
|:----------------------------------------------------------------------|:-------------------------------------------------------------------------------------------------------|
| [INLONG-4612](https://github.com/apache/incubator-inlong/issues/4612) | [Improve][Dashboard][Manager] Iceberg sink configuration protocol key update                           |
| [INLONG-4610](https://github.com/apache/incubator-inlong/issues/4610) | [Improve][Dashboard] Save sink fields failed                                                           |
| [INLONG-4588](https://github.com/apache/incubator-inlong/issues/4588) | [Improve][Dashboard] Approval management splits different routes                                       |
| [INLONG-4580](https://github.com/apache/incubator-inlong/issues/4580) | [Bug][Dashboard] File source IP and Hive conf dir are mandatory                                        |
| [INLONG-4577](https://github.com/apache/incubator-inlong/issues/4577) | [Feature][Dashboard] Support TubeMQ cluster management                                                 |
| [INLONG-4550](https://github.com/apache/incubator-inlong/issues/4550) | [Feature][Dashboard] Support DataProxy Cluster and Node management                                     |
| [INLONG-4544](https://github.com/apache/incubator-inlong/issues/4544) | [Improve][Dashboard] Pulsar Cluster support tenant param                                               |
| [INLONG-4523](https://github.com/apache/incubator-inlong/issues/4523) | [Feature][Dashboard] Support Clusters Module                                                           |
| [INLONG-4500](https://github.com/apache/incubator-inlong/issues/4500) | [Improve][Manager][Dashboard] Remove non-null restriction on hiveConfDir parameter                     |
| [INLONG-4436](https://github.com/apache/incubator-inlong/issues/4436) | [Bug][Dashboard] Hive Sink confDir parameter tooltip error                                             |
| [INLONG-4488](https://github.com/apache/incubator-inlong/issues/4488) | [Improve][Dashboard] Remove useless modules                                                            |
| [INLONG-4423](https://github.com/apache/incubator-inlong/issues/4423) | [Improve][Dashboard] Hive Sink adds hiveConfDir parameter                                              |
| [INLONG-4319](https://github.com/apache/incubator-inlong/issues/4319) | [Improve][Dashboard] Approve page support cluster info                                                 |
| [INLONG-4284](https://github.com/apache/incubator-inlong/issues/4284) | [Improve][Dashboard] Modify ClickHouse sink parameters                                                 |
| [INLONG-4274](https://github.com/apache/incubator-inlong/issues/4274) | [Improve][Dashboard] Update the parameters to adapt the manager module                                 |
| [INLONG-4218](https://github.com/apache/incubator-inlong/issues/4218) | [Feature][Dashboard] Unified group page                                                                |
| [INLONG-4119](https://github.com/apache/incubator-inlong/issues/4119) | [Improve][Dashboard] Change the keyWord to keyword in query request params                             |
| [INLONG-4102](https://github.com/apache/incubator-inlong/issues/4102) | [Improve][Dashboard] Add tooltip for dataPath of the Hive sink                                         |
| [INLONG-4089](https://github.com/apache/incubator-inlong/issues/4089) | [Feature][Dashboard] Create ClickHouse sink need to fill more params                                   |
| [INLONG-4031](https://github.com/apache/incubator-inlong/issues/4031) | [Bug][Dashboard] Kafka sink storage topic partitionNum key error                                       |
| [INLONG-4028](https://github.com/apache/incubator-inlong/issues/4028) | [Bug][Dashboard] ClickHouse types do not match what ClickHouse using                                   |
| [INLONG-3938](https://github.com/apache/incubator-inlong/issues/3938) | [Bug][Dashboard] CI workflow build failed incidentally                                                 |
| [INLONG-3851](https://github.com/apache/incubator-inlong/issues/3851) | [Improve][Dashboard] Unify the naming of data streams                                                  |

### DataProxy
| ISSUE                                                                 | Summary                                                                                                |
|:----------------------------------------------------------------------|:-------------------------------------------------------------------------------------------------------|
| [INLONG-4521](https://github.com/apache/incubator-inlong/issues/4521) | [Improve][DataProxy][Manager] Change the naming of third-party cluster related classes                 |
| [INLONG-4056](https://github.com/apache/incubator-inlong/issues/4056) | [Feature][DataProxy] Return the response to the SDK/Agent after saving the event to the cache cluster  |

### Manager
| ISSUE                                                                 | Summary                                                                                                |
|:----------------------------------------------------------------------|:-------------------------------------------------------------------------------------------------------|
| [INLONG-4648](https://github.com/apache/incubator-inlong/issues/4648) | [Improve][Manager] Read the path of Sort connectors from configuration file                            |
| [INLONG-4626](https://github.com/apache/incubator-inlong/issues/4626) | [Improve][Manager] Remove redundant connector sub directory                                            |
| [INLONG-4622](https://github.com/apache/incubator-inlong/issues/4622) | [Bug][Manager] Append db name in JDBC URL for load node                                                |
| [INLONG-4615](https://github.com/apache/incubator-inlong/issues/4615) | [Improve][Manager] PluginClassLoader adapts to the Windows system                                      |
| [INLONG-4612](https://github.com/apache/incubator-inlong/issues/4612) | [Improve][Dashboard][Manager] Iceberg sink configuration protocol key update                           |
| [INLONG-4607](https://github.com/apache/incubator-inlong/issues/4607) | [Bug][Manager] Add ClickHouse field types for FormatInfo                                               |
| [INLONG-4601](https://github.com/apache/incubator-inlong/issues/4601) | [Bug][Manager] The fieldList in SinkRequest should be changed to sinkFieldList                         |
| [INLONG-4598](https://github.com/apache/incubator-inlong/issues/4598) | [Bug][Manager] Pulsar topic incorrect                                                                  |
| [INLONG-4586](https://github.com/apache/incubator-inlong/issues/4586) | [Improve][Manager] Fix redefined streamFields in stream source                                         |
| [INLONG-4583](https://github.com/apache/incubator-inlong/issues/4583) | [Bug][Manager] Query InlongGroup info error from the browser                                           |
| [INLONG-4563](https://github.com/apache/incubator-inlong/issues/4563) | [Feature][Manager] Support create TubeMQ resources by its origin APIs                                  |
| [INLONG-4556](https://github.com/apache/incubator-inlong/issues/4556) | [Improve][Manager] Optimize ProcessorExecutor Logic                                                    |
| [INLONG-4552](https://github.com/apache/incubator-inlong/issues/4552) | [Improve][Manager] Add composite index for table in DDL                                                |
| [INLONG-4543](https://github.com/apache/incubator-inlong/issues/4543) | [Improve][Manager] Query MQ clusters from inlong cluster table                                         |
| [INLONG-4541](https://github.com/apache/incubator-inlong/issues/4541) | [Feature][Manager] Support save extension params for inlong cluster                                    |
| [INLONG-4534](https://github.com/apache/incubator-inlong/issues/4534) | [Improve][Manager] Add complete unit test to create data flow                                          |
| [INLONG-4532](https://github.com/apache/incubator-inlong/issues/4532) | [Improve][Manager] Init sort config error during initing group info in the client                      |
| [INLONG-4529](https://github.com/apache/incubator-inlong/issues/4529) | [Improve][Manager] Fix PluginClassLoader unit test error                                               |
| [INLONG-4528](https://github.com/apache/incubator-inlong/issues/4528) | [Feature][Manager] Support Greenplum sink                                                              |
| [INLONG-4521](https://github.com/apache/incubator-inlong/issues/4521) | [Improve][DataProxy][Manager] Change the naming of third-party cluster related classes                 |
| [INLONG-4519](https://github.com/apache/incubator-inlong/issues/4519) | [Feature][Manager] Support Elasticsearch sink                                                          |
| [INLONG-4516](https://github.com/apache/incubator-inlong/issues/4516) | [Improve][Manager] Get the MQ cluster for data proxy from the inlong cluster table                     |
| [INLONG-4513](https://github.com/apache/incubator-inlong/issues/4513) | [Improve][Manager] Add Iceberg and HBase examples for the manager client                               |
| [INLONG-4512](https://github.com/apache/incubator-inlong/issues/4512) | [Improve][Manager] Remove third_party_cluster and data_proxy_cluster tables                            |
| [INLONG-4510](https://github.com/apache/incubator-inlong/issues/4510) | [Improve][Manager] Remove GsonUtils, InlongParser, and Gson dependency                                 |
| [INLONG-4508](https://github.com/apache/incubator-inlong/issues/4508) | [Improve][Manager] Remove the management of the DB and file servers' config                            |
| [INLONG-4505](https://github.com/apache/incubator-inlong/issues/4505) | [Improve][Manager] Improve the return information of validation rules                                  |
| [INLONG-4503](https://github.com/apache/incubator-inlong/issues/4503) | [Bug][Manager] Client executes request error                                                           |
| [INLONG-4500](https://github.com/apache/incubator-inlong/issues/4500) | [Improve][Manager][Dashboard] Remove non-null restriction on hiveConfDir parameter                     |
| [INLONG-4497](https://github.com/apache/incubator-inlong/issues/4497) | [Improve][Manager] Fix deleteGroup Async method in Client                                              |
| [INLONG-4487](https://github.com/apache/incubator-inlong/issues/4487) | [Improve][Manager] Fix json parse exception for streamSource/streamSink                                |
| [INLONG-4481](https://github.com/apache/incubator-inlong/issues/4481) | [Improve][Manager] Restore iceberg fields that may still have dependents                               |
| [INLONG-4473](https://github.com/apache/incubator-inlong/issues/4473) | [Bug][Manager] DuplicateKeyException when save StreamSinkField                                         |
| [INLONG-4471](https://github.com/apache/incubator-inlong/issues/4471) | [Improve][Manager] Fix json parse exception in Client                                                  |
| [INLONG-4468](https://github.com/apache/incubator-inlong/issues/4468) | [Improve][Manager] Use config url to create pulsar admin                                               |
| [INLONG-4466](https://github.com/apache/incubator-inlong/issues/4466) | [Bug][Manager] The Oracle data source could not be parsed                                              |
| [INLONG-4464](https://github.com/apache/incubator-inlong/issues/4464) | [Improve][Manager] Fix problems emerged from full link path test                                       |
| [INLONG-4462](https://github.com/apache/incubator-inlong/issues/4462) | [Improve][Manager] Fix NPE when parsing pageInfo in manager client                                     |
| [INLONG-4476](https://github.com/apache/incubator-inlong/issues/4476) | [Improve][Sort][Manager] Remove zk and related classes                                                 |
| [INLONG-4458](https://github.com/apache/incubator-inlong/issues/4458) | [Improve][Sort][Manager] Unify the meta field naming                                                   |
| [INLONG-4445](https://github.com/apache/incubator-inlong/issues/4445) | [Improve][Manager] Change the relationship to relation to adapt the Sort protocol                      |
| [INLONG-4443](https://github.com/apache/incubator-inlong/issues/4443) | [Improve][Manager] Remove some deprecated classes                                                      |
| [INLONG-4439](https://github.com/apache/incubator-inlong/issues/4439) | [Improve][Manager] Refactor gson adapter for managerctl                                                |
| [INLONG-4438](https://github.com/apache/incubator-inlong/issues/4438) | [Bug][Manager] Caught BusinessException when deploy InLong cluster firstly                             |
| [INLONG-4428](https://github.com/apache/incubator-inlong/issues/4428) | [Improve][Sort][Manager] Optimize the name for Data Node related modules and classes                   |
| [INLONG-4427](https://github.com/apache/incubator-inlong/issues/4427) | [Improve][Manager] The manager-client module reuses the source classes in manager-common               |
| [INLONG-4421](https://github.com/apache/incubator-inlong/issues/4421) | [Improve][Manager] Remove unused classes and table structures                                          |
| [INLONG-4419](https://github.com/apache/incubator-inlong/issues/4419) | [Improve][Manager] The manager-client module reuses the sink classes in manager-common                 |
| [INLONG-4417](https://github.com/apache/incubator-inlong/issues/4417) | [Improve][Manager] Manager print error logs when deploy by docker-compose                              |
| [INLONG-4414](https://github.com/apache/incubator-inlong/issues/4414) | [Feature][Manager]  Support MySQL data sink                                                            |
| [INLONG-4408](https://github.com/apache/incubator-inlong/issues/4408) | [Feature][Manager][Sort] Add iceberg sink load node                                                    |
| [INLONG-4406](https://github.com/apache/incubator-inlong/issues/4406) | [Improve][Manager] Fix InlongGroupInfo parse exception                                                 |
| [INLONG-4398](https://github.com/apache/incubator-inlong/issues/4398) | [Bug][Manager] Status display incomplete for managerctl                                                |
| [INLONG-4388](https://github.com/apache/incubator-inlong/issues/4388) | [Bug][Manager] Elasticsearch create command scaling_factor use wrong mapping info                      |
| [INLONG-4384](https://github.com/apache/incubator-inlong/issues/4384) | [Improve][Manager] Store the specific field params of the Iceberg to extParams                         |
| [INLONG-4381](https://github.com/apache/incubator-inlong/issues/4381) | [Improve][Manager] Optimize client http request                                                        |
| [INLONG-4377](https://github.com/apache/incubator-inlong/issues/4377) | [Feature][Manager] Add hbase and elasticsearch sink type support in manager client sdk                 |
| [INLONG-4376](https://github.com/apache/incubator-inlong/issues/4376) | [Feature][Manager] Support SqlServer sink                                                              |
| [INLONG-4369](https://github.com/apache/incubator-inlong/issues/4369) | [Improve][Manager] Support for modification of information after approval                              |
| [INLONG-4364](https://github.com/apache/incubator-inlong/issues/4364) | [Improve][Manager] Optimize sort protocol                                                              |
| [INLONG-4362](https://github.com/apache/incubator-inlong/issues/4362) | [Bug][Manager] Lack of flink dependencies for inlong-manager/manager-plugins                           |
| [INLONG-4361](https://github.com/apache/incubator-inlong/issues/4361) | [Improve][Manager] Refactor the manager client module                                                  |
| [INLONG-4358](https://github.com/apache/incubator-inlong/issues/4358) | [Feature][Manager] Support SqlServer source                                                            |
| [INLONG-4337](https://github.com/apache/incubator-inlong/issues/4337) | [Improve][Manager] Remove inlong group pulsar related tables and classes                               |
| [INLONG-4332](https://github.com/apache/incubator-inlong/issues/4332) | [Feature][Manager][Sort] Support ClickHouse load node                                                  |
| [INLONG-4325](https://github.com/apache/incubator-inlong/issues/4325) | [Bug][Manager] Register sql function exception                                                         |
| [INLONG-4315](https://github.com/apache/incubator-inlong/issues/4315) | [Bug][Manager] Incorrect task service node order in create-group workflow                              |
| [INLONG-4310](https://github.com/apache/incubator-inlong/issues/4310) | [Feature][Manager] Manager-plugin adapt changes in sort entrance                                       |
| [INLONG-4309](https://github.com/apache/incubator-inlong/issues/4309) | [Feature][Manager] Supplement hbase dependencies and license file                                      |
| [INLONG-4301](https://github.com/apache/incubator-inlong/issues/4301) | [Feature][Manager] Support oracle source                                                               |
| [INLONG-4300](https://github.com/apache/incubator-inlong/issues/4300) | [Improve][Manager] Autowired the workflow resources to simply the bean management                      |
| [INLONG-4299](https://github.com/apache/incubator-inlong/issues/4299) | [Improve][Manager] Add InlongStreamExtensionInfo                                                       |
| [INLONG-4295](https://github.com/apache/incubator-inlong/issues/4295) | [Improve][Manager] Add Json sub type support for InlongGroupInfo                                       |
| [INLONG-4280](https://github.com/apache/incubator-inlong/issues/4280) | [Feature][Manager] Add params for Iceberg sink                                                         |
| [INLONG-4278](https://github.com/apache/incubator-inlong/issues/4278) | [Improve][Manager] Support pulsar extract node in Manager                                              |
| [INLONG-4273](https://github.com/apache/incubator-inlong/issues/4273) | [Feature][Manager] Add MongoDB source support                                                          |
| [INLONG-4270](https://github.com/apache/incubator-inlong/issues/4270) | [Feature][Manager] Inlong group supports extensions of different types of MQ                           |
| [INLONG-4263](https://github.com/apache/incubator-inlong/issues/4263) | [Feature][Manager] Support HBase sink resource creation                                                |
| [INLONG-4254](https://github.com/apache/incubator-inlong/issues/4254) | [Bug][Manager] Lack of flink dependencies for inlong-manager/manager-plugins                           |
| [INLONG-4247](https://github.com/apache/incubator-inlong/issues/4247) | [Improve][Manager] Add stream create/suspend/restart/delete api                                        |
| [INLONG-4245](https://github.com/apache/incubator-inlong/issues/4245) | [Improve][Manager][Sort] Manager transmit consumer group name of kafka to sort                         |
| [INLONG-4240](https://github.com/apache/incubator-inlong/issues/4240) | [Feature][Manager] Add postgres source and sink node configuration utils                               |
| [INLONG-4239](https://github.com/apache/incubator-inlong/issues/4239) | [Improve][Manager] Remove fastjson dependency                                                          |
| [INLONG-4236](https://github.com/apache/incubator-inlong/issues/4236) | [Feature][Manager] Support operating the indices and mappings for Elasticsearch                        |
| [INLONG-4228](https://github.com/apache/incubator-inlong/issues/4228) | [Feature][Sort][Manager] Adaptive HDFS Load Node                                                       |
| [INLONG-4223](https://github.com/apache/incubator-inlong/issues/4223) | [Improve][Manager] Refactor the consumption table structure                                            |
| [INLONG-4221](https://github.com/apache/incubator-inlong/issues/4221) | [Improve][Manager] Remove duplicate serializationType in KafkaSourceListResponse                       |
| [INLONG-4220](https://github.com/apache/incubator-inlong/issues/4220) | [Feature][Manager] Add StreamResourceProcessForm                                                       |
| [INLONG-4212](https://github.com/apache/incubator-inlong/issues/4212) | [Bug][Manager] The processor executor maybe throws a null pointer exception                            |
| [INLONG-4208](https://github.com/apache/incubator-inlong/issues/4208) | [Improve][Manager] Merge UpdateGroupProcessForm into GroupResourceProcessForm                          |
| [INLONG-4203](https://github.com/apache/incubator-inlong/issues/4203) | [Improve][Manager] Improve the HTTP request and response parse                                         |
| [INLONG-4197](https://github.com/apache/incubator-inlong/issues/4197) | [Feature][Manager] Add Hbase sink info and load node utils                                             |
| [INLONG-4194](https://github.com/apache/incubator-inlong/issues/4194) | [Improve][Manager] Add update sort config API in manager client                                        |
| [INLONG-4188](https://github.com/apache/incubator-inlong/issues/4188) | [Improve][Manager] Check whether the stream exists in the manager client                               |
| [INLONG-4186](https://github.com/apache/incubator-inlong/issues/4186) | [Improve][Manager] Add token field in cluster and node table                                           |
| [INLONG-4183](https://github.com/apache/incubator-inlong/issues/4183) | [Improve][Manager] Fix splitFields in manager service                                                  |
| [INLONG-4181](https://github.com/apache/incubator-inlong/issues/4181) | [Improve][Manager]Fix transform update api                                                             |
| [INLONG-4179](https://github.com/apache/incubator-inlong/issues/4179) | [Improve][Manager] Add comments in manager modules                                                     |
| [INLONG-4177](https://github.com/apache/incubator-inlong/issues/4177) | [Feature][Manager] Refactor getSortClusterConfig interface                                             |
| [INLONG-4168](https://github.com/apache/incubator-inlong/issues/4168) | [Feature][Manager] Update inlong_group table schema                                                    |
| [INLONG-4164](https://github.com/apache/incubator-inlong/issues/4164) | [Improve][Manager] Migrate the use of third_party_cluster table to inlong_cluster table                |
| [INLONG-4155](https://github.com/apache/incubator-inlong/issues/4155) | [Improve][Manager] Change constants and remove clone method in WorkflowContext                         |
| [INLONG-4146](https://github.com/apache/incubator-inlong/issues/4146) | [Feature][Manager] Get DataProxy configuration data from inlong_cluster table                          |
| [INLONG-4142](https://github.com/apache/incubator-inlong/issues/4142) | [Improve][Manager] Improve ServiceTask clone method                                                    |
| [INLONG-4139](https://github.com/apache/incubator-inlong/issues/4139) | [Improve][Manager] Query inlong group by the status list in manager client                             |
| [INLONG-4133](https://github.com/apache/incubator-inlong/issues/4133) | [Improve][Manager] Not pass the type field when querying sources and sinks                             |
| [INLONG-4128](https://github.com/apache/incubator-inlong/issues/4128) | [Improve][Manager] Abstracting the logic for creating Hive tables                                      |
| [INLONG-4120](https://github.com/apache/incubator-inlong/issues/4120) | [Improve][Manager] Change the keyWord to keyword in query params                                       |
| [INLONG-4118](https://github.com/apache/incubator-inlong/issues/4118) | [Improve][Manager] It should not return an empty list when paging the auto-push source                 |
| [INLONG-4110](https://github.com/apache/incubator-inlong/issues/4110) | [Improve][Manager] Create cascade function wrapper                                                     |
| [INLONG-4108](https://github.com/apache/incubator-inlong/issues/4108) | [Improve][Manager] Merge two enums of manager                                                          |
| [INLONG-4105](https://github.com/apache/incubator-inlong/issues/4105) | [Improve][Manager] Refactor the sink workflow and sink resource operator                               |
| [INLONG-4100](https://github.com/apache/incubator-inlong/issues/4100) | [Improve][Manager] Add id in update request for source/sink/transform                                  |
| [INLONG-4099](https://github.com/apache/incubator-inlong/issues/4099) | [Feature][Manager] Support iceberg stream sink resource operator                                       |
| [INLONG-4095](https://github.com/apache/incubator-inlong/issues/4095) | [Bug][Manager] Managerctl unit test error and characters are not aligned                               |
| [INLONG-4092](https://github.com/apache/incubator-inlong/issues/4092) | [Improve][Manager] Add primary key in Kafka source                                                     |
| [INLONG-4085](https://github.com/apache/incubator-inlong/issues/4085) | [Improve][Manager] Change the inlong_group and inlong_stream table structure                           |
| [INLONG-4084](https://github.com/apache/incubator-inlong/issues/4084) | [Improve][Manager] Add some fields for stream_source and stream_sink                                   |
| [INLONG-4078](https://github.com/apache/incubator-inlong/issues/4078) | [Improve][Manager] Add notes for manager client api                                                    |
| [INLONG-4077](https://github.com/apache/incubator-inlong/issues/4077) | [Improve][Manager] Implement the APIs of data node management                                          |
| [INLONG-4071](https://github.com/apache/incubator-inlong/issues/4071) | [Feature][Manager] Add data cluster table                                                              |
| [INLONG-4070](https://github.com/apache/incubator-inlong/issues/4070) | [Improve][Manager] Add update api In Inlong stream                                                     |
| [INLONG-4069](https://github.com/apache/incubator-inlong/issues/4069) | [Improve][Manager] Add ext_tag field for inlong cluster table                                          |
| [INLONG-4067](https://github.com/apache/incubator-inlong/issues/4067) | [Improve][Manager] Optimize fieldRelationShip in split transform                                       |
| [INLONG-4063](https://github.com/apache/incubator-inlong/issues/4063) | [Umbrella][Manager] Refactor the inlong group interfaces to support easily extending different MQs     |
| [INLONG-4060](https://github.com/apache/incubator-inlong/issues/4060) | [Improve][Manager] Fix NodeUtils for sort                                                              |
| [INLONG-4052](https://github.com/apache/incubator-inlong/issues/4052) | [Improve][Manager] Remove zone tag field of inlong cluster table                                       |
| [INLONG-4046](https://github.com/apache/incubator-inlong/issues/4046) | [Feature][Manager] Fix Filter Function of Join node                                                    |
| [INLONG-4042](https://github.com/apache/incubator-inlong/issues/4042) | [Improve][Manager] Add properties in MysqlExtractNode for migrating all databases                      |
| [INLONG-4040](https://github.com/apache/incubator-inlong/issues/4040) | [Bug][Manager] Hive sink table path config error                                                       |
| [INLONG-4034](https://github.com/apache/incubator-inlong/issues/4034) | [Improve][Manager] Add originFieldName in StreamField                                                  |
| [INLONG-4026](https://github.com/apache/incubator-inlong/issues/4026) | [Improve][Manager] Fix field type of StreamSourceFieldMapper                                           |
| [INLONG-4017](https://github.com/apache/incubator-inlong/issues/4017) | [Bug][Manager] Fix DataType deserialized exception                                                     |
| [INLONG-4012](https://github.com/apache/incubator-inlong/issues/4012) | [Feature][Manager] Add kafka sink resource operator                                                    |
| [INLONG-4000](https://github.com/apache/incubator-inlong/issues/4000) | [Improve][Manager] Refactor the implementations of heartbeat interfaces                                |
| [INLONG-3993](https://github.com/apache/incubator-inlong/issues/3993) | [Improve][Manager] Support HiveLoadNode in light mode                                                  |
| [INLONG-3981](https://github.com/apache/incubator-inlong/issues/3981) | [Improve][Manager] Fix status check of lightweight Group                                               |
| [INLONG-3958](https://github.com/apache/incubator-inlong/issues/3958) | [Improve][Manager] Fix NPEs in manager service                                                         |
| [INLONG-3951](https://github.com/apache/incubator-inlong/issues/3951) | [Bug][Manager] Unique index error for cluster_name in SQL file                                         |
| [INLONG-3947](https://github.com/apache/incubator-inlong/issues/3947) | [Improve][Manager] Support blank middleware                                                            |
| [INLONG-3946](https://github.com/apache/incubator-inlong/issues/3946) | [Improve][Manager] Implement the APIs of cluster management                                            |
| [INLONG-3943](https://github.com/apache/incubator-inlong/issues/3943) | [Feature][Manager] Add inlong_cluster and inlong_cluster_node tables                                   |
| [INLONG-3942](https://github.com/apache/incubator-inlong/issues/3942) | [Umbrella][Manager] Provides cluster management features for the InLong                                |
| [INLONG-3929](https://github.com/apache/incubator-inlong/issues/3929) | [Improve][Manager] Support deDuplicate transform in manager                                            |
| [INLONG-3921](https://github.com/apache/incubator-inlong/issues/3921) | [Improve][Manager] Add primary key in Kafka source                                                     |
| [INLONG-3920](https://github.com/apache/incubator-inlong/issues/3920) | [Improve][Manager] Add primary key in Binlog source                                                    |
| [INLONG-3919](https://github.com/apache/incubator-inlong/issues/3919) | [Improve][Manager] Data consumption and data source module supports access control                     |
| [INLONG-3915](https://github.com/apache/incubator-inlong/issues/3915) | [Bug][Manager] Missing delete flag on entity creation                                                  |
| [INLONG-3888](https://github.com/apache/incubator-inlong/issues/3888) | [Bug][Manager] The method of batchSaveAll occurred error as the sink_name was null                     |
| [INLONG-3883](https://github.com/apache/incubator-inlong/issues/3883) | [Feature][Manager] Support create table of ClickHouse                                                  |
| [INLONG-3879](https://github.com/apache/incubator-inlong/issues/3879) | [Improve][Manager] Update status enum for group, stream,  source, and sink                             |
| [INLONG-3876](https://github.com/apache/incubator-inlong/issues/3876) | [Bug][Manager] The managerctl tool crashes when lunches with  -h or --help argument                    |
| [INLONG-3874](https://github.com/apache/incubator-inlong/issues/3874) | [Improve][Manager] Abstract the operator class for creating Sink resources                             |
| [INLONG-3866](https://github.com/apache/incubator-inlong/issues/3866) | [Improve][Manager] Rename the third-party package to resource                                          |
| [INLONG-3861](https://github.com/apache/incubator-inlong/issues/3861) | [Improve][Manager] Support the expansion of TubeMQ, Pulsar, or other message queues                    |
| [INLONG-3858](https://github.com/apache/incubator-inlong/issues/3858) | [Bug][Manager] The other admin role can not list all inlong group info and stream info                 |
| [INLONG-3856](https://github.com/apache/incubator-inlong/issues/3856) | [Feature][Manager] Add heartbeat report handler                                                        |
| [INLONG-3855](https://github.com/apache/incubator-inlong/issues/3855) | [Feature][Manager] Add lightweight mode for inlong group                                               |
| [INLONG-3782](https://github.com/apache/incubator-inlong/issues/3782) | [Improve][Manager] Improve the log configuration                                                       |
| [INLONG-3776](https://github.com/apache/incubator-inlong/issues/3776) | [Improve][Manager] Update the third-party components LICENSEs                                          |
| [INLONG-3775](https://github.com/apache/incubator-inlong/issues/3775) | [Improve][Manager] Add a specific meaning for the managerctl status output                             |
| [INLONG-3731](https://github.com/apache/incubator-inlong/issues/3731) | [Improve][Manager] Make state more abstract for managerctl                                             |
| [INLONG-3719](https://github.com/apache/incubator-inlong/issues/3719) | [Feature][Manager] Support data_transformation feature                                                 |
| [INLONG-3698](https://github.com/apache/incubator-inlong/issues/3698) | [Feature][Manager] Support complex data type distribution for hive-sink                                |
| [INLONG-3636](https://github.com/apache/incubator-inlong/issues/3636) | [Improve][Manager] Fix the warning logs during the build                                               |
| [INLONG-3392](https://github.com/apache/incubator-inlong/issues/3392) | [Improve][Manager] Optimize groupName and groupId                                                      |
| [INLONG-3238](https://github.com/apache/incubator-inlong/issues/3238) | [Bug][Manager] The data grouping list cannot be edited?                                                |
| [INLONG-2901](https://github.com/apache/incubator-inlong/issues/2901) | [Bug][Manager] Maven cannot run test classes                                                           |
| [INLONG-2544](https://github.com/apache/incubator-inlong/issues/2544) | [Improve][Manager] Refactor the CreateStreamWorkflowDefinition                                         |
| [INLONG-2305](https://github.com/apache/incubator-inlong/issues/2305) | [Feature][Manager] Add Cluster Management for MQ/DataProxy/Sort Cluster                                |
| [INLONG-1858](https://github.com/apache/incubator-inlong/issues/1858) | [Bug][Manager] Adding columns to a Hive table does not take effect                                     |

### SDK
| ISSUE                                                                 | Summary                                                                                                |
|:----------------------------------------------------------------------|:-------------------------------------------------------------------------------------------------------|
| [INLONG-4400](https://github.com/apache/incubator-inlong/issues/4400) | [Improve][SDK] Unified dataproxy sdk clusterId property name                                           |
| [INLONG-4354](https://github.com/apache/incubator-inlong/issues/4354) | [Bug][SDK] ProxyConfigEntry cluster id NPE                                                             |

### Sort
| ISSUE                                                                 | Summary                                                                                                |
|:----------------------------------------------------------------------|:-------------------------------------------------------------------------------------------------------|
| [INLONG-4647](https://github.com/apache/incubator-inlong/issues/4647) | [Improve][Sort] Re-optimize the distribution package of the Sort connectors                            |
| [INLONG-4638](https://github.com/apache/incubator-inlong/issues/4638) | [Improve][Sort] Remove the dependency of spotbugs-annotations                                          |
| [INLONG-4624](https://github.com/apache/incubator-inlong/issues/4624) | [Improve][Sort] Package Pulsar and Hive connectors to the same file                                    |
| [INLONG-4619](https://github.com/apache/incubator-inlong/issues/4619) | [Bug][Sort] Fix maven package problem of Hive connector                                                |
| [INLONG-4596](https://github.com/apache/incubator-inlong/issues/4596) | [Bug][Sort] Fix jdbc-connector packaging lost dependency                                               |
| [INLONG-4591](https://github.com/apache/incubator-inlong/issues/4591) | [Bug][Sort] Set the default Hive version and upgrade the log4j to log4j2                               |
| [INLONG-4557](https://github.com/apache/incubator-inlong/issues/4557) | [Bug][Sort] Fix HBase connector dependency and pom relocation problem                                  |
| [INLONG-4527](https://github.com/apache/incubator-inlong/issues/4527) | [Improve][Sort] Upgrade the Elasticsearch version and add related license                              |
| [INLONG-4493](https://github.com/apache/incubator-inlong/issues/4493) | [Improve][Sort] Remove hiveConfDir not null constraint                                                 |
| [INLONG-4491](https://github.com/apache/incubator-inlong/issues/4491) | [Bug][Sort] Missing dependencies after packaging for sort-dist module                                  |
| [INLONG-4476](https://github.com/apache/incubator-inlong/issues/4476) | [Improve][Sort][Manager] Remove zk and related classes                                                 |
| [INLONG-4458](https://github.com/apache/incubator-inlong/issues/4458) | [Improve][Sort][Manager] Unify the meta field naming                                                   |
| [INLONG-4448](https://github.com/apache/incubator-inlong/issues/4448) | [Feature][Sort] Add Greenplum database data load support                                               |
| [INLONG-4429](https://github.com/apache/incubator-inlong/issues/4429) | [Improve][Sort] Add sqlserver jdbc driver and management version                                       |
| [INLONG-4428](https://github.com/apache/incubator-inlong/issues/4428) | [Improve][Sort][Manager] Optimize the name for Data Node related modules and classes                   |
| [INLONG-4408](https://github.com/apache/incubator-inlong/issues/4408) | [Feature][Manager][Sort] Add iceberg sink load node                                                    |
| [INLONG-4405](https://github.com/apache/incubator-inlong/issues/4405) | [Feature][Sort] Support run SQL script                                                                 |
| [INLONG-4394](https://github.com/apache/incubator-inlong/issues/4394) | [Feature][Sort] Add Oracle data load support                                                           |
| [INLONG-4390](https://github.com/apache/incubator-inlong/issues/4390) | [Bug][Sort] Exclude mysql:mysql-connector-java:jar package                                             |
| [INLONG-4385](https://github.com/apache/incubator-inlong/issues/4385) | [Bug][Sort] Exclude or remove the mysql:mysql-connector-java:jar:8.0.21 package                        |
| [INLONG-4383](https://github.com/apache/incubator-inlong/issues/4383) | [Feature][Sort] Add MySQL data load support                                                            |
| [INLONG-4371](https://github.com/apache/incubator-inlong/issues/4371) | [Bug][Sort] Remove null constraint on Hive version                                                     |
| [INLONG-4353](https://github.com/apache/incubator-inlong/issues/4353) | [Improve][Sort] Optimize code structure and shading jar                                                |
| [INLONG-4346](https://github.com/apache/incubator-inlong/issues/4346) | [Improve][Sort] Enhance upsert capability for SqlServer                                                |
| [INLONG-4345](https://github.com/apache/incubator-inlong/issues/4345) | [Feature][Sort] Support sink changelog stream to TDSQL PostgreSQL                                      |
| [INLONG-4342](https://github.com/apache/incubator-inlong/issues/4342) | [Improve][Sort] Duplicate audit-sdk dependency in sort core                                            |
| [INLONG-4339](https://github.com/apache/incubator-inlong/issues/4339) | [Improve][Sort] Rollback debezium-core to 1.5.4                                                        |
| [INLONG-4332](https://github.com/apache/incubator-inlong/issues/4332) | [Feature][Manager][Sort] Support ClickHouse load node                                                  |
| [INLONG-4327](https://github.com/apache/incubator-inlong/issues/4327) | [Bug][Sort] Fix missing some connector table factory error after packaging                             |
| [INLONG-4312](https://github.com/apache/incubator-inlong/issues/4312) | [Feature][Sort] Add SqlServer data load support                                                        |
| [INLONG-4306](https://github.com/apache/incubator-inlong/issues/4306) | [Bug][Sort] Parameter error   connector of file system                                                 |
| [INLONG-4303](https://github.com/apache/incubator-inlong/issues/4303) | [Improve][Sort] Iceberg Load Node add required option                                                  |
| [INLONG-4292](https://github.com/apache/incubator-inlong/issues/4292) | [Improve][Agent][TubeMQ][Sort] Upgrade the property file for all modules from log4j to log4j2          |
| [INLONG-4282](https://github.com/apache/incubator-inlong/issues/4282) | [Improve][Sort] Optimize the sort package structure                                                    |
| [INLONG-4264](https://github.com/apache/incubator-inlong/issues/4264) | [Bug][Sort] Sort lightweight start 'pulsar-to-kafka' task failed                                       |
| [INLONG-4262](https://github.com/apache/incubator-inlong/issues/4262) | [Feature][Sort] Add SqlServer data extract support                                                     |
| [INLONG-4259](https://github.com/apache/incubator-inlong/issues/4259) | [Feature][Sort] Import inlong format json serialize/deserialize                                        |
| [INLONG-4250](https://github.com/apache/incubator-inlong/issues/4250) | [Feature][Sort] Add Elasticsearch load node                                                            |
| [INLONG-4245](https://github.com/apache/incubator-inlong/issues/4245) | [Improve][Manager][Sort] Manager transmit consumer group name of kafka to sort                         |
| [INLONG-4243](https://github.com/apache/incubator-inlong/issues/4243) | [Feature][Sort] Add Oracle data extract support                                                        |
| [INLONG-4228](https://github.com/apache/incubator-inlong/issues/4228) | [Feature][Sort][Manager] Adaptive HDFS Load Node                                                       |
| [INLONG-4227](https://github.com/apache/incubator-inlong/issues/4227) | [Feature][Sort] Sort lightweight support extract data to ClickHouse                                    |
| [INLONG-4224](https://github.com/apache/incubator-inlong/issues/4224) | [Improve][Sort] Add debezium module to connectors                                                      |
| [INLONG-4244](https://github.com/apache/incubator-inlong/issues/4244) | [Improve][Sort] Remove flink-avro relocation                                                           |
| [INLONG-4215](https://github.com/apache/incubator-inlong/issues/4215) | [Improve][Sort] Add license for Hive connector of Sort                                                 |
| [INLONG-4198](https://github.com/apache/incubator-inlong/issues/4198) | [Feature][Sort] Add Postgres load node                                                                 |
| [INLONG-4189](https://github.com/apache/incubator-inlong/issues/4189) | [Feature][Sort] Change the NOTICE to LICENSE                                                           |
| [INLONG-4174](https://github.com/apache/incubator-inlong/issues/4174) | [Feature][Sort] Add Postgres extract node supporting                                                   |
| [INLONG-4171](https://github.com/apache/incubator-inlong/issues/4171) | [Feature][Sort] Add FileSystem extract node                                                            |
| [INLONG-4170](https://github.com/apache/incubator-inlong/issues/4170) | [Feature][Sort] Add FileSystem load node                                                               |
| [INLONG-4169](https://github.com/apache/incubator-inlong/issues/4169) | [Improve][Sort] Add Java docs in sort                                                                  |
| [INLONG-4167](https://github.com/apache/incubator-inlong/issues/4167) | [Feature][Sort] Add MongoDB extract node                                                               |
| [INLONG-4157](https://github.com/apache/incubator-inlong/issues/4157) | [Feature][Sort] Sort lightweight support load data to Iceberg                                          |
| [INLONG-4156](https://github.com/apache/incubator-inlong/issues/4156) | [Feature][Sort] Support HBase load node                                                                |
| [INLONG-4141](https://github.com/apache/incubator-inlong/issues/4141) | [Feature][Sort] Sort lightweight support load data from Pulsar                                         |
| [INLONG-4097](https://github.com/apache/incubator-inlong/issues/4097) | [Improve][Sort] Use javax constrain notNull annotation                                                 |
| [INLONG-4090](https://github.com/apache/incubator-inlong/issues/4090) | [Improve][Sort] Add license for MySQL CDC in Sort single tenant                                        |
| [INLONG-4086](https://github.com/apache/incubator-inlong/issues/4086) | [Improve][Sort] Remove BufferedSocketInputStream class as it is not used                               |
| [INLONG-4081](https://github.com/apache/incubator-inlong/issues/4081) | [Bug][Sort] Fix upsert_kafka constant to upsert-kafka                                                  |
| [INLONG-4066](https://github.com/apache/incubator-inlong/issues/4066) | [Feature][Sort] Add Inlong Msg format for inlong msg                                                   |
| [INLONG-4058](https://github.com/apache/incubator-inlong/issues/4058) | [Improve][Sort] Resolve AVRO format dependency conflict                                                |
| [INLONG-4050](https://github.com/apache/incubator-inlong/issues/4050) | [Bug][Sort] Parameter definition error of HiveLoad                                                     |
| [INLONG-4048](https://github.com/apache/incubator-inlong/issues/4048) | [Bug][Sort] Fix metadata type process error and hive-exec dependency scope error                       |
| [INLONG-4044](https://github.com/apache/incubator-inlong/issues/4044) | [Bug][Sort] Resolve conflict of flink-table-api-java-bridge jar                                        |
| [INLONG-4035](https://github.com/apache/incubator-inlong/issues/4035) | [Bug][Sort] Change the restriction of Hive catalogName from not nullable to nullable                   |
| [INLONG-4030](https://github.com/apache/incubator-inlong/issues/4030) | [Improve][Sort] Import all changelog mode data ingest into Hive                                        |
| [INLONG-4022](https://github.com/apache/incubator-inlong/issues/4022) | [Bug][Sort] Flink table catalog only supports timestamp of precision 9                                 |
| [INLONG-4013](https://github.com/apache/incubator-inlong/issues/4013) | [Feature][Sort] Support write metadata in canal format                                                 |
| [INLONG-4007](https://github.com/apache/incubator-inlong/issues/4007) | [Improve][Sort] Modify default settings of CSV format                                                  |
| [INLONG-4005](https://github.com/apache/incubator-inlong/issues/4005) | [Bug][Sort] Remove some inappropriate comment and code                                                 |
| [INLONG-3996](https://github.com/apache/incubator-inlong/issues/3996) | [Feature][Sort] Support all migrate for database                                                       |
| [INLONG-3979](https://github.com/apache/incubator-inlong/issues/3979) | [Bug][Sort] Fix mysqlExtractNode options append error and conflict of flink jar                        |
| [INLONG-3973](https://github.com/apache/incubator-inlong/issues/3973) | [Feature][Sort] CDC support all migration                                                              |
| [INLONG-3961](https://github.com/apache/incubator-inlong/issues/3961) | [Feature][Sort] Add MySQL CDC append                                                                   |
| [INLONG-3956](https://github.com/apache/incubator-inlong/issues/3956) | [Feature][Sort] Add Hive connector to support CDC                                                      |
| [INLONG-3953](https://github.com/apache/incubator-inlong/issues/3953) | [Feature][Sort] Add MySQL dynamic table implementation -  modified from Flink CDC                      |
| [INLONG-3924](https://github.com/apache/incubator-inlong/issues/3924) | [Feature][Sort] Add MySQL cdc and support multiple meta data                                           |
| [INLONG-3899](https://github.com/apache/incubator-inlong/issues/3899) | [Feature][Sort] Add string regexp replace support for transform                                        |
| [INLONG-3893](https://github.com/apache/incubator-inlong/issues/3893) | [Feature][Sort] Add string delimiting support for transform                                            |
| [INLONG-3890](https://github.com/apache/incubator-inlong/issues/3890) | [Feature][Sort] Add StringConstantParam to enhance support for constant parameters                     |
| [INLONG-3885](https://github.com/apache/incubator-inlong/issues/3885) | [Feature][Sort] Add KafkaExtractNode to support Kafka source                                           |
| [INLONG-3868](https://github.com/apache/incubator-inlong/issues/3868) | [Feature][Sort] Support data from mysql binlog sync to kafka                                           |
| [INLONG-3860](https://github.com/apache/incubator-inlong/issues/3860) | [Improve][Sort] Add some format for ExtractNode and LoadNode                                           |
| [INLONG-3841](https://github.com/apache/incubator-inlong/issues/3841) | [Feature][Sort] Add distinct support based time column for transform                                   |
| [INLONG-3839](https://github.com/apache/incubator-inlong/issues/3839) | [Feature][Sort] Add cascade function support for transform                                             |
| [INLONG-3837](https://github.com/apache/incubator-inlong/issues/3837) | [Feature][Sort] Optimize the time window correlation function format                                   |
| [INLONG-3836](https://github.com/apache/incubator-inlong/issues/3836) | [Feature][Sort] Add join support for transform                                                         |
| [INLONG-3835](https://github.com/apache/incubator-inlong/issues/3835) | [Feature][Sort] Register CascadeFunctionWrapper in the parent interface                                |
| [INLONG-3834](https://github.com/apache/incubator-inlong/issues/3834) | [Feature][Sort] Fix unit test sporadic errors                                                          |
| [INLONG-3831](https://github.com/apache/incubator-inlong/issues/3831) | [Feature][Sort] Add meta field support for sort lightweight                                            |
| [INLONG-3829](https://github.com/apache/incubator-inlong/issues/3829) | [Feature][Sort] Optimize the sort entrance program to support lightweight                              |
| [INLONG-3827](https://github.com/apache/incubator-inlong/issues/3827) | [Feature][Sort] Add functions definition to support transform                                          |
| [INLONG-3826](https://github.com/apache/incubator-inlong/issues/3826) | [Feature][Sort] Enhance field format to support varchar types and timestamp of different precisions    |
| [INLONG-3823](https://github.com/apache/incubator-inlong/issues/3823) | [Feature][Sort] Fix error caused by unregistered custom function                                       |
| [INLONG-3822](https://github.com/apache/incubator-inlong/issues/3822) | [Feature][Sort] Add node relations definition to support transform                                     |
| [INLONG-3817](https://github.com/apache/incubator-inlong/issues/3817) | [Feature][Sort] Fix null point exception in canal-json format                                          |
| [INLONG-3816](https://github.com/apache/incubator-inlong/issues/3816) | [Feature][Sort] Fix NPE in RegexpReplaceFirstFunction                                                  |
| [INLONG-3815](https://github.com/apache/incubator-inlong/issues/3815) | [Feature][Sort] Fix meta field sync error                                                              |
| [INLONG-3805](https://github.com/apache/incubator-inlong/issues/3805) | [Feature][Sort] Add operators definition to support transform                                          |
| [INLONG-3800](https://github.com/apache/incubator-inlong/issues/3800) | [Feature][Sort] Add GroupInfo, StreamInfo definition to support transform                              |
| [INLONG-3794](https://github.com/apache/incubator-inlong/issues/3794) | [Feature][Sort] Add TimeUnitConstantParam definition to support transform                              |
| [INLONG-3793](https://github.com/apache/incubator-inlong/issues/3793) | [Feature][Sort] Add ConstantParam definition to support transform                                      |
| [INLONG-3791](https://github.com/apache/incubator-inlong/issues/3791) | [Feature][Sort] Add WatermarkField definition to support transform                                     |
| [INLONG-3790](https://github.com/apache/incubator-inlong/issues/3790) | [Feature][Sort] Add FieldRelationShip definition to support transform                                  |
| [INLONG-3789](https://github.com/apache/incubator-inlong/issues/3789) | [Feature][Sort] Add NodeRelationShip definition to support transform                                   |
| [INLONG-3788](https://github.com/apache/incubator-inlong/issues/3788) | [Feature][Sort] Add Node interface and derived interface definitions to support transform              |
| [INLONG-3787](https://github.com/apache/incubator-inlong/issues/3787) | [Feature][Sort] Add Function interface and derived interface definitions to support transform          |
| [INLONG-3786](https://github.com/apache/incubator-inlong/issues/3786) | [Feature][Sort] Add Operator interface and derived interface definitions to support transform          |
| [INLONG-3778](https://github.com/apache/incubator-inlong/issues/3778) | [Feature][Sort] FieldInfo enhanced to support transform in the future                                  |
| [INLONG-3777](https://github.com/apache/incubator-inlong/issues/3777) | [Feature][Sort] ExtractNode,LoadNode implementation                                                    |
| [INLONG-3658](https://github.com/apache/incubator-inlong/issues/3658) | [Umbrella][Sort] Data integration lightweight                                                          |
| [INLONG-1823](https://github.com/apache/incubator-inlong/issues/1823) | [Feature][Sort] Support store data to Elasticsearch                                                    |

### Sort-Standalone
| ISSUE                                                                 | Summary                                                                                                |
|:----------------------------------------------------------------------|:-------------------------------------------------------------------------------------------------------|
| [INLONG-4453](https://github.com/apache/incubator-inlong/issues/4453) | [Bug][Sort-Standalone] Wrong audit when send to kafka failed                                           |
| [INLONG-3773](https://github.com/apache/incubator-inlong/issues/3773) | [Feature][Sort-Standalone] Support configurable handler to transform data of Kafka                     |
| [INLONG-3667](https://github.com/apache/incubator-inlong/issues/3667) | [Feature][Sort-Standalone] Add manage entry to stop cache consumer before node offline or upgrade      |
| [INLONG-1933](https://github.com/apache/incubator-inlong/issues/1933) | [Feature][Sort-Standalone] Read API support inlong manager commands                                    |

### TubeMQ
| ISSUE                                                                 | Summary                                                                                                |
|:----------------------------------------------------------------------|:-------------------------------------------------------------------------------------------------------|
| [INLONG-4486](https://github.com/apache/incubator-inlong/issues/4486) | [Improve][TubeMQ] Adjust the parameter requirements of group consume delete control APIs               |
| [INLONG-4470](https://github.com/apache/incubator-inlong/issues/4470) | [Improve][TubeMQ] The adminQueryBlackGroupInfo method adds query topicName field                       |
| [INLONG-4451](https://github.com/apache/incubator-inlong/issues/4451) | [Bug][TubeMQ] The zookeeper service can not start for TubeMQ Docker Container                          |
| [INLONG-4324](https://github.com/apache/incubator-inlong/issues/4324) | [Improve][TubeMQ] Add Javadoc for methods                                                              |
| [INLONG-4321](https://github.com/apache/incubator-inlong/issues/4321) | [Improve][TubeMQ] Add Javadoc comments for methods                                                     |
| [INLONG-4292](https://github.com/apache/incubator-inlong/issues/4292) | [Improve][Agent][TubeMQ][Sort] Upgrade the property file for all modules from log4j to log4j2          |
| [INLONG-4217](https://github.com/apache/incubator-inlong/issues/4217) | [Improve][TubeMQ] Add the flow control method and filtering method of the consumption group settings   |
| [INLONG-4130](https://github.com/apache/incubator-inlong/issues/4130) | [Improve][TubeMQ] Optimize the broker replication method and topic replication method                  |
| [INLONG-4114](https://github.com/apache/incubator-inlong/issues/4114) | [Bug][TubeMQ] All container can not start successfully                                                 |
| [INLONG-3975](https://github.com/apache/incubator-inlong/issues/3975) | [Improve][TubeMQ] Modify the MasterConfigTest file to configure the incoming parameters                |
| [INLONG-3869](https://github.com/apache/incubator-inlong/issues/3869) | [Improve][TubeMQ] Remove hibernate for tube manager                                                    |
| [INLONG-3475](https://github.com/apache/incubator-inlong/issues/3475) | [Feature][TubeMQ] Add an API for batch deletion of authorized consumer group records                   |

### Other
| ISSUE                                                                 | Summary                                                                                                |
|:----------------------------------------------------------------------|:-------------------------------------------------------------------------------------------------------|
| [INLONG-4640](https://github.com/apache/incubator-inlong/issues/4640) | [License] Complete the LICENSE of the third-party dependencies of the Sort connectors                  |
| [INLONG-4633](https://github.com/apache/incubator-inlong/issues/4633) | [License] Add the third-party dependency LICENSE of Sort connectors module                             |
| [INLONG-4628](https://github.com/apache/incubator-inlong/issues/4628) | [License] Update inlong-manager's third-party dependency LICENSE                                       |
| [INLONG-4574](https://github.com/apache/incubator-inlong/issues/4574) | [Release] Bumped version to 1.3.0-incubating-SNAPSHOT                                                  |
| [INLONG-4568](https://github.com/apache/incubator-inlong/issues/4568) | [Release] Bumped version to 1.2.1-incubating-SNAPSHOT                                                  |
| [INLONG-4567](https://github.com/apache/incubator-inlong/issues/4567) | [Release] Update changes log for the 1.2.0 version                                                     |
| [INLONG-4565](https://github.com/apache/incubator-inlong/issues/4565) | [Release] Add the 1.2.0 version option for the bug report                                              |
| [INLONG-4368](https://github.com/apache/incubator-inlong/issues/4368) | [License] Final LICENSE check of all modules                                                           |
| [INLONG-4336](https://github.com/apache/incubator-inlong/issues/4336) | [License] Update inlong-sort's third-party dependency LICENSE                                          |
| [INLONG-4318](https://github.com/apache/incubator-inlong/issues/4318) | [License] Update inlong-manager's third-party dependency LICENSE                                       |
| [INLONG-4314](https://github.com/apache/incubator-inlong/issues/4314) | [License] Update Sort-standalone's third-party dependency LICENSE                                      |
| [INLONG-4305](https://github.com/apache/incubator-inlong/issues/4305) | [License] Update TubeMQ-Manager's third-party dependency LICENSE                                       |
| [INLONG-4296](https://github.com/apache/incubator-inlong/issues/4296) | [License] Update Audit, DataProxy, TubeMQ's third-party dependency LICENSE                             |
| [INLONG-4288](https://github.com/apache/incubator-inlong/issues/4288) | [License] Update Agent's third-party dependency LICENSE                                                |
| [INLONG-3968](https://github.com/apache/incubator-inlong/issues/3968) | [License] Remove the "WIP" label of the DISCLAIMER file                                                |
| [INLONG-3864](https://github.com/apache/incubator-inlong/issues/3864) | [License] Recheck the third-party dependencies by combing each module                                  |
| [INLONG-3849](https://github.com/apache/incubator-inlong/issues/3849) | [License] Update the third-party components LICENSEs for inlong-audit                                  |
| [INLONG-3771](https://github.com/apache/incubator-inlong/issues/3771) | [License] Update the third-party components LICENSEs for inlong-agent                                  |
| [INLONG-3422](https://github.com/apache/incubator-inlong/issues/3422) | [License] Sort out the LICENSEs of the third-party components that the project depends on              |
| [INLONG-4426](https://github.com/apache/incubator-inlong/issues/4426) | [Improve][Office-Website] Update CI Nodejs Version                                                     |
| [INLONG-4150](https://github.com/apache/incubator-inlong/issues/4150) | [Improve][Office-Website] Automatically identify version number sorting                                |
| [INLONG-4455](https://github.com/apache/incubator-inlong/issues/4455) | [Improve][GitHub] Update the Pull Request TEMPLATE to make it more clear                               |
| [INLONG-4267](https://github.com/apache/incubator-inlong/issues/4267) | [Bug][GitHub] The checks pipeline of PR was incorrect                                                  |
| [INLONG-4251](https://github.com/apache/incubator-inlong/issues/4251) | [Improve][GitHub] Improve GitHub configuration in `.asf.yaml`                                          |
| [INLONG-4205](https://github.com/apache/incubator-inlong/issues/4205) | [Bug][GitHub] Error in the greeting workflow                                                           |
| [INLONG-4201](https://github.com/apache/incubator-inlong/issues/4201) | [Improve][GitHub] Improve workflows and documentation                                                  |
| [INLONG-4161](https://github.com/apache/incubator-inlong/issues/4161) | [Bug][GitHub] Incorrect name in stale workflow                                                         |
| [INLONG-4153](https://github.com/apache/incubator-inlong/issues/4153) | [Feature][GitHub] Add support for first interaction                                                    |
| [INLONG-4038](https://github.com/apache/incubator-inlong/issues/4038) | [Improve][GitHub] Enable the alert of dependabot, and disable the automatic update                     |
| [INLONG-4024](https://github.com/apache/incubator-inlong/issues/4024) | [Improve][GitHub] Improve trigger conditions in the stable workflow                                    |
| [INLONG-4019](https://github.com/apache/incubator-inlong/issues/4019) | [Improve][GitHub] Update the dependency from dependabot                                                |
| [INLONG-4001](https://github.com/apache/incubator-inlong/issues/4001) | [Improve][Docker] Modify the MySQL Docker image version to 8.0.28                                      |
| [INLONG-3998](https://github.com/apache/incubator-inlong/issues/3998) | [Improve][GitHub] Improve labeler workflow with docker, k8s and github labels                          |
| [INLONG-3995](https://github.com/apache/incubator-inlong/issues/3995) | [Improve][GitHub] Improve Dependabot configuration                                                     |
| [INLONG-3974](https://github.com/apache/incubator-inlong/issues/3974) | [Feature][GitHub] Add support for Dependabot                                                           |
| [INLONG-3473](https://github.com/apache/incubator-inlong/issues/3473) | [Feature][GitHub][K8s] Add support for helm chart testing                                              |
| [INLONG-4349](https://github.com/apache/incubator-inlong/issues/4349) | [Improve][Doc] Update check style to avoid the Javadoc missing and error                               |
| [INLONG-4256](https://github.com/apache/incubator-inlong/issues/4256) | [Improve][Doc] Add java doc to solve the checkstyle issues                                             |
| [INLONG-4073](https://github.com/apache/incubator-inlong/issues/4073) | [Improve][Doc] Modify the invitation email templates of Committer or PPMC                              |
| [INLONG-3965](https://github.com/apache/incubator-inlong/issues/3965) | [Improve][Doc] Add how-to-maintain-3rd-party-dependencies.md                                           |
| [INLONG-3930](https://github.com/apache/incubator-inlong/issues/3930) | [Improve][Doc] Add more deployment and development guides in Readme                                    |
| [INLONG-3843](https://github.com/apache/incubator-inlong/issues/3843) | [Bug][Doc] The link to "Contribution Guide for Apache InLong" is invalid                               |
| [INLONG-1839](https://github.com/apache/incubator-inlong/issues/1839) | [Improve][Doc] Supplement deployment document                                                          |
| [INLONG-4351](https://github.com/apache/incubator-inlong/issues/4351) | [Improve][Pom] Update the fastjson to solve the CVEs                                                   |
| [INLONG-4484](https://github.com/apache/incubator-inlong/issues/4484) | [Improve][Pom] Upgrade Spring version from 5.3.19 to 5.3.20                                            |
| [INLONG-3940](https://github.com/apache/incubator-inlong/issues/3940) | [Improve][Pom] Bump spring-core from 5.3.18 to 5.3.19                                                  |
| [INLONG-3935](https://github.com/apache/incubator-inlong/issues/3935) | [Feature][Pom] Remove dependency of testng                                                             |
| [INLONG-3780](https://github.com/apache/incubator-inlong/issues/3780) | [Improve][Pom] Upgrade postgresql due to CVEs                                                          |
| [INLONG-4434](https://github.com/apache/incubator-inlong/issues/4434) | [Bug][Docker] Audit Container caught error when create pulsar topic                                    |
| [INLONG-3898](https://github.com/apache/incubator-inlong/issues/3898) | [Bug][Docker] The log paths of Agent, Audit, Dataproxy and TubeMQ Manager containers are incorrect     |
| [INLONG-3744](https://github.com/apache/incubator-inlong/issues/3744) | [Bug][Docker] Docker images are not pushed in release-* branches                                       |
| [INLONG-3553](https://github.com/apache/incubator-inlong/issues/3553) | [Bug][Docker][K8s] TubeMQ pod fails to start                                                           |
| [INLONG-4144](https://github.com/apache/incubator-inlong/issues/4144) | [Bug][K8s] HTTP error appears on the login dashboard when deploying InLong using helm                  |
| [INLONG-3845](https://github.com/apache/incubator-inlong/issues/3845) | [Bug][K8s] The manager pod fails to start                                                              |
| [INLONG-3635](https://github.com/apache/incubator-inlong/issues/3635) | [Improve][JavaDoc] Fix the Javadoc check style problems for all modules                                |


## Release InLong 1.1.0-incubating - Released (as of 2022-04-15)

### Agent
| ISSUE                                                                 | Summary                                                                                      |
|:----------------------------------------------------------------------|:---------------------------------------------------------------------------------------------|
| [INLONG-3699](https://github.com/apache/incubator-inlong/issues/3699) | [Improve][Agent] Exclude mysql-connector-java                                                |
| [INLONG-3692](https://github.com/apache/incubator-inlong/issues/3692) | [Bug][Agent] There are many agent processes after recovering the directory                   |
| [INLONG-3652](https://github.com/apache/incubator-inlong/issues/3652) | [Improve][Agent] Improve TestBinlogOffsetManager unit test                                   |
| [INLONG-3650](https://github.com/apache/incubator-inlong/issues/3650) | [Bug] Agent fix timeoffset npe                                                               |
| [INLONG-3638](https://github.com/apache/incubator-inlong/issues/3638) | [Bug] Agent and DataProxy can not listen to the 8080 port for Prometheus                     |
| [INLONG-3629](https://github.com/apache/incubator-inlong/issues/3629) | [Improve][Agent] Improve TestFileAgent unit test                                             |
| [INLONG-3620](https://github.com/apache/incubator-inlong/issues/3620) | [Improve] Update the file agent guide document                                               |
| [INLONG-3587](https://github.com/apache/incubator-inlong/issues/3587) | [Bug][Agent]Resource leak                                                                    |
| [INLONG-3476](https://github.com/apache/incubator-inlong/issues/3476) | [Bug][Agent] debezium 1.8.1 has npe                                                          |
| [INLONG-3466](https://github.com/apache/incubator-inlong/issues/3466) | [Feature][Agent] Remove protobuf dependency                                                  |
| [INLONG-3463](https://github.com/apache/incubator-inlong/issues/3463) | [Bug][Agent] Fix unit test of TestTaskWrapper                                                |
| [INLONG-3448](https://github.com/apache/incubator-inlong/issues/3448) | [Improve][Manager] Limit the number of Agent pull tasks                                      |
| [INLONG-3437](https://github.com/apache/incubator-inlong/issues/3437) | [Agent] Sort out the LICENSEs of the third-party components of inlong-agent                  |
| [INLONG-3381](https://github.com/apache/incubator-inlong/issues/3381) | [Feature] Agent wait one minute for dataproxy to prepare topic config                        |
| [INLONG-3349](https://github.com/apache/incubator-inlong/issues/3349) | [Feature] Agent add limitation for job number                                                |
| [INLONG-3335](https://github.com/apache/incubator-inlong/issues/3335) | [Bug] fix agent snapshot mode won't work and optimize jvm parameters                         |
| [INLONG-3326](https://github.com/apache/incubator-inlong/issues/3326) | [Improve][Agent] The unit test for TestTaskWrapper was running too long                      |
| [INLONG-3317](https://github.com/apache/incubator-inlong/issues/3317) | [Improve][Agent] Change agent heartbeat/report interval to 10s                               |
| [INLONG-3308](https://github.com/apache/incubator-inlong/issues/3308) | [Bug][Agent] NPE occurred in parsing deliveryTime                                            |
| [INLONG-3306](https://github.com/apache/incubator-inlong/issues/3306) | [Feature][Agent] Use rocksdb as default db in agent                                          |
| [INLONG-3304](https://github.com/apache/incubator-inlong/issues/3304) | [Bug][Agent] Reader cost too much CPU                                                        |
| [INLONG-3299](https://github.com/apache/incubator-inlong/issues/3299) | [Bug][Agent] Report job result rather than task result                                       |
| [INLONG-3298](https://github.com/apache/incubator-inlong/issues/3298) | [Feature][Agent] Remove dbd implementation                                                   |
| [INLONG-3297](https://github.com/apache/incubator-inlong/issues/3297) | [Feature] Add version control in Agent CommandEntity                                         |
| [INLONG-3274](https://github.com/apache/incubator-inlong/issues/3274) | [Bug][Agent] When Kafka topic is deleted                                                     |
| [INLONG-3271](https://github.com/apache/incubator-inlong/issues/3271) | [Bug][Agent] Cannot get localip in docker.sh                                                 |
| [INLONG-3168](https://github.com/apache/incubator-inlong/issues/3168) | [Bug][Agent] Change the deserialization type from String to byte array                       |
| [INLONG-3148](https://github.com/apache/incubator-inlong/issues/3148) | [Bug][Agent] fix avro serialization                                                          |
| [INLONG-3104](https://github.com/apache/incubator-inlong/issues/3104) | [Bug][Agent] Add default value for kafka consumer group                                      |
| [INLONG-3100](https://github.com/apache/incubator-inlong/issues/3100) | [Bug][Agent] Upgrade Kafka to newest version 3.1.0                                           |
| [INLONG-3099](https://github.com/apache/incubator-inlong/issues/3099) | [Bug][Agent] Duplicate send message when agent receive data                                  |
| [INLONG-3083](https://github.com/apache/incubator-inlong/issues/3083) | [Bug][Agent] Upgrade Scala version in Kafka client                                           |
| [INLONG-3077](https://github.com/apache/incubator-inlong/issues/3077) | [Bug][Agent] FileNotFoundException occurred in unit tests                                    |
| [INLONG-3076](https://github.com/apache/incubator-inlong/issues/3076) | [Bug][Agent] MalformedObjectNameException occurred in unit tests                             |
| [INLONG-3050](https://github.com/apache/incubator-inlong/issues/3050) | [Bug][Agent] Update guava version                                                            |
| [INLONG-3045](https://github.com/apache/incubator-inlong/issues/3045) | [Feature][Agent] Add rocksDb implementation                                                  |
| [INLONG-3027](https://github.com/apache/incubator-inlong/issues/3027) | [Feature][Agent] Upgrade snappy version                                                      |
| [INLONG-3022](https://github.com/apache/incubator-inlong/issues/3022) | [Bug] agent pod start failed                                                                 |
| [INLONG-2985](https://github.com/apache/incubator-inlong/issues/2985) | [Bug][Manager] Fix task type and UTF question for agent                                      |
| [INLONG-2974](https://github.com/apache/incubator-inlong/issues/2974) | [Improve][Manager] Support agent to pull tasks without ip and uuid                           |
| [INLONG-2933](https://github.com/apache/incubator-inlong/issues/2933) | [Bug][Agent][Manager] Change the type of the deliveryTime field from Date to String          |
| [INLONG-2908](https://github.com/apache/incubator-inlong/issues/2908) | [Bug][Agent] Delete uuid around space                                                        |
| [INLONG-2894](https://github.com/apache/incubator-inlong/issues/2894) | [Improve][Agent] Adapt the interface and field modification of the Inlong-Manager            |
| [INLONG-2883](https://github.com/apache/incubator-inlong/issues/2883) | [Bug][Agent] ManagerFetcher throws exception when invoke the Gson.fromJson method            |
| [INLONG-2877](https://github.com/apache/incubator-inlong/issues/2877) | [Bug][Agent] Task position manager throws NPE when send dataproxy ack success                |
| [INLONG-2870](https://github.com/apache/incubator-inlong/issues/2870) | [Bug][Agent] Use base64 to encode snapshot instead of using iso-8859-1                       |
| [INLONG-2860](https://github.com/apache/incubator-inlong/issues/2860) | [Feature][Agent] Create file folder when history file set by user does not exist             |
| [INLONG-2859](https://github.com/apache/incubator-inlong/issues/2859) | [Improve][Agent]  Optimize stopping Kafka tasks                                              |
| [INLONG-2857](https://github.com/apache/incubator-inlong/issues/2857) | [Feature][Agent] Support to destroy task                                                     |
| [INLONG-2851](https://github.com/apache/incubator-inlong/issues/2851) | [Feature] Agent change task id string to integer                                             |
| [INLONG-2826](https://github.com/apache/incubator-inlong/issues/2826) | [Bug] Agent mysql connection should set allowPublicKeyRetrieval to true to support mysql 8.0 |
| [INLONG-2818](https://github.com/apache/incubator-inlong/issues/2818) | [Bug] Agent kafka job and binlog job has jar conflict                                        |
| [INLONG-2790](https://github.com/apache/incubator-inlong/issues/2790) | [Bug][Agent] Log4j cannot be output due to jar conflict                                      |
| [INLONG-2788](https://github.com/apache/incubator-inlong/issues/2788) | [Feature] Agent support sync send data to dataproxy when needed (binlog etc.)                |
| [INLONG-2786](https://github.com/apache/incubator-inlong/issues/2786) | [Feature] Agent jetty server support different job type                                      |
| [INLONG-2779](https://github.com/apache/incubator-inlong/issues/2779) | [Feature] Agent support delete job using jetty server                                        |
| [INLONG-2756](https://github.com/apache/incubator-inlong/issues/2756) | [Improve][Agent] Add more logs when sending data to proxy                                    |
| [INLONG-2754](https://github.com/apache/incubator-inlong/issues/2754) | [Feature][Agent] Add strea metric data to Prometheus and JMX                                 |
| [INLONG-2736](https://github.com/apache/incubator-inlong/issues/2736) | [Bug][Manager] Agent get task from manager error                                             |
| [INLONG-2735](https://github.com/apache/incubator-inlong/issues/2735) | [INLONG][Agent] Fix dataprofile properties                                                   |
| [INLONG-2688](https://github.com/apache/incubator-inlong/issues/2688) | [Feature][Agent] Support task freeze and restart when needed                                 |
| [INLONG-2687](https://github.com/apache/incubator-inlong/issues/2687) | [Feature][Agent] Provide binlog reader ability using debezium engine                         |
| [INLONG-2686](https://github.com/apache/incubator-inlong/issues/2686) | [Feature][Agent] Support snapshot for each task                                              |
| [INLONG-2680](https://github.com/apache/incubator-inlong/issues/2680) | [Improve][Common][Agent] Move common class from inlong-agent module to inlong-common         |
| [INLONG-2675](https://github.com/apache/incubator-inlong/issues/2675) | [Feature][Agent] Fix the problem of common dependcy                                          |
| [INLONG-2666](https://github.com/apache/incubator-inlong/issues/2666) | [Feature][Agent] Support kafka collection                                                    |
| [INLONG-2654](https://github.com/apache/incubator-inlong/issues/2654) | [Feature][Agent] Report heartbeat to manager                                                 |
| [INLONG-2530](https://github.com/apache/incubator-inlong/issues/2530) | [Bug] Agent data time never changes                                                          |
| [INLONG-2285](https://github.com/apache/incubator-inlong/issues/2285) | [Feature][Agent] Make berkeleydb-je an optional dependency of InLong-Agent                   |

### DataProxy
| ISSUE                                                                 | Summary                                                                                      |
|:----------------------------------------------------------------------|:---------------------------------------------------------------------------------------------|
| [INLONG-3638](https://github.com/apache/incubator-inlong/issues/3638) | [Bug] Agent and DataProxy can not listen to the 8080 port for Prometheus                     |
| [INLONG-3573](https://github.com/apache/incubator-inlong/issues/3573) | [Feature][Dataproxy][Audit]Tidy up dependencies between dataproxy                            |
| [INLONG-3520](https://github.com/apache/incubator-inlong/issues/3520) | [Improve][DataProxy] Unify the data directory                                                |
| [INLONG-3459](https://github.com/apache/incubator-inlong/issues/3459) | [Bug] DataProxy start error Due to IllegalArgumentException                                  |
| [INLONG-3436](https://github.com/apache/incubator-inlong/issues/3436) | [DataProxy] Sort out the LICENSEs of the third-party components of inlong-dataproxy          |
| [INLONG-3352](https://github.com/apache/incubator-inlong/issues/3352) | [Bug][Dataproxy]  Dataproxy keeps trying to send messages that have send failed              |
| [INLONG-3291](https://github.com/apache/incubator-inlong/issues/3291) | [Bug][Dataproxy] Default channel config for order message didn't work                        |
| [INLONG-3282](https://github.com/apache/incubator-inlong/issues/3282) | [Feature][DataProxy] Add default order message configuration                                 |
| [INLONG-3250](https://github.com/apache/incubator-inlong/issues/3250) | [Bug][DataProxy] Fix duration error of DataProxy metric                                      |
| [INLONG-3231](https://github.com/apache/incubator-inlong/issues/3231) | [Feature][DataProxy] Change the default topic to an optional configuration                   |
| [INLONG-3183](https://github.com/apache/incubator-inlong/issues/3183) | [Bug][Dataproxy] When creating a producer fails                                              |
| [INLONG-3181](https://github.com/apache/incubator-inlong/issues/3181) | [Improve][DataProxy] Optimizing unit tests and code style                                    |
| [INLONG-3161](https://github.com/apache/incubator-inlong/issues/3161) | [Bug][Dataproxy] When sending order messages, no response message is returned to client      |
| [INLONG-3136](https://github.com/apache/incubator-inlong/issues/3136) | [Feature] DataProxy get NOUPDATE"" configuration from Manager when request md5 is same       |"
| [INLONG-3080](https://github.com/apache/incubator-inlong/issues/3080) | [Bug][DataProxy] Fix dataproxy UT bug add mock of MetricRegister                             |
| [INLONG-3067](https://github.com/apache/incubator-inlong/issues/3067) | [Feature][DataProxy] Upgrading the documentation of using the default Pulsar configuration   |
| [INLONG-3060](https://github.com/apache/incubator-inlong/issues/3060) | [Feature][DataProxy] Use Pulsar configuration by default                                     |
| [INLONG-3058](https://github.com/apache/incubator-inlong/issues/3058) | [Feature][DataProxy] Add some configs while creating Pulsar producer                         |
| [INLONG-3047](https://github.com/apache/incubator-inlong/issues/3047) | [Bug][DataProxy] All common.properties configs are overwritten                               |
| [INLONG-3031](https://github.com/apache/incubator-inlong/issues/3031) | [Bug][Dataproxy] Repeated registration jmx metric bean                                       |
| [INLONG-2962](https://github.com/apache/incubator-inlong/issues/2962) | [Bug][UT] Unit tests throw so many error msg for DataProxy                                   |
| [INLONG-2961](https://github.com/apache/incubator-inlong/issues/2961) | [Improve][DataProxy] Check style error in DataProxy                                          |
| [INLONG-2906](https://github.com/apache/incubator-inlong/issues/2906) | [Improve] Fix conflict defined of mq in Dataproxy and Sort                                   |
| [INLONG-2812](https://github.com/apache/incubator-inlong/issues/2812) | [Improve][DataProxy] Modify flume conf and rename MetaSink                                   |
| [INLONG-2805](https://github.com/apache/incubator-inlong/issues/2805) | [Feature][DataProxy] Add stream config log report                                            |
| [INLONG-2802](https://github.com/apache/incubator-inlong/issues/2802) | [Bug][DataProxy] Update mx.properties local file too often                                   |
| [INLONG-2783](https://github.com/apache/incubator-inlong/issues/2783) | [Bug][DataProxy] Port conflict with pulsar port                                              |
| [INLONG-2781](https://github.com/apache/incubator-inlong/issues/2781) | [Feature][DataProxy] Update netty version to 4.x                                             |
| [INLONG-2719](https://github.com/apache/incubator-inlong/issues/2719) | [Bug][DataProxy] Setting multiple topics for the same groupId doesn't work for Pulsar        |
| [INLONG-2711](https://github.com/apache/incubator-inlong/issues/2711) | [Bug][SDK] Dataproxy-SDK get manager ip list error                                           |
| [INLONG-2607](https://github.com/apache/incubator-inlong/issues/2607) | [Feature][DataProxy] Supports prometheus metric report for PulsarSink                        |
| [INLONG-2568](https://github.com/apache/incubator-inlong/issues/2568) | [Feature][Dataproxy] Support dynamically getting TubeMq config from Manager                  |
| [INLONG-2491](https://github.com/apache/incubator-inlong/issues/2491) | [Feature][Dataproxy] update netty version to 4.1.72.Final and log4j to log4j2                |
| [INLONG-2381](https://github.com/apache/incubator-inlong/issues/2381) | [Feature] DataProxy support Tube sink of PB compression cache message protocol.              |
| [INLONG-2379](https://github.com/apache/incubator-inlong/issues/2379) | [Feature] DataProxy support Pulsar sink of PB compression cache message protocol.            |
| [INLONG-2377](https://github.com/apache/incubator-inlong/issues/2377) | [Feature] DataProxy support PB compression protocol format source.                           |

### Manager
| ISSUE                                                                 | Summary                                                                                                |
|:----------------------------------------------------------------------|:-------------------------------------------------------------------------------------------------------|
| [INLONG-3716](https://github.com/apache/incubator-inlong/issues/3716) | [Improve][Manager] Decrease the size of manager plugins                                                |
| [INLONG-3712](https://github.com/apache/incubator-inlong/issues/3712) | [Bug][Manager] validation-api dependency conflict                                                      |
| [INLONG-3710](https://github.com/apache/incubator-inlong/issues/3710) | [Bug][Manager] Update the import package for ObjectMapper                                              |
| [INLONG-3704](https://github.com/apache/incubator-inlong/issues/3704) | [Improve][Manager] change the log level for status report                                              |
| [INLONG-3701](https://github.com/apache/incubator-inlong/issues/3701) | [Improve][Manager] Decrease the size of manager client tools                                           |
| [INLONG-3697](https://github.com/apache/incubator-inlong/issues/3697) | [Improve][Manager]  Replenish manager client examples                                                  |
| [INLONG-3686](https://github.com/apache/incubator-inlong/issues/3686) | [Improve][Manager] Remove the check for the serialization type of file source                          |
| [INLONG-3683](https://github.com/apache/incubator-inlong/issues/3683) | [Improve] Add AUTO_PUSH source stream in Manager                                                       |
| [INLONG-3662](https://github.com/apache/incubator-inlong/issues/3662) | [Improve][Manager] Disable ZooKeeper by default and deserialize file source from stream info           |
| [INLONG-3652](https://github.com/apache/incubator-inlong/issues/3652) | [Improve][Agent] Improve TestBinlogOffsetManager unit test                                             |
| [INLONG-3647](https://github.com/apache/incubator-inlong/issues/3647) | [Bug] Manager caught Sniffer : error while sniffing nodes java.net.ConnectException                    |
| [INLONG-3642](https://github.com/apache/incubator-inlong/issues/3642) | [Improve][Manager] Update start script and log configuration                                           |
| [INLONG-3627](https://github.com/apache/incubator-inlong/issues/3627) | [Improve][Manager] Remove deprecated source_file related classes                                       |
| [INLONG-3603](https://github.com/apache/incubator-inlong/issues/3603) | [Improve][Manager] The serialization type cannot be empty for File source                              |
| [INLONG-3601](https://github.com/apache/incubator-inlong/issues/3601) | [Bug][Manager] Should not create Hive resource when sink type is Kafka                                 |
| [INLONG-3599](https://github.com/apache/incubator-inlong/issues/3599) | [Bug][Manager] Null pointer exception occurred when list file sources                                  |
| [INLONG-3596](https://github.com/apache/incubator-inlong/issues/3596) | [Bug] manager can not start successfully                                                               |
| [INLONG-3589](https://github.com/apache/incubator-inlong/issues/3589) | [Feature][Manager] Add Iceberg sink info for Sort                                                      |
| [INLONG-3580](https://github.com/apache/incubator-inlong/issues/3580) | [Improve][Manager] Remove agentIp param in StreamSource                                                |
| [INLONG-3565](https://github.com/apache/incubator-inlong/issues/3565) | [Improve][Manager] Unified the interface for Flink plugin                                              |
| [INLONG-3550](https://github.com/apache/incubator-inlong/issues/3550) | [Improve][Manager] Add file source in Manager Client                                                   |
| [INLONG-3544](https://github.com/apache/incubator-inlong/issues/3544) | [Feature][Manager] Refactor file source request and response                                           |
| [INLONG-3542](https://github.com/apache/incubator-inlong/issues/3542) | [Feature][Manager] Add Iceberg params and change SQL files                                             |
| [INLONG-3538](https://github.com/apache/incubator-inlong/issues/3538) | [Improve][Manager] Adjust mode of getting sort URL                                                     |
| [INLONG-3537](https://github.com/apache/incubator-inlong/issues/3537) | [Improve][Manager] Remove unused APIs and change Kafka sink params                                     |
| [INLONG-3535](https://github.com/apache/incubator-inlong/issues/3535) | [Improve][Manager] Update JDBC configs and maven pom files                                             |
| [INLONG-3510](https://github.com/apache/incubator-inlong/issues/3510) | [Bug][Manager] When deployed                                                                           |
| [INLONG-3507](https://github.com/apache/incubator-inlong/issues/3507) | [Bug][Manager] Upgrade Elasticsearch jar due to cve                                                    |
| [INLONG-3480](https://github.com/apache/incubator-inlong/issues/3480) | [Bug][Manager] Fix null pointer exception when calling sink method in manager client                   |
| [INLONG-3462](https://github.com/apache/incubator-inlong/issues/3462) | [Feature][Manager] Add test module for manager client                                                  |
| [INLONG-3454](https://github.com/apache/incubator-inlong/issues/3454) | [Improve][Manager] Remove the dependency of nimbusds which was unused                                  |
| [INLONG-3451](https://github.com/apache/incubator-inlong/issues/3451) | [Bug][Manager] Got wrong results when querying tube cluster info                                       |
| [INLONG-3448](https://github.com/apache/incubator-inlong/issues/3448) | [Improve][Manager] Limit the number of Agent pull tasks                                                |
| [INLONG-3438](https://github.com/apache/incubator-inlong/issues/3438) | [Manager] Sort out the LICENSEs of the third-party components of inlong-manager                        |
| [INLONG-3428](https://github.com/apache/incubator-inlong/issues/3428) | [Improve][Manager] Set the default value and code refactor                                             |
| [INLONG-3405](https://github.com/apache/incubator-inlong/issues/3405) | [Improve][Manager] Support generic partition configuration for Hive sink                               |
| [INLONG-3398](https://github.com/apache/incubator-inlong/issues/3398) | [Bug][Manager] Fix database error when saving sink field                                               |
| [INLONG-3397](https://github.com/apache/incubator-inlong/issues/3397) | [Bug][Manager] SQL error when saving sink fields                                                       |
| [INLONG-3383](https://github.com/apache/incubator-inlong/issues/3383) | [Bug][Manager] Fix the null pointer caused by sink field not configured with source field              |
| [INLONG-3376](https://github.com/apache/incubator-inlong/issues/3376) | [Improve][Manager] Support custom field format in client                                               |
| [INLONG-3370](https://github.com/apache/incubator-inlong/issues/3370) | [Improve][Manager] Optimize stream source delete logic                                                 |
| [INLONG-3369](https://github.com/apache/incubator-inlong/issues/3369) | [Improve][Manager] Add StreamSource in list API                                                        |
| [INLONG-3367](https://github.com/apache/incubator-inlong/issues/3367) | [Improve][Manager] Support custom field format                                                         |
| [INLONG-3362](https://github.com/apache/incubator-inlong/issues/3362) | [Improve][Manager] Make Group.updateStatus new Transaction                                             |
| [INLONG-3339](https://github.com/apache/incubator-inlong/issues/3339) | [Bug][Manager] Should update status when agent result was failed                                       |
| [INLONG-3337](https://github.com/apache/incubator-inlong/issues/3337) | [Bug][Manager] Fix API error in manger client                                                          |
| [INLONG-3334](https://github.com/apache/incubator-inlong/issues/3334) | [Improve][Manager] Get source field list from stream field table for Sort                              |
| [INLONG-3323](https://github.com/apache/incubator-inlong/issues/3323) | [Improve][Manager] Add APIs in manager client                                                          |
| [INLONG-3312](https://github.com/apache/incubator-inlong/issues/3312) | [Improve][Manager] Optimize the delete operation for stream source                                     |
| [INLONG-3310](https://github.com/apache/incubator-inlong/issues/3310) | [Improve][Manager] Optimize Pessimistic Lock for select stream sources                                 |
| [INLONG-3301](https://github.com/apache/incubator-inlong/issues/3301) | [Improve][Manager] Remove deprecated classes and tables                                                |
| [INLONG-3300](https://github.com/apache/incubator-inlong/issues/3300) | [Improve][Manager] Optimize the interface of the inlong-stream page                                    |
| [INLONG-3294](https://github.com/apache/incubator-inlong/issues/3294) | [Bug][Manager] Protocol of client and manager is inconsistent                                          |
| [INLONG-3293](https://github.com/apache/incubator-inlong/issues/3293) | [Improve][Manager] Add version controller for stream source                                            |
| [INLONG-3287](https://github.com/apache/incubator-inlong/issues/3287) | [Bug][Manager] Fix heartbeat manager init in Manager Service                                           |
| [INLONG-3280](https://github.com/apache/incubator-inlong/issues/3280) | [Bug][Manager][Dashboard] Update and delete datasource failed                                          |
| [INLONG-3269](https://github.com/apache/incubator-inlong/issues/3269) | [Improve][Manager] Change the request method of list query from GET to POST                            |
| [INLONG-3264](https://github.com/apache/incubator-inlong/issues/3264) | [Improve][Manager] MySQL deadlocked when operating stream source                                       |
| [INLONG-3257](https://github.com/apache/incubator-inlong/issues/3257) | [Bug][Manager][Dashboard] Create CommonServerDB return 404                                             |
| [INLONG-3252](https://github.com/apache/incubator-inlong/issues/3252) | [Bug][Manager] Remove transaction in select method                                                     |
| [INLONG-3246](https://github.com/apache/incubator-inlong/issues/3246) | [Improve][Manager] Add config_failed status after suspend/restart/delete failed for inlong group       |
| [INLONG-3242](https://github.com/apache/incubator-inlong/issues/3242) | [Bug][Manager] ConsumptionMqExtBase cannot be cast to ConsumptionPulsarInfo                            |
| [INLONG-3239](https://github.com/apache/incubator-inlong/issues/3239) | [Bug][Manager] Listing inlong group failed in manager client                                           |
| [INLONG-3228](https://github.com/apache/incubator-inlong/issues/3228) | [Bug][Manager] Deadlock found when trying to get lock                                                  |
| [INLONG-3225](https://github.com/apache/incubator-inlong/issues/3225) | [Improve][Manager] Resolves multiple IPs when querying a DataProxy cluster                             |
| [INLONG-3222](https://github.com/apache/incubator-inlong/issues/3222) | [Improve][Manager] Check source state while operate stop / restart / delete                            |
| [INLONG-3210](https://github.com/apache/incubator-inlong/issues/3210) | [Feature] [Manager] Support group batch query in manager client                                        |
| [INLONG-3209](https://github.com/apache/incubator-inlong/issues/3209) | [Improve][Manager] Optimize timeout handling in manager client                                         |
| [INLONG-3208](https://github.com/apache/incubator-inlong/issues/3208) | [Improve][Manager] Support batch query by inlong group name and inlong group id                        |
| [INLONG-3192](https://github.com/apache/incubator-inlong/issues/3192) | [Improve][Manager] Optimize group state collect in Manager Client                                      |
| [INLONG-3190](https://github.com/apache/incubator-inlong/issues/3190) | [Bug][Manager] Sql error in select source list                                                         |
| [INLONG-3188](https://github.com/apache/incubator-inlong/issues/3188) | [Bug][Manager] Inlong group status was not right after approve                                         |
| [INLONG-3179](https://github.com/apache/incubator-inlong/issues/3179) | [Improve][Manager] Check the source name can not be the same when saving stream source                 |
| [INLONG-3178](https://github.com/apache/incubator-inlong/issues/3178) | [Improve][Manager] Add check param for manager-client                                                  |
| [INLONG-3176](https://github.com/apache/incubator-inlong/issues/3176) | [Bug][Manager] Fix duplicate key  exception in manager client                                          |
| [INLONG-3175](https://github.com/apache/incubator-inlong/issues/3175) | [Feature][Manager] SortService check md5                                                               |
| [INLONG-3166](https://github.com/apache/incubator-inlong/issues/3166) | [Improve][Manager] Replace hdfsDefaultFs and warehouseDir of Hive sink with dataPath field             |
| [INLONG-3160](https://github.com/apache/incubator-inlong/issues/3160) | [Bug][Manager] Deleting stream source failed as the status was not allowed to delete                   |
| [INLONG-3156](https://github.com/apache/incubator-inlong/issues/3156) | [Feature][Manager] Add Shiro interfaces for manager authorization                                      |
| [INLONG-3152](https://github.com/apache/incubator-inlong/issues/3152) | [Improve][Manager] Stop and update operation in initializing state                                     |
| [INLONG-3149](https://github.com/apache/incubator-inlong/issues/3149) | [Improve][Manager] Add async method for inlong group stop/restart/delete                               |
| [INLONG-3146](https://github.com/apache/incubator-inlong/issues/3146) | [Improve][Manager] Optimize FieldType enums                                                            |
| [INLONG-3140](https://github.com/apache/incubator-inlong/issues/3140) | [Bug][Manager] Fix NPE in Manager Client                                                               |
| [INLONG-3134](https://github.com/apache/incubator-inlong/issues/3134) | [Bug][Manager] Save stream sink field error                                                            |
| [INLONG-3112](https://github.com/apache/incubator-inlong/issues/3112) | [Feature][Manager] Support metadata in manager and manager client                                      |
| [INLONG-3101](https://github.com/apache/incubator-inlong/issues/3101) | [Improve][Manager] Support user defined properties in StreamSource                                     |
| [INLONG-3095](https://github.com/apache/incubator-inlong/issues/3095) | [Improve][Manager] Update inlong group info in the complete listeners                                  |
| [INLONG-3090](https://github.com/apache/incubator-inlong/issues/3090) | [Improve][Manager] Add TDMQ_PULSAR type in manager                                                     |
| [INLONG-3089](https://github.com/apache/incubator-inlong/issues/3089) | [Bug][Manager] Create group resource faild after approving one inlong group                            |
| [INLONG-3073](https://github.com/apache/incubator-inlong/issues/3073) | [Improve][Manager] Get MQ cluster by the type and mq_set_name                                          |
| [INLONG-3068](https://github.com/apache/incubator-inlong/issues/3068) | [Improve][Manager] Add autoOffsetReset param for Kafka source                                          |
| [INLONG-3065](https://github.com/apache/incubator-inlong/issues/3065) | [Improve][Manager] Support download plugins from remote address                                        |
| [INLONG-3064](https://github.com/apache/incubator-inlong/issues/3064) | [Improve][Manager] Unify field types of sink and source in manager client                              |
| [INLONG-3062](https://github.com/apache/incubator-inlong/issues/3062) | [Improve][Manager] Merge the data_proxy_cluster table and the third_party_cluster table                |
| [INLONG-3053](https://github.com/apache/incubator-inlong/issues/3053) | [Bug][Manager] Push sort config failed as the mqExtInfo is null in workflow form                       |
| [INLONG-3046](https://github.com/apache/incubator-inlong/issues/3046) | [Bug][Manager] The status was incorrect after approving an inlong group                                |
| [INLONG-3042](https://github.com/apache/incubator-inlong/issues/3042) | [Improve][Manager] Supplements of  binlog allMigration stream                                          |
| [INLONG-3039](https://github.com/apache/incubator-inlong/issues/3039) | [Improve][Manager] Add properties in sinkRequest                                                       |
| [INLONG-3037](https://github.com/apache/incubator-inlong/issues/3037) | [Improve][Manager] Add field mapping support for source and sink in manage client                      |
| [INLONG-3024](https://github.com/apache/incubator-inlong/issues/3024) | [Bug][Manager] Save cluster failed as the token field is too long                                      |
| [INLONG-3017](https://github.com/apache/incubator-inlong/issues/3017) | [Bug][Manager] The interface of OpenAPI does not need authentication                                   |
| [INLONG-3012](https://github.com/apache/incubator-inlong/issues/3012) | [Improve][Manager] Support built-in field for source and sink info                                     |
| [INLONG-3000](https://github.com/apache/incubator-inlong/issues/3000) | [Improve][Manager] Add token field for cluster info                                                    |
| [INLONG-2993](https://github.com/apache/incubator-inlong/issues/2993) | [Bug][Manager] Check whether the mq info is NULL to avoid NPE                                          |
| [INLONG-2992](https://github.com/apache/incubator-inlong/issues/2992) | [Feature][Manager] Support the field mapping feature for Sort                                          |
| [INLONG-2985](https://github.com/apache/incubator-inlong/issues/2985) | [Bug][Manager] Fix task type and UTF question for agent                                                |
| [INLONG-2974](https://github.com/apache/incubator-inlong/issues/2974) | [Improve][Manager] Support agent to pull tasks without ip and uuid                                     |
| [INLONG-2973](https://github.com/apache/incubator-inlong/issues/2973) | [Bug][Manager] Fix get pulsar info from third party cluster table                                      |
| [INLONG-2971](https://github.com/apache/incubator-inlong/issues/2971) | [Improve][Manager] Support stream log collecting in manager client                                     |
| [INLONG-2969](https://github.com/apache/incubator-inlong/issues/2969) | [Bug][Manager] Fix interface of open API cluster                                                       |
| [INLONG-2957](https://github.com/apache/incubator-inlong/issues/2957) | [Improve][Manager] Optimize the cluster management interface                                           |
| [INLONG-2944](https://github.com/apache/incubator-inlong/issues/2944) | [Improve][Manager] Should not change the modify_time when updating the source snapshot                 |
| [INLONG-2939](https://github.com/apache/incubator-inlong/issues/2939) | [Improve][Manager] Support sync message transfer in manager client                                     |
| [INLONG-2934](https://github.com/apache/incubator-inlong/issues/2934) | [Bug][Manager] Manager client occured NPE since not check NULL                                         |
| [INLONG-2933](https://github.com/apache/incubator-inlong/issues/2933) | [Bug][Agent][Manager] Change the type of the deliveryTime field from Date to String                    |
| [INLONG-2930](https://github.com/apache/incubator-inlong/issues/2930) | [Feature][Manager] Add ClickHouse sink support in manager-client                                       |
| [INLONG-2913](https://github.com/apache/incubator-inlong/issues/2913) | [Bug][Manager] Fix get data proxy cluster failed and update inlong group failed                        |
| [INLONG-2912](https://github.com/apache/incubator-inlong/issues/2912) | [Improve][Manager] Add fields for the binlog task                                                      |
| [INLONG-2900](https://github.com/apache/incubator-inlong/issues/2900) | [Bug][Manager] Pulsar topics for DataProxy are inconsistent with topics for Sort                       |
| [INLONG-2898](https://github.com/apache/incubator-inlong/issues/2898) | [Bug][Manager] Fix parse Json exception in manager client                                              |
| [INLONG-2892](https://github.com/apache/incubator-inlong/issues/2892) | [Improve][Manager] Update status of StreamSource after approving the InlongGroup or InlongStream       |
| [INLONG-2890](https://github.com/apache/incubator-inlong/issues/2890) | [Feature][Manager] Support query source list in stream/listAll API                                     |
| [INLONG-2888](https://github.com/apache/incubator-inlong/issues/2888) | [Bug][Manager] Stream source was not deleted when calling delete operate                               |
| [INLONG-2886](https://github.com/apache/incubator-inlong/issues/2886) | [Improve][Manager] Check if the URL is valid to avoid network security attacks                         |
| [INLONG-2873](https://github.com/apache/incubator-inlong/issues/2873) | [Bug][Manager] Fix serialization problem                                                               |
| [INLONG-2869](https://github.com/apache/incubator-inlong/issues/2869) | [Feature][Manager] Support config sync send data for agent and sort                                    |
| [INLONG-2867](https://github.com/apache/incubator-inlong/issues/2867) | [Feature][Manager] Support report the task result and get tasks for the agent                          |
| [INLONG-2862](https://github.com/apache/incubator-inlong/issues/2862) | [Feature][Manager] Startup sort task through the ordinary flink cluster                                |
| [INLONG-2856](https://github.com/apache/incubator-inlong/issues/2856) | [Improve][Manager] Support multi-source and multi-sink in one stream                                   |
| [INLONG-2855](https://github.com/apache/incubator-inlong/issues/2855) | [Feature][Manager] Support use other plugin of Authorization                                           |
| [INLONG-2849](https://github.com/apache/incubator-inlong/issues/2849) | [Bug][Manager] Manager client occurred NPE                                                             |
| [INLONG-2845](https://github.com/apache/incubator-inlong/issues/2845) | [Bug][Manager] Manager client occurred NPE when parsing the ext info                                   |
| [INLONG-2841](https://github.com/apache/incubator-inlong/issues/2841) | [Bug][Manager] New Inlong group cannot invoke the related listeners                                    |
| [INLONG-2839](https://github.com/apache/incubator-inlong/issues/2839) | [Improve][Manager] Add intermediate state for Inlong group                                             |
| [INLONG-2837](https://github.com/apache/incubator-inlong/issues/2837) | [Bug][Manager] Loss update Kafka operation when using manager client to update config                  |
| [INLONG-2830](https://github.com/apache/incubator-inlong/issues/2830) | [Improve][Manager] Support more than one source for a pair of group and streams                        |
| [INLONG-2829](https://github.com/apache/incubator-inlong/issues/2829) | [Feature][Manager] Support for migrating all databases in a database server for the inlong-sort module |
| [INLONG-2827](https://github.com/apache/incubator-inlong/issues/2827) | [Feature][Manager] Support configurable plugin when creating Hive table                                |
| [INLONG-2821](https://github.com/apache/incubator-inlong/issues/2821) | [Improve][Manager] Change the status of the source after receiving the task snapshot                   |
| [INLONG-2815](https://github.com/apache/incubator-inlong/issues/2815) | [Improve][Manager] Optimize Inlong domains for manager-client                                          |
| [INLONG-2808](https://github.com/apache/incubator-inlong/issues/2808) | [Feature][Manager] Support kafka sink in manager client                                                |
| [INLONG-2807](https://github.com/apache/incubator-inlong/issues/2807) | [Improve][Manager] Optimize state defined in manager client                                            |
| [INLONG-2794](https://github.com/apache/incubator-inlong/issues/2794) | [Bug] Manager website should not display port when adding agent job                                    |
| [INLONG-2791](https://github.com/apache/incubator-inlong/issues/2791) | [Improve][Manager] Optimize manager client APIs                                                        |
| [INLONG-2768](https://github.com/apache/incubator-inlong/issues/2768) | [Bug][Manager] The middleware_type not same after creating group                                       |
| [INLONG-2764](https://github.com/apache/incubator-inlong/issues/2764) | [Bug][Manager] Key was duplicate when InlongGroup extList already has the same key                     |
| [INLONG-2760](https://github.com/apache/incubator-inlong/issues/2760) | [Bug][Manager] Delete data grouping exception                                                          |
| [INLONG-2759](https://github.com/apache/incubator-inlong/issues/2759) | [Bug][Manager] InlongGroupController update interface status problem                                   |
| [INLONG-2751](https://github.com/apache/incubator-inlong/issues/2751) | [Bug][Manager] Fix the response code while query failing                                               |
| [INLONG-2743](https://github.com/apache/incubator-inlong/issues/2743) | [Improve][Manager] Support getting inlong workflow error for manager-client module                     |
| [INLONG-2741](https://github.com/apache/incubator-inlong/issues/2741) | [Feature][Manager] Inlong client adds an interface for querying inlong group                           |
| [INLONG-2736](https://github.com/apache/incubator-inlong/issues/2736) | [Bug][Manager] Agent get task from manager error                                                       |
| [INLONG-2734](https://github.com/apache/incubator-inlong/issues/2734) | [Improve][Manager] Support multi serialization type for Sort in Manager                                |
| [INLONG-2732](https://github.com/apache/incubator-inlong/issues/2732) | [Feature][Manager] Support more parameters for Kafka source                                            |
| [INLONG-2723](https://github.com/apache/incubator-inlong/issues/2723) | [Bug][Manager] Manager module occurred exception when startup                                          |
| [INLONG-2720](https://github.com/apache/incubator-inlong/issues/2720) | [Bug][Manager] data_source_cmd_config table not exit                                                   |
| [INLONG-2717](https://github.com/apache/incubator-inlong/issues/2717) | [Improve][Manager] Support middleware of NONE                                                          |
| [INLONG-2715](https://github.com/apache/incubator-inlong/issues/2715) | [Feature][Manager] Support more parameters for the StreamSource entity                                 |
| [INLONG-2714](https://github.com/apache/incubator-inlong/issues/2714) | [Bug][Manager] Create stream_source table failed                                                       |
| [INLONG-2711](https://github.com/apache/incubator-inlong/issues/2711) | [Bug][SDK] Dataproxy-SDK get manager ip list error                                                     |
| [INLONG-2707](https://github.com/apache/incubator-inlong/issues/2707) | [Bug][Manager] Table name and field type was inconsistent in SQL and XML file                          |
| [INLONG-2701](https://github.com/apache/incubator-inlong/issues/2701) | [Bug][Manager] Occurred NPE as the data proxy cluster name is null                                     |
| [INLONG-2700](https://github.com/apache/incubator-inlong/issues/2700) | [Bug][Manager] Inlong group status was incorrect                                                       |
| [INLONG-2699](https://github.com/apache/incubator-inlong/issues/2699) | [Bug][Manager] Field ext_params in table data_proxy_cluster not exits                                  |
| [INLONG-2697](https://github.com/apache/incubator-inlong/issues/2697) | [Bug][Manager] Inlong manager occurred NullpointException                                              |
| [INLONG-2694](https://github.com/apache/incubator-inlong/issues/2694) | [Feature][Manager] Implement services of getSortSource interface                                       |
| [INLONG-2693](https://github.com/apache/incubator-inlong/issues/2693) | [Feature][Manager] Define tables and beans for getSortSource interface                                 |
| [INLONG-2690](https://github.com/apache/incubator-inlong/issues/2690) | [Improve][Manager] Optimize group state in workflow                                                    |
| [INLONG-2689](https://github.com/apache/incubator-inlong/issues/2689) | [Feature][Manager] Support report heartbeat for source agent                                           |
| [INLONG-2682](https://github.com/apache/incubator-inlong/issues/2682) | [Feature][Manager] Add metric and config log report interface                                          |
| [INLONG-2678](https://github.com/apache/incubator-inlong/issues/2678) | [Improve][Manager] Update field type in manager sql script                                             |
| [INLONG-2677](https://github.com/apache/incubator-inlong/issues/2677) | [Feature][Manager] Get MQ cluster Info from database                                                   |
| [INLONG-2676](https://github.com/apache/incubator-inlong/issues/2676) | [Improve][Manager] Support stop / restart / finish stream source task                                  |
| [INLONG-2669](https://github.com/apache/incubator-inlong/issues/2669) | [Improve][Manager] Optimizing source module code structure                                             |
| [INLONG-2662](https://github.com/apache/incubator-inlong/issues/2662) | [Bug][Manager] Fix duplicate listener in manager service                                               |
| [INLONG-2660](https://github.com/apache/incubator-inlong/issues/2660) | [Improve][Manager] Optimize manager state machine                                                      |
| [INLONG-2655](https://github.com/apache/incubator-inlong/issues/2655) | [Bug][Manager] Fix non-null limit in sql file                                                          |
| [INLONG-2653](https://github.com/apache/incubator-inlong/issues/2653) | [Feature][Manager] Support Kafka source in Inong Stream                                                |
| [INLONG-2638](https://github.com/apache/incubator-inlong/issues/2638) | [Bug][Manager] apache_inlong_manager.sql file execution exception                                      |
| [INLONG-2636](https://github.com/apache/incubator-inlong/issues/2636) | [Improve][Manager] Enable sort config generate when zookeeper is disabled;                             |
| [INLONG-2617](https://github.com/apache/incubator-inlong/issues/2617) | [Bug][Manager] After approving the new group                                                           |
| [INLONG-2616](https://github.com/apache/incubator-inlong/issues/2616) | [Improve][Manager] Optimize manager client and some APIs                                               |
| [INLONG-2614](https://github.com/apache/incubator-inlong/issues/2614) | [Feature][Sort] Support array and map data structures in Hive sink and ClickHouse sink                 |
| [INLONG-2612](https://github.com/apache/incubator-inlong/issues/2612) | [Improve][Manager] Unify the domain model of the Manager module                                        |
| [INLONG-2610](https://github.com/apache/incubator-inlong/issues/2610) | [Feature][Manager] Plug-in support for StreamSource                                                    |
| [INLONG-2605](https://github.com/apache/incubator-inlong/issues/2605) | [Improve][Manager] Refactor the manager-workflow module                                                |
| [INLONG-2600](https://github.com/apache/incubator-inlong/issues/2600) | [Improve][Manager] Rename the third party cluster class name and table name                            |
| [INLONG-2588](https://github.com/apache/incubator-inlong/issues/2588) | [Feature][Manager] Support cluster management                                                          |
| [INLONG-2586](https://github.com/apache/incubator-inlong/issues/2586) | [Feature][Manager] Support agent to get task from manager                                              |
| [INLONG-2579](https://github.com/apache/incubator-inlong/issues/2579) | [Feature][Manager] Support stream sink to ClickHouse                                                   |
| [INLONG-2574](https://github.com/apache/incubator-inlong/issues/2574) | [Feature][Manager] Add getSortSource interface for Sort                                                |
| [INLONG-2573](https://github.com/apache/incubator-inlong/issues/2573) | [Feature][Manager] Inlong manager support getSortSource interface                                      |
| [INLONG-2571](https://github.com/apache/incubator-inlong/issues/2571) | [Bug][Manager] Fix unit tests bugs                                                                     |
| [INLONG-2558](https://github.com/apache/incubator-inlong/issues/2558) | [Improve][Manager] Optimizing manager test pattern                                                     |
| [INLONG-2529](https://github.com/apache/incubator-inlong/issues/2529) | [Bug][manager] get NumberFormatException when creating a new stream                                    |
| [INLONG-2512](https://github.com/apache/incubator-inlong/issues/2512) | [Improve] [Manager] Add manager client                                                                 |
| [INLONG-2507](https://github.com/apache/incubator-inlong/issues/2507) | [Bug][Manager] Init sort config failed                                                                 |
| [INLONG-2492](https://github.com/apache/incubator-inlong/issues/2492) | [Feature][Manager] Plug-in support for DataStorage                                                     |
| [INLONG-2491](https://github.com/apache/incubator-inlong/issues/2491) | [Feature][Dataproxy] update netty version to 4.1.72.Final and log4j to log4j2                          |
| [INLONG-2490](https://github.com/apache/incubator-inlong/issues/2490) | [Feature][Manager] Support to startup a single tenant sort job                                         |
| [INLONG-2483](https://github.com/apache/incubator-inlong/issues/2483) | [Feature] Manager provide metadata interface to Dataproxy                                              |
| [INLONG-2414](https://github.com/apache/incubator-inlong/issues/2414) | [Manager] Exclude test jar file during the apache-rat-plugin check                                     |
| [INLONG-2410](https://github.com/apache/incubator-inlong/issues/2410) | [Improve] Inlong Manager support business workflow suspend                                             | 
| [INLONG-2353](https://github.com/apache/incubator-inlong/issues/2353) | [Feature] Tube manager cluster adds support for multi-master configuration                             |
| [INLONG-2286](https://github.com/apache/incubator-inlong/issues/2286) | [Feature][Manager] Put inlong group id in dataflow info for Sort                                       |
| [INLONG-2162](https://github.com/apache/incubator-inlong/issues/2162) | [Feature][Manager] Manager support getSortSourceConfig interface                                       |
| [INLONG-1517](https://github.com/apache/incubator-inlong/issues/1517) | [Feature][Manager] Support sink data to ClickHouse                                                     |

### Audit
| ISSUE                                                                 | Summary                                                                         |
|:----------------------------------------------------------------------|:--------------------------------------------------------------------------------|
| [INLONG-3606](https://github.com/apache/incubator-inlong/issues/3606) | [Bug] lack of the guide for Sort to configure Audit and Flink Plugin            |
| [INLONG-3573](https://github.com/apache/incubator-inlong/issues/3573) | [Feature][Dataproxy][Audit]Tidy up dependencies between dataproxy               |
| [INLONG-3543](https://github.com/apache/incubator-inlong/issues/3543) | [Feature][Audit]Upgrade audit netty version to 4.1.72.Final and log4j to log4j2 |
| [INLONG-3528](https://github.com/apache/incubator-inlong/issues/3528) | [Improve] unify the log directory for manager and audit                         |
| [INLONG-3440](https://github.com/apache/incubator-inlong/issues/3440) | [Audit] Sort out the LICENSEs of the third-party components of inlong-audit     |
| [INLONG-3417](https://github.com/apache/incubator-inlong/issues/3417) | [Improve] add audit configuration for other component docker image              |
| [INLONG-3288](https://github.com/apache/incubator-inlong/issues/3288) | [Improve][Audit] Support TubMQ for website                                      |
| [INLONG-3159](https://github.com/apache/incubator-inlong/issues/3159) | [Feature][Audit] Store support TubeMQ                                           |
| [INLONG-3158](https://github.com/apache/incubator-inlong/issues/3158) | [Feature][Audit] Proxy support TubeMQ                                           |
| [INLONG-3013](https://github.com/apache/incubator-inlong/issues/3013) | [Bug][Audit] Error occurred in started container on tencent eks                 |
| [INLONG-2960](https://github.com/apache/incubator-inlong/issues/2960) | [Bug][Audit] Unit tests error when executing mvn test command                   |
| [INLONG-2640](https://github.com/apache/incubator-inlong/issues/2640) | [Bug][K8s] The Audit Configmap can not be handled as a ConfigMap                |
| [INLONG-2623](https://github.com/apache/incubator-inlong/issues/2623) | [Improve][Audit] Add audit image for docker publish script                      |
| [INLONG-2591](https://github.com/apache/incubator-inlong/issues/2591) | [Bug][Audit] Audit proxy and store process with wrong options                   |
| [INLONG-2549](https://github.com/apache/incubator-inlong/issues/2549) | [Improve] [audit] update audit protobuf field type                              |
| [INLONG-2548](https://github.com/apache/incubator-inlong/issues/2548) | [Bug] update version of lombok from 1.18.20  to 1.18.22                         |
| [INLONG-2540](https://github.com/apache/incubator-inlong/issues/2540) | [agent] create db sql collect task by config from manager                       |
| [INLONG-2538](https://github.com/apache/incubator-inlong/issues/2538) | [TubeMQ] Optimize message write cache logic                                     |
| [INLONG-2535](https://github.com/apache/incubator-inlong/issues/2535) | [Improve][dashboard] Audit module display time in reverse order                 |
| [INLONG-2523](https://github.com/apache/incubator-inlong/issues/2523) | [Improve][Audit] Modify package name according to specification                 |
| [INLONG-2468](https://github.com/apache/incubator-inlong/issues/2468) | [Bug][Audit] CommunicationsException occurred in unit tests                     |
| [INLONG-2441](https://github.com/apache/incubator-inlong/issues/2441) | [Improve] [InLong audit] Modify the version of audit protobuf                   |
| [INLONG-2408](https://github.com/apache/incubator-inlong/issues/2408) | [Audit] protobuf-java dependency has security vulnerability                     |

### Sort
| ISSUE                                                                 | Summary                                                                                                          |
|:----------------------------------------------------------------------|:-----------------------------------------------------------------------------------------------------------------|
| [INLONG-3682](https://github.com/apache/incubator-inlong/issues/3682) | [Improve] Optimize classification for the sort and usage manual guide                                            |
| [INLONG-3672](https://github.com/apache/incubator-inlong/issues/3672) | [Feature][Sort-standalone] Tidy up dependencies.                                                                 |
| [INLONG-3670](https://github.com/apache/incubator-inlong/issues/3670) | [Improve][Dashboard] Add dashboard plugin docs to official website                                               |
| [INLONG-3668](https://github.com/apache/incubator-inlong/issues/3668) | [Sort-standalone] exclude spotbugs-annotations package                                                           |
| [INLONG-3606](https://github.com/apache/incubator-inlong/issues/3606) | [Bug] lack of the guide for Sort to configure Audit and Flink Plugin                                             |
| [INLONG-3591](https://github.com/apache/incubator-inlong/issues/3591) | [Feature] Support multiple SortTask with the one-on-one relationship of Source and SortTask.                     |
| [INLONG-3589](https://github.com/apache/incubator-inlong/issues/3589) | [Feature][Manager] Add Iceberg sink info for Sort                                                                |
| [INLONG-3546](https://github.com/apache/incubator-inlong/issues/3546) | [Feature] Support reporting metrics by audit-sdk in sort-single-tenant                                           |
| [INLONG-3538](https://github.com/apache/incubator-inlong/issues/3538) | [Improve][Manager] Adjust mode of getting sort URL                                                               |
| [INLONG-3523](https://github.com/apache/incubator-inlong/issues/3523) | [Sort-Flink] Remove lzo-core dependency                                                                          |
| [INLONG-3501](https://github.com/apache/incubator-inlong/issues/3501) | [Sort-standalone] Sort out the LICENSEs of the third-party components of inlong-standalone                       |
| [INLONG-3486](https://github.com/apache/incubator-inlong/issues/3486) | [Bug][Sort] Data with Timestamp/Date type are written wrongly when using parquet format                          |
| [INLONG-3483](https://github.com/apache/incubator-inlong/issues/3483) | [Bug][Sort] Wrong date data in ORC formatted output                                                              |
| [INLONG-3457](https://github.com/apache/incubator-inlong/issues/3457) | [Improve][Sort] Exclude partition fields when writing data with parquet/orc format to hive                       |
| [INLONG-3450](https://github.com/apache/incubator-inlong/issues/3450) | [Feature][SDK] Sort-SDK change ack log from info to debug                                                        |
| [INLONG-3426](https://github.com/apache/incubator-inlong/issues/3426) | [Improve][Sort] Unify the value of binlog event type                                                             |
| [INLONG-3418](https://github.com/apache/incubator-inlong/issues/3418) | [Feature][Sort-Standalone] Upgrade protobuf version to 3.19.4                                                    |
| [INLONG-3414](https://github.com/apache/incubator-inlong/issues/3414) | [Improve][Sort] Set the default value of field includeUpdateBefore for DebeziumDeserializationInfo               |
| [INLONG-3408](https://github.com/apache/incubator-inlong/issues/3408) | [Bug][Sort-Standalone] Replace IP and authentication in configuration example                                    |
| [INLONG-3396](https://github.com/apache/incubator-inlong/issues/3396) | [Feature][Sort] Support multiple dataflow to write the same hive table                                           |
| [INLONG-3378](https://github.com/apache/incubator-inlong/issues/3378) | [Feature] Add configuration example of Sort-standalone(Hive+ElasticSearch)                                       |
| [INLONG-3372](https://github.com/apache/incubator-inlong/issues/3372) | [Bug][Sort] The binlog type is always `INSERT` when the output format is Canal                                   |
| [INLONG-3340](https://github.com/apache/incubator-inlong/issues/3340) | [Bug][Sort-Standalone] ClsSink cannot acquire correct IdConfig and type overflow                                 |
| [INLONG-3332](https://github.com/apache/incubator-inlong/issues/3332) | [Bug][Sort-Standalone] NP when init ClsSink and data race problem when first get ClsIdConfig field list          |
| [INLONG-3329](https://github.com/apache/incubator-inlong/issues/3329) | [Bug][Sort] Wrong class mapping of debezium serialization info                                                   |
| [INLONG-3328](https://github.com/apache/incubator-inlong/issues/3328) | [Feature][Sort-Standalone] Support to load sort-sdk configuration from file                                      |
| [INLONG-3321](https://github.com/apache/incubator-inlong/issues/3321) | [Improve][Sort] Set the correspond field in output to null if the field value in input is null                   |
| [INLONG-3316](https://github.com/apache/incubator-inlong/issues/3316) | [Bug][Sort] Change target sort jar in inlong-distribution module                                                 |
| [INLONG-3285](https://github.com/apache/incubator-inlong/issues/3285) | [Bug][Sort] Elasticsearch jar has security issue                                                                 |
| [INLONG-3260](https://github.com/apache/incubator-inlong/issues/3260) | [Improve][Sort] Change the default semantic to at-least-once when using kafka producer                           |
| [INLONG-3256](https://github.com/apache/incubator-inlong/issues/3256) | [Improve][SDK] Improve sort-sdk log info                                                                         |
| [INLONG-3243](https://github.com/apache/incubator-inlong/issues/3243) | [Feature][Sort-Standalone] Support multiple scenes to request configs                                            |
| [INLONG-3237](https://github.com/apache/incubator-inlong/issues/3237) | [Feature][Sort-Standalone] SdkSource support periodiclly update sdk config and remove expire client.             |
| [INLONG-3218](https://github.com/apache/incubator-inlong/issues/3218) | [Bug][SDK] Sort-SDK may creating multiple duplicate consumers                                                    |
| [INLONG-3206](https://github.com/apache/incubator-inlong/issues/3206) | [Improve][Sort] Do not specify uid for kafka sink in case of transactionalId conflict                            |
| [INLONG-3202](https://github.com/apache/incubator-inlong/issues/3202) | [Feature][SDK] Unify SortSourceConfig of Sort-Sdk and Manager                                                    |
| [INLONG-3173](https://github.com/apache/incubator-inlong/issues/3173) | [Bug][Sort-Standalone] Unify SortClusterConfig in manager and sort-standalone                                    |
| [INLONG-3130](https://github.com/apache/incubator-inlong/issues/3130) | [Feature][Sort] Support extract specified metadata from input data with canal format                             |
| [INLONG-3122](https://github.com/apache/incubator-inlong/issues/3122) | [Bug][Sort-Standalone] Missing TASK_NAME parameter when report to Audit                                          |
| [INLONG-3117](https://github.com/apache/incubator-inlong/issues/3117) | [Bug][Sort-Standalone] Parameter error when invoking SortSdk ack method                                          |
| [INLONG-3116](https://github.com/apache/incubator-inlong/issues/3116) | [Bug][Sort-Standalone] SortSdkSource does not specify the manager url                                            |
| [INLONG-3115](https://github.com/apache/incubator-inlong/issues/3115) | [Bug][Sort-Standalone] optimize the sort-standalone                                                              |
| [INLONG-3113](https://github.com/apache/incubator-inlong/issues/3113) | [Bug][Sort] Date and Time related bugs                                                                           |
| [INLONG-3110](https://github.com/apache/incubator-inlong/issues/3110) | [Improve][Sort] Shade flink-avro to avoid potential conflicts                                                    |
| [INLONG-3108](https://github.com/apache/incubator-inlong/issues/3108) | [TubeMQ] Optimize the implementation of KeepAlive Interface                                                      |
| [INLONG-3086](https://github.com/apache/incubator-inlong/issues/3086) | [Improve][Sort] Check style error in Sort                                                                        |
| [INLONG-3078](https://github.com/apache/incubator-inlong/issues/3078) | [Bug][Sort] TubeClientException occurred in unit tests                                                           |
| [INLONG-3055](https://github.com/apache/incubator-inlong/issues/3055) | [Bug][Sort] Fix bugs of deserializing TransformationInfo json string                                             |
| [INLONG-3054](https://github.com/apache/incubator-inlong/issues/3054) | [Bug][Sort] Start sort task failed as parsing the config error                                                   |
| [INLONG-3053](https://github.com/apache/incubator-inlong/issues/3053) | [Bug][Manager] Push sort config failed as the mqExtInfo is null in workflow form                                 |
| [INLONG-3011](https://github.com/apache/incubator-inlong/issues/3011) | [Feature][Sort] Add deploy command of sort-standalone                                                            |
| [INLONG-2910](https://github.com/apache/incubator-inlong/issues/2910) | [Bug][Sort] Deserialization failure of BuiltInField                                                              |
| [INLONG-2872](https://github.com/apache/incubator-inlong/issues/2872) | [Feature][Sort] Support field mapping when transforming                                                          |
| [INLONG-2847](https://github.com/apache/incubator-inlong/issues/2847) | [Feature][Sort] Support whole-database migration from debezium format to canal format                            |
| [INLONG-2820](https://github.com/apache/incubator-inlong/issues/2820) | [Improve][Sort] Improve the deserialization processing of the update event in DebeziumDeserializationSchema      |
| [INLONG-2816](https://github.com/apache/incubator-inlong/issues/2816) | [Bug][Sort-sdk] java.lang.OutOfMemoryError: Java heap space                                                      |
| [INLONG-2793](https://github.com/apache/incubator-inlong/issues/2793) | [Bug][Sort] Bugs related to hive sink                                                                            |
| [INLONG-2785](https://github.com/apache/incubator-inlong/issues/2785) | [Feature][Sort] Support extract metadata from data with debezium format and write them to data with canal format |
| [INLONG-2774](https://github.com/apache/incubator-inlong/issues/2774) | [Bug][Sort] Fix bugs in sort-single-tenant                                                                       |
| [INLONG-2730](https://github.com/apache/incubator-inlong/issues/2730) | [Feature][Sort] Stand-alone CLS sink reduce the number of AsyncProducerClient                                    |
| [INLONG-2728](https://github.com/apache/incubator-inlong/issues/2728) | [TubeMQ] Optimize the content of statistical metrics                                                             |
| [INLONG-2723](https://github.com/apache/incubator-inlong/issues/2723) | [Bug][Manager] Manager module occurred exception when startup                                                    |
| [INLONG-2721](https://github.com/apache/incubator-inlong/issues/2721) | [Bug][Sort] Fix bugs in HiveSinkInfo                                                                             |
| [INLONG-2684](https://github.com/apache/incubator-inlong/issues/2684) | [Bug][SDK] Sort SDK occurred OOM in unit tests                                                                   |
| [INLONG-2667](https://github.com/apache/incubator-inlong/issues/2667) | [Bug][Sort] Bugs occurred when starting up sort-single-tenant                                                    |
| [INLONG-2659](https://github.com/apache/incubator-inlong/issues/2659) | [Bug][Sort] Could not build the program from JAR file.                                                           |
| [INLONG-2651](https://github.com/apache/incubator-inlong/issues/2651) | [Feature][Sort] Add CLS sink                                                                                     |
| [INLONG-2650](https://github.com/apache/incubator-inlong/issues/2650) | [Feature][Sort] Define sort stand-alone CLS context and config bean                                              |
| [INLONG-2649](https://github.com/apache/incubator-inlong/issues/2649) | [Feature][Sort] Implement default IEvent2LogItemHandler interface                                                |
| [INLONG-2642](https://github.com/apache/incubator-inlong/issues/2642) | [Feature][Sort] Use proxy user to write hive                                                                     |
| [INLONG-2634](https://github.com/apache/incubator-inlong/issues/2634) | [Feature][Sort] Support CHDFS filesystem when using Hive sink                                                    |
| [INLONG-2625](https://github.com/apache/incubator-inlong/issues/2625) | [Feature][Sort] Support extracting data time in deserialization                                                  |
| [INLONG-2614](https://github.com/apache/incubator-inlong/issues/2614) | [Feature][Sort] Support array and map data structures in Hive sink and ClickHouse sink                           |
| [INLONG-2572](https://github.com/apache/incubator-inlong/issues/2572) | [Bug][SDK] Sort sdk cause with name javax/management/MBeanServer in unit tests                                   |
| [INLONG-2561](https://github.com/apache/incubator-inlong/issues/2561) | [Feature][Sort] Update deploy settings of InLong-Sort                                                            |
| [INLONG-2554](https://github.com/apache/incubator-inlong/issues/2554) | [Feature][Sort] Support array and map data structures in ORC writer                                              |
| [INLONG-2526](https://github.com/apache/incubator-inlong/issues/2526) | [Feature][Sort] Support serialization and deserialization of debezium-json formatted data                        |
| [INLONG-2524](https://github.com/apache/incubator-inlong/issues/2524) | [Feature][InLong-Sort] Support deserialization of json                                                           |
| [INLONG-2507](https://github.com/apache/incubator-inlong/issues/2507) | [Bug][Manager] Init sort config failed                                                                           |
| [INLONG-2496](https://github.com/apache/incubator-inlong/issues/2496) | [Feature][Sort]Support COS filesystem when using hive sink                                                       |
| [INLONG-2435](https://github.com/apache/incubator-inlong/issues/2435) | [Feature] Fix Sort-standalone UT problem.                                                                        |
| [INLONG-2413](https://github.com/apache/incubator-inlong/issues/2413) | [Feature][Sort]Support non-partitioned table when using hive sink                                                |
| [INLONG-2382](https://github.com/apache/incubator-inlong/issues/2382) | [Feature] Sort-sdk support Pulsar consumer of PB compression cache message protocol.                             |
| [INLONG-2346](https://github.com/apache/incubator-inlong/issues/2346) | [Feature][InLong-Sort] Support avro and canal formats for sort sink                                              |
| [INLONG-1928](https://github.com/apache/incubator-inlong/issues/1928) | [Feature]Inlong-Sort-Standalone support to consume events from Tube cache clusters.                              |
| [INLONG-1896](https://github.com/apache/incubator-inlong/issues/1896) | [Feature]Inlong-Sort-Standalone support to sort the events to Kafka clusters.                                    |

### TubeMQ
| ISSUE                                                                 | Summary                                                                                         |
|:----------------------------------------------------------------------|:------------------------------------------------------------------------------------------------|
| [INLONG-3644](https://github.com/apache/incubator-inlong/issues/3644) | [Feature][TubeMQ]Upgrade netty version and tidy up dependencies.                                |
| [INLONG-3621](https://github.com/apache/incubator-inlong/issues/3621) | [Improve][TubeMQ] Added cluster switching method and delete cluster support to delete master    |
| [INLONG-3598](https://github.com/apache/incubator-inlong/issues/3598) | [Improve][TubeMQ] Add broker modify method                                                      |
| [INLONG-3568](https://github.com/apache/incubator-inlong/issues/3568) | [Improve][TubeMQ] Nodes realize batch online                                                    |
| [INLONG-3560](https://github.com/apache/incubator-inlong/issues/3560) | [Bug][TubeMQ][InLong] The tubemq pod is invalid                                                 |
| [INLONG-3547](https://github.com/apache/incubator-inlong/issues/3547) | [Bug][TubeMQ] curl and ps commands not found in tubemq docker container                         |
| [INLONG-3514](https://github.com/apache/incubator-inlong/issues/3514) | [Improve][TubeMQ] Add name and IP attributes for query cluster API                              |
| [INLONG-3509](https://github.com/apache/incubator-inlong/issues/3509) | [TubeMQ]Optimize the LICENSE file format of inlong-tubemq third-party components                |
| [INLONG-3477](https://github.com/apache/incubator-inlong/issues/3477) | [TubeMQ] Remove direct reference to log4j1.x                                                    |
| [INLONG-3453](https://github.com/apache/incubator-inlong/issues/3453) | [Feature][TubeMQ] Remove hibernete for tube manager                                             |
| [INLONG-3451](https://github.com/apache/incubator-inlong/issues/3451) | [Bug][Manager] Got wrong results when querying tube cluster info                                |
| [INLONG-3445](https://github.com/apache/incubator-inlong/issues/3445) | [Feature][TubeMQ] Remove the hibernate dependency for the tube manager                          |
| [INLONG-3432](https://github.com/apache/incubator-inlong/issues/3432) | [TubeMQ] Sort out the LICENSEs of the third-party components of inlong-tubemq-manager           |
| [INLONG-3431](https://github.com/apache/incubator-inlong/issues/3431) | [TubeMQ] Sort out the LICENSEs of the third-party components of inlong-tubemq                   |
| [INLONG-3429](https://github.com/apache/incubator-inlong/issues/3429) | [TubeMQ] Add missing adminQueryMasterVersion method                                             |
| [INLONG-3363](https://github.com/apache/incubator-inlong/issues/3363) | [TubeMQ]Added how to use optional BDB components and documentation                              |
| [INLONG-3354](https://github.com/apache/incubator-inlong/issues/3354) | [TubeMQ]Update master.ini configuration guidelines document                                     |
| [INLONG-3348](https://github.com/apache/incubator-inlong/issues/3348) | [TubeMQ] Update protobuf-java version to 3.19.4                                                 |
| [INLONG-3324](https://github.com/apache/incubator-inlong/issues/3324) | [TubeMQ]Optimize CliMetaDataBRU class implementation                                            |
| [INLONG-3290](https://github.com/apache/incubator-inlong/issues/3290) | [TubeMQ]Add the query API for finding the consumption group based on the specified topic        |
| [INLONG-3268](https://github.com/apache/incubator-inlong/issues/3268) | [TubeMQ] Fix some bugs when metadata is saved to ZooKeeper                                      |
| [INLONG-3254](https://github.com/apache/incubator-inlong/issues/3254) | [TubeMQ]Replace the call of MetaDataManager with DefaultMetaDataService                         |
| [INLONG-3201](https://github.com/apache/incubator-inlong/issues/3201) | [Improve][TubeMQ] Improve the cluster query function                                            |
| [INLONG-3154](https://github.com/apache/incubator-inlong/issues/3154) | [TubeMQ] Adjust the Master.ini file reading implementation                                      |
| [INLONG-3143](https://github.com/apache/incubator-inlong/issues/3143) | [TubeMQ] Optimize Metadatamanager class implementation                                          |
| [INLONG-3108](https://github.com/apache/incubator-inlong/issues/3108) | [TubeMQ] Optimize the implementation of KeepAlive Interface                                     |
| [INLONG-3105](https://github.com/apache/incubator-inlong/issues/3105) | [TubeMQ] Add MetaStoreMapper related implementation                                             |
| [INLONG-3095](https://github.com/apache/incubator-inlong/issues/3095) | [Improve][Manager] Update inlong group info in the complete listeners                           |
| [INLONG-3093](https://github.com/apache/incubator-inlong/issues/3093) | [TubeMQ] Optimize the AbsXXXMapperImpl implementation classes                                   |
| [INLONG-3079](https://github.com/apache/incubator-inlong/issues/3079) | [Bug][TubeMQ] An NPE was thrown when starting the Tube-Manager                                  |
| [INLONG-3078](https://github.com/apache/incubator-inlong/issues/3078) | [Bug][Sort] TubeClientException occurred in unit tests                                          |
| [INLONG-3072](https://github.com/apache/incubator-inlong/issues/3072) | [TubeMQ] Output the total count of control block in admin_query_cluster_topic_view              |
| [INLONG-3035](https://github.com/apache/incubator-inlong/issues/3035) | [TubeMQ] Optimize the MetaStoreService implementation class                                     |
| [INLONG-3029](https://github.com/apache/incubator-inlong/issues/3029) | [TubeMQ] Adjust the implementation classes under the impl.bdbimpl package                       |
| [INLONG-3020](https://github.com/apache/incubator-inlong/issues/3020) | [Improve] Format the some code of TubeMQ Go SDK                                                 |
| [INLONG-3015](https://github.com/apache/incubator-inlong/issues/3015) | [Feature][TubeMQ] Add configuration to support the number of reloaded machines per batch        |
| [INLONG-2980](https://github.com/apache/incubator-inlong/issues/2980) | [TubeMQ] Modify the code style problems of the metadata classes                                 |
| [INLONG-2979](https://github.com/apache/incubator-inlong/issues/2979) | [Feature] Tubemq cluster delete provides token code                                             |
| [INLONG-2955](https://github.com/apache/incubator-inlong/issues/2955) | [TubeMQ] Adjust the offsetstorage and zookeeper package paths                                   |
| [INLONG-2915](https://github.com/apache/incubator-inlong/issues/2915) | [TubeMQ] Fix code style issues                                                                  |
| [INLONG-2844](https://github.com/apache/incubator-inlong/issues/2844) | [TubeMQ] Implement the ZooKeeper-based metadata Mapper class                                    |
| [INLONG-2813](https://github.com/apache/incubator-inlong/issues/2813) | [Improve] update the docker config for getting TubeMq config dynamically                        |
| [INLONG-2803](https://github.com/apache/incubator-inlong/issues/2803) | [Improve][TubeMQ] Update the Python client package                                              |
| [INLONG-2776](https://github.com/apache/incubator-inlong/issues/2776) | [TubeMQ] Add metadata backup cli script                                                         |
| [INLONG-2728](https://github.com/apache/incubator-inlong/issues/2728) | [TubeMQ] Optimize the content of statistical metrics                                            |
| [INLONG-2620](https://github.com/apache/incubator-inlong/issues/2620) | [TubeMQ] Add direct write to disk control                                                       |
| [INLONG-2609](https://github.com/apache/incubator-inlong/issues/2609) | [TubeMQ] Fix Javadoc related errors                                                             |
| [INLONG-2603](https://github.com/apache/incubator-inlong/issues/2603) | [TubeMQ] Remove obsolete metric codes                                                           |
| [INLONG-2596](https://github.com/apache/incubator-inlong/issues/2596) | [Improve][TubeMQ] Fix param in the client module and the main class of tubeManager pom is error |
| [INLONG-2569](https://github.com/apache/incubator-inlong/issues/2569) | [TubeMQ] Discarded msgTime value when msgType is empty                                          |
| [INLONG-2555](https://github.com/apache/incubator-inlong/issues/2555) | [TubeMQ] Remove slf4j-log4j12                                                                   |
| [INLONG-2552](https://github.com/apache/incubator-inlong/issues/2552) | [TubeMQ] Add Master metric operation APIs                                                       |
| [INLONG-2538](https://github.com/apache/incubator-inlong/issues/2538) | [TubeMQ] Optimize message write cache logic                                                     |
| [INLONG-2518](https://github.com/apache/incubator-inlong/issues/2518) | [TubeMQ] Adjust the client's metric statistics logic                                            |
| [INLONG-2517](https://github.com/apache/incubator-inlong/issues/2517) | [TubeMQ] Adjust the statistical logic of the Master service status                              |
| [INLONG-2516](https://github.com/apache/incubator-inlong/issues/2516) | [TubeMQ] Optimize Broker's JMX metric interface                                                 |
| [INLONG-2508](https://github.com/apache/incubator-inlong/issues/2508) | [TubeMQ] Add Broker metric operation APIs                                                       |
| [INLONG-2505](https://github.com/apache/incubator-inlong/issues/2505) | [TubeMQ] Add MsgStoreStatsHolder class                                                          |
| [INLONG-2488](https://github.com/apache/incubator-inlong/issues/2488) | [TubeMQ] Optimize MsgFileStatisInfo implementation logic                                        |
| [INLONG-2484](https://github.com/apache/incubator-inlong/issues/2484) | [TubeMQ]Optimize MsgMemStatisInfo implementation logic                                          |
| [INLONG-2480](https://github.com/apache/incubator-inlong/issues/2480) | [TubeMQ] Add WebCallStatsHolder class for Web API call statistics                               |
| [INLONG-2478](https://github.com/apache/incubator-inlong/issues/2478) | [TubeMQ] Optimize GroupCountService logic implementation                                        |
| [INLONG-2474](https://github.com/apache/incubator-inlong/issues/2474) | [TubeMQ] Adjust the statistics of Broker's message service part                                 |
| [INLONG-2451](https://github.com/apache/incubator-inlong/issues/2451) | [TubeMQ] Add Histogram implementation classes                                                   |
| [INLONG-2445](https://github.com/apache/incubator-inlong/issues/2445) | [TubeMQ] Add Gauge and Counter implementation classes                                           |
| [INLONG-2433](https://github.com/apache/incubator-inlong/issues/2433) | [TubeMQ] Abstract metrics' interface                                                            |
| [INLONG-2353](https://github.com/apache/incubator-inlong/issues/2353) | [Feature] Tube manager cluster adds support for multi-master configuration                      |
| [INLONG-2282](https://github.com/apache/incubator-inlong/issues/2282) | [Feature][TubeMQ] Add ZooKeeper as the metadata storage component of TubeMQ                     |
| [INLONG-2204](https://github.com/apache/incubator-inlong/issues/2204) | [Improve][TubeMQ] Optimize the collection of metrics for TubeMQ                                 |
| [INLONG-1655](https://github.com/apache/incubator-inlong/issues/1655) | [Improve] TubeMQ Documents should use English pictures                                          |

### Dashboard
| ISSUE                                                                 | Summary                                                                                     |
|:----------------------------------------------------------------------|:--------------------------------------------------------------------------------------------|
| [INLONG-3684](https://github.com/apache/incubator-inlong/issues/3684) | [Improve][Dashboard]  Add tooltip for stream data type                                      |
| [INLONG-3670](https://github.com/apache/incubator-inlong/issues/3670) | [Improve][Dashboard] Add dashboard plugin docs to official website                          |
| [INLONG-3660](https://github.com/apache/incubator-inlong/issues/3660) | [Improve][Dashboard] Change visible for dataType and dataSeparator                          |
| [INLONG-3631](https://github.com/apache/incubator-inlong/issues/3631) | [Improve][Dashboard] Change the ClickHouse sink page to adapt the Manager module            |
| [INLONG-3617](https://github.com/apache/incubator-inlong/issues/3617) | [Improve][Dashboard] Add params for stream source to adapt Manager module                   |
| [INLONG-3556](https://github.com/apache/incubator-inlong/issues/3556) | [Feature][Dashboard] Add Iceberg params to adapt the Manager module                         |
| [INLONG-3518](https://github.com/apache/incubator-inlong/issues/3518) | [Feature][Dashboard] Support Iceberg Sink                                                   |
| [INLONG-3506](https://github.com/apache/incubator-inlong/issues/3506) | [Feature][Dashboard] Support Kafka                                                          |
| [INLONG-3498](https://github.com/apache/incubator-inlong/issues/3498) | [Improve][Dashboard] Adapt manager streams update API                                       |
| [INLONG-3496](https://github.com/apache/incubator-inlong/issues/3496) | [Improve][Dashboard] Update node version                                                    |
| [INLONG-3492](https://github.com/apache/incubator-inlong/issues/3492) | [Improve][Dashboard] Initialize a npmrc file                                                |
| [INLONG-3471](https://github.com/apache/incubator-inlong/issues/3471) | [Improve][Dashboard] Hive sink adapts to new manager API                                    |
| [INLONG-3442](https://github.com/apache/incubator-inlong/issues/3442) | [Dashboard] Sort out the LICENSEs of the third-party components of inlong-dashboard         |
| [INLONG-3423](https://github.com/apache/incubator-inlong/issues/3423) | [Improve][Dashboard] Add user and password config to binlog source                          |
| [INLONG-3394](https://github.com/apache/incubator-inlong/issues/3394) | [Improve][Dashboard] Remove the stream owner parameter and manage it uniformly by group     |
| [INLONG-3390](https://github.com/apache/incubator-inlong/issues/3390) | [Improve][Dashboard] Text form support date and array dataType                              |
| [INLONG-3341](https://github.com/apache/incubator-inlong/issues/3341) | [Feature][Dashboard] Sink supports plug-in configuration                                    |
| [INLONG-3314](https://github.com/apache/incubator-inlong/issues/3314) | [Improve][Dashboard] Support for new data stream API data formats                           |
| [INLONG-3280](https://github.com/apache/incubator-inlong/issues/3280) | [Bug][Manager][Dashboard] Update and delete datasource failed                               |
| [INLONG-3275](https://github.com/apache/incubator-inlong/issues/3275) | [Improve][Dashboard] Change the request method of list query from GET to POST               |
| [INLONG-3257](https://github.com/apache/incubator-inlong/issues/3257) | [Bug][Manager][Dashboard] Create CommonServerDB return 404                                  |
| [INLONG-3220](https://github.com/apache/incubator-inlong/issues/3220) | [Improve][Dashboard] The binlog configuration aligns the parameters of the managerAPI       |
| [INLONG-3128](https://github.com/apache/incubator-inlong/issues/3128) | [Feature][Dashboard] Make binlog as a source type                                           |
| [INLONG-2997](https://github.com/apache/incubator-inlong/issues/2997) | [Improve][Dashboard] The group execution log needs to distinguish between different states  |
| [INLONG-2996](https://github.com/apache/incubator-inlong/issues/2996) | [Bug][Dashboard] An error is reported after closing the group execution log modal           |
| [INLONG-2895](https://github.com/apache/incubator-inlong/issues/2895) | [Feature][Dashboard] The data source in the data stream supports binlog collection          |
| [INLONG-2861](https://github.com/apache/incubator-inlong/issues/2861) | [Feature][Dashboard] Support common data source module                                      |
| [INLONG-2799](https://github.com/apache/incubator-inlong/issues/2799) | [Bug][Dashboard] Some code specification issues                                             |
| [INLONG-2624](https://github.com/apache/incubator-inlong/issues/2624) | [Improve][Dashboard] Modify the interface and parameters to adapt to changes in the Manager |
| [INLONG-2535](https://github.com/apache/incubator-inlong/issues/2535) | [Improve][dashboard] Audit module display time in reverse order                             |
| [INLONG-2500](https://github.com/apache/incubator-inlong/issues/2500) | [Feature][Dashboard] Adapt to Manager's modification of data storage                        |
| [INLONG-2461](https://github.com/apache/incubator-inlong/issues/2461) | [Bug] a number of CVEs exist for NPMs exist in dashboard                                    |

## Release 1.0.0-incubating - Released (as of 2022-2-1)

### FEATURES:
| ISSUE  | Summary  |
| :---- | :------- |
| [INLONG-2347](https://github.com/apache/incubator-inlong/issues/2347) | [Feature]Support hive sink in sort-single-tenant |
| [INLONG-2334](https://github.com/apache/incubator-inlong/issues/2334) | [Feature][inlong-dataproxy]create pulsar client need support config ioThreads |
| [INLONG-2333](https://github.com/apache/incubator-inlong/issues/2333) | [Feature]Support clickhouse sink in sort-single-tenant |
| [INLONG-2266](https://github.com/apache/incubator-inlong/issues/2266) | [Feature]Support reporting metrics by audit-sdk in sort | 
| [INLONG-2250](https://github.com/apache/incubator-inlong/issues/2250) | [Feature][InLong-Sort] Support Kafka sink in InLong-Sort | 
| [INLONG-2247](https://github.com/apache/incubator-inlong/issues/2247) | Read the consume group offset and store to the specified topic | 
| [INLONG-2236](https://github.com/apache/incubator-inlong/issues/2236) | [Feature]Support iceberg sink in sort-single-tenant |
| [INLONG-2232](https://github.com/apache/incubator-inlong/issues/2232) | Add start and end timestamp of segment |
| [INLONG-2218](https://github.com/apache/incubator-inlong/issues/2218) | [Feature][InLong-DataProxy] Inlong-DataProxy support authentication access pulsar |
| [INLONG-2217](https://github.com/apache/incubator-inlong/issues/2217) | [Feature][InLong-DataProxy] Add TCP protocol client demo and config doc feature |
| [INLONG-2216](https://github.com/apache/incubator-inlong/issues/2216) | [Feature][InLong-DataProxy] Add UDP protocol  client demo and config doc |
| [INLONG-2215](https://github.com/apache/incubator-inlong/issues/2215) | [Feature][InLong-DataProxy] Add http protocol  client demo and config doc |
| [INLONG-2326](https://github.com/apache/incubator-inlong/issues/2326) | [Feature] Inlong-Sort-Standalone support to sort the events to ElasticSearch cluster. |
| [INLONG-2322](https://github.com/apache/incubator-inlong/issues/2322) | [Feature][InLong-Sort] Support json format for kafka sink |
| [INLONG-2301](https://github.com/apache/incubator-inlong/issues/2301) | [Feature]  Support Standalone deployment for InLong |
| [INLONG-2207](https://github.com/apache/incubator-inlong/issues/2207) | [Feature][InLong-Website] Add component about charts |  
| [INLONG-2187](https://github.com/apache/incubator-inlong/issues/2187) | [Feature] Website support audit view |                
| [INLONG-2183](https://github.com/apache/incubator-inlong/issues/2183) | [Feature][InLong-Sort] Bump flink version to 1.13.5 | 
| [INLONG-2176](https://github.com/apache/incubator-inlong/issues/2176) | Add histogram metric and client-side metric output |  
| [INLONG-2170](https://github.com/apache/incubator-inlong/issues/2170) | [Feature] add Inlong-Sort-standalone document. |
| [INLONG-2169](https://github.com/apache/incubator-inlong/issues/2169) | [Feature] [Agent] should provide docs for agent db sql collect |
| [INLONG-2167](https://github.com/apache/incubator-inlong/issues/2167) | [Feature] [Agent] support db SQL collect |
| [INLONG-2164](https://github.com/apache/incubator-inlong/issues/2164) | [Feature] Sort-standalone expose metric data using prometheus HttpServer. |
| [INLONG-2161](https://github.com/apache/incubator-inlong/issues/2161) | [Feature][InLong-Manager] Manager support getClusterConfig  |
| [INLONG-2138](https://github.com/apache/incubator-inlong/issues/2138) | [Feature] Agent should provide docs for programmers to customize their own source or sink | 
| [INLONG-2106](https://github.com/apache/incubator-inlong/issues/2106) | [Feature] DataProxy expose metric data using prometheus HttpServer. | 
| [INLONG-2096](https://github.com/apache/incubator-inlong/issues/2096) | [Feature] DataProxy add InlongGroupId+InlongStreamId metric dimensions in TDSDKSource and TubeSink. |
| [INLONG-2077](https://github.com/apache/incubator-inlong/issues/2077) | [Feature]sort-sdk change pulsar consume mode from listener to fetch |
| [INLONG-2076](https://github.com/apache/incubator-inlong/issues/2076) | [Feature] Tube sink of DataProxy support new Message format. |
| [INLONG-2075](https://github.com/apache/incubator-inlong/issues/2075) | [Feature] SDK Source of DataProxy support new Message format. |
| [INLONG-2058](https://github.com/apache/incubator-inlong/issues/2058) | [Feature] The metric of Sort-standalone append a dimension(minute level) of event time, supporting audit reconciliation of minute level.  |
| [INLONG-2056](https://github.com/apache/incubator-inlong/issues/2056) | [Feature]The metric of DataProxy append a dimension(minute level) of event time, supporting audit reconciliation of minute level. |
| [INLONG-2055](https://github.com/apache/incubator-inlong/issues/2055) | [Feature] [InLong audit] Audit SDK Support real-time report  |
| [INLONG-2054](https://github.com/apache/incubator-inlong/issues/2054) | [Feature] [InLong audit] Audit SDK Support disaster tolerance |
| [INLONG-2053](https://github.com/apache/incubator-inlong/issues/2053) | [Feature] [InLong audit] Audit Web Page Display |
| [INLONG-2051](https://github.com/apache/incubator-inlong/issues/2051) | [Feature] [InLong audit] Add Audit API for Manager |
| [INLONG-2050](https://github.com/apache/incubator-inlong/issues/2050) | [Feature] [InLong audit] Audit Strore for Elasticsearch |
| [INLONG-2045](https://github.com/apache/incubator-inlong/issues/2045) | [Feature]sort-sdk support Prometheus monitor |
| [INLONG-2028](https://github.com/apache/incubator-inlong/issues/2028) | [Feature][CI] Add support for docker build on GitHub Actions |
| [INLONG-1992](https://github.com/apache/incubator-inlong/issues/1992) | [Feature]sort-flink support configurable loader of getting configuration. |
| [INLONG-1950](https://github.com/apache/incubator-inlong/issues/1950) | [Feature] DataProxy add supporting to udp protocol for reporting data |
| [INLONG-1949](https://github.com/apache/incubator-inlong/issues/1949) | [Feature] DataProxy sdk add demo  |
| [INLONG-1931](https://github.com/apache/incubator-inlong/issues/1931) | [Feature]Inlong-Sort-Standalone-readapi support to consume events from inlong cache clusters(tube) |
| [INLONG-1895](https://github.com/apache/incubator-inlong/issues/1895) | [Feature]Inlong-Sort-Standalone support to sort the events to Hive cluster. |
| [INLONG-1894](https://github.com/apache/incubator-inlong/issues/1894) | [Feature]Inlong-Sort-Standalone support JMX metrics listener for pushing. |
| [INLONG-1892](https://github.com/apache/incubator-inlong/issues/1892) | [Feature]Inlong-Sort-Standalone support to consume events from Pulsar cache clusters. |
| [INLONG-1738](https://github.com/apache/incubator-inlong/issues/1738) | [Feature]  InLong audit |

### IMPROVEMENTS:
| ISSUE  | Summary  |
| :---- | :------- |
| [INLONG-2373](https://github.com/apache/incubator-inlong/issues/2373) | [Improve] Refactor of CreateBusinessWorkflow |
| [INLONG-2358](https://github.com/apache/incubator-inlong/issues/2358) | [InLong audit] modify audit proxy name of introduction |               
| [INLONG-2352](https://github.com/apache/incubator-inlong/issues/2352) | [InLong audit] add audit introduction |                                
| [INLONG-2349](https://github.com/apache/incubator-inlong/issues/2349) | [inlong-dataproxy] change log file name from flum.log to dataproxy.log |
| [INLONG-2331](https://github.com/apache/incubator-inlong/issues/2331) | [Improve] Extract connector related code to sort-connector module | 
| [INLONG-2329](https://github.com/apache/incubator-inlong/issues/2329) | [Improve][inlong-dataproxy-sdk] asyncSendMessage in sender.java can be optimized to reduce the number of invalid objects |
| [INLONG-2297](https://github.com/apache/incubator-inlong/issues/2297) | [Improve][agent] support audit for source and sink |
| [INLONG-2296](https://github.com/apache/incubator-inlong/issues/2296) | Added lag consumption log |
| [INLONG-2294](https://github.com/apache/incubator-inlong/issues/2294) | Rename the variable BROKER_VERSION to SERVER_VERSION |
| [INLONG-2279](https://github.com/apache/incubator-inlong/issues/2279) | [Improve] Supplement TubeMQ's  Javadoc information |
| [INLONG-2274](https://github.com/apache/incubator-inlong/issues/2274) | [Improve][Manager] Supports configuring whether to create a Hive database or table |
| [INLONG-2271](https://github.com/apache/incubator-inlong/issues/2271) | [Improve] rename the TDMsg to InLongMsg |
| [INLONG-2258](https://github.com/apache/incubator-inlong/issues/2258) | [Improve][dashboard] Audit page support auto select datastream |
| [INLONG-2254](https://github.com/apache/incubator-inlong/issues/2254) | Add historical offset query API |
| [INLONG-2245](https://github.com/apache/incubator-inlong/issues/2245) | [Improve] Supports database-level isolation of audit queries | 
| [INLONG-2229](https://github.com/apache/incubator-inlong/issues/2229) | [Improve] Manager support pulsar authentification  | 
| [INLONG-2225](https://github.com/apache/incubator-inlong/issues/2225) | [Improve][InLong-Dashboard] Audit module support i18n | 
| [INLONG-2220](https://github.com/apache/incubator-inlong/issues/2220) | [Improve] move dataproxy-sdk to inlong-sdk | 
| [INLONG-2210](https://github.com/apache/incubator-inlong/issues/2210) | [Improve] package `inlong-manager-web` as `inlong-manager` | 
| [INLONG-2200](https://github.com/apache/incubator-inlong/issues/2200) | [Feature] DataProxy add supporting to http protocol for reporting data |  
| [INLONG-2196](https://github.com/apache/incubator-inlong/issues/2196) | [Improve] move website to dashboard |         
| [INLONG-2193](https://github.com/apache/incubator-inlong/issues/2193) | [Improve] optimize inlong manager structure | 
| [INLONG-2160](https://github.com/apache/incubator-inlong/issues/2160) | [Improve] Time format conversion using DateTimeFormatter |  
| [INLONG-2151](https://github.com/apache/incubator-inlong/issues/2151) | [Improve] Add time and sort statistics by topic | 
| [INLONG-2133](https://github.com/apache/incubator-inlong/issues/2133) | Update year to 2022 | 
| [INLONG-2126](https://github.com/apache/incubator-inlong/issues/2126) | [Improve]prepare_env.sh can be merged into dataproxy-start.sh，as a InLong beginner maybe forgot this step |
| [INLONG-2122](https://github.com/apache/incubator-inlong/issues/2122) | [Improve] Send a dev notifications email for issue status |
| [INLONG-2119](https://github.com/apache/incubator-inlong/issues/2119) | [Improve][Website][CI] Add support for building inlong website when building or testing project |
| [INLONG-2117](https://github.com/apache/incubator-inlong/issues/2117) | [Improve][agent] optimize class name  |
| [INLONG-2116](https://github.com/apache/incubator-inlong/issues/2116) | [Improve][Website] Improve the README document |
| [INLONG-2107](https://github.com/apache/incubator-inlong/issues/2107) | [Improve] [InLong Manager] remove gson and json-simple from dependency |  
| [INLONG-2103](https://github.com/apache/incubator-inlong/issues/2103) | [Improve] update the definition of Apache InLong | 
| [INLONG-2073](https://github.com/apache/incubator-inlong/issues/2073) | [Improve] [InLong agent] remove spring 2.5.6 from dependencyManagement |
| [INLONG-2072](https://github.com/apache/incubator-inlong/issues/2072) | [Improve] update the deployment guide for sort |
| [INLONG-2070](https://github.com/apache/incubator-inlong/issues/2070) | [Improve] update the default pulsar demo configuration for dataproxy  |
| [INLONG-1944](https://github.com/apache/incubator-inlong/issues/1944) | Bumped version to 0.13.0-incubating-SNAPSHOT for the master branch |

### BUG FIXES:
| ISSUE  | Summary  |
| :---- | :------- |
| [INLONG-2371](https://github.com/apache/incubator-inlong/issues/2371) | [Bug][inlong-dataproxy] monitorIndex should not use msgid for key,it affects performance |
| [INLONG-2361](https://github.com/apache/incubator-inlong/issues/2361) | [Bug] audit have no data |
| [INLONG-2344](https://github.com/apache/incubator-inlong/issues/2344) | [Bug][InLong-Sort] Kafka sink ut failed under multithread compiling | 
| [INLONG-2338](https://github.com/apache/incubator-inlong/issues/2338) | [Bug] agent can not get dataproxy for docker-compose environment |
| [INLONG-2336](https://github.com/apache/incubator-inlong/issues/2336) | [Bug][agent] the manager fetcher thread was shielded |
| [INLONG-2288](https://github.com/apache/incubator-inlong/issues/2288) | [Bug] sort-flink task catches an NPE |
| [INLONG-2264](https://github.com/apache/incubator-inlong/issues/2264) | [Bug] DataProxy get metric value with error JMX ObjectName |
| [INLONG-2263](https://github.com/apache/incubator-inlong/issues/2263) | [Bug] SortStandalone get metric value with error JMX ObjectName |
| [INLONG-2252](https://github.com/apache/incubator-inlong/issues/2252) | [Bug] Remove <> character in sort-standalone quick_start.md. |     
| [INLONG-2242](https://github.com/apache/incubator-inlong/issues/2242) | [BUG][manager] table field incorrect: db_collector_detail_task, 'sql' should be 'sql_statement' |
| [INLONG-2237](https://github.com/apache/incubator-inlong/issues/2237) | [Bug] call audit query interface error |
| [INLONG-2230](https://github.com/apache/incubator-inlong/issues/2230) | [Bug]  manager started get jackson error |    
| [INLONG-2227](https://github.com/apache/incubator-inlong/issues/2227) | [Bug] build failed for dataproxy-sdk |
| [INLONG-2224](https://github.com/apache/incubator-inlong/issues/2224) | [Bug][inlong-DataProxy] Source receive one message will be send to pulsar twice when config both memery channel and file channel | 
| [INLONG-2202](https://github.com/apache/incubator-inlong/issues/2202) | [Bug] add lower version log4j exclusion in sort-standalone pom.xml |   
| [INLONG-2199](https://github.com/apache/incubator-inlong/issues/2199) | [Bug][inlong-audit][audit-source] one message will put tow channel, and store two message | 
| [INLONG-2191](https://github.com/apache/incubator-inlong/issues/2191) | [Bug][inlong-audit][audit-source] requestId is not set in response message |
| [INLONG-2190](https://github.com/apache/incubator-inlong/issues/2190) | [Bug][inlong-audit][audit-store] can not started by start shell |
| [INLONG-2174](https://github.com/apache/incubator-inlong/issues/2174) | [Bug]Clickhouse sink can cause data loss when checkpointing | 
| [INLONG-2155](https://github.com/apache/incubator-inlong/issues/2155) | [Bug][Manager] Some unit tests running failed | 
| [INLONG-2148](https://github.com/apache/incubator-inlong/issues/2148) | [Bug][sort]Pattern used for extracting clickhouse metadata is not compatible with some versions of clickhouse |
| [INLONG-2143](https://github.com/apache/incubator-inlong/issues/2143) | [Bug][sort] caught a NoClassDefFoundError exception |
| [INLONG-2137](https://github.com/apache/incubator-inlong/issues/2137) | [Bug] version 0.12.0 cannot pass UT |
| [INLONG-2130](https://github.com/apache/incubator-inlong/issues/2130) | [Bug] inlong-sort occurs `ClassNotFoundException: og.objenesis..ClassUtils` | 
| [INLONG-2113](https://github.com/apache/incubator-inlong/issues/2113) | [Bug][Docker] Audit docker image build failed |
| [INLONG-2098](https://github.com/apache/incubator-inlong/issues/2098) | [Bug] agent can not restart successfully |
| [INLONG-2097](https://github.com/apache/incubator-inlong/issues/2097) | [Bug][Docker] error while building tubemq image |
| [INLONG-2094](https://github.com/apache/incubator-inlong/issues/2094) | [Bug] summit job failed after enabling Prometheus |
| [INLONG-2089](https://github.com/apache/incubator-inlong/issues/2089) | [Bug]tubemq-manager throws error when starting:   java.lang.ClassNotFoundException: javax.validation.ClockProvider |
| [INLONG-2087](https://github.com/apache/incubator-inlong/issues/2087) | [Bug] Miss a "-p" flag before 2181:2181 in the command "Start Standalone Container" |
| [INLONG-2085](https://github.com/apache/incubator-inlong/issues/2085) | [Bug] Solve the incubator-inlong-website Compilation failure problem |
| [INLONG-2084](https://github.com/apache/incubator-inlong/issues/2084) | [Bug]A bug in the Go SDK demo, and the API result class is not clear enough |
| [INLONG-2082](https://github.com/apache/incubator-inlong/issues/2082) | [Bug] file agent collector file failed |
| [INLONG-2080](https://github.com/apache/incubator-inlong/issues/2080) | [Bug] file agent send file failed |
| [INLONG-2078](https://github.com/apache/incubator-inlong/issues/2078) | [Bug] create pulsar subscription failed |
| [INLONG-2068](https://github.com/apache/incubator-inlong/issues/2068) | [Bug] the class name in dataproxy stop.sh  is wrong |
| [INLONG-2066](https://github.com/apache/incubator-inlong/issues/2066) | Each message will be consumed twice.[Bug] |
| [INLONG-2064](https://github.com/apache/incubator-inlong/issues/2064) | [Bug]master branch, tubemq-manager  module occurs: package Java.validation.constraints not exists |
| [INLONG-2061](https://github.com/apache/incubator-inlong/issues/2061) | [Bug][Office-Website] The homepage structure image error |
| [INLONG-1989](https://github.com/apache/incubator-inlong/issues/1989) | [Bug]some font of " DataProxy-SDK architecture " page  incorrectly |
| [INLONG-1342](https://github.com/apache/incubator-inlong/issues/1342) | [Bug] Create tube consumer group failed where the group exists |  

## Release 0.12.0-incubating - Released (as of 2021-12-22)

### FEATURES:
| ISSUE  | Summary  |
| :---- | :------- |
| [INLONG-1310](https://github.com/apache/incubator-inlong/issues/1310) | [Feature] [Feature] Support Pulsar
| [INLONG-1711](https://github.com/apache/incubator-inlong/issues/1711) | [feature] website support process pulsar dataflow
| [INLONG-1712](https://github.com/apache/incubator-inlong/issues/1712) | [Feature][agent] Add agent metric statistics
| [INLONG-1722](https://github.com/apache/incubator-inlong/issues/1722) | [Feature] Add IssueNavigationLink for IDEA
| [INLONG-1725](https://github.com/apache/incubator-inlong/issues/1725) | [Feature] [InLong-Manager] Modify bid and tid (or dsid) to inlongGroupId and inlongStreamId
| [INLONG-1726](https://github.com/apache/incubator-inlong/issues/1726) | [Feature] [InLong-Website] Adapt the Manager module and modify the field names of bid and dsid
| [INLONG-1732](https://github.com/apache/incubator-inlong/issues/1732) | [Feature] [InLong-Agent] Modify bid and tid to inlongGroupId and inlongStreamId
| [INLONG-1738](https://github.com/apache/incubator-inlong/issues/1738) | [Feature] InLong audit
| [INLONG-1764](https://github.com/apache/incubator-inlong/issues/1764) | [Feature]Use black for code block background style
| [INLONG-1768](https://github.com/apache/incubator-inlong/issues/1768) | [Feature] Adding consume type that allows partition assign from the client
| [INLONG-1785](https://github.com/apache/incubator-inlong/issues/1785) | [Feature] add 0.11.0 release article for blog
| [INLONG-1786](https://github.com/apache/incubator-inlong/issues/1786) | [Feature]Inlong-common provide monitoring indicator reporting mechanism with JMX, user can implement the code that read the metrics and report to user-defined monitor system.
| [INLONG-1791](https://github.com/apache/incubator-inlong/issues/1791) | [Feature][InLong-Manager] Some bid fields have not been modified
| [INLONG-1796](https://github.com/apache/incubator-inlong/issues/1796) | [Feature]DataProxy support monitor indicator with JMX.
| [INLONG-1809](https://github.com/apache/incubator-inlong/issues/1809) | [Feature] Adjust the font style of the official home page
| [INLONG-1814](https://github.com/apache/incubator-inlong/issues/1814) | [Feature] Show document file subdirectories
| [INLONG-1817](https://github.com/apache/incubator-inlong/issues/1817) | [Feature][InLong-Manager] Workflow supports data stream for Pulsar
| [INLONG-1821](https://github.com/apache/incubator-inlong/issues/1821) | [INLONG-810] Sort Module Support store data to ApacheDoris
| [INLONG-1826](https://github.com/apache/incubator-inlong/issues/1826) | [Feature] Use jmx metric defined in inlong-common
| [INLONG-1830](https://github.com/apache/incubator-inlong/issues/1830) | [Feature] Add a star reminder
| [INLONG-1833](https://github.com/apache/incubator-inlong/issues/1833) | [Feature] Add Team button to the navigation bar
| [INLONG-1840](https://github.com/apache/incubator-inlong/issues/1840) | [Feature] add a Welcome committer articles to official website blog
| [INLONG-1847](https://github.com/apache/incubator-inlong/issues/1847) | [Feature][InLong-Manager] Add consumption APIs for Pulsar MQ
| [INLONG-1849](https://github.com/apache/incubator-inlong/issues/1849) | [Feature][InLong-Manager] Push Sort config for Pulsar
| [INLONG-1851](https://github.com/apache/incubator-inlong/issues/1851) | [Feature]TubeMQ supports monitoring indicators with JMX.
| [INLONG-1853](https://github.com/apache/incubator-inlong/issues/1853) | [Feature] Agent should provide docs for jmx metrics
| [INLONG-1854](https://github.com/apache/incubator-inlong/issues/1854) | [Feature] Agent Rmi args should be added in agent-env.sh
| [INLONG-1856](https://github.com/apache/incubator-inlong/issues/1856) | [Feature] Add a news tab on the official website
| [INLONG-1867](https://github.com/apache/incubator-inlong/issues/1867) | [Feature] Add a user column display to the official website
| [INLONG-1873](https://github.com/apache/incubator-inlong/issues/1873) | [Feature] refactor the structure of the document for the official website
| [INLONG-1874](https://github.com/apache/incubator-inlong/issues/1874) | [Feature] Add contact information and common links at the bottom of the homepage of the official website
| [INLONG-1878](https://github.com/apache/incubator-inlong/issues/1878) | [Feature] Optimize user display page layout style
| [INLONG-1901](https://github.com/apache/incubator-inlong/issues/1901) | [Feature] Optimize the layout of the user display page
| [INLONG-1910](https://github.com/apache/incubator-inlong/issues/1910) | [Feature]Inlong-Sort-Standalone-sort-sdk support to consume events from inlong cache clusters(pulsar)
| [INLONG-1926](https://github.com/apache/incubator-inlong/issues/1926) | [Feature]Inlong-Sort-Standalone support JMX metrics listener for pulling.
| [INLONG-1938](https://github.com/apache/incubator-inlong/issues/1938) | [Feature] DataProxy send message to multi-pulsar cluster conf demo
| [INLONG-2002](https://github.com/apache/incubator-inlong/issues/2002) | [Feature]creating data access with pulsar, users should be able to change the ensemble param

### IMPROVEMENTS:
| ISSUE  | Summary  |
| :---- | :------- |
| [INLONG-1708](https://github.com/apache/incubator-inlong/issues/1708) | [Improve] Add restrict of @author and Chinese in java file
| [INLONG-1729](https://github.com/apache/incubator-inlong/issues/1729) | [Improve] Avoid using constant value as version when referencing other modules
| [INLONG-1739](https://github.com/apache/incubator-inlong/issues/1739) | [Improve] Optimization of TubeMQ SDK usage demo
| [INLONG-1740](https://github.com/apache/incubator-inlong/issues/1740) | [Improve] change bid/tid to be more identifiable
| [INLONG-1746](https://github.com/apache/incubator-inlong/issues/1746) | [improve] the log4j properties for dataproxy contains some useless code and some class name are incorrect
| [INLONG-1756](https://github.com/apache/incubator-inlong/issues/1756) | [Improve] Use metadata to manage data sources and flow fields
| [INLONG-1772](https://github.com/apache/incubator-inlong/issues/1772) | [Improve]Adjust the ProcessResult class implementation
| [INLONG-1798](https://github.com/apache/incubator-inlong/issues/1798) | [Improve]RestTemplate does not read configuration from the configuration file
| [INLONG-1802](https://github.com/apache/incubator-inlong/issues/1802) | [Improve] Optimize document version management
| [INLONG-1808](https://github.com/apache/incubator-inlong/issues/1808) | [Improve] Optimize document of DataProxy about monitor metric.
| [INLONG-1810](https://github.com/apache/incubator-inlong/issues/1810) | [Improve] update the architecture for office-website
| [INLONG-1811](https://github.com/apache/incubator-inlong/issues/1811) | [Improve] Modify the architecture diagram of README.md
| [INLONG-1815](https://github.com/apache/incubator-inlong/issues/1815) | [Improve][translation] the blog of the 0.11.0 release should be translated into English
| [INLONG-1819](https://github.com/apache/incubator-inlong/issues/1819) | Optimize GC parameter configuration in TubeMQ's env.sh file
| [INLONG-1822](https://github.com/apache/incubator-inlong/issues/1822) | Optimize the table formatting in some MD documents
| [INLONG-1824](https://github.com/apache/incubator-inlong/issues/1824) | Refine the how-to-vote-a-committer-ppmc.md
| [INLONG-1857](https://github.com/apache/incubator-inlong/issues/1857) | [Improve] Adjust the content of the Disclaimer and Events column
| [INLONG-1859](https://github.com/apache/incubator-inlong/issues/1859) | [Improve][InLong-Manager] Remove duplicate SQL files
| [INLONG-1861](https://github.com/apache/incubator-inlong/issues/1861) | [Improve] Update document for docker-compose
| [INLONG-1863](https://github.com/apache/incubator-inlong/issues/1863) | [Improve][TubeMQ] repHelperHost for master should be exposed in configuration
| [INLONG-1864](https://github.com/apache/incubator-inlong/issues/1864) | [Improve] Agent Website doc contains a typo
| [INLONG-1865](https://github.com/apache/incubator-inlong/issues/1865) | [Improve] There are several errors in TubeMQ's guidance document
| [INLONG-1877](https://github.com/apache/incubator-inlong/issues/1877) | [Improve] improve the document's format for the office website
| [INLONG-1886](https://github.com/apache/incubator-inlong/issues/1886) | [Improve][InLong-Manager] Refactor and delete unused entities
| [INLONG-1916](https://github.com/apache/incubator-inlong/issues/1916) | [Improve][website] modify the Business to InLong Group
| [INLONG-1934](https://github.com/apache/incubator-inlong/issues/1934) | [Improve] update the image of the hive example after the bid changed
| [INLONG-1935](https://github.com/apache/incubator-inlong/issues/1935) | [Improve] package the SQL file for the manager
| [INLONG-1939](https://github.com/apache/incubator-inlong/issues/1939) | [Improve] add basic concepts for InLong
| [INLONG-1952](https://github.com/apache/incubator-inlong/issues/1952) | [Improve] Update the office website structure image
| [INLONG-1987](https://github.com/apache/incubator-inlong/issues/1987) | [Improve] Add function comment information in TubeMQ
| [INLONG-2017](https://github.com/apache/incubator-inlong/issues/2017) | [Improve] Add more guide documents for Pulsar

### BUG FIXES:
| ISSUE  | Summary  |
| :---- | :------- |
| [INLONG-1706](https://github.com/apache/incubator-inlong/issues/1706) | [Bug] there are some incorrect expressions for issues tracking in the how-to-contribute file
| [INLONG-1716](https://github.com/apache/incubator-inlong/issues/1716) | [Bug][manager] can not login successfully
| [INLONG-1731](https://github.com/apache/incubator-inlong/issues/1731) | [Bug] release template has sth wrong with KEY URL
| [INLONG-1745](https://github.com/apache/incubator-inlong/issues/1745) | [Bug]TubeMQ HTTP API download link cannot be opened
| [INLONG-1752](https://github.com/apache/incubator-inlong/issues/1752) | [Bug] The official website action failed to build, it may be that the node version needs to be upgraded
| [INLONG-1754](https://github.com/apache/incubator-inlong/issues/1754) | [Bug] confused navigation in download page
| [INLONG-1755](https://github.com/apache/incubator-inlong/issues/1755) | [Bug] Broken link in the ANNOUNCE email template
| [INLONG-1769](https://github.com/apache/incubator-inlong/issues/1769) | [Bug][TubeMQ]Util function SpitToMap in Go SDK panic
| [INLONG-1771](https://github.com/apache/incubator-inlong/issues/1771) | [Bug] Website readme error
| [INLONG-1776](https://github.com/apache/incubator-inlong/issues/1776) | [Bug] Get error while parse td msg with go client
| [INLONG-1777](https://github.com/apache/incubator-inlong/issues/1777) | [Bug][TubeMQ]Go SDK failed to parse tdmsg v4
| [INLONG-1781](https://github.com/apache/incubator-inlong/issues/1781) | [Bug] Get uncorrect time value of attributes
| [INLONG-1783](https://github.com/apache/incubator-inlong/issues/1783) | [Bug] Topic filters config has't any effects
| [INLONG-1828](https://github.com/apache/incubator-inlong/issues/1828) | [Bug]parse message error: invalid default attr's msg Length
| [INLONG-1876](https://github.com/apache/incubator-inlong/issues/1876) | [Bug] office website build failed
| [INLONG-1897](https://github.com/apache/incubator-inlong/issues/1897) | [Bug][Website] form cannot use chain name
| [INLONG-1898](https://github.com/apache/incubator-inlong/issues/1898) | [Bug][Website] The error of the person responsible for the second edit of the new consumption
| [INLONG-1902](https://github.com/apache/incubator-inlong/issues/1902) | [Bug][Website] Access create params error
| [INLONG-1911](https://github.com/apache/incubator-inlong/issues/1911) | [Bug] Some questions about the metric implementation in the common module
| [INLONG-1915](https://github.com/apache/incubator-inlong/issues/1915) | [Bug] tubemq master can not start
| [INLONG-1919](https://github.com/apache/incubator-inlong/issues/1919) | [Bug] TubeMQ HTTP API xls can not download
| [INLONG-1920](https://github.com/apache/incubator-inlong/issues/1920) | [Bug]Failed to start up MultiSession factory by following the demo code
| [INLONG-1953](https://github.com/apache/incubator-inlong/issues/1953) | [Bug]It can not be submitted when I create data access using file data source
| [INLONG-1954](https://github.com/apache/incubator-inlong/issues/1954) | [Bug]inlong-sort does not support pulsar ???
| [INLONG-1955](https://github.com/apache/incubator-inlong/issues/1955) | [Bug]Source data fields' type are all mapped to tinyint, and can not be modified
| [INLONG-1958](https://github.com/apache/incubator-inlong/issues/1958) | [Bug]Avoid the security risks of log4j package
| [INLONG-1966](https://github.com/apache/incubator-inlong/issues/1966) | [Bug][InLong-Manager] The stream name field is not required, but error occurs when create a data stream with name field not filled
| [INLONG-1967](https://github.com/apache/incubator-inlong/issues/1967) | [Bug][InLong-Manager] Cannot create the Pulsar subscription
| [INLONG-1973](https://github.com/apache/incubator-inlong/issues/1973) | [Bug]with the demo conf of dataproxy, the app can not start rightly
| [INLONG-1975](https://github.com/apache/incubator-inlong/issues/1975) | [Bug]error occurs when deleting a data access
| [INLONG-1978](https://github.com/apache/incubator-inlong/issues/1978) | [Bug]Create multiple file import tasks, and inlong-agent reports an error when registering metric
| [INLONG-1980](https://github.com/apache/incubator-inlong/issues/1980) | [Bug]the content of topics.properties generated incorrectly，and too much backup files generate automatically
| [INLONG-1981](https://github.com/apache/incubator-inlong/issues/1981) | [Bug] When compiling the project, the InLong-audit module reported Warning errors
| [INLONG-1984](https://github.com/apache/incubator-inlong/issues/1984) | [Bug][InLong-Manager] Create pulsar access, modify pulsar related parameters failed
| [INLONG-1995](https://github.com/apache/incubator-inlong/issues/1995) | [Bug] Compile Audit-SDK and report TestNGException
| [INLONG-1996](https://github.com/apache/incubator-inlong/issues/1996) | [Bug] Compile the project and InLong-Agent module throws 3 exceptions
| [INLONG-1997](https://github.com/apache/incubator-inlong/issues/1997) | [Bug]after the compilation of inlong, no lib directory in inlong-dataproxy
| [INLONG-2009](https://github.com/apache/incubator-inlong/issues/2009) | [Bug]Topic obtained through "/api/inlong/manager/openapi/dataproxy/getConfig" is not right
| [INLONG-2012](https://github.com/apache/incubator-inlong/issues/2012) | [Bug] Inlong-agent could not fetch file agent task through api --"/api/inlong/manager/openapi/agent/fileAgent/getTaskConf"
| [INLONG-2014](https://github.com/apache/incubator-inlong/issues/2014) | [Bug]inlong-dataproxy could not identify the groupId and topic format of topics.properties
| [INLONG-2018](https://github.com/apache/incubator-inlong/issues/2018) | [Bug]after approving a data access, some failures happen and the data access is always in the state of configuration
| [INLONG-2020](https://github.com/apache/incubator-inlong/issues/2020) | [Bug] Dependency of "jul-to-slf4j" is missing for pulsar connector
| [INLONG-2023](https://github.com/apache/incubator-inlong/issues/2023) | [Bug] Agent stream id is not passed to proxy
| [INLONG-2026](https://github.com/apache/incubator-inlong/issues/2026) | [Bug] Found Pulsar client create failure when starting Sort
| [INLONG-2030](https://github.com/apache/incubator-inlong/issues/2030) | [Bug]inlong-agent raises NPE error when running
| [INLONG-2032](https://github.com/apache/incubator-inlong/issues/2032) | [Bug]"javax.xml.parsers.FactoryConfigurationError" throwed in flink when starting a inlong-sort job
| [INLONG-2035](https://github.com/apache/incubator-inlong/issues/2035) | [Bug] Agent use wrong tid __ to generate message
| [INLONG-2038](https://github.com/apache/incubator-inlong/issues/2038) | [Bug]inlong-sort abandon data from pulsar due to an ClassCastException
| [INLONG-2043](https://github.com/apache/incubator-inlong/issues/2043) | [Bug] Sort module renames tid to streamId


## Release 0.11.0-incubating - Released (as of 2021-10-25)

### FEATURES:
| ISSUE  | Summary  |
| :---- | :------- |
| [INLONG-624](https://github.com/apache/incubator-inlong/issues/624) | [Feature] Go SDK support for TubeMQ
| [INLONG-1308](https://github.com/apache/incubator-inlong/issues/1308) | [Feature] Support Deploying All Modules on Kubernetes
| [INLONG-1330](https://github.com/apache/incubator-inlong/issues/1330) | [Feature] DataProxy support Pulsar
| [INLONG-1631](https://github.com/apache/incubator-inlong/issues/1631) | [Feature] [office-website] Refactor incubator-inlong-website by docusaurus

### IMPROVEMENTS:
| ISSUE  | Summary  |
| :---- | :------- |
| [INLONG-1324](https://github.com/apache/incubator-inlong/issues/1324) | [Improve] [Manager] The consumption details should be refreshed after editing successfully
| [INLONG-1327](https://github.com/apache/incubator-inlong/issues/1327) | [Improve] [Manager] Supports pagi`ng query for workflow execution log
| [INLONG-1578](https://github.com/apache/incubator-inlong/issues/1570) | [Improve] Go SDK should provide a more elegant way to set the parameter of config`
| [INLONG-1571](https://github.com/apache/incubator-inlong/issues/1571) | [Improve] [CI] Check License Heade
| [INLONG-1584](https://github.com/apache/incubator-inlong/issues/1584) | [Improve] TDMsg Decode Support For Go SDK
| [INLONG-1585](https://github.com/apache/incubator-inlong/issues/1585) | [Improve] Improve issue template with issue forms
| [INLONG-1589](https://github.com/apache/incubator-inlong/issues/1589) | [Improve] [Manager] Manager provide an openapi of DataProxy configuration data for multi-subcluster
| [INLONG-1593](https://github.com/apache/incubator-inlong/issues/1593) | [Improve] Add EmptyLineSeparator java code checkstyle rule
| [INLONG-1595](https://github.com/apache/incubator-inlong/issues/1595) | [Improve] inlong-dataproxy start by the configuration data from inlong-manager
| [INLONG-1623](https://github.com/apache/incubator-inlong/issues/1602) | [Improve] Optimize EntityStatus enum
| [INLONG-1619](https://github.com/apache/incubator-inlong/issues/1619) | [Improve] Add improve suggestion template
| [INLONG-1611](https://github.com/apache/incubator-inlong/issues/1611) | [Improve] Enable Merge Button
| [INLONG-1623](https://github.com/apache/incubator-inlong/issues/1623) | [Improve] add contribution guide document for the main repo
| [INLONG-1626](https://github.com/apache/incubator-inlong/issues/1626) | [Improve] [office-website] Agent introduce a Message filter
| [INLONG-1628](https://github.com/apache/incubator-inlong/issues/1628) | [Improve] Remove commitlint in package.json
| [INLONG-1629](https://github.com/apache/incubator-inlong/issues/1629) | [Improve] Disable merge commit
| [INLONG-1632](https://github.com/apache/incubator-inlong/issues/1632) | [Improve] [office-website] Refactoring of basic projects
| [INLONG-1633](https://github.com/apache/incubator-inlong/issues/1633) | [Improve] [office-website] Migrate modules documentation
| [INLONG-1634](https://github.com/apache/incubator-inlong/issues/1634) | [Improve] [office-website] Migrate download documentation
| [INLONG-1635](https://github.com/apache/incubator-inlong/issues/1635) | [Improve] [office-website] Migrate development documentation
| [INLONG-1636](https://github.com/apache/incubator-inlong/issues/1636) | [Improve] [office-website] Replace the default language selection icon
| [INLONG-1637](https://github.com/apache/incubator-inlong/issues/1637) | [Improve] [office-website] Add docusaurus i18n docs
| [INLONG-1638](https://github.com/apache/incubator-inlong/issues/1638) | [Improve] [office-website] Adapt new github action command
| [INLONG-1641](https://github.com/apache/incubator-inlong/issues/1641) | [Improve] [Agent] Agent introduce a Message filter
| [INLONG-1642](https://github.com/apache/incubator-inlong/issues/1642) | [Improve] [Agent] Agent Use Message filter to get tid from different lines in a file
| [INLONG-1650](https://github.com/apache/incubator-inlong/issues/1650) | [Improve] [TubeMQ] Provide a more elegant way to define config address
| [INLONG-1662](https://github.com/apache/incubator-inlong/issues/1662) | [Improve] [GitHub] Improve issue templates
| [INLONG-1666](https://github.com/apache/incubator-inlong/issues/1666) | [Improve] [TubeMQ] README for Go SDK
| [INLONG-1668](https://github.com/apache/incubator-inlong/issues/1668) | [Improve] [office-website] Adapt quick edit link
| [INLONG-1669](https://github.com/apache/incubator-inlong/issues/1669) | [Improve] [office-website] Adapt docusaurus build command
| [INLONG-1670](https://github.com/apache/incubator-inlong/issues/1670) | [Improve] [Manager] Add H2 in UT
| [INLONG-1680](https://github.com/apache/incubator-inlong/issues/1680) | [Improve] [doc] remove the redundant download links
| [INLONG-1682](https://github.com/apache/incubator-inlong/issues/1682) | [Improve] [TubeMQ] New Go module for Go SDK
| [INLONG-1699](https://github.com/apache/incubator-inlong/issues/1699) | [Improve] [doc] add a correct interpretation for InLong
| [INLONG-1701](https://github.com/apache/incubator-inlong/issues/1701) | [Improve] [InLong-Manager] Adjust unit tests

### BUG FIXES:
| ISSUE  | Summary  |
| :---- | :------- |
| [INLONG-1498](https://github.com/apache/incubator-inlong/issues/1498) | ignore the files with versionsBackup suffix for the bumped version
| [INLONG-1507](https://github.com/apache/incubator-inlong/issues/1507) | Go Client should reconnect to server if the server is shutdown and restarted
| [INLONG-1509](https://github.com/apache/incubator-inlong/issues/1509) | duplicate issues be counted in CHANGES.md
| [INLONG-1511](https://github.com/apache/incubator-inlong/issues/1511) | release guild documents has some errors
| [INLONG-1514](https://github.com/apache/incubator-inlong/issues/1514) | the license header is not correct for inlong-website/nginx.conf
| [INLONG-1525](https://github.com/apache/incubator-inlong/issues/1525) | Go SDK fail to parse SubscribeInfo
| [INLONG-1527](https://github.com/apache/incubator-inlong/issues/1527) | GoSDK should throw error if it fail to connect to master
| [INLONG-1529](https://github.com/apache/incubator-inlong/issues/1529) | Go SDK should reset heartbeat if register to master successfully
| [INLONG-1531](https://github.com/apache/incubator-inlong/issues/1531) | Go SDK should init the flow control item of the partition
| [INLONG-1533](https://github.com/apache/incubator-inlong/issues/1533) | Go SDK should provide more example
| [INLONG-1535](https://github.com/apache/incubator-inlong/issues/1535) | Go SDK should be closed before stopping the event processing goroutine
| [INLONG-1538](https://github.com/apache/incubator-inlong/issues/1538) | TubeMQ reports the error "Topic xxx not publish" when producing data
| [INLONG-1550](https://github.com/apache/incubator-inlong/issues/1550) | Go SDK should obey the flow control rule
| [INLONG-1552](https://github.com/apache/incubator-inlong/issues/1552) | Java SDK should deal with the default flow control rule
| [INLONG-1553](https://github.com/apache/incubator-inlong/issues/1553) | migrate the user manual documents at first class
| [INLONG-1554](https://github.com/apache/incubator-inlong/issues/1554) | remove the Console Introduction for manager
| [INLONG-1555](https://github.com/apache/incubator-inlong/issues/1555) | Go SDK should record the consumer config to the log
| [INLONG-1558](https://github.com/apache/incubator-inlong/issues/1558) | Go SDK should provide a multi goroutine consumer example
| [INLONG-1560](https://github.com/apache/incubator-inlong/issues/1560) | C++ SDK can not return error code of PartInUse and PartWaiting correctly
| [INLONG-1562](https://github.com/apache/incubator-inlong/issues/1562) | [K8s] There are some syntax bugs and configuration bugs in helm chart
| [INLONG-1563](https://github.com/apache/incubator-inlong/issues/1563) | Go SDK can not stop the heartbeat timer after the consumer has been closed
| [INLONG-1566](https://github.com/apache/incubator-inlong/issues/1566) | The user defined partition offset of Go SDK can not take effect
| [INLONG-1568](https://github.com/apache/incubator-inlong/issues/1568) | C++ SDK cant not return the whether the partition has been registered correctly
| [INLONG-1569](https://github.com/apache/incubator-inlong/issues/1569) | The first_registered is not the same with its naming
| [INLONG-1573](https://github.com/apache/incubator-inlong/issues/1573) | Add TDMsg decode logic to TubeMQ's C++ SDK
| [INLONG-1575](https://github.com/apache/incubator-inlong/issues/1575) | Modify the download url of version 0.9.0
| [INLONG-1579](https://github.com/apache/incubator-inlong/issues/1579) | lots of files are not standard License Header
| [INLONG-1581](https://github.com/apache/incubator-inlong/issues/1581) | InLong's website does not work without Javascript
| [INLONG-1587](https://github.com/apache/incubator-inlong/issues/1587) | Fix compile error
| [INLONG-1592](https://github.com/apache/incubator-inlong/issues/1592) | TextFileReader: The cpu utilization rate is very high, nearly 50%
| [INLONG-1600](https://github.com/apache/incubator-inlong/issues/1600) | There are some YAML errors in bug report and feature request issue forms
| [INLONG-1604](https://github.com/apache/incubator-inlong/issues/1604) | Some resultType is wrong in mapper
| [INLONG-1607](https://github.com/apache/incubator-inlong/issues/1607) | The master version should be added in the bug-report.yml
| [INLONG-1614](https://github.com/apache/incubator-inlong/issues/1614) | dataProxyConfigRepository constructor error
| [INLONG-1617](https://github.com/apache/incubator-inlong/issues/1617) | Ignore mysql directory after run docker compose
| [INLONG-1621](https://github.com/apache/incubator-inlong/issues/1621) | RestTemplateConfig cannot load config from properties
| [INLONG-1625](https://github.com/apache/incubator-inlong/issues/1625) | some page links are not available for Contribution Guide
| [INLONG-1645](https://github.com/apache/incubator-inlong/issues/1645) | [Bug] Druid datasource is not used
| [INLONG-1665](https://github.com/apache/incubator-inlong/issues/1665) | Adjust the content of the document title
| [INLONG-1673](https://github.com/apache/incubator-inlong/issues/1673) | some links are not available after office-website refactored
| [INLONG-1676](https://github.com/apache/incubator-inlong/issues/1676) | two recent PRs were overwritten after the office-website refactored
| [INLONG-1677](https://github.com/apache/incubator-inlong/issues/1677) | the architecture picture is lost in README
| [INLONG-1685](https://github.com/apache/incubator-inlong/issues/1685) | the Chinese Quick Start Guide has some incorrect place after the office-webiste refactored
| [INLONG-1694](https://github.com/apache/incubator-inlong/issues/1694) | Build docker mirror error for TubeMQ C++
| [INLONG-1695](https://github.com/apache/incubator-inlong/issues/1695) | [Bug][DataProxy] Build failed

## Release 0.10.0-incubating - Released (as of 2021-09-01)

### IMPROVEMENTS:
| ISSUE  | Summary  |
| :---- | :------- |
| [INLONG-570](https://issues.apache.org/jira/browse/INLONG-570) | Optimizing the implementations of HTTP API for Master
| [INLONG-726](https://issues.apache.org/jira/browse/INLONG-726) | Optimize The Deployment For InLong
| [INLONG-732](https://issues.apache.org/jira/browse/INLONG-732) | Optimize the CI/CD workflow for build and integration test
| [INLONG-733](https://issues.apache.org/jira/browse/INLONG-733) | Unity the Manger-API/Manger-OpenAPI, and change Manager-API to Manager-Web
| [INLONG-744](https://issues.apache.org/jira/browse/INLONG-744) | Error log, should use log4j
| [INLONG-750](https://issues.apache.org/jira/browse/INLONG-750) | Add configuration descriptions for 'defEthName' in 'broker.ini'
| [INLONG-756](https://issues.apache.org/jira/browse/INLONG-756) | package start.sh script executable for agent
| [INLONG-768](https://issues.apache.org/jira/browse/INLONG-768) | add github pull request template
| [INLONG-789](https://issues.apache.org/jira/browse/INLONG-789) | make agent readme more friendly
| [INLONG-792](https://issues.apache.org/jira/browse/INLONG-792) | tubemanager add a cluster after configuration
| [INLONG-800](https://issues.apache.org/jira/browse/INLONG-800) | Fix codestyle of some comments and methods names.
| [INLONG-804](https://issues.apache.org/jira/browse/INLONG-804) | Optimize the ASF Configuration
| [INLONG-805](https://issues.apache.org/jira/browse/INLONG-805) | Migrate InLong Issues from JIRA to GitHub
| [INLONG-808](https://issues.apache.org/jira/browse/INLONG-808) | Missing dataproxy sdk readme
| [INLONG-809](https://issues.apache.org/jira/browse/INLONG-809) | dataproxy readme delete reference url
| [INLONG-1498](https://github.com/apache/incubator-inlong/issues/1498) |  ignore the files with versionsBackup suffix for the bumped version
| [INLONG-1487](https://github.com/apache/incubator-inlong/issues/1487) |  remove the user number limit  when create a new data stream
| [INLONG-1486](https://github.com/apache/incubator-inlong/issues/1486) |  [agent] update the document about configuring the dataprxy address
| [INLONG-1485](https://github.com/apache/incubator-inlong/issues/1485) |  [sort] add the guide documents for using Pulsar
| [INLONG-1484](https://github.com/apache/incubator-inlong/issues/1484) |  Bid and Tid is not well explained in agent and might cause send error
| [INLONG-1464](https://github.com/apache/incubator-inlong/issues/1464) |  Add code CheckStyle rules
| [INLONG-1459](https://github.com/apache/incubator-inlong/issues/1459) |  proxy address configuration is redundant for inlong-agent
| [INLONG-1457](https://github.com/apache/incubator-inlong/issues/1457) |  remove the user limit for creating a new data access
| [INLONG-1455](https://github.com/apache/incubator-inlong/issues/1455) |  add a script to publish docker images
| [INLONG-1443](https://github.com/apache/incubator-inlong/issues/1443) |   Provide management interface SDK
| [INLONG-1439](https://github.com/apache/incubator-inlong/issues/1439) |  Add the port legal check and remove the useless deleteWhen field
| [INLONG-1430](https://github.com/apache/incubator-inlong/issues/1430) |  Go SDK example
| [INLONG-1429](https://github.com/apache/incubator-inlong/issues/1429) |  update the asf config for inlong office website
| [INLONG-1427](https://github.com/apache/incubator-inlong/issues/1427) |  Go SDK return maxOffset and updateTime in ConsumerOffset
| [INLONG-1424](https://github.com/apache/incubator-inlong/issues/1424) |  change the format of the configuration file: make the yaml to properties
| [INLONG-1423](https://github.com/apache/incubator-inlong/issues/1423) |  modify the docker image of the inlong-manager module
| [INLONG-1417](https://github.com/apache/incubator-inlong/issues/1417) |  rename the distribution file for inlong
| [INLONG-1415](https://github.com/apache/incubator-inlong/issues/1415) |  [TubeMQ Docker] expose zookeeper port for other component usages
| [INLONG-1409](https://github.com/apache/incubator-inlong/issues/1409) |  Sort out the LICENSE information of the 3rd-party components that the DataProxy submodule depends on
| [INLONG-1407](https://github.com/apache/incubator-inlong/issues/1407) |  [DataProxy]Adjust the pom dependency of the DataProxy module
| [INLONG-1405](https://github.com/apache/incubator-inlong/issues/1405) |  too many issues mail at dev@inlong mailbox

### BUG FIXES:
| ISSUE  | Summary  |
| :---- | :------- |
| [INLONG-751](https://issues.apache.org/jira/browse/INLONG-751) | InLong Manager start up error
| [INLONG-776](https://issues.apache.org/jira/browse/INLONG-776) | fix the version error for tubemq cpp client docker image
| [INLONG-777](https://issues.apache.org/jira/browse/INLONG-777) | InLong Manager new data stream error
| [INLONG-782](https://issues.apache.org/jira/browse/INLONG-782) | Optimize The PULL_REQUEST_TEMPLATE
| [INLONG-787](https://issues.apache.org/jira/browse/INLONG-787) | The actions "reviewdog/action-setup" is not allowed to be used
| [INLONG-797](https://issues.apache.org/jira/browse/INLONG-797) | the document for deployment DataProxy is not complete
| [INLONG-799](https://issues.apache.org/jira/browse/INLONG-799) | can not find common.properties for dataproxy
| [INLONG-1488](https://github.com/apache/incubator-inlong/issues/1488) |  there are still some chinese characters for website
| [INLONG-1475](https://github.com/apache/incubator-inlong/issues/1475) |  Tube manager compile ch.qos.logback with error
| [INLONG-1474](https://github.com/apache/incubator-inlong/issues/1474) |  the interface of get data proxy configurations got abnormal status result
| [INLONG-1470](https://github.com/apache/incubator-inlong/issues/1470) |  Java.util.ConcurrentModificationException error when rebalance
| [INLONG-1468](https://github.com/apache/incubator-inlong/issues/1468) |  The update interval of dataproxy is quite long and may cause produce error when config is not updated
| [INLONG-1466](https://github.com/apache/incubator-inlong/issues/1466) |  get snappy error when the agent collecting data
| [INLONG-1462](https://github.com/apache/incubator-inlong/issues/1462) |  dataproxy can not create configuration properties successfully in the docker container
| [INLONG-1458](https://github.com/apache/incubator-inlong/issues/1458) |  The http port in agent readme should be 8008 to be consistent with the code
| [INLONG-1453](https://github.com/apache/incubator-inlong/issues/1453) |  agent connect dataproxy fail when using docker-compose
| [INLONG-1448](https://github.com/apache/incubator-inlong/issues/1448) |  The Manager throws an exception when creating a business
| [INLONG-1447](https://github.com/apache/incubator-inlong/issues/1447) |  Fix Group Control API logic bug
| [INLONG-1444](https://github.com/apache/incubator-inlong/issues/1444) |  Fix Web API multiple field search logic bug
| [INLONG-1441](https://github.com/apache/incubator-inlong/issues/1441) |  Repair Broker configuration API bugs
| [INLONG-1436](https://github.com/apache/incubator-inlong/issues/1436) |  [CI] The checkstyle workflow is redundant
| [INLONG-1432](https://github.com/apache/incubator-inlong/issues/1432) |  The manager url of agent and dataproxy need to be updated since manager merged openapi and api into one module
| [INLONG-1403](https://github.com/apache/incubator-inlong/issues/1403) |  fix some error in dataproxy-sdk readme

### SUB-TASK:
| ISSUE  | Summary  |
| :---- | :------- |
| [INLONG-576](https://issues.apache.org/jira/browse/INLONG-576) | Build metadata entity classes
| [INLONG-578](https://issues.apache.org/jira/browse/INLONG-578) | Build implementation classes based on BDB storage
| [INLONG-579](https://issues.apache.org/jira/browse/INLONG-579) | Add structure mapping of BDB and metadata entity classes
| [INLONG-580](https://issues.apache.org/jira/browse/INLONG-580) | Build active and standby keep-alive services
| [INLONG-581](https://issues.apache.org/jira/browse/INLONG-581) | Add data cache in BDB metadata Mapper implementations
| [INLONG-582](https://issues.apache.org/jira/browse/INLONG-582) | Adjust the business logic related to the BdbClusterSettingEntity class
| [INLONG-583](https://issues.apache.org/jira/browse/INLONG-583) | Adjust BrokerConfManager class implementation
| [INLONG-584](https://issues.apache.org/jira/browse/INLONG-584) | Adjust WebMasterInfoHandler class implementation
| [INLONG-593](https://issues.apache.org/jira/browse/INLONG-593) | Add WebGroupConsumeCtrlHandler class implementation
| [INLONG-595](https://issues.apache.org/jira/browse/INLONG-595) | Add WebBrokerConfHandler class implementation
| [INLONG-596](https://issues.apache.org/jira/browse/INLONG-596) | Add WebTopicConfHandler class implementation
| [INLONG-597](https://issues.apache.org/jira/browse/INLONG-597) | Adjust WebTopicCtrlHandler class implementation
| [INLONG-598](https://issues.apache.org/jira/browse/INLONG-598) | Adjust WebTopicCtrlHandler class implementation
| [INLONG-599](https://issues.apache.org/jira/browse/INLONG-599) | Adjust WebParameterUtils.java's static functions
| [INLONG-601](https://issues.apache.org/jira/browse/INLONG-601) | Adjust WebBrokerDefConfHandler class implementation
| [INLONG-602](https://issues.apache.org/jira/browse/INLONG-602) | Add replacement processing after metadata changes
| [INLONG-611](https://issues.apache.org/jira/browse/INLONG-611) | Add FSM for broker configure manage
| [INLONG-617](https://issues.apache.org/jira/browse/INLONG-617) | Add unit tests for WebParameterUtils
| [INLONG-618](https://issues.apache.org/jira/browse/INLONG-618) | Add unit tests for metastore.dao.entity.*
| [INLONG-625](https://issues.apache.org/jira/browse/INLONG-625) | Add unit tests for metamanage.metastore.impl.*
| [INLONG-626](https://issues.apache.org/jira/browse/INLONG-626) | Fix broker and topic confiugre implement bugs
| [INLONG-707](https://issues.apache.org/jira/browse/INLONG-707) | Bumped version to 0.10.0-SNAPSHOT
| [INLONG-740](https://issues.apache.org/jira/browse/INLONG-740) | Merge the changes in INLONG-739 to master and delete the temporary branch
| [INLONG-755](https://issues.apache.org/jira/browse/INLONG-755) | Go SDK Consumer Result
| [INLONG-757](https://issues.apache.org/jira/browse/INLONG-757) | fix the artifactId of dataproxy
| [INLONG-758](https://issues.apache.org/jira/browse/INLONG-758) | remove redundant baseDirectory for manager output files
| [INLONG-759](https://issues.apache.org/jira/browse/INLONG-759) | fix assembly issue for TubeMQ manager
| [INLONG-760](https://issues.apache.org/jira/browse/INLONG-760) | standardize the directories name for the sort sub-module
| [INLONG-761](https://issues.apache.org/jira/browse/INLONG-761) | unify all modules target files to a singe directory
| [INLONG-762](https://issues.apache.org/jira/browse/INLONG-762) | refactor the deployment document
| [INLONG-763](https://issues.apache.org/jira/browse/INLONG-763) | make the inlong-websit be a maven module of InLong project
| [INLONG-764](https://issues.apache.org/jira/browse/INLONG-764) | Fix Go SDK RPC Request bug
| [INLONG-766](https://issues.apache.org/jira/browse/INLONG-766) | Fix Go SDK Codec Bug
| [INLONG-770](https://issues.apache.org/jira/browse/INLONG-770) | update the readme document
| [INLONG-771](https://issues.apache.org/jira/browse/INLONG-771) | Fix Go SDK Authorization Bug
| [INLONG-773](https://issues.apache.org/jira/browse/INLONG-773) | add manager docker image
| [INLONG-774](https://issues.apache.org/jira/browse/INLONG-774) | update TubeMQ docker images to InLong repo
| [INLONG-778](https://issues.apache.org/jira/browse/INLONG-778) | Fix Go SDK Consumer Bug
| [INLONG-779](https://issues.apache.org/jira/browse/INLONG-779) | update tubemq manager docker image
| [INLONG-781](https://issues.apache.org/jira/browse/INLONG-781) | add inlong agent docker image support
| [INLONG-784](https://issues.apache.org/jira/browse/INLONG-784) | Fix Go SDK Heartbeat Bug
| [INLONG-785](https://issues.apache.org/jira/browse/INLONG-785) | Fix Go SDK Metadata Bug
| [INLONG-786](https://issues.apache.org/jira/browse/INLONG-786) | add dataproxy docker image
| [INLONG-788](https://issues.apache.org/jira/browse/INLONG-788) | Fix Go SDK Remote Cache Bug
| [INLONG-791](https://issues.apache.org/jira/browse/INLONG-791) | Go SDK Support multiple topic address
| [INLONG-793](https://issues.apache.org/jira/browse/INLONG-793) | Fix Some Corner Case in Go SDK
| [INLONG-794](https://issues.apache.org/jira/browse/INLONG-794) | add website docker image
| [INLONG-803](https://issues.apache.org/jira/browse/INLONG-803) | add docker requirement for building InLong
| [INLONG-806](https://issues.apache.org/jira/browse/INLONG-806) | open GitHub Issue For InLong
| [INLONG-807](https://issues.apache.org/jira/browse/INLONG-807) | migrate issue history to inlong
| [INLONG-1491](https://github.com/apache/incubator-inlong/issues/1491) |  Add 0.10.0 version release modification to CHANGES.md
| [INLONG-1492](https://github.com/apache/incubator-inlong/issues/1492) |  Bumped version to 0.11.0-incubating-SNAPSHOT
| [INLONG-1493](https://github.com/apache/incubator-inlong/issues/1493) |  Modify download&release notes for 0.10.0
| [INLONG-1494](https://github.com/apache/incubator-inlong/issues/1494) |  Adjust the version information of all pom.xml to 0.10.0-incubating
| [INLONG-1495](https://github.com/apache/incubator-inlong/issues/1495) |  Update Office website content for release 0.10.0
| [INLONG-1496](https://github.com/apache/incubator-inlong/issues/1496) |  Release InLong 0.10.0
| [INLONG-1497](https://github.com/apache/incubator-inlong/issues/1497) |  create a 0.10.0 branch to release
| [INLONG-1502](https://github.com/apache/incubator-inlong/issues/1502) |  publish all 0.10.0 images to docker hub

## Release 0.9.0-incubating - Released (as of 2021-07-11)

### IMPROVEMENTS:
| JIRA  | Summary  | Priority |
| :---- | :------- | :------- |
| [INLONG-594](https://issues.apache.org/jira/browse/INLONG-594) | Trpc-go  tube sdk strongly rely on local config  | Major |
| [INLONG-616](https://issues.apache.org/jira/browse/INLONG-616) | Adjust the content in .asf.yaml according to the new project name  | Major |
| [INLONG-651](https://issues.apache.org/jira/browse/INLONG-651) | Refine the tubemq-client-cpp build description  | Major |
| [INLONG-655](https://issues.apache.org/jira/browse/INLONG-655) | add dependency in tube-manager  | Major |
| [INLONG-656](https://issues.apache.org/jira/browse/INLONG-656) | fix tubemanager start.sh  | Major |
| [INLONG-657](https://issues.apache.org/jira/browse/INLONG-657) | remove some test cases in agent  | Major |
| [INLONG-659](https://issues.apache.org/jira/browse/INLONG-659) | fix unit test in agent  | Major |
| [INLONG-666](https://issues.apache.org/jira/browse/INLONG-666) | change tar name in agent  | Major |
| [INLONG-697](https://issues.apache.org/jira/browse/INLONG-697) | fix decode error in proxySdk  | Major |
| [INLONG-705](https://issues.apache.org/jira/browse/INLONG-705) | add stop.sh in dataproxy  | Major |
| [INLONG-743](https://issues.apache.org/jira/browse/INLONG-743) | Adjust the rat check setting of the pom.xml  | Major |

### BUG FIXES:
| JIRA  | Summary  | Priority |
| :---- | :------- | :------- |
| [INLONG-577](https://issues.apache.org/jira/browse/INLONG-577) | reload status output and topic config output mismatch | Major |
| [INLONG-612](https://issues.apache.org/jira/browse/INLONG-612) | Restful api "admin_snapshot_message" is not compatible with the old version | Major |
| [INLONG-638](https://issues.apache.org/jira/browse/INLONG-638) | Issues About Disk Error recovery | Major |
| [INLONG-688](https://issues.apache.org/jira/browse/INLONG-688) | change additionstr to additionAtr in agent | Major |
| [INLONG-703](https://issues.apache.org/jira/browse/INLONG-703) | Query after adding a consumer group policy and report a null error | Major |
| [INLONG-724](https://issues.apache.org/jira/browse/INLONG-724) | Encountered a symbol not found error when compiling | Major |

### TASK:
| JIRA | Summary | Priority |
|:---- |:---- | :--- |
| [INLONG-613](https://issues.apache.org/jira/browse/INLONG-613) | Adjust the project codes according to the renaming requirements  | Major |

### SUB-TASK:
| JIRA  | Summary  | Priority |
| :---- | :------- | :------- |
| [INLONG-519](https://issues.apache.org/jira/browse/INLONG-519) | Bumped version to 0.9.0-SNAPSHOT | Major |
| [INLONG-565](https://issues.apache.org/jira/browse/INLONG-565) | Replace simple scripts and code implementation | Major |
| [INLONG-571](https://issues.apache.org/jira/browse/INLONG-571) | Adjust WebOtherInfoHandler class implementation | Major |
| [INLONG-573](https://issues.apache.org/jira/browse/INLONG-573) | Adjust WebAdminFlowRuleHandler class implementation | Major |
| [INLONG-574](https://issues.apache.org/jira/browse/INLONG-574) | Adjust WebAdminGroupCtrlHandler class implementation | Major |
| [INLONG-632](https://issues.apache.org/jira/browse/INLONG-632) | Add inlong-manager subdirectory | Major |
| [INLONG-633](https://issues.apache.org/jira/browse/INLONG-633) | Add inlong-sort subdirectory | Major |
| [INLONG-634](https://issues.apache.org/jira/browse/INLONG-634) | Add inlong-tubemq subdirectory | Major |
| [INLONG-635](https://issues.apache.org/jira/browse/INLONG-635) | Add inlong-dataproxy subdirectory | Major |
| [INLONG-636](https://issues.apache.org/jira/browse/INLONG-636) | Add inlong-agent subdirectory | Major |
| [INLONG-640](https://issues.apache.org/jira/browse/INLONG-640) | Adjust the main frame of the InLong project | Major |
| [INLONG-641](https://issues.apache.org/jira/browse/INLONG-641) | Add inlong-common module | Major |
| [INLONG-642](https://issues.apache.org/jira/browse/INLONG-642) | Add inlong-website subdirectory | Major |
| [INLONG-643](https://issues.apache.org/jira/browse/INLONG-643) | Add inlong-dataproxy-sdk subdirectory | Major |
| [INLONG-644](https://issues.apache.org/jira/browse/INLONG-644) | Remove "/dist" from .gitignore and add subdirectory dist in inlong-sort | Major |
| [INLONG-646](https://issues.apache.org/jira/browse/INLONG-646) | Remove time related unit tests until timezone is configurable in inlong-sort | Major |
| [INLONG-647](https://issues.apache.org/jira/browse/INLONG-647) | Adjust the introduction content of the README.md | Major |
| [INLONG-648](https://issues.apache.org/jira/browse/INLONG-648) | Change initial version of inlong-sort to 0.9.0-incubating-SNAPSHOT | Major |
| [INLONG-649](https://issues.apache.org/jira/browse/INLONG-649) | Modify the suffix of the docs/zh-cn/download/release-0.8.0.md file | Major |
| [INLONG-650](https://issues.apache.org/jira/browse/INLONG-650) | Adjust .asf.yaml's label | Major |
| [INLONG-654](https://issues.apache.org/jira/browse/INLONG-654) | Adjust the link in ReadMe.md according to the latest document | Major |
| [INLONG-658](https://issues.apache.org/jira/browse/INLONG-658) | modify the dependency of inlong-manager | Major |
| [INLONG-663](https://issues.apache.org/jira/browse/INLONG-663) | modify the tar package name of inlong-manager | Major |
| [INLONG-667](https://issues.apache.org/jira/browse/INLONG-667) | rename tar in agent | Major |
| [INLONG-673](https://issues.apache.org/jira/browse/INLONG-673) | add tube cluster id in inlong-manager | Major |
| [INLONG-674](https://issues.apache.org/jira/browse/INLONG-674) | adjust HiveSinkInfo in inlong-manager | Major |
| [INLONG-675](https://issues.apache.org/jira/browse/INLONG-675) | modify the npm script of inlong-website | Major |
| [INLONG-676](https://issues.apache.org/jira/browse/INLONG-676) | modify manager-web to manager-api in inlong-manager module | Major |
| [INLONG-677](https://issues.apache.org/jira/browse/INLONG-677) | Support dt as built-in data time partition field in inlong-sort | Major |
| [INLONG-681](https://issues.apache.org/jira/browse/INLONG-681) | modify assembly in agent proxy tubemanager | Major |
| [INLONG-687](https://issues.apache.org/jira/browse/INLONG-687) | set schemaName to m0_day when save business in inlong-manager | Major |
| [INLONG-689](https://issues.apache.org/jira/browse/INLONG-689) | add sort app name | Major |
| [INLONG-691](https://issues.apache.org/jira/browse/INLONG-691) | update properties and scripts for inlong-manager | Major |
| [INLONG-692](https://issues.apache.org/jira/browse/INLONG-692) | remove hive cluster entity in inlong-manager | Major |
| [INLONG-693](https://issues.apache.org/jira/browse/INLONG-693) | change data type to tdmsg | Major |
| [INLONG-694](https://issues.apache.org/jira/browse/INLONG-694) | Add retry mechanism for creating tube consumer group | Major |
| [INLONG-695](https://issues.apache.org/jira/browse/INLONG-695) | update getConfig API in inlong-manager | Major |
| [INLONG-696](https://issues.apache.org/jira/browse/INLONG-696) | modify the status of the entities after approval | Major |
| [INLONG-699](https://issues.apache.org/jira/browse/INLONG-699) | Fix serialization issue of DeserializationInfo 's subType in inlong-sort | Major |
| [INLONG-700](https://issues.apache.org/jira/browse/INLONG-700) | Optimize dependencies in inlong-sort | Major |
| [INLONG-701](https://issues.apache.org/jira/browse/INLONG-701) | Update create resource workflow definition | Major |
| [INLONG-702](https://issues.apache.org/jira/browse/INLONG-702) | sort config field spillter | Major |
| [INLONG-706](https://issues.apache.org/jira/browse/INLONG-706) | Add 0.9.0 version release modification to CHANGES.md | Major |
| [INLONG-709](https://issues.apache.org/jira/browse/INLONG-709) | Adjust the version information of all pom.xml to 0.9.0-incubating | Major |
| [INLONG-712](https://issues.apache.org/jira/browse/INLONG-712) | adjust partition info for hive sink | Major |
| [INLONG-713](https://issues.apache.org/jira/browse/INLONG-713) | add partition filed when create hive table | Major |
| [INLONG-714](https://issues.apache.org/jira/browse/INLONG-714) | Enable checkpointing in inlong-sort | Major |
| [INLONG-715](https://issues.apache.org/jira/browse/INLONG-715) | Make shouldRollOnCheckpoint always return true in DefaultRollingPolicy in inlong-sort | Major |
| [INLONG-716](https://issues.apache.org/jira/browse/INLONG-716) | set terminated symbol when create hive table | Major |
| [INLONG-717](https://issues.apache.org/jira/browse/INLONG-717) | Declare the 3rd party Catagory x LICENSE components in use | Major |


## Release 0.8.0-incubating - Released (as of 2021-01-18)

### IMPROVEMENTS:
| JIRA  | Summary  | Priority |
| :---- | :------- | :------- |
| [INLONG-430](https://issues.apache.org/jira/browse/INLONG-430) | Optimizing the implementation of HTTP API for broke  | Major |
| [INLONG-445](https://issues.apache.org/jira/browse/INLONG-445) | Adjust the status check default sleep interval of pullConsumeReadyChkSliceMs  | Major |
| [INLONG-448](https://issues.apache.org/jira/browse/INLONG-448) | Add Committer and PPMC operation process  | Major |
| [INLONG-449](https://issues.apache.org/jira/browse/INLONG-449) | Adjust Example implementation  | Major |
| [INLONG-452](https://issues.apache.org/jira/browse/INLONG-452) | Optimize rebalance performance | Major |
| [INLONG-467](https://issues.apache.org/jira/browse/INLONG-467) | Add WEB APIs of Master and Broker | Major |
| [INLONG-489](https://issues.apache.org/jira/browse/INLONG-489) | Add the maximum message length parameter setting | Major |
| [INLONG-495](https://issues.apache.org/jira/browse/INLONG-495) | Code implementation adjustment based on SpotBugs check | Major |
| [INLONG-511](https://issues.apache.org/jira/browse/INLONG-511) | Replace the conditional operator (?:) with mid()  | Major |
| [INLONG-512](https://issues.apache.org/jira/browse/INLONG-512) | Add package length control based on Topic  | Major |
| [INLONG-515](https://issues.apache.org/jira/browse/INLONG-515) | Add cluster Topic view web api  | Major |

### BUG FIXES:
| JIRA  | Summary  | Priority |
| :---- | :------- | :------- |
| [INLONG-437](https://issues.apache.org/jira/browse/INLONG-437) | Fix tubemq table source sink factory instance creating problem | Major |
| [INLONG-441](https://issues.apache.org/jira/browse/INLONG-441) | An error occurred when using the Tubemq class to create a sink table | Major |
| [INLONG-442](https://issues.apache.org/jira/browse/INLONG-442) | Modifying the jvm parameters when the broker starts does not take effect  | Major    |
| [INLONG-443](https://issues.apache.org/jira/browse/INLONG-443) | TubemqSourceFunction class prints too many logs problem | Major |
| [INLONG-446](https://issues.apache.org/jira/browse/INLONG-446) | Small bugs fix that do not affect the main logics | Major |
| [INLONG-450](https://issues.apache.org/jira/browse/INLONG-450) | TubeClientException: Generate producer id failed  | Major |
| [INLONG-453](https://issues.apache.org/jira/browse/INLONG-453) | TubemqSourceFunction class prints too many logs problem | Major |
| [INLONG-506](https://issues.apache.org/jira/browse/INLONG-506) | cmakelist error | Major |
| [INLONG-510](https://issues.apache.org/jira/browse/INLONG-510) | Found a bug in MessageProducerExample class | Major |
| [INLONG-518](https://issues.apache.org/jira/browse/INLONG-518) | fix parameter pass error | Major |
| [INLONG-526](https://issues.apache.org/jira/browse/INLONG-526) | Adjust the packaging script and version check list, remove the "-WIP" tag | Major |
| [INLONG-555](https://issues.apache.org/jira/browse/INLONG-555) | short session data can only be written to a specific partition | Major |
| [INLONG-556](https://issues.apache.org/jira/browse/INLONG-556) | Index value is bigger than the actual number of records | Low |


### TASK:
| JIRA | Summary | Priority |
|:---- |:---- | :--- |
| [INLONG-505](https://issues.apache.org/jira/browse/INLONG-505) | Remove the "WIP" label of the DISCLAIMER file  | Major |
| [INLONG-543](https://issues.apache.org/jira/browse/INLONG-543) | Modify the LICENSE statement of multiple files and others  | Major |
| [INLONG-557](https://issues.apache.org/jira/browse/INLONG-557) | Handle the issues mentioned in the 0.8.0-RC2 review  | Major |
| [INLONG-562](https://issues.apache.org/jira/browse/INLONG-562) | Update project contents according to the 0.8.0-RC3 review  | Major |

### SUB-TASK:
| JIRA  | Summary  | Priority |
| :---- | :------- | :------- |
| [INLONG-428](https://issues.apache.org/jira/browse/INLONG-433) | Bumped version to 0.8.0-SNAPSHOT | Major |
| [INLONG-433](https://issues.apache.org/jira/browse/INLONG-433) | add tubemq perf-consumer/producer scripts | Major |
| [INLONG-434](https://issues.apache.org/jira/browse/INLONG-434) | Adjust Broker API mapping | Major |
| [INLONG-435](https://issues.apache.org/jira/browse/INLONG-435) | Create Web field Mapping | Major |
| [INLONG-436](https://issues.apache.org/jira/browse/INLONG-436) | Adjust Broker's HTTP API implementation | Major |
| [INLONG-439](https://issues.apache.org/jira/browse/INLONG-439) | Add Cli field Scheme definition | Major |
| [INLONG-440](https://issues.apache.org/jira/browse/INLONG-440) | Add feature package tube-manager to zip  | Major |
| [INLONG-444](https://issues.apache.org/jira/browse/INLONG-444) | Add consume and produce Cli commands | Major |
| [INLONG-447](https://issues.apache.org/jira/browse/INLONG-447) | Add Broker-Admin Cli | Major |
| [INLONG-451](https://issues.apache.org/jira/browse/INLONG-451) | Replace ConsumeTupleInfo with Tuple2  | Major    |
| [INLONG-457](https://issues.apache.org/jira/browse/INLONG-457) | There is no need to return StringBuilder in Master.java | Major |
| [INLONG-463](https://issues.apache.org/jira/browse/INLONG-463) | Adjust Master rebalance process implementation  | Major |
| [INLONG-464](https://issues.apache.org/jira/browse/INLONG-464) | Add parameter rebalanceParallel in master.ini | Major |
| [INLONG-470](https://issues.apache.org/jira/browse/INLONG-470) | Add query API of TopicName and BrokerId collection  | Major |
| [INLONG-471](https://issues.apache.org/jira/browse/INLONG-471) | Add query API Introduction of TopicName and BrokerId collection | Major |
| [INLONG-472](https://issues.apache.org/jira/browse/INLONG-472) | Adjust Broker's AbstractWebHandler class implementation  | Major |
| [INLONG-475](https://issues.apache.org/jira/browse/INLONG-475) | add the offset clone api of the consume group  | Major |
| [INLONG-482](https://issues.apache.org/jira/browse/INLONG-482) | Add offset query api  | Major |
| [INLONG-484](https://issues.apache.org/jira/browse/INLONG-484) | Add query API for topic publication information  | Major |
| [INLONG-485](https://issues.apache.org/jira/browse/INLONG-485) | Add the batch setting API of consume group offset  | Major |
| [INLONG-486](https://issues.apache.org/jira/browse/INLONG-486) | Add the delete API of consumer group offset  | Major |
| [INLONG-494](https://issues.apache.org/jira/browse/INLONG-494) | Update API interface instruction document | Major |
| [INLONG-499](https://issues.apache.org/jira/browse/INLONG-499) | Add configure store  | Major |
| [INLONG-500](https://issues.apache.org/jira/browse/INLONG-500) | Add setting operate API  | Major |
| [INLONG-501](https://issues.apache.org/jira/browse/INLONG-501) | Adjust max message size check logic  | Major |
| [INLONG-502](https://issues.apache.org/jira/browse/INLONG-502) | Add setting API interface document  | Major |
| [INLONG-504](https://issues.apache.org/jira/browse/INLONG-504) | Adjust the WebMethodMapper class interfaces  | Major |
| [INLONG-508](https://issues.apache.org/jira/browse/INLONG-508) | Optimize Broker's PB parameter check processing logic  | Major |
| [INLONG-509](https://issues.apache.org/jira/browse/INLONG-509) | Adjust the packet length check when data is loaded  | Major |
| [INLONG-522](https://issues.apache.org/jira/browse/INLONG-522) | Add admin_query_cluster_topic_view API document  | Major |
| [INLONG-544](https://issues.apache.org/jira/browse/INLONG-544) | Adjust the LICENSE statement in the client.conf files of Python and C/C++ SDK | Major |
| [INLONG-546](https://issues.apache.org/jira/browse/INLONG-546) | Restore the original license header of the referenced external source files | Major |
| [INLONG-547](https://issues.apache.org/jira/browse/INLONG-547) | Recode the implementation of the *Startup.java classes in the Tool package | Major |
| [INLONG-548](https://issues.apache.org/jira/browse/INLONG-548) | Handle the LICENSE authorization of font files in the resources | Major |
| [INLONG-549](https://issues.apache.org/jira/browse/INLONG-549) | Handling the problem of compilation failure | Major |
| [INLONG-550](https://issues.apache.org/jira/browse/INLONG-550) | Adjust LICENSE file content | Major |
| [INLONG-551](https://issues.apache.org/jira/browse/INLONG-551) | Adjust NOTICE file content | Major |
| [INLONG-558](https://issues.apache.org/jira/browse/INLONG-558) | Adjust the LICENSE of the file header | Major |
| [INLONG-559](https://issues.apache.org/jira/browse/INLONG-559) | Update the LICENSE file according to the 0.8.0-RC2 review | Major |
| [INLONG-560](https://issues.apache.org/jira/browse/INLONG-560) | Remove unprepared modules | Major |


## Release 0.7.0-incubating - Released (as of 2020-11-25)

### New Features:

| JIRA  | Summary  | Priority |
| :---- | :------- | :------- |
| [INLONG-162](https://issues.apache.org/jira/browse/INLONG-162) | Python SDK support in TubeMQ | High |
| [INLONG-336](https://issues.apache.org/jira/browse/INLONG-336) | Propose web portal to manage tube cluster Phase-I | Major |
| [INLONG-390](https://issues.apache.org/jira/browse/INLONG-390)   | support build C++ SDK with docker image | Normal |

### IMPROVEMENTS:

| JIRA  | Summary  | Priority |
| :---- | :------- | :------- |
| [INLONG-369](https://issues.apache.org/jira/browse/INLONG-369) | hope to add an option in the compilation script (like `make lib` etc...)                 | Major    |
| [INLONG-373](https://issues.apache.org/jira/browse/INLONG-373) | Reduce the redundant code of Utils::Split functions             | Major    |
| [INLONG-374](https://issues.apache.org/jira/browse/INLONG-374) | Adjust some coding style issues     | Major    |
| [INLONG-375](https://issues.apache.org/jira/browse/INLONG-375) | Add a section to the README file about how to compile the project| Major    |
| [INLONG-385](https://issues.apache.org/jira/browse/INLONG-385) | update docker images     | Major    |
| [INLONG-393](https://issues.apache.org/jira/browse/INLONG-393) | Optimize the mapping code of WEB API     | Major    |
| [INLONG-406](https://issues.apache.org/jira/browse/INLONG-406) | test_consumer.py works for both Python 2 and 3   | Minor |
| [INLONG-410](https://issues.apache.org/jira/browse/INLONG-410) | install python package and simplify test_consumer.py    | Major    |
| [INLONG-416](https://issues.apache.org/jira/browse/INLONG-416) | support consume from specified position   | Major    |
| [INLONG-417](https://issues.apache.org/jira/browse/INLONG-417) | C++ Client support parse message from binary data for Python SDK    | Major    |
| [INLONG-419](https://issues.apache.org/jira/browse/INLONG-419) | SetMaxPartCheckPeriodMs() negative number, getMessage() still  | Major    |

### BUG FIXES:

| JIRA                                                         | Summary                                                      | Priority |
| :----------------------------------------------------------- | :----------------------------------------------------------- | :------- |
| [INLONG-365](https://issues.apache.org/jira/browse/INLONG-365) | Whether the consumption setting is wrong after the processRequest exception | Major    |
| [INLONG-370](https://issues.apache.org/jira/browse/INLONG-370) | Calling GetCurConsumedInfo API always returns failure      | Major    |
| [INLONG-376](https://issues.apache.org/jira/browse/INLONG-376) | Move pullrequests_status notifications commits mail list | Major    |
| [INLONG-366](https://issues.apache.org/jira/browse/INLONG-366) | Found a nullpointerexception bug in broker | Normal |
| [INLONG-379](https://issues.apache.org/jira/browse/INLONG-379) | Modify the memory cache size default to 3M | Normal |
| [INLONG-380](https://issues.apache.org/jira/browse/INLONG-380) | Cpp client link error when gcc optimization is disabled   | Major    |
| [INLONG-405](https://issues.apache.org/jira/browse/INLONG-405) | python sdk install files lack of the whole cpp configuration | Major |
| [INLONG-401](https://issues.apache.org/jira/browse/INLONG-401) | python sdk readme bug | Minor |
| [INLONG-407](https://issues.apache.org/jira/browse/INLONG-407) | Fix some content in README.md | Trivial |
| [INLONG-418](https://issues.apache.org/jira/browse/INLONG-418) | C++ SDK function SetMaxPartCheckPeriodMs() can't work | Major |

### SUB-TASK:

| JIRA  | Summary  | Priority |
| :---- | :------- | :------- |
| [INLONG-276](https://issues.apache.org/jira/browse/INLONG-276) | add python client encode/decode protobuf message for TubeMQ RPC Protocol                                 | Major    |
| [INLONG-338](https://issues.apache.org/jira/browse/INLONG-338) | web pages for tubemq manager                                     | Major    |
| [INLONG-341](https://issues.apache.org/jira/browse/INLONG-341) | open independent sub-project for tubemq                                | Major    |
| [INLONG-342](https://issues.apache.org/jira/browse/INLONG-342) | abstract backend threads for routine management                              | Major    |
| [INLONG-346](https://issues.apache.org/jira/browse/INLONG-346) | remove chinese comments                                          | Minor |
| [INLONG-355](https://issues.apache.org/jira/browse/INLONG-355) | Add business entity for topic manager                            | Major    |
| [INLONG-361](https://issues.apache.org/jira/browse/INLONG-361) | create topic when getting request             | Major    |
| [INLONG-364](https://issues.apache.org/jira/browse/INLONG-364) | uniform response format for exception state                              | Major    |
| [INLONG-383](https://issues.apache.org/jira/browse/INLONG-383) | document about Installation/API Reference/Example                                   | Major    |
| [INLONG-387](https://issues.apache.org/jira/browse/INLONG-387) | add manager web pages                                       | Major    |
| [INLONG-392](https://issues.apache.org/jira/browse/INLONG-392) | add query rest api for clusters| Major    |
| [INLONG-394](https://issues.apache.org/jira/browse/INLONG-394) | Creating Mapper class from web api to inner handler | Major    |
| [INLONG-395](https://issues.apache.org/jira/browse/INLONG-395) | Create Abstract WebHandler class                            | Major    |
| [INLONG-396](https://issues.apache.org/jira/browse/INLONG-396) | Adjust the WebXXXHandler classes implementation  | Major    |
| [INLONG-397](https://issues.apache.org/jira/browse/INLONG-397) | Add master info and other info web handler   | Major    |
| [INLONG-398](https://issues.apache.org/jira/browse/INLONG-398) | reinit project for using pybind11                            | Major    |
| [INLONG-399](https://issues.apache.org/jira/browse/INLONG-399) | expose C++ SDK method by Pybind11                                         | Major    |
| [INLONG-400](https://issues.apache.org/jira/browse/INLONG-400) | add example for consume message by bypind11                                 | Major    |
| [INLONG-402](https://issues.apache.org/jira/browse/INLONG-402) | add modify rest api for clusters                           | Major    |
| [INLONG-412](https://issues.apache.org/jira/browse/INLONG-402) | tube manager start stop scrrpts                           | Major    |
| [INLONG-415](https://issues.apache.org/jira/browse/INLONG-415) | exclude apache license for front end code  | Major    |

## Release 0.6.0-incubating - Released (as of 2020-09-25)

### New Features:

| JIRA  | Summary  | Priority |
| :---- | :------- | :------- |
| [INLONG-319](https://issues.apache.org/jira/browse/INLONG-319) | In the pull mode, consumers support the  suspension of consumption for a certain partition | Major    |
| [INLONG-3](https://issues.apache.org/jira/browse/INLONG-3)   | C++ SDK support in TubeMQ                                    | Normal   |

### IMPROVEMENTS:

| JIRA  | Summary  | Priority |
| :---- | :------- | :------- |
| [INLONG-311](https://issues.apache.org/jira/browse/INLONG-311) | Feedback more production information                 | Major    |
| [INLONG-312](https://issues.apache.org/jira/browse/INLONG-312) | Feedback more consumption information                | Major    |
| [INLONG-325](https://issues.apache.org/jira/browse/INLONG-325) | Add 406 ~ 408 error code to pullSelect call          | Major    |
| [INLONG-345](https://issues.apache.org/jira/browse/INLONG-345) | Optimize the call logic of getMessage() in Pull mode | Major    |
| [INLONG-352](https://issues.apache.org/jira/browse/INLONG-352) | Set the parameters of the example at startup         | Major    |
| [INLONG-353](https://issues.apache.org/jira/browse/INLONG-353) | Update LICENSE about C/C++ SDK's code reference      | Major    |
| [INLONG-356](https://issues.apache.org/jira/browse/INLONG-356) | C++ SDK Codec decode add requestid                   | Major    |
| [INLONG-327](https://issues.apache.org/jira/browse/INLONG-327) | Fix the concurrency problem in the example           | Normal   |

### BUG FIXES:

| JIRA                                                         | Summary                                                      | Priority |
| :----------------------------------------------------------- | :----------------------------------------------------------- | :------- |
| [INLONG-316](https://issues.apache.org/jira/browse/INLONG-316) | Where the port the port is aleady used, the  process throw the exception, but not exit | Major    |
| [INLONG-317](https://issues.apache.org/jira/browse/INLONG-317) | The Store Manager throws java.lang.NullPointerException      | Major    |
| [INLONG-320](https://issues.apache.org/jira/browse/INLONG-320) | Request for static web contents would get responses with no content | Major    |
| [INLONG-354](https://issues.apache.org/jira/browse/INLONG-354) | Found a dns translate bug in C/C++ sdk                       | Major    |
| [INLONG-306](https://issues.apache.org/jira/browse/INLONG-306) | Raise Nullpointer Exception when create tubemq instance      | Low      |
| [INLONG-359](https://issues.apache.org/jira/browse/INLONG-359) | TubeMQ consume speed dropped to 0 in some partitions, it is a very serious bug | Blocker  |

### SUB-TASK:

| JIRA  | Summary  | Priority |
| :---- | :------- | :------- |
| [INLONG-250](https://issues.apache.org/jira/browse/INLONG-250) | Create C/C++ configure files                                 | Major    |
| [INLONG-251](https://issues.apache.org/jira/browse/INLONG-251) | Create C/C++ Codec utils                                     | Major    |
| [INLONG-252](https://issues.apache.org/jira/browse/INLONG-252) | Create C/C++ Metadata classes                                | Major    |
| [INLONG-262](https://issues.apache.org/jira/browse/INLONG-262) | Create C++ flow control handler                              | Major    |
| [INLONG-263](https://issues.apache.org/jira/browse/INLONG-263) | Create C/C++ ini file read utils                             | Major    |
| [INLONG-266](https://issues.apache.org/jira/browse/INLONG-266) | [INLONG-266] Add Tencent/rapidjson as submodule              | Major    |
| [INLONG-267](https://issues.apache.org/jira/browse/INLONG-267) | Create C/C++ Message class                                   | Major    |
| [INLONG-269](https://issues.apache.org/jira/browse/INLONG-269) | Create C/C++ RmtDataCache class                              | Major    |
| [INLONG-272](https://issues.apache.org/jira/browse/INLONG-272) | Unified C/C++ files's code style                             | Major    |
| [INLONG-274](https://issues.apache.org/jira/browse/INLONG-274) | Support CMake compilation                                    | Major    |
| [INLONG-275](https://issues.apache.org/jira/browse/INLONG-275) | Thread Pool & Timer                                          | Major    |
| [INLONG-280](https://issues.apache.org/jira/browse/INLONG-280) | Create C/C++ subscribe info class                            | Major    |
| [INLONG-281](https://issues.apache.org/jira/browse/INLONG-281) | atomic_def.h use C++11 stdlib class                          | Major    |
| [INLONG-282](https://issues.apache.org/jira/browse/INLONG-282) | Create C/C++ return result class                             | Major    |
| [INLONG-283](https://issues.apache.org/jira/browse/INLONG-283) | Adjust C/C++ some file names: add "tubemq_" prefix           | Major    |
| [INLONG-285](https://issues.apache.org/jira/browse/INLONG-285) | Replace C/C++ pthread's mutex to std::mutex                  | Major    |
| [INLONG-286](https://issues.apache.org/jira/browse/INLONG-286) | Create C/C++ SDK's manager class                             | Major    |
| [INLONG-287](https://issues.apache.org/jira/browse/INLONG-287) | C++ SDK io buffer                                            | Major    |
| [INLONG-288](https://issues.apache.org/jira/browse/INLONG-288) | C++ SDK Codec interface                                      | Major    |
| [INLONG-289](https://issues.apache.org/jira/browse/INLONG-289) | C++ SDK Codec TubeMQ proto support                           | Major    |
| [INLONG-290](https://issues.apache.org/jira/browse/INLONG-290) | C++ SDK TCP Connect                                          | Major    |
| [INLONG-291](https://issues.apache.org/jira/browse/INLONG-291) | C++ SDK Connect Pool                                         | Major    |
| [INLONG-293](https://issues.apache.org/jira/browse/INLONG-293) | C++ SDK Create Future class                                  | Major    |
| [INLONG-296](https://issues.apache.org/jira/browse/INLONG-296) | Adjust the version information of all pom.xml                | Major    |
| [INLONG-300](https://issues.apache.org/jira/browse/INLONG-300) | Update LICENSE                                               | Major    |
| [INLONG-308](https://issues.apache.org/jira/browse/INLONG-308) | Upgrade Jetty 6 (mortbay) => Jetty 9 (eclipse)               | Major    |
| [INLONG-309](https://issues.apache.org/jira/browse/INLONG-309) | Add POST support to WebAPI                                   | Major    |
| [INLONG-326](https://issues.apache.org/jira/browse/INLONG-326) | [website] Added 405 ~ 408 error code definition              | Major    |
| [INLONG-347](https://issues.apache.org/jira/browse/INLONG-347) | C++ SDK Create client API                                    | Major    |
| [INLONG-348](https://issues.apache.org/jira/browse/INLONG-348) | C++SDK Client handler detail                                 | Major    |
| [INLONG-349](https://issues.apache.org/jira/browse/INLONG-349) | C++ SDK Create Thread Pool                                   | Major    |
| [INLONG-350](https://issues.apache.org/jira/browse/INLONG-350) | C++ SDK client code adj                                      | Major    |
| [INLONG-351](https://issues.apache.org/jira/browse/INLONG-351) | C++ SDK example&tests                                        | Major    |
| [INLONG-358](https://issues.apache.org/jira/browse/INLONG-358) | Adjust tubemq-manager, remove it from master, and develop with INLONG-336  branch | Major    |
| [INLONG-268](https://issues.apache.org/jira/browse/INLONG-268) | C++ SDK log module                                           | Normal   |
| [INLONG-292](https://issues.apache.org/jira/browse/INLONG-292) | C++ SDK singleton & executor_pool optimization               | Normal   |
| [INLONG-270](https://issues.apache.org/jira/browse/INLONG-270) | this point c++ SDK class                                     | Minor    |
| [INLONG-271](https://issues.apache.org/jira/browse/INLONG-271) | C++ SDK copy constructor and  assignment constructor         | Minor    |
| [INLONG-273](https://issues.apache.org/jira/browse/INLONG-273) | C++ SDK dir name change inc -> include/tubemq/               | Minor    |

## Release 0.5.0-incubating - released (as of 2020-07-22)

### NEW FEATURES:
| JIRA | Summary | Priority |
|:---- |:---- | :--- |
|[INLONG-122](https://issues.apache.org/jira/browse/INLONG-122) | Increase JAVA version collection of SDK environment |  Major|
|[INLONG-163](https://issues.apache.org/jira/browse/INLONG-163) | Flume sink for TubeMQ |  Major|
|[INLONG-197](https://issues.apache.org/jira/browse/INLONG-197) | Support TubeMQ connector for Apache Flink |  Major|
|[INLONG-238](https://issues.apache.org/jira/browse/INLONG-238) | Support TubeMQ connector for Apache Spark Streaming |  Major|
|[INLONG-239](https://issues.apache.org/jira/browse/INLONG-239) | support deployment on kubernetes |  Major|

### IMPROVEMENTS:
| JIRA | Summary | Priority |
|:---- |:---- | :--- |
| [INLONG-46](https://issues.apache.org/jira/browse/INLONG-46) | Correct some spelling issues |  Low|
| [INLONG-53](https://issues.apache.org/jira/browse/INLONG-53) | fix some typos |  Low|
| [INLONG-55](https://issues.apache.org/jira/browse/INLONG-55) | fix some typos |  Low|
| [INLONG-57](https://issues.apache.org/jira/browse/INLONG-57) | fix some typos & todo |  Low|
| [INLONG-58](https://issues.apache.org/jira/browse/INLONG-58) | fix some typos |  Low|
| [INLONG-60](https://issues.apache.org/jira/browse/INLONG-60) | Remove unnecessary synchronized & using IllegalArgumentException instead of IllegalStateException |  Low|
| [INLONG-61](https://issues.apache.org/jira/browse/INLONG-61) | minor update & fix some typos |  Low|
| [INLONG-64](https://issues.apache.org/jira/browse/INLONG-64) | minor update & fix some typos |  Low|
| [INLONG-67](https://issues.apache.org/jira/browse/INLONG-67) | remove synchronized & fix some typos |  Low|
| [INLONG-71](https://issues.apache.org/jira/browse/INLONG-71) | using IllegalArgumentException & fix some typos |  Low|
| [INLONG-73](https://issues.apache.org/jira/browse/INLONG-73) | remove duplicate codes & some minor updates |  Normal|
| [INLONG-74](https://issues.apache.org/jira/browse/INLONG-74) | minor updates for DefaultBdbStoreService |  Low|
| [INLONG-75](https://issues.apache.org/jira/browse/INLONG-75) | remove unused Logger |  Major|
| [INLONG-76](https://issues.apache.org/jira/browse/INLONG-76) | rename the classes |  Low|
| [INLONG-77](https://issues.apache.org/jira/browse/INLONG-77) | fix typo |  Low|
| [INLONG-79](https://issues.apache.org/jira/browse/INLONG-79) | fix typo |  Major|
| [INLONG-80](https://issues.apache.org/jira/browse/INLONG-80) | Fix some typos |  Low|
| [INLONG-82](https://issues.apache.org/jira/browse/INLONG-82) | Fix some typos & update comments |  Low|
| [INLONG-83](https://issues.apache.org/jira/browse/INLONG-83) | Fix some typos |  Low|
| [INLONG-87](https://issues.apache.org/jira/browse/INLONG-87) | Minor updates |  Low|
| [INLONG-89](https://issues.apache.org/jira/browse/INLONG-89) | Minor updates |  Low|
| [INLONG-90](https://issues.apache.org/jira/browse/INLONG-90) | Remove unused codes in TubeBroker |  Normal|
| [INLONG-91](https://issues.apache.org/jira/browse/INLONG-91) | replace explicit type with <> |  Low|
| [INLONG-93](https://issues.apache.org/jira/browse/INLONG-93) | Substitute the parameterized type for client module & missed server module |  Low|
| [INLONG-94](https://issues.apache.org/jira/browse/INLONG-94) | Substitute the parameterized type for core module |  Low|
| [INLONG-95](https://issues.apache.org/jira/browse/INLONG-95) | Substitute the parameterized type for server module |  Low|
| [INLONG-96](https://issues.apache.org/jira/browse/INLONG-96) | Fix typo & use IllegalArgumentException |  Low|
| [INLONG-98](https://issues.apache.org/jira/browse/INLONG-98) | Fix typo & Simplify 'instanceof' judgment |  Low|
| [INLONG-100](https://issues.apache.org/jira/browse/INLONG-100) | Fix typos & remove unused codes |  Low|
| [INLONG-101](https://issues.apache.org/jira/browse/INLONG-101) | Optimize code & Fix type |  Low|
| [INLONG-103](https://issues.apache.org/jira/browse/INLONG-103) | Substitute Chinese comments with English |  Normal|
| [INLONG-108](https://issues.apache.org/jira/browse/INLONG-108) | About maven jdk version configuration problem |  Minor|
| [INLONG-127](https://issues.apache.org/jira/browse/INLONG-127) | Fixed a bug & minor changes |  Low|
| [INLONG-128](https://issues.apache.org/jira/browse/INLONG-128) | Shorten the log clearup check cycle |  Major|
| [INLONG-138](https://issues.apache.org/jira/browse/INLONG-138) | Optimize core module test case code |  Low|
| [INLONG-141](https://issues.apache.org/jira/browse/INLONG-141) | Remove the requirement to provide localHostIP |  Major|
| [INLONG-152](https://issues.apache.org/jira/browse/INLONG-152) | Modify the master.ini file's annotations |  Normal|
| [INLONG-154](https://issues.apache.org/jira/browse/INLONG-154) | Modify the wrong comment & Minor changes for example module |  Low|
| [INLONG-155](https://issues.apache.org/jira/browse/INLONG-155) | Use enum class for consume position |  Normal|
| [INLONG-156](https://issues.apache.org/jira/browse/INLONG-156) | Update for README.md |  Normal|
| [INLONG-166](https://issues.apache.org/jira/browse/INLONG-166) | Hide `bdbStore` configs in master.ini |  Major|
| [INLONG-167](https://issues.apache.org/jira/browse/INLONG-167) | Change to relative paths in default configs |  Trivial|
| [INLONG-168](https://issues.apache.org/jira/browse/INLONG-168) | Example module: remove localhost IP configuration parameters |  Minor|
| [INLONG-170](https://issues.apache.org/jira/browse/INLONG-170) | improve build/deployment/configuration for quick start |  Major|
| [INLONG-196](https://issues.apache.org/jira/browse/INLONG-196) | use log to print exception |  Low|
| [INLONG-201](https://issues.apache.org/jira/browse/INLONG-201) | [Website] Adjust user guide & fix demo example |  Major|
| [INLONG-202](https://issues.apache.org/jira/browse/INLONG-202) | Add protobuf protocol syntax declaration |  Major|
| [INLONG-213](https://issues.apache.org/jira/browse/INLONG-213) | Optimize code & Minor changes |  Low|
| [INLONG-216](https://issues.apache.org/jira/browse/INLONG-216) | use ThreadUtil.sleep replace Thread.sleep |  Low|
| [INLONG-222](https://issues.apache.org/jira/browse/INLONG-222) | Optimize code: Unnecessary boxing/unboxing conversion |  Normal|
| [INLONG-224](https://issues.apache.org/jira/browse/INLONG-224) | Fixed: Unnecessary conversion to string inspection for server module |  Low|
| [INLONG-226](https://issues.apache.org/jira/browse/INLONG-226) | Add Windows startup scripts |  High|
| [INLONG-227](https://issues.apache.org/jira/browse/INLONG-227) | remove build guide in docker-build readme |  Major|
| [INLONG-232](https://issues.apache.org/jira/browse/INLONG-232) | TubeBroker#register2Master, reconnect and wait |  Low|
| [INLONG-234](https://issues.apache.org/jira/browse/INLONG-234) | Add .asf.yaml to change notifications |  Major|
| [INLONG-235](https://issues.apache.org/jira/browse/INLONG-235) | Add code coverage supporting for pull request created. |  Normal|
| [INLONG-237](https://issues.apache.org/jira/browse/INLONG-237) | add maven module build for docker image |  Major|

### BUG FIXES:
| JIRA | Summary | Priority |
|:---- |:---- | :--- |
| [INLONG-47](https://issues.apache.org/jira/browse/INLONG-47) | Fix some typos |  Major|
| [INLONG-102](https://issues.apache.org/jira/browse/INLONG-102) | Fix question [INLONG-101] [Optimize code] |  Major|
| [INLONG-121](https://issues.apache.org/jira/browse/INLONG-121) | Fix compilation alarm |  Major|
| [INLONG-139](https://issues.apache.org/jira/browse/INLONG-139) | a bug in the equals method of the TubeClientConfig class |  Major|
| [INLONG-157](https://issues.apache.org/jira/browse/INLONG-157) | Optimize Broker disk anomaly check |  Normal|
| [INLONG-158](https://issues.apache.org/jira/browse/INLONG-158) | nextWithAuthInfo2B status should be managed independently according to Broker |  Normal|
| [INLONG-159](https://issues.apache.org/jira/browse/INLONG-159) | Fix some typos |  Normal|
| [INLONG-165](https://issues.apache.org/jira/browse/INLONG-165) | Remove unnecessary fiiles |  Major|
| [INLONG-205](https://issues.apache.org/jira/browse/INLONG-205) | Duplicate dependency of jetty in tuber-server pom file |  Minor|
| [INLONG-206](https://issues.apache.org/jira/browse/INLONG-206) | There are some residual files after executed unit tests |  Major|
| [INLONG-210](https://issues.apache.org/jira/browse/INLONG-210) | Add log4j properties file for unit tests |  Minor|
| [INLONG-217](https://issues.apache.org/jira/browse/INLONG-217) | UPdate the je download path |  Major|
| [INLONG-218](https://issues.apache.org/jira/browse/INLONG-218) | build failed: Too many files with unapproved license |  Major|
| [INLONG-230](https://issues.apache.org/jira/browse/INLONG-230) | TubeMQ run mvn test failed with openjdk version 13.0.2 |  Major|
| [INLONG-236](https://issues.apache.org/jira/browse/INLONG-236) | Can't get dependencies from the maven repository |  Major|
| [INLONG-253](https://issues.apache.org/jira/browse/INLONG-253) | tube-consumer fetch-worker cpu used too high |  Major|
| [INLONG-254](https://issues.apache.org/jira/browse/INLONG-254) | support using different mapping port for standalone mode |  Major|
| [INLONG-265](https://issues.apache.org/jira/browse/INLONG-265) | Unexpected broker disappearance in broker list after updating default broker metadata |  Major|

### TASK:
| JIRA | Summary | Priority |
|:---- |:---- | :--- |
|[INLONG-193](https://issues.apache.org/jira/browse/INLONG-193)  | Update project document content |  Major |

### SUB-TASK:
| JIRA | Summary | Priority |
|:---- |:---- | :--- |
|[INLONG-123](https://issues.apache.org/jira/browse/INLONG-123) | Batch flush data to disk |  Major |
|[INLONG-126](https://issues.apache.org/jira/browse/INLONG-126) | Increase the unflushed data bytes control |  Major |
|[INLONG-140](https://issues.apache.org/jira/browse/INLONG-140) | Remove the SSD auxiliary consumption function |  Major |
|[INLONG-160](https://issues.apache.org/jira/browse/INLONG-160) | Improve the protocol between Broker and Master |  Major |
|[INLONG-169](https://issues.apache.org/jira/browse/INLONG-169) | support build with docker image |  Major |
|[INLONG-171](https://issues.apache.org/jira/browse/INLONG-171) | master and broker support config hostname with “localhost” or "127.0.0.1" or dns address |  Major |
|[INLONG-172](https://issues.apache.org/jira/browse/INLONG-172) | simplify start/stop script |  Major |
|[INLONG-173](https://issues.apache.org/jira/browse/INLONG-173) | change jvm memory parameters for default deployment |  Major |
|[INLONG-174](https://issues.apache.org/jira/browse/INLONG-174) | hange defaule accessing url of web gui to http://your-master-ip:8080 |  Major |
|[INLONG-178](https://issues.apache.org/jira/browse/INLONG-178) | change default IPs configuration to localhost |  Major |
|[INLONG-188](https://issues.apache.org/jira/browse/INLONG-188) | the example for demo topic catch exception |  Major |
|[INLONG-194](https://issues.apache.org/jira/browse/INLONG-194) | [website]Remove SSD auxiliary storage introduction |  Major |
|[INLONG-195](https://issues.apache.org/jira/browse/INLONG-195) | [website] Adjust the content of the Chinese part of the document |  Major |
|[INLONG-198](https://issues.apache.org/jira/browse/INLONG-198) | Support TubeMQ source for flink |  Major |
|[INLONG-199](https://issues.apache.org/jira/browse/INLONG-199) | Support TubeMQ sink for flink |  Major |
|[INLONG-204](https://issues.apache.org/jira/browse/INLONG-204) | Remove document address guideline |  Major |
|[INLONG-221](https://issues.apache.org/jira/browse/INLONG-221) | make quick start doc more easy for reading |  Major |
|[INLONG-240](https://issues.apache.org/jira/browse/INLONG-240) | add status command for broker/master script |  Major |
|[INLONG-241](https://issues.apache.org/jira/browse/INLONG-241) | add helm chart for tubemq |  Major |
|[INLONG-242](https://issues.apache.org/jira/browse/INLONG-242) | Support Table interface for TubeMQ flink connector |  Major |
|[INLONG-244](https://issues.apache.org/jira/browse/INLONG-244) | tubemq web support access using proxy IP |  Major |
|[INLONG-246](https://issues.apache.org/jira/browse/INLONG-246) | support register broker using hostname |  Major |
|[INLONG-295](https://issues.apache.org/jira/browse/INLONG-295) | Modify CHANGES.md to add 0.5.0 version release modification |  Major |
|[INLONG-299](https://issues.apache.org/jira/browse/INLONG-299) | Fix RAT check warnning |  Major |
|[INLONG-300](https://issues.apache.org/jira/browse/INLONG-300) | Update LICENSE |  Major |



## Release 0.3.0-incubating - Released (as of 2020-06-08)

### NEW FEATURES:

| JIRA | Summary | Priority |
|:---- |:---- | :--- |
|[INLONG-42](https://issues.apache.org/jira/browse/INLONG-42) | Add peer information about message received  Major  New Feature |  Major|

### IMPROVEMENTS:
| JIRA | Summary | Priority |
|:---- |:---- | :--- |
| [INLONG-16](https://issues.apache.org/jira/browse/INLONG-16) |Correct BdbStoreService#isPrimaryNodeActived to BdbStoreService#isPrimaryNodeActive|  Low|
| [INLONG-18](https://issues.apache.org/jira/browse/INLONG-18) |Correct TMaster#idGenerater to TMaster#idGenerator|  Low|
| [INLONG-19](https://issues.apache.org/jira/browse/INLONG-19) |Correct parameter names to fit in camel case|  Low|
| [INLONG-20](https://issues.apache.org/jira/browse/INLONG-20) |Correct DefaultLoadBalancer#balance parameter  | Low|
| [INLONG-21](https://issues.apache.org/jira/browse/INLONG-21) |Change version number from x.y-SNAPSHOT to x.y.z-incubating-SNAPSHOT|  Normal|
| [INLONG-22](https://issues.apache.org/jira/browse/INLONG-22) |Correct ClientSubInfo#getTopicProcesser -> ClientSubInfo#getTopicProcessor|  Low|
| [INLONG-23](https://issues.apache.org/jira/browse/INLONG-23) |Improve project README content introduction|  Major|
| [INLONG-24](https://issues.apache.org/jira/browse/INLONG-24) |Add NOTICE and adjust LICENSE  | Major|
| [INLONG-26](https://issues.apache.org/jira/browse/INLONG-26) |correct spelling (difftime-> diffTime)  |Low|
| [INLONG-27](https://issues.apache.org/jira/browse/INLONG-27) |replace StringBuffer with StringBuilder |  Major|
| [INLONG-28](https://issues.apache.org/jira/browse/INLONG-28) |ignore path error  |Major|
| [INLONG-29](https://issues.apache.org/jira/browse/INLONG-29) |Change the package name to org.apache.tubemq.""  |Major|
| [INLONG-33](https://issues.apache.org/jira/browse/INLONG-33) |refactor enum implement from annoymouse inner class  | Major|
| [INLONG-38](https://issues.apache.org/jira/browse/INLONG-38) |Add Broker's running status check  | Major||
| [INLONG-39](https://issues.apache.org/jira/browse/INLONG-39) |Optimize the loadMessageStores() logic  | Nor|mal|
| [INLONG-40](https://issues.apache.org/jira/browse/INLONG-40) |Optimize message disk store classes's logic  | Major|
| [INLONG-43](https://issues.apache.org/jira/browse/INLONG-43) |Add DeletePolicy's value check  | Major|
| [INLONG-44](https://issues.apache.org/jira/browse/INLONG-44) |Remove unnecessary synchronized definition of shutdown () function  | Normal|
| [INLONG-49](https://issues.apache.org/jira/browse/INLONG-49) |setTimeoutTime change to updTimeoutTime  | Major|
| [INLONG-50](https://issues.apache.org/jira/browse/INLONG-50) |Replace fastjson to gson  | Major|
| [INLONG-7](https://issues.apache.org/jira/browse/INLONG-7) | Using StringBuilder instead of StringBuffer in BaseResult  | Low|
| [INLONG-9](https://issues.apache.org/jira/browse/INLONG-9) | Remove some unnecessary code  | Minor |

### BUG FIXES:
| JIRA | Summary | Priority |
|:---- |:---- | :--- |
| [INLONG-10](https://issues.apache.org/jira/browse/INLONG-10) |Fix Javadoc error|Low|
| [INLONG-14](https://issues.apache.org/jira/browse/INLONG-14) |Some compilation errors|Major|
| [INLONG-15](https://issues.apache.org/jira/browse/INLONG-15) |Correct typo in http_access_API_definition.md|Low|
| [INLONG-32](https://issues.apache.org/jira/browse/INLONG-32) |File path not match with package name in tubemq-client module|Major|
| [INLONG-35](https://issues.apache.org/jira/browse/INLONG-35) |check illegal package's field value|Normal|
| [INLONG-36](https://issues.apache.org/jira/browse/INLONG-36) |Remove unnecessary removefirst() function printing|Normal|
| [INLONG-37](https://issues.apache.org/jira/browse/INLONG-37) |Offset is set to 0 when Broker goes offline|Major|
| [INLONG-45](https://issues.apache.org/jira/browse/INLONG-45) |Check groupName with checkHostName function|Major|
| [INLONG-48](https://issues.apache.org/jira/browse/INLONG-48) |No timeout when setting consumer timeout|Major|
| [INLONG-59](https://issues.apache.org/jira/browse/INLONG-59) |Null pointer exception is thrown while constructing ConsumerConfig with MasterInfo|Normal|
| [INLONG-62](https://issues.apache.org/jira/browse/INLONG-62) |consumed and set consumerConfig.setConsumeModel (0) for the first time|Major|
| [INLONG-66](https://issues.apache.org/jira/browse/INLONG-66) |TubeSingleSessionFactory shutdown bug|Normal|
| [INLONG-85](https://issues.apache.org/jira/browse/INLONG-85) |There is NPE when creating PullConsumer with TubeSingleSessionFactory|Major|
| [INLONG-88](https://issues.apache.org/jira/browse/INLONG-88) |Broker does not take effect after the deletePolicy value is changed|Major|
| [INLONG-149](https://issues.apache.org/jira/browse/INLONG-149) |Some of the consumers stop consuming their corresponding partitions and never release the partition to others|Major|
| [INLONG-153](https://issues.apache.org/jira/browse/INLONG-153) |update copyright notices year to 2020|  Major |
| [INLONG-165](https://issues.apache.org/jira/browse/INLONG-165) |Remove unnecessary fiiles|  Major |

### TASK:
| JIRA | Summary | Priority |
|:---- |:---- | :--- |
|[INLONG-12](https://issues.apache.org/jira/browse/INLONG-12)  |Change to use Apache License V2   |  Major |

### SUB-TASK:
| JIRA | Summary | Priority |
|:---- |:---- | :--- |
|[INLONG-130](https://issues.apache.org/jira/browse/INLONG-130) |Generate CHANGES.md and DISCLAIMER-WIP   |  Major |
|[INLONG-133](https://issues.apache.org/jira/browse/INLONG-133) |Add Apache parent pom |  Major |
|[INLONG-134](https://issues.apache.org/jira/browse/INLONG-134) |add maven-source-plugin for generate source jar|  Major |
|[INLONG-135](https://issues.apache.org/jira/browse/INLONG-135) |Refactoring all pom.xml|  Major |
|[INLONG-136](https://issues.apache.org/jira/browse/INLONG-136) |Add LICENSE/NOTICE/DISCLAIMER-WIP to binary package|  Major |
