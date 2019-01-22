package com.drawinds.blog.advetisement.config;

import com.drawinds.blog.advetisement.distributed.lock.DistributedLockTemplate;
import com.drawinds.blog.advetisement.distributed.lock.SingleDistributedLockTemplate;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * Author: JackShieh
 * Corporation: Drawinds LTD
 * WE FLY WE DREAM
 * blog
 * Created: 2019/1/13 19:19
 * Description: Redisson配置
 */
@Configuration
public class RedissonConfig {

    @Bean
    public RedissonClient redisson() throws IOException {
        Config config = Config.fromJSON(Redisson.class.getClassLoader().getResource("redisson-config.yml"));
//        config.useSentinelServers()
//                .setMasterName("mymaster")
//                .addSentinelAddress("redis://192.168.1.1:26379")
//                .setPassword("123456");
        return Redisson.create(config);
    }

    @Bean
    public DistributedLockTemplate distributedLock(RedissonClient redisson) {
        return new SingleDistributedLockTemplate(redisson);
    }
}
