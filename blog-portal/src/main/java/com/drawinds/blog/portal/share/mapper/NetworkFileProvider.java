package com.drawinds.blog.portal.share.mapper;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2018/12/30 12:34
 * Description:
 */
public class NetworkFileProvider {

    public String addNetworkFile(){
        return "INSERT INTO network_file (id, name, storage_type, location, created, create_by, modified, modify_by, data_valid) VALUES (#{id}, #{name}, #{storageType}, #{location}, #{created}, #{createBy}, #{modified}, #{modifyBy}, #{dataValid})";
    }
}
