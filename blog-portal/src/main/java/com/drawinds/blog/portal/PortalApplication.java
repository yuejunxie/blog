package com.drawinds.blog.portal;

import com.drawinds.blog.portal.config.xa.DBConfig;
import com.drawinds.blog.portal.share.config.xa.ShareDBConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2018/12/28 21:51
 * Description:
 */
//@EnableHystrix
//@EnableHystrixDashboard
//@EnableFeignClients
//@EnableCircuitBreaker
@EnableConfigurationProperties({DBConfig.class, ShareDBConfig.class})
@SpringBootApplication
public class PortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(PortalApplication.class, args);
    }
}
