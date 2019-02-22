package com.drawinds.blog.grpc.netty.http;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpContentCompressor;
import io.netty.handler.codec.http.HttpContentDecompressor;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * Author: JackShieh
 * Corporation: Drawinds LTD
 * WE FLY WE DREAM
 * blog
 * Created: 2019/2/21 14:51
 * Description: HTTP压缩
 */
public class HttpCompressionInitializer extends ChannelInitializer<Channel> {

    private final boolean server;

    public HttpCompressionInitializer(boolean server) {
        this.server = server;
    }

    @Override
    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast("codec", server ? new HttpServerCodec() : new HttpClientCodec());
        pipeline.addLast(server ? "compressor" : "decompressor", server ? new HttpContentCompressor() : new HttpContentDecompressor());

    }
}
