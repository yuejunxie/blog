package com.drawinds.blog.advertisement;

import org.redisson.spring.session.config.EnableRedissonHttpSession;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2019/1/31 18:59
 * Description:
 */
@SpringBootApplication
@EnableRedissonHttpSession
public class AdvertisementApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdvertisementApplication.class, args);
    }
}
