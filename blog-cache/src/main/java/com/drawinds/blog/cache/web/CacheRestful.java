package com.drawinds.blog.cache.web;

import com.drawinds.blog.cache.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2019/3/10 18:04
 * Description:
 */
@RestController
@RequestMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CacheRestful {

    @Autowired
    private CacheService cacheService;

    @GetMapping("/name")
    public String getName() {
        return cacheService.cacheName();
    }


}
