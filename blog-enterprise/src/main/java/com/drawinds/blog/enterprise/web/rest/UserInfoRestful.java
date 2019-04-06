package com.drawinds.blog.enterprise.web.rest;

import com.drawinds.blog.entity.usercenter.entity.UserInfo;
import com.drawinds.blog.repo.usercenter.repo.UserInfoRepository;
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
 * Created: 2019/4/6 0:48
 * Description:
 */
@RestController
@RequestMapping(path = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserInfoRestful {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @GetMapping
    public UserInfo userInfo(String username) {
        return userInfoRepository.getUserInfoByUsername(username);
    }
}
