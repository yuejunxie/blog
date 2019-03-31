package com.drawinds.blog.source.aop.proxy.jdk;

import com.drawinds.blog.source.aop.proxy.GamePlayer;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2019/3/23 10:41
 * Description:
 */
@Slf4j
public class GamPlyerImpl implements GamePlayer {

    private String name;

    public GamPlyerImpl(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String talk() {
        return "My name is " + name;
    }

    @Override
    public void jump() {
        log.info("I have jumped from there to here!");
    }

    @Override
    public void slade() {
        log.info("It's time for the show!");
    }
}
