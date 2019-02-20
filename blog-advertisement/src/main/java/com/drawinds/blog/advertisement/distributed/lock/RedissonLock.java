package com.drawinds.blog.advetisement.distributed.lock;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Author: JackShieh
 * Corporation: Drawinds LTD
 * WE FLY WE DREAM
 * blog
 * Created: 2019/1/13 19:26
 * Description:
 */
@Service
public class RedissonLock {

    @Autowired
    private RedissonClient redisson;


    public void lock(String id) {
        RLock rLock = redisson.getLock(id);
        rLock.lock(3, TimeUnit.SECONDS);
    }

    public void unlock(String id) {

    }


}
