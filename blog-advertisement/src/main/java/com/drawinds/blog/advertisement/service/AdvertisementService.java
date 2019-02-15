package com.drawinds.blog.advertisement.service;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2019/1/31 20:04
 * Description:
 */
public interface AdvertisementService {
    /**
     *
     * @param name
     * @param content
     * @return
     */
    int newAdvertisement(String name, String content);
}
