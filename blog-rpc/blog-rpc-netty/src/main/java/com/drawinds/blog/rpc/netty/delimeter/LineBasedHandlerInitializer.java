package com.drawinds.blog.rpc.netty.delimeter;

import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.handler.codec.LineBasedFrameDecoder;

/**
 * Author: JackShieh
 * Corporation: Drawinds LTD
 * WE FLY WE DREAM
 * blog
 * Created: 2019/2/21 17:02
 * Description: 基于分隔符
 */
public class LineBasedHandlerInitializer extends ChannelInitializer<Channel> {

    @Override
    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new LineBasedFrameDecoder(64 * 1024))
                .addLast(new FrameHandler());
    }

    private class FrameHandler extends SimpleChannelInboundHandler<ByteBuf> {

        @Override
        protected void messageReceived(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {

        }
    }
}
