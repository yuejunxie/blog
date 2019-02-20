package com.drawinds.blog.configs.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.ByteToMessageDecoder;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.List;

/**
 * Author: JackShieh
 * Corporation: Drawinds LTD
 * WE FLY WE DREAM
 * blog
 * Created: 2019/2/15 20:47
 * Description:
 */
@Slf4j
public class ServerBoot {

    public static void main(String[] args) throws InterruptedException {
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        NioEventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        serverBootstrap.group(eventLoopGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ByteToMessageDecoder() {
//                    @Override
//                    protected void messageReceived(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
//                        log.info(msg.toString(Charset.defaultCharset()));
//                        log.info("Received Data");
//                    }

                    @Override
                    public boolean isSharable() {
                        return false;
                    }
//
//                    @Override
//                    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
//                        ctx.channel().write("success");
//                    }

                    @Override
                    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
                        log.info(in.toString(Charset.defaultCharset()));
                        log.info("Received Data");
                        out.add(in);
                    }
                });
        ChannelFuture future = serverBootstrap.bind(new InetSocketAddress(8080)).sync();
        future.addListener((ChannelFutureListener) future1 -> {
            if (future1.isSuccess()) {
                log.info("Server bound");
            } else {
                log.info("Server bound fail");
                future1.cause().printStackTrace();
            }
        });
        future.channel().closeFuture().sync();
    }
}
