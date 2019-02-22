package com.drawinds.blog.rpc;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: JackShieh
 * Corporation: Drawinds LTD
 * WE FLY WE DREAM
 * blog
 * Created: 2019/2/20 22:25
 * Description:
 */
@Slf4j
public class PortGenerator {

    public static void main(String[] args) {
        String app = "blog";
        int res = 0, time = 1;
        char[] chars = app.toCharArray();
        for (char c : chars) {
            res += time * c;
            time = time << 1;
        }
        log.info(res+"");

    }
}
