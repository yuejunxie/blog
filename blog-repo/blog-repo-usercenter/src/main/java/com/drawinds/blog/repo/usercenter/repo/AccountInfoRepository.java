package com.drawinds.blog.repo.usercenter.repo;

import com.drawinds.blog.entity.usercenter.entity.AccountInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2019/4/5 22:36
 * Description:
 */
public interface AccountInfoRepository extends JpaRepository<AccountInfo, String> {

    AccountInfo getAccountInfoById(String id);

    AccountInfo getAccountInfoByAccount(String account);

    AccountInfo getAccountInfoByAccountAndType(String account, String type);

}
