package com.drawinds.blog.enterprise.api.feign;

import com.drawinds.blog.api.usercenter.api.UserInfoApi;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2019/4/7 13:30
 * Description:
 */
@FeignClient(name = "usercenter")
@Hystrix
public interface UserInfoFeign extends UserInfoApi {

}
