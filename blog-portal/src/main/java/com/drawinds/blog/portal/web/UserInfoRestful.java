package com.drawinds.blog.portal.web;

import com.drawinds.blog.portal.model.UserInfo;
import com.drawinds.blog.portal.service.UserInfoService;
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
 * Created: 2018/12/28 23:43
 * Description:
 */
@RestController
@RequestMapping(value = "/userInfo", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserInfoRestful {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping
    public UserInfo getByAccount(String account) {
        return userInfoService.getByAccount(account);
    }

    @GetMapping("/add")
    public int addUser() {
        return userInfoService.addUser();
    }

}
