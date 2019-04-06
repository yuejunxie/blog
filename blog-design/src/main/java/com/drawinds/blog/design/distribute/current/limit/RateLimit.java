package com.drawinds.blog.design.distribute.current.limit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2019/3/31 12:24
 * Description:
 */
@Slf4j
public class RateLimit {
    private RateLimiter rateLimiter = RateLimiter.create(4000);

    public void rateLimit() {
        rateLimiter.tryAcquire();
    }

    //限流接口每秒的请求数
    public void instantCache() throws ExecutionException {
        LoadingCache<Long, AtomicLong> counter = CacheBuilder.newBuilder().expireAfterAccess(2, TimeUnit.SECONDS)
                .build(new CacheLoader<Long, AtomicLong>() {
                    @Override
                    public AtomicLong load(Long key) throws Exception {
                        return new AtomicLong(0);
                    }
                });
        long limit = 1000;
        while (true) {
            long currentSeconds = System.currentTimeMillis() / 1000;
            if (counter.get(currentSeconds).incrementAndGet() > limit) {
                log.info("限流");
                continue;
            }
        }
    }

}
