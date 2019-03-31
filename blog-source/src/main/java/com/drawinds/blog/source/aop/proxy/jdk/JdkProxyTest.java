package com.drawinds.blog.source.aop.proxy.jdk;

import com.drawinds.blog.source.aop.proxy.GamePlayer;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2019/3/23 10:46
 * Description:
 */
@Slf4j
public class JdkProxyTest {

    static {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
//        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "C:\\class");
    }

    @Test
    public void jdkTest() {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        GamePlayer target = new GamPlyerImpl("Jack");
        GemaPlayerHandler handler = new GemaPlayerHandler(target);
        GamePlayer proxy = (GamePlayer) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class<?>[]{GamePlayer.class}, handler);
        Class<? extends GamePlayer> proxyClass = proxy.getClass();
        log.info(proxyClass.getName());
        log.info("父类");
        Class<?> superclass = proxyClass.getSuperclass();
        log.info(superclass.getName());
        log.info("父接口");
        Class<?>[] interfaces = proxyClass.getInterfaces();
        for (Class<?> intef : interfaces) {
            log.info(intef.getName());
        }
        log.info("字段");
        Field[] fields = proxyClass.getFields();
        for (Field field : fields) {
            log.info(field.toString());
        }
        log.info("构造函数");
        Constructor<?>[] constructors = proxyClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            log.info(constructor.toString());
        }
        log.info("方法");
        Method[] methods = proxyClass.getMethods();
        for (Method method : methods) {
            log.info(method.toString());
        }
        //保存
        byte[] bytes = ProxyGenerator.generateProxyClass("", new Class[]{GamePlayer.class});
        try(FileOutputStream fos =new FileOutputStream(new File("D:/$Proxy.class"))){
            fos.write(bytes);
            fos.flush();
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
