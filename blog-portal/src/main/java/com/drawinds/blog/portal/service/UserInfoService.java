package com.drawinds.blog.portal.service;

import com.drawinds.blog.portal.model.UserInfo;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2018/12/28 23:42
 * Description:
 */
public interface UserInfoService {
    /**
     * 账号查询
     *
     * @param account
     * @return
     */
    UserInfo getByAccount(String account);

    int addUser();
}
