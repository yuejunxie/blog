package com.drawinds.blog.cache.service.impl;

import com.drawinds.blog.cache.service.CacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2019/3/10 18:01
 * Description:
 */
@Slf4j
@Service
public class CacheServiceImpl implements CacheService {

    @Cacheable(value = "name")
    @Override
    public String cacheName() {
        log.info("cache");
        return "abc";
    }
}
