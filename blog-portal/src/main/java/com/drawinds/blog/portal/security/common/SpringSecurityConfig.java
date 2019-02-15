package com.drawinds.blog.portal.security.common;

import com.drawinds.blog.portal.security.form.*;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

/**
 * Author: JackShieh
 * Corporation: Drawinds LTD
 * WE FLY WE DREAM
 * blog
 * Created: 2019/1/29 12:17
 * Description:
 */
@Configuration
public class SpringSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityContextLogoutHandler logoutHandler() {
        return new FormSecurityContextLogoutHandler();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(UserDetailsService userDetailsService) {
        FormAuthenticationProvider authenticationProvider = new FormAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        return authenticationProvider;
    }

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new FormAuthenticationFailureHandler();
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new FormAuthenticationSuccessHandler();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new FormUserDetailsService();
    }

}
