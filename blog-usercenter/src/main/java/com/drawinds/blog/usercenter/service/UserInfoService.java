package com.drawinds.blog.usercenter.service;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2019/1/31 19:59
 * Description:
 */
public interface UserInfoService {
    /**
     * 创建新用户
     *
     * @param username
     * @return
     */
    int addUser(String username) throws Exception;
}
