package com.drawinds.blog.repo.usercenter.repo;

import com.drawinds.blog.entity.usercenter.entity.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2019/4/6 0:14
 * Description:
 */
public interface AccountTypeRepository extends JpaRepository<AccountType, Integer> {

    AccountType getAccountTypeById(Integer id);

    AccountType getAccountTypeByCode(String code);
}
