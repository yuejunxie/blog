package com.drawinds.blog.enterprise.web.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2019/4/7 18:11
 * Description:
 */
@RestController
@RequestMapping(value = "/index", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class IndexRest {

    @GetMapping
    public String index(ServletRequest request) {
        return "登陆成功";
    }
}
