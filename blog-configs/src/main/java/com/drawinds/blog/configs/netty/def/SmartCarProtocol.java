package com.drawinds.blog.configs.netty.def;

import lombok.Data;

/**
 * Author: JackShieh
 * Corporation: Drawinds LTD
 * WE FLY WE DREAM
 * blog
 * Created: 2019/2/17 15:47
 * Description:
 */
@Data
public class SmartCarProtocol {

    private int headData = ConstantValue.HEAD_DATA;

    private int contentLength;

    private byte[] content;

    public SmartCarProtocol(int contentLength, byte[] content) {
        this.contentLength = contentLength;
        this.content = content;
    }
}
