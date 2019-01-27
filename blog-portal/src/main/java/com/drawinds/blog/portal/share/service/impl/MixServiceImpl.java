package com.drawinds.blog.portal.share.service.impl;

import com.drawinds.blog.portal.mapper.UserInfoMapper;
import com.drawinds.blog.portal.model.UserInfo;
import com.drawinds.blog.portal.share.mapper.NetworkFileMapper;
import com.drawinds.blog.portal.share.model.NetworkFile;
import com.drawinds.blog.portal.share.service.MixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Author: JackShieh
 * Corporation: Drawinds LTD
 * WE FLY WE DREAM
 * blog
 * Created: 2019/1/27 16:57
 * Description:
 */
@Service
@Transactional(transactionManager = "xatx")//(transactionManager = "shareDataSourceTransactionManager")
public class MixServiceImpl implements MixService {


    @Override
    public void mixAdd() {
        NetworkFile networkFile = new NetworkFile("测试", "xxx", "/da/sd");
        userInfoMapper.addUser(new UserInfo("liwen"));
        networkFileMapper.addNetworkFile(networkFile);
        throw new RuntimeException();
    }

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private NetworkFileMapper networkFileMapper;
}
