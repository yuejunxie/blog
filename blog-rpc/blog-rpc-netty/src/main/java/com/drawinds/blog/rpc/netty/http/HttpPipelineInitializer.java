package com.drawinds.blog.rpc.netty.http;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpRequestEncoder;
import io.netty.handler.codec.http.HttpResponseDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;

/**
 * Author: JackShieh
 * Corporation: Drawinds LTD
 * WE FLY WE DREAM
 * blog
 * Created: 2019/2/20 22:34
 * Description: HTTP解码器，编码器，编解码器
 */
public class HttpPipelineInitializer extends ChannelInitializer<Channel> {

    private final boolean server;

    public HttpPipelineInitializer(boolean server) {
        this.server = server;
    }

    @Override
    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast("decoder", server ? new HttpRequestDecoder() : new HttpResponseDecoder());
        pipeline.addLast("encoder", server ? new HttpResponseEncoder() : new HttpRequestEncoder());
    }
}
