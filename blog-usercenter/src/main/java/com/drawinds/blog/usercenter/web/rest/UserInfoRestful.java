package com.drawinds.blog.usercenter.web.rest;

import com.drawinds.blog.usercenter.common.AjaxResult;
import com.drawinds.blog.usercenter.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
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
 * Created: 2019/1/31 19:51
 * Description:
 */
@Slf4j
@RestController
@RequestMapping(value = "/api/v1/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserInfoRestful {

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping
    public AjaxResult<Void> addUser(String username) {
        try {
            userInfoService.addUser(username);
            log.error("success");
        } catch (Exception e) {
            log.error("failed", e);
        }
        return new AjaxResult();
    }

}
