package com.drawinds.blog.enterprise.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2019/4/7 18:25
 * Description:
 */
@Configuration
@Slf4j
public class SessionConfig {

    private static final Map<String, HttpSession> sessions = new HashMap<>();

    public List<HttpSession> getActiveSessions() {
        return new ArrayList<>(sessions.values());
    }

    @Bean
    public HttpSessionListener httpSessionListener() {
        return new HttpSessionListener() {
            @Override
            public void sessionCreated(HttpSessionEvent hse) {
                log.info("Session Created");
                sessions.put(hse.getSession().getId(), hse.getSession());
                sessions.forEach((k, v) -> log.info(k + v.toString()));
            }


            @Override
            public void sessionDestroyed(HttpSessionEvent hse) {
                log.info("Session Removed");
                sessions.remove(hse.getSession().getId());
                sessions.forEach((k, v) -> log.info(k + v.toString()));
            }
        };
    }

}
