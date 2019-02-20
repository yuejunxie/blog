package com.drawinds.blog.configs.netty.def;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Author: JackShieh
 * Corporation: Drawinds LTD
 * WE FLY WE DREAM
 * blog
 * Created: 2019/2/17 16:17
 * Description:
 */
public class ServerHandler extends ChannelHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // 用于获取客户端发来的数据信息
        SmartCarProtocol body = (SmartCarProtocol) msg;
        System.out.println("Server接受的客户端的信息 :" + body.toString());

        // 会写数据给客户端
        String str = "Hi I am Server ...";
        SmartCarProtocol response = new SmartCarProtocol(str.getBytes().length,
                str.getBytes());
        // 当服务端完成写操作后，关闭与客户端的连接
        ctx.writeAndFlush(response);
        // .addListener(ChannelFutureListener.CLOSE);

        // 当有写操作时，不需要手动释放msg的引用
        // 当只有读操作时，才需要手动释放msg的引用
    }



    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        // cause.printStackTrace();
        ctx.close();
    }
}
