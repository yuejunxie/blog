package com.drawinds.blog.portal.share.service;

import com.drawinds.blog.portal.share.model.NetworkFile;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2018/12/30 13:31
 * Description:
 */
public interface NetworkFileService {
    /**
     *
     * @param id
     * @return
     */
    NetworkFile getNetworkFileById(String id);

    /**
     *
     * @param networkFile
     * @return
     */
    int addNetworkFile(NetworkFile networkFile);
}
