package com.drawinds.blog.portal.share.mapper;

import com.drawinds.blog.portal.share.model.NetworkFile;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2018/12/29 22:34
 * Description:
 */
@Mapper
public interface NetworkFileMapper {

    @Select("SELECT * FROM network_file WHERE id = #{id}")
    NetworkFile getNetworkFileById(String id);

    @Insert("INSERT INTO network_file (name, storage_type, location) VALUES (#{name}, #{storageType}, #{location})")
    int addNetworkFile(NetworkFile networkFile);
}
