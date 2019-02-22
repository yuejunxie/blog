package com.drawinds.blog.rpc.netty.delimeter;

import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * Author: JackShieh
 * Corporation: Drawinds LTD
 * WE FLY WE DREAM
 * blog
 * Created: 2019/2/21 17:38
 * Description:
 */
public class LengthBasedFrameDecoder extends ChannelInitializer {

    @Override
    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new LengthFieldBasedFrameDecoder(64 * 1024, 0, 8));
        pipeline.addLast(new FrameHandler());
    }

    private class FrameHandler extends SimpleChannelInboundHandler<ByteBuf> {
        @Override
        protected void messageReceived(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {

        }
    }
}
