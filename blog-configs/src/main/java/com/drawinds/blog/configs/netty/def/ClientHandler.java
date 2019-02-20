package com.drawinds.blog.configs.netty.def;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;

/**
 * Author: JackShieh
 * Corporation: Drawinds LTD
 * WE FLY WE DREAM
 * blog
 * Created: 2019/2/17 16:27
 * Description:
 */
public class ClientHandler extends ChannelHandlerAdapter {

    // 客户端与服务端，连接成功的售后
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // 发送SmartCar协议的消息
        // 要发送的信息
        String data = "I am client ...";
        // 获得要发送信息的字节数组
        byte[] content = data.getBytes();
        // 要发送信息的长度
        int contentLength = content.length;

        SmartCarProtocol protocol = new SmartCarProtocol(contentLength, content);

        ctx.writeAndFlush(protocol);
    }

    // 只是读数据，没有写数据的话
    // 需要自己手动的释放的消息
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        try {
            // 用于获取客户端发来的数据信息
            SmartCarProtocol body = (SmartCarProtocol) msg;
            System.out.println("Client接受的客户端的信息 :" + body.toString());

        } finally {
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

}