package com.drawinds.blog.grpc.netty.http;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * Author: JackShieh
 * Corporation: Drawinds LTD
 * WE FLY WE DREAM
 * blog
 * Created: 2019/2/21 14:42
 * Description: 聚合HTTP消息
 */
public class HttpAggregatorInitializer extends ChannelInitializer<Channel> {

    private final boolean server;

    public HttpAggregatorInitializer(boolean server) {
        this.server = server;
    }

    @Override
    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast("codec", server ? new HttpServerCodec() : new HttpClientCodec());
        //512KB
        pipeline.addLast("aggregator", new HttpObjectAggregator(512 * 1024));
    }
}
