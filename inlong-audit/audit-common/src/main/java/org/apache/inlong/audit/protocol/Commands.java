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

package org.apache.inlong.audit.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import org.apache.inlong.audit.protocol.AuditApi.AuditReply;
import org.apache.inlong.audit.protocol.AuditApi.AuditRequest;
import org.apache.inlong.audit.protocol.AuditApi.BaseCommand;
import org.apache.inlong.audit.protocol.AuditApi.BaseCommand.Type;
import org.apache.inlong.audit.protocol.AuditApi.Pong;

/**
 * Audit commands, used to get various of ByteBuf.
 */
public class Commands {

    public static int HEAD_LENGTH = 4;

    public static ByteBuf getPongChannelBuffer() {
        BaseCommand cmdPong = BaseCommand.newBuilder()
                .setType(Type.PONG)
                .setPong(Pong.getDefaultInstance()).build();
        return getChannelBuffer(cmdPong.toByteArray());
    }

    public static ByteBuf getPingChannelBuffer() {
        BaseCommand cmdPing = BaseCommand.newBuilder()
                .setType(Type.PING)
                .setPong(Pong.getDefaultInstance()).build();
        return getChannelBuffer(cmdPing.toByteArray());
    }

    public static ByteBuf getAuditRequestBuffer(AuditRequest auditRequest) {
        BaseCommand cmdAuditRequest = BaseCommand.newBuilder()
                .setType(Type.AUDIT_REQUEST)
                .setAuditRequest(auditRequest).build();
        return getChannelBuffer(cmdAuditRequest.toByteArray());
    }

    public static ByteBuf getAuditReplyBuffer(AuditReply auditReply) {
        BaseCommand cmdAuditReply = BaseCommand.newBuilder()
                .setType(Type.AUDIT_REPLY)
                .setAuditReply(auditReply).build();
        return getChannelBuffer(cmdAuditReply.toByteArray());
    }

    private static ByteBuf getChannelBuffer(byte[] body) {
        // [totalSize] | [body]
        int totalLength = body.length;
        ByteBuf buffer = ByteBufAllocator.DEFAULT.buffer(HEAD_LENGTH + totalLength);
        buffer.writeInt(totalLength);
        buffer.writeBytes(body);
        return buffer;
    }
}
