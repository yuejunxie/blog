package com.drawinds.blog.cache;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2019/3/10 17:51
 * Description:
 */
@SpringBootApplication
public class CacheApplication {

//    static {
//        System.setProperty("", "true");
//    }

    public static void main(String[] args) {
//        SpringApplication.run(CacheApplication.class, args);\
        Runnable task = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 8, 30, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10));
        ThreadPoolExecutor executor1 = new ThreadPoolExecutor(4, 8, 30, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10));
        for (int i = 0; i < 100; i++) {
            executor.execute(task);
            executor1.execute(task);
        }
        while (true) {

        }
    }
}
