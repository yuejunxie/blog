package com.drawinds.blog.enterprise.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2019/4/7 13:29
 * Description:
 */
@RestController
@RequestMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserInfoApi implements com.drawinds.blog.api.usercenter.api.UserInfoApi {

    @Override
    @GetMapping
    public com.drawinds.blog.api.usercenter.api.UserInfoApi getUserInfo(String username) {
        return null;
    }
}
