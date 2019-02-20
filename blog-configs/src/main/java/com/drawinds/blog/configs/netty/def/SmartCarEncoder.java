package com.drawinds.blog.configs.netty.def;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * Author: JackShieh
 * Corporation: Drawinds LTD
 * WE FLY WE DREAM
 * blog
 * Created: 2019/2/17 15:55
 * Description:
 */
public class SmartCarEncoder extends MessageToByteEncoder<SmartCarProtocol> {
    @Override
    protected void encode(ChannelHandlerContext ctx, SmartCarProtocol msg, ByteBuf out) throws Exception {
        out.writeInt(msg.getHeadData());
        out.writeInt(msg.getContentLength());
        out.writeBytes(msg.getContent());
    }
}
