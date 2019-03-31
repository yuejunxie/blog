package com.drawinds.blog.usercenter.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@AllArgsConstructor
@NoArgsConstructor
public class AjaxResult<T> implements Serializable {
    private long code = 0x00000001;

    private T data;

    private String message;

    public AjaxResult(T data) {
        this.data = data;
    }
}
