package com.drawinds.blog.grpc.netty.delimeter;

import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.handler.codec.LineBasedFrameDecoder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: JackShieh
 * Corporation: Drawinds LTD
 * WE FLY WE DREAM
 * blog
 * Created: 2019/2/21 17:10
 * Description:
 */
@Slf4j
public class CmdHandlerInitializer extends ChannelInitializer<Channel> {

    final byte SPACE = (byte) ' ';

    @Override
    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new CmdDecoder(64 * 1024));
        pipeline.addLast(new CmdHandler());
    }

    private class CmdDecoder extends LineBasedFrameDecoder {
        public CmdDecoder(int mexLength) {
            super(mexLength);
        }

        @Override
        protected Object decode(ChannelHandlerContext ctx, ByteBuf buffer) throws Exception {
            ByteBuf frame = (ByteBuf) super.decode(ctx, buffer);
            if (frame == null) {
                return null;
            }
            int index = frame.indexOf(frame.readerIndex(), frame.writerIndex(), SPACE);
            return new Cmd(frame.slice(frame.readerIndex(), index), frame.slice(index + 1, frame.writerIndex()));
        }
    }

    @Data
    @AllArgsConstructor
    private class Cmd {
        ByteBuf name;
        ByteBuf args;
    }

    private class CmdHandler extends SimpleChannelInboundHandler<Cmd> {
        @Override
        protected void messageReceived(ChannelHandlerContext ctx, Cmd msg) throws Exception {
            log.info(msg.toString());
        }
    }
}
