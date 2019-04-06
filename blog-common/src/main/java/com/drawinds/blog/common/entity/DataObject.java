package com.drawinds.blog.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2019/4/5 23:33
 * Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataObject {
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
