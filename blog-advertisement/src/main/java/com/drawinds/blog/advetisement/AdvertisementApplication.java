package com.drawinds.blog.advetisement;

import org.redisson.spring.session.config.EnableRedissonHttpSession;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Author: JackShieh
 * Corporation: Drawinds LTD
 * WE FLY WE DREAM
 * blog
 * Created: 2019/1/13 19:19
 * Description:
 */
@SpringBootApplication
@EnableRedissonHttpSession
public class AdvertisementApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdvertisementApplication.class, args);
    }
}
