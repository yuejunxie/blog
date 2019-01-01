package com.drawinds.blog.portal.model;

import lombok.Data;
import lombok.NoArgsConstructor;

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
public class UserInfo {
    /*
     * 主键
     */
    private String id;
    /*
     * 账号
     */
    private String account;
    /*
     * 昵称
     */
    private String nickName;
    /*
     * 名字
     */
    private String name;
    /*
     * 出生日期
     */
    private Date birthday;
    /*
     *微信号
     */
    private String wechat;
    /*
     * 手机号码
     */
    private String phone;
    /*
     *邮箱
     */
    private String email;
    /*
     *身份证号码
     */
    private String identification;
    /*
     *记录创建时间
     */
    private Date created;
    /*
     *记录修改时间
     */
    private Date modified;
    /*
     *记录创建人
     */
    private String createdBy;
    /*
     *记录修改时间
     */
    private String modifyBy;
    /*
     * 数据有效性
     */
    private Boolean data_valid = true;
}
