package com.drawinds.blog.portal.service.impl;

import com.drawinds.blog.portal.mapper.UserInfoMapper;
import com.drawinds.blog.portal.model.UserInfo;
import com.drawinds.blog.portal.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2018/12/28 23:42
 * Description:
 */
@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;


    @Override
    public UserInfo getByAccount(String account) {
        return userInfoMapper.findByAccount(account);
    }

    @Override
    public int addUser() {
        return userInfoMapper.addUser(new UserInfo());
    }
}
