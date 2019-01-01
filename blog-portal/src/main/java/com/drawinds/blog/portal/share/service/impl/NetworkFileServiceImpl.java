package com.drawinds.blog.portal.share.service.impl;

import com.drawinds.blog.portal.share.mapper.NetworkFileMapper;
import com.drawinds.blog.portal.share.model.NetworkFile;
import com.drawinds.blog.portal.share.service.NetworkFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2018/12/30 13:31
 * Description:
 */
@Service
@Transactional(transactionManager = "shareDataSourceTransactionManager")
public class NetworkFileServiceImpl implements NetworkFileService {

    @Autowired
    private NetworkFileMapper networkFileMapper;


    @Override
    public NetworkFile getNetworkFileById(String id) {
        return networkFileMapper.getNetworkFileById(id);
    }

    @Override
    @Cacheable
    public int addNetworkFile(NetworkFile networkFile) {
        int i = networkFileMapper.addNetworkFile(networkFile);
        throw new RuntimeException();
//        return i;
    }
}
