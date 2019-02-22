package com.drawinds.blog.rpc.netty.websocket;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.ContinuationWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;

/**
 * Author: JackShieh
 * Corporation: Drawinds LTD
 * WE FLY WE DREAM
 * blog
 * Created: 2019/2/21 15:01
 * Description:
 */
public class WebSocketServerInitializer extends ChannelInitializer<Channel> {
    @Override
    protected void initChannel(Channel ch) throws Exception {
        ch.pipeline().addLast(new HttpServerCodec(),
                new HttpObjectAggregator(64 * 1024),
                new WebSocketServerProtocolHandler("/websocket"),
                new TextFrameHandler(),
                new BinaryFrameHandler(),
                new ContinuationFrameHandler());
    }

    private class TextFrameHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {
        @Override
        protected void messageReceived(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {

        }
    }

    private class BinaryFrameHandler extends SimpleChannelInboundHandler<BinaryWebSocketFrame> {
        @Override
        protected void messageReceived(ChannelHandlerContext ctx, BinaryWebSocketFrame msg) throws Exception {

        }
    }

    private class ContinuationFrameHandler extends SimpleChannelInboundHandler<ContinuationWebSocketFrame> {
        @Override
        protected void messageReceived(ChannelHandlerContext ctx, ContinuationWebSocketFrame msg) throws Exception {

        }
    }
}
