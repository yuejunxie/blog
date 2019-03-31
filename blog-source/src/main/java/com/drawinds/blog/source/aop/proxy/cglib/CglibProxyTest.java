package com.drawinds.blog.source.aop.proxy.cglib;

import org.junit.Test;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2019/3/23 19:57
 * Description:
 */
public class CglibProxyTest {

    @Test
    public void cglib() {
        // 代理类class文件存入本地磁盘方便我们反编译查看源码
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\code");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(PersonService.class);
        enhancer.setCallback(new HelloMethodInterceptor());
        PersonService proxy = (PersonService) enhancer.create();
        proxy.sayHello();
    }
}
