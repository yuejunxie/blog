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
public class RoleInfo extends DataObject {
    /**
     * 主键ID
     */
    @Id
    private Integer id;
    /**
     * 角色编码
     */
    @NonNull
    private String code;
    /**
     * 角色名称
     */
    @NonNull
    private String name;
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
