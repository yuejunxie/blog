package com.drawinds.blog.api.usercenter.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2019/4/6 13:43
 * Description:
 */
@RequestMapping(value = "/cloud/v1/user")
public interface UserInfoApi {

    @GetMapping("/")
    UserInfoApi getUserInfo(String username);
}
