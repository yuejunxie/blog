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
 * Created: 2019/4/5 22:40
 * Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class UserInfo extends DataObject {
    /**
     * 主键ID
     */
    @Id
    private String id;
    /**
     * 用户名
     */
    @NonNull
    private String username;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 姓名
     */
    private String name;
    /**
     * 身份证号
     */
    private String identification;
    /**
     * 出生日期
     */
    private Instant birthday;
    /**
     * 性别
     */
    private String gender;
    /**
     * 微信
     */
    private String wechat;
    /**
     * QQ号
     */
    private String qq;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
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
