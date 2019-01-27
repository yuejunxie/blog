package com.drawinds.blog.portal.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author: JackShieh
 * Corporation: Drawinds LTD
 * WE FLY WE DREAM
 * blog
 * Created: 2019/1/27 21:58
 * Description:
 */
@Configuration
public class SecurityConfig {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private LogoutSuccessHandler logoutSuccessHandler;

    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;


    @Bean
    public WebSecurityConfigurerAdapter webSecurityConfigurerAdapter() {
        return new WebSecurityConfigurerAdapter() {

            @Override
            protected void configure(HttpSecurity http) throws Exception {
                http.authorizeRequests()
//                        .antMatchers("/").permitAll()
                        .anyRequest().authenticated()
                        .and().logout().permitAll().invalidateHttpSession(true).deleteCookies("session").logoutSuccessHandler(logoutSuccessHandler)
                        .and().formLogin().successHandler(authenticationSuccessHandler)
//                        .and().formLogin()//.permitAll().loginPage("/usercenter/login").successHandler(authenticationSuccessHandler)//.loginProcessingUrl("")
//                        .and().logout().permitAll()
                        .and().sessionManagement().maximumSessions(100).and()//.expiredUrl("/usercenter/login");
                        .and().csrf().disable()
                ;

//                http.formLogin()          // 定义当需要用户登录时候，转到的登录页面。
////                        .loginPage("/login.html")      // 设置登录页面
////                        .loginProcessingUrl("/user/login") // 自定义的登录接口
//                        .and()
//                        .authorizeRequests()    // 定义哪些URL需要被保护、哪些不需要被保护
////                        .antMatchers("/login.html").permitAll()   // 设置所有人都可以访问登录页面
//                        .anyRequest()        // 任何请求,登录后可以访问
//                        .authenticated()
//                        .and().csrf().disable();     // 关闭csrf防护
            }

            @Override
            public void configure(WebSecurity web) throws Exception {
                web.ignoring().antMatchers("/js/**", "/css/**", "/images/**");
            }

            @Override
            protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication().usersByUsernameQuery("").authoritiesByUsernameQuery("").passwordEncoder();
                auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
                auth.inMemoryAuthentication().withUser("admin").password("123456").roles("admin");
            }
        };
    }

}
