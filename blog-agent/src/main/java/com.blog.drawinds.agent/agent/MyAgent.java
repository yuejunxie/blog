package com.blog.drawinds.agent.agent;

import lombok.extern.slf4j.Slf4j;

import java.lang.instrument.Instrumentation;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2019/3/12 22:26
 * Description:
 */
@Slf4j
public class MyAgent {

    public static void premain(String agentArgs, Instrumentation inst) {
        log.info("this is an agent.");
        log.info("args:" + agentArgs + "\n");
    }
}
