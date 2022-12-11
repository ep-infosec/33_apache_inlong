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

package org.apache.inlong.manager.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.inlong.manager.common.enums.OperationType;
import org.apache.inlong.manager.pojo.common.Response;
import org.apache.inlong.manager.common.validation.UpdateValidation;
import org.apache.inlong.manager.pojo.transform.DeleteTransformRequest;
import org.apache.inlong.manager.pojo.transform.TransformRequest;
import org.apache.inlong.manager.pojo.transform.TransformResponse;
import org.apache.inlong.manager.service.operationlog.OperationLog;
import org.apache.inlong.manager.service.transform.StreamTransformService;
import org.apache.inlong.manager.service.user.LoginUserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Stream transform control layer
 */
@RestController
@RequestMapping("/api")
@Api(tags = "Stream-Transform-API")
public class StreamTransformController {

    @Autowired
    protected StreamTransformService streamTransformService;

    @RequestMapping(value = "/transform/save", method = RequestMethod.POST)
    @OperationLog(operation = OperationType.CREATE)
    @ApiOperation(value = "Save stream transform")
    public Response<Integer> save(@Validated @RequestBody TransformRequest request) {
        return Response.success(
                streamTransformService.save(request, LoginUserUtils.getLoginUser().getName()));
    }

    @RequestMapping(value = "/transform/list", method = RequestMethod.GET)
    @ApiOperation(value = "Get stream transform list")
    public Response<List<TransformResponse>> list(@RequestParam("inlongGroupId") String groupId,
            @RequestParam("inlongStreamId") String streamId) {
        return Response.success(streamTransformService.listTransform(groupId, streamId));
    }

    @RequestMapping(value = "/transform/update", method = RequestMethod.POST)
    @OperationLog(operation = OperationType.UPDATE)
    @ApiOperation(value = "Update stream transform")
    public Response<Boolean> update(@Validated(UpdateValidation.class) @RequestBody TransformRequest request) {
        String operator = LoginUserUtils.getLoginUser().getName();
        return Response.success(streamTransformService.update(request, operator));
    }

    @RequestMapping(value = "/transform/delete", method = RequestMethod.DELETE)
    @OperationLog(operation = OperationType.UPDATE)
    @ApiOperation(value = "Delete stream transform")
    public Response<Boolean> delete(@Validated DeleteTransformRequest request) {
        String operator = LoginUserUtils.getLoginUser().getName();
        return Response.success(streamTransformService.delete(request, operator));
    }

}
