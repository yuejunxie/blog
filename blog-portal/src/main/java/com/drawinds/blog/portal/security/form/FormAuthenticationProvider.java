package com.drawinds.blog.portal.security.form;

import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * Author: JackShieh
 * Corporation: Drawinds LTD
 * WE FLY WE DREAM
 * blog
 * Created: 2019/1/29 12:38
 * Description:
 */
public class FormAuthenticationProvider extends DaoAuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getPrincipal() == null ? "NONE_PROVIDED" : authentication.getName();
        if (!"NONE_PROVIDED".equals(username)) {
            //检查失败次数
//            throw new LockedException("User Locked:" + username);
        }
        return super.authenticate(authentication);
    }



}
