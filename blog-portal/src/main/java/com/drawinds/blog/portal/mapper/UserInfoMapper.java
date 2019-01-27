package com.drawinds.blog.portal.mapper;

import com.drawinds.blog.portal.model.UserInfo;
import org.apache.ibatis.annotations.*;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2018/12/28 22:58
 * Description:
 */
@Mapper
public interface UserInfoMapper {

    @SelectProvider(type = UserInfoProvider.class, method = "findByAccount")
    UserInfo findByAccount(@Param("account") String account);

    @Insert("insert into uc_user_info (username) values (#{username})")
    int addUser(UserInfo userInfo);
}
