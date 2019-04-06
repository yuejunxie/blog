package com.drawinds.blog.entity.usercenter.entity;

import com.drawinds.blog.common.entity.DataObject;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2019/4/5 22:42
 * Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class AccountInfo extends DataObject {
    /**
     * 主键ID
     */
    @Id
    private String id;
    /**
     * 账号-联合唯一索引
     */
    @NonNull
    private String account;
    /**
     * 账号类型-联合唯一索引
     */
    @NonNull
    private String type;
    /**
     * 验证
     */
    private String authentication;
    /**
     * 账号状态
     */
    private AccountStatus status;
    /**
     * 用户角色-外键角色表
     */
    private String role;
    /**
     * 用户名-外键用户表
     */
    private String username;
    //公共信息
    /**
     * 创建者
     */
    private String creator = "sys";
    /**
     * 创建日期
     */
    private Instant created;
    /**
     * 修改者
     */
    private String modifier = "sys";
    /**
     * 修改日期
     */
    private Instant modified;
    /**
     * 有效性
     */
    private Boolean valid = true;
}

enum AccountStatus {
    NEW, NORMAL, LOCKED, RISTRICTED, CLOSED, DELETED
}
