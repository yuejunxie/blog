package com.drawinds.blog.configs.netty.def;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;

/**
 * Author: JackShieh
 * Corporation: Drawinds LTD
 * WE FLY WE DREAM
 * blog
 * Created: 2019/2/17 21:04
 * Description:
 */
public class DelimiterFrameDecoder extends DelimiterBasedFrameDecoder {

    public DelimiterFrameDecoder(int maxFrameLength, ByteBuf delimiter) {
        super(maxFrameLength, delimiter);
    }
}
