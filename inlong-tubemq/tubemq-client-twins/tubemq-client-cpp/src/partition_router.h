/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

#ifndef TUBEMQ_PARTITION_ROUTER_H_
#define TUBEMQ_PARTITION_ROUTER_H_

#include <mutex>
#include <string>
#include <unordered_map>
#include <vector>

#include "meta_info.h"
#include "tubemq/tubemq_atomic.h"
#include "tubemq/tubemq_message.h"
#include "utils.h"

namespace tubemq {

class PartitionRouter {
 public:
  virtual int GetPartition(const Message& message, const std::vector<Partition> partitions);
};

class RoundRobinPartitionRouter {
 public:
  RoundRobinPartitionRouter();
  ~RoundRobinPartitionRouter();

  int GetPartition(const Message& message, const std::vector<Partition>& partitions);

 private:
  AtomicInteger stepped_counter_;
  std::unordered_map<std::string, AtomicInteger> partition_router_map_;
  std::mutex partition_router_map_mutex;
};

}  // namespace tubemq

#endif
