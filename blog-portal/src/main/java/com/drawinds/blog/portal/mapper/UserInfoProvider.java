package com.drawinds.blog.portal.mapper;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.jdbc.SQL;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2018/12/29 19:50
 * Description:
 */
@Slf4j
public class UserInfoProvider {

    public String findByAccount() {
        String sql = new SQL().SELECT("id","account","nick_name","name","birthday").FROM("uc_user_info").WHERE("account=#{account}").toString();
        return sql.toString();
    }
}
