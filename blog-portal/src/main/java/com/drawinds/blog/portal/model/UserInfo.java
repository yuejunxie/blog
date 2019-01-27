package com.drawinds.blog.portal.model;

import lombok.*;

import java.util.Date;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2018/12/28 22:25
 * Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class UserInfo {
    /*
     * 主键
     */
    private Integer id;
    /*
     * 用户名
     */
    @NonNull
    private String username;
    /*
     * 账号
     */
    private String account;
    /*
     * 昵称
     */
    private String nickName;
    /*
     *身份证号码
     */
    private String identification;
    /*
     * 姓
     */
    private String surname;
    /*
     * 名
     */
    private String name;
    /*
     * 出生日期
     */
    private Date birthday;
    /*
     * 微信号
     */
    private String wechat;
    /*
     * QQ号
     */
    private String qq;
    /*
     * 手机号码
     */
    private String telephone;
    /*
     * 手机号码
     */
    private String mobilePhone;
    /*
     * 邮箱
     */
    private String email;
    /*
     * 创建时间
     */
    private Date created;
    /*
     * 创建人
     */
    private String createdBy;
    /*
     * 修改时间
     */
    private Date modified;
    /*
     * 修改人
     */
    private String modifiedBy;
    /*
     * 数据有效性
     */
    private Boolean dataValid = true;
}
