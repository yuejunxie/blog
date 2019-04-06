package com.drawinds.blog.repo.usercenter.repo;

import com.drawinds.blog.entity.usercenter.entity.RoleInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2019/4/5 22:36
 * Description:
 */
public interface RoleInfoRepository extends JpaRepository<RoleInfo, Integer> {

    RoleInfo getRoleInfoById(Integer id);

    RoleInfo getRoleInfoByCode(String code);
}
