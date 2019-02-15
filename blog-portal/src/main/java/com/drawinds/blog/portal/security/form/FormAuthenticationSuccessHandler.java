package com.drawinds.blog.portal.security.form;

import io.netty.util.internal.StringUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.web.servlet.handler.DispatcherServletWebRequest;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author: JackShieh
 * Corporation: Drawinds LTD
 * WE FLY WE DREAM
 * blog
 * Created: 2019/1/29 12:37
 * Description:
 */
@Slf4j
public class FormAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        //清除失败次数
        String username = authentication.getName();
        String forwardedFor = request.getHeader("X-Forwarded-For");
        String remoteHost = StringUtil.isNullOrEmpty(forwardedFor) ? request.getRemoteHost() : forwardedFor;
        String clientType = request.getHeader("ClientType");
        SessionUser sessionUser = new SessionUser(username, clientType, remoteHost);
        request.getSession().setAttribute("user", sessionUser);
        super.onAuthenticationSuccess(request, response, authentication);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class SessionUser {
        private String username;
        private String clientType;
        private String remoteHost;

    }
}
