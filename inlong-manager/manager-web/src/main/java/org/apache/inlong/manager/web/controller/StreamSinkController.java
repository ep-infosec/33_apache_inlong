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
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.inlong.manager.common.enums.OperationType;
import org.apache.inlong.manager.common.validation.UpdateValidation;
import org.apache.inlong.manager.pojo.common.PageResult;
import org.apache.inlong.manager.pojo.common.Response;
import org.apache.inlong.manager.pojo.common.UpdateResult;
import org.apache.inlong.manager.pojo.sink.SinkPageRequest;
import org.apache.inlong.manager.pojo.sink.SinkRequest;
import org.apache.inlong.manager.pojo.sink.StreamSink;
import org.apache.inlong.manager.service.operationlog.OperationLog;
import org.apache.inlong.manager.service.sink.StreamSinkService;
import org.apache.inlong.manager.service.user.LoginUserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Stream sink control layer
 */
@RestController
@RequestMapping("/api")
@Api(tags = "Stream-Sink-API")
public class StreamSinkController {

    @Autowired
    private StreamSinkService sinkService;

    @RequestMapping(value = "/sink/save", method = RequestMethod.POST)
    @OperationLog(operation = OperationType.CREATE)
    @ApiOperation(value = "Save stream sink")
    public Response<Integer> save(@Validated @RequestBody SinkRequest request) {
        return Response.success(sinkService.save(request, LoginUserUtils.getLoginUser().getName()));
    }

    @RequestMapping(value = "/sink/get/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Get stream sink")
    @ApiImplicitParam(name = "id", dataTypeClass = Integer.class, required = true)
    public Response<StreamSink> get(@PathVariable Integer id) {
        return Response.success(sinkService.get(id));
    }

    @RequestMapping(value = "/sink/list", method = RequestMethod.GET)
    @ApiOperation(value = "List stream sinks by paginating")
    public Response<PageResult<? extends StreamSink>> listByCondition(SinkPageRequest request) {
        return Response.success(sinkService.listByCondition(request));
    }

    @RequestMapping(value = "/sink/update", method = RequestMethod.POST)
    @OperationLog(operation = OperationType.UPDATE)
    @ApiOperation(value = "Update stream sink")
    public Response<Boolean> update(@Validated(UpdateValidation.class) @RequestBody SinkRequest request) {
        return Response.success(sinkService.update(request, LoginUserUtils.getLoginUser().getName()));
    }

    @RequestMapping(value = "/sink/updateByKey", method = RequestMethod.POST)
    @OperationLog(operation = OperationType.UPDATE)
    @ApiOperation(value = "Update stream sink by key")
    public Response<UpdateResult> updateByKey(@RequestBody SinkRequest request) {
        return Response.success(sinkService.updateByKey(request, LoginUserUtils.getLoginUser().getName()));
    }

    @RequestMapping(value = "/sink/delete/{id}", method = RequestMethod.DELETE)
    @OperationLog(operation = OperationType.DELETE)
    @ApiOperation(value = "Delete stream sink")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startProcess", dataTypeClass = boolean.class),
            @ApiImplicitParam(name = "id", dataTypeClass = Integer.class, required = true)
    })
    public Response<Boolean> delete(@PathVariable Integer id,
            @RequestParam(required = false, defaultValue = "false") boolean startProcess) {
        return Response.success(sinkService.delete(id, startProcess, LoginUserUtils.getLoginUser().getName()));
    }

    @RequestMapping(value = "/sink/deleteByKey", method = RequestMethod.DELETE)
    @OperationLog(operation = OperationType.DELETE)
    @ApiOperation(value = "Delete stream sink by key")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startProcess", dataTypeClass = boolean.class),
            @ApiImplicitParam(name = "groupId", dataTypeClass = String.class, required = true),
            @ApiImplicitParam(name = "streamId", dataTypeClass = String.class, required = true),
            @ApiImplicitParam(name = "name", dataTypeClass = String.class, required = true)
    })
    public Response<Boolean> deleteByKey(@RequestParam(required = false, defaultValue = "false") boolean startProcess,
            @RequestParam String groupId, @RequestParam String streamId, @RequestParam String name) {
        String username = LoginUserUtils.getLoginUser().getName();
        return Response.success(sinkService.deleteByKey(groupId, streamId, name, startProcess, username));
    }

}
