package com.drawinds.blog.source.aop.proxy.cglib;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2019/3/23 19:35
 * Description:
 */
@Slf4j
public class HelloMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        log.info("before");
        Object object = methodProxy.invokeSuper(o, objects);
        log.info("after");
        LinkedList r = new LinkedList();
        PriorityQueue priorityQueue = new PriorityQueue();
        return object;
    }

    public static void main(String[] args) {
        TreeMap<String, String> treeMap = new TreeMap((o1, o2) -> {
            if (o1 == null) {
                return 1;
            } else if (o2 == null) {
                return -1;
            } else {
                return o1.hashCode() - o2.hashCode();
            }
        });
        treeMap.put("asd", "ad");
        treeMap.put(null, "sdf");
        String s = treeMap.get(null);
        System.out.println(s);
//        weakRef();
    }

    private static void weakRef() {
        Car car = new Car(22000, "silver");
        WeakReference<Car> weakCar = new WeakReference<>(car);

        int i = 0;

        while (true) {
//            System.out.println("here is the strong reference 'car' " + car);
            if (weakCar.get() != null) {
                i++;
                System.out.println("Object is alive for " + i + " loops - " + weakCar);
            } else {
                System.out.println("Object has been collected.");
                break;
            }
        }
    }
}

class Car {

    private int code;

    private String name;

    public Car(int code, String name) {
        this.code = code;
        this.name = name;
    }
}
