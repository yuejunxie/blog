package com.drawinds.blog.advertisement.web.rest;

import com.drawinds.blog.advertisement.common.AjaxResult;
import com.drawinds.blog.advertisement.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2019/1/31 20:01
 * Description:
 */
@RestController
@RequestMapping(value = "/api/v1/advertisement", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AdvertisementRestful {

    @Autowired
    private AdvertisementService advertisementService;

    @PostMapping
    public AjaxResult<Void> newAdvertisement(String name, String content) {
        advertisementService.newAdvertisement(name, content);
        return new AjaxResult<>();
    }
}
