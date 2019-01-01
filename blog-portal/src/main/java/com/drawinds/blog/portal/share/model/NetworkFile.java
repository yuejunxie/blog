package com.drawinds.blog.portal.share.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2018/12/29 21:57
 * Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NetworkFile {
    private String id;

    private String name;

    private String storageType;

    private String location;

    private Date created;

    private String createBy;

    private Date modified;

    private String modifyBy;

    private Boolean dataValid = true;

}
