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

package org.apache.inlong.dataproxy.base;

import io.netty.channel.ChannelHandlerContext;
import java.util.Map;
import org.apache.flume.Event;
import org.apache.inlong.dataproxy.source.MsgType;

public class SinkRspEvent implements Event {

    private ChannelHandlerContext ctx;
    private MsgType msgType;
    private Event event;

    public SinkRspEvent(Event event, MsgType msgType, ChannelHandlerContext ctx) {
        this.event = event;
        this.msgType = msgType;
        this.ctx = ctx;
    }

    @Override
    public Map<String, String> getHeaders() {
        return event.getHeaders();
    }

    @Override
    public void setHeaders(Map<String, String> map) {
        event.setHeaders(map);
    }

    @Override
    public byte[] getBody() {
        return event.getBody();
    }

    @Override
    public void setBody(byte[] bytes) {
        event.setBody(bytes);
    }

    /**
     * Get event reported channel context
     *
     * @return ctx
     */
    public ChannelHandlerContext getCtx() {
        return ctx;
    }

    /**
     * Get event's message type
     *
     * @return msgType
     */
    public MsgType getMsgType() {
        return msgType;
    }
}
