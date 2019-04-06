package com.drawinds.blog.repo.usercenter.repo;

import com.drawinds.blog.entity.usercenter.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2019/4/5 22:35
 * Description:
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, String> {

    UserInfo getUserInfoById(String id);

    UserInfo getUserInfoByUsername(String username);
}
