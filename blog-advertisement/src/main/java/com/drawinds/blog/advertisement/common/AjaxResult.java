package com.drawinds.blog.advertisement.common;

import lombok.Data;

import java.io.Serializable;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2019/1/31 19:55
 * Description:
 */
@Data
public class AjaxResult<T> implements Serializable {
    private long code;

    private T data;

    private String message;
}
