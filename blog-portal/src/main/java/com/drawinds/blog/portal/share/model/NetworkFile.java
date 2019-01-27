package com.drawinds.blog.portal.share.model;

import lombok.*;

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
@RequiredArgsConstructor
public class NetworkFile {

    private Integer id;

    @NonNull
    private String name;

    @NonNull
    private String storageType;

    @NonNull
    private String location;

    private Date created;

    private String createdBy;

    private Date modified;

    private String modifiedBy;

    private Boolean dataValid = true;

}
