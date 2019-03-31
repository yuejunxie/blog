package com.drawinds.blog.source.aop.proxy.jdk;

import com.drawinds.blog.source.aop.proxy.GamePlayer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2019/3/23 10:45
 * Description:
 */
public class GemaPlayerHandler implements InvocationHandler {

    private GamePlayer gamePlayer;

    public GemaPlayerHandler(GamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(gamePlayer, args);
    }
}
