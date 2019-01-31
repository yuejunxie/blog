package com.drawinds.blog.portal.security.common;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Author: JackShieh
 * Corporation: Drawinds LTD
 * WE FLY WE DREAM
 * blog
 * Created: 2019/1/29 13:32
 * Description:
 */
@ConfigurationProperties(prefix = "securty.config")
@Data
public class SecurityConfigProperties {

    private String successUrl = "/center";

    private String failUrl = "/toLogin";

    private String toLoginUrl = "/redirect?login=/toLogin";

    private String doLoginUrl = "/formLogin";

    private String logoutUrl = "/logout";


}
