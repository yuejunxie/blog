package com.drawinds.blog.advetisement;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RBucket;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * Author: JackShieh
 * Corporation: Drawinds LTD
 * WE FLY WE DREAM
 * blog
 * Created: 2019/1/13 19:31
 * Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Component
public class RedissonTest {

    String lockKey = "testRedisson";//分布式锁的key

    @Autowired
    private RedissonClient redisson;

    @Test
    public void set() {
        // 设置字符串
        RBucket<String> keyObj = redisson.getBucket("k1");
        keyObj.set("v1236");
    }

    @Test
    public void testDistributed() {
        //执行的业务代码
        for (int i = 0; i < 55; i++) {
            RLock lock = redisson.getLock(lockKey);
            lock.lock(60, TimeUnit.SECONDS); //设置60秒自动释放锁  （默认是30秒自动过期）
//            int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("aaa").toString());
//            if (stock > 0) {
//                stringRedisTemplate.opsForValue().set("aaa", (stock - 1) + "");
//                System.out.println("test2_:lockkey:" + lockKey + ",stock:" + (stock - 1) + "");
//            }
            lock.unlock(); //释放锁
        }
    }
}
