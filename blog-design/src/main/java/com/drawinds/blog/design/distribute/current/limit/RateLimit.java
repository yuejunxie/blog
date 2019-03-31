package com.drawinds.blog.design.distribute.current.limit;

import com.google.common.util.concurrent.RateLimiter;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2019/3/31 12:24
 * Description:
 */
public class RateLimit {
    private RateLimiter rateLimiter = RateLimiter.create(4000);

    public void rateLimit(){
        rateLimiter.tryAcquire();
    }
}
