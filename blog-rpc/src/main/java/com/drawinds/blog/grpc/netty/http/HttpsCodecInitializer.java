package com.drawinds.blog.grpc.netty.http;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslHandler;

import javax.net.ssl.SSLEngine;

/**
 * Author: JackShieh
 * Corporation: Drawinds LTD
 * WE FLY WE DREAM
 * blog
 * Created: 2019/2/21 14:55
 * Description:
 */
public class HttpsCodecInitializer extends ChannelInitializer<Channel> {

    private final SslContext sslContext;
    private final boolean server;

    public HttpsCodecInitializer(SslContext sslContext, boolean server) {
        this.sslContext = sslContext;
        this.server = server;
    }

    @Override
    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        SSLEngine sslEngine = sslContext.newEngine(ch.alloc());
        pipeline.addFirst("ssl", new SslHandler(sslEngine));
        pipeline.addLast("codec", server ? new HttpServerCodec() : new HttpClientCodec());
    }
}
