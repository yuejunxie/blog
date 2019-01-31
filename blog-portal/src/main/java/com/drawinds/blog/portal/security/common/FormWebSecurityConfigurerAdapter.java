package com.drawinds.blog.portal.security.common;

import com.drawinds.blog.portal.security.form.FormLogoutSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

/**
 * Author: JackShieh
 * Corporation: Drawinds LTD
 * WE FLY WE DREAM
 * blog
 * Created: 2019/1/29 13:26
 * Description:
 */
@Configuration
@EnableWebSecurity
@EnableConfigurationProperties(SecurityConfigProperties.class)
@ConditionalOnProperty(value = "", havingValue = "xx", matchIfMissing = true)
public class FormWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityContextLogoutHandler securityContextLogoutHandler;

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;

    @Autowired
    private SecurityConfigProperties securityConfigProperties;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authenticationProvider);
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
        auth.inMemoryAuthentication().withUser("admin").password("123456").roles("admin");
//        super.configure(auth);
    }

    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        UsernamePasswordAuthenticationFilter filter = new UsernamePasswordAuthenticationFilter();
        filter.setAuthenticationSuccessHandler(authenticationSuccessHandler);
        filter.setAuthenticationFailureHandler(authenticationFailureHandler);
        filter.setAuthenticationManager(authenticationManagerBean());
        filter.setFilterProcessesUrl(securityConfigProperties.getDoLoginUrl());
        LoginUrlAuthenticationEntryPoint entryPoint = new LoginUrlAuthenticationEntryPoint(securityConfigProperties.getDoLoginUrl());

//        http.authorizeRequests()
//                .antMatchers("/").permitAll()
////                .antMatchers("/").permitAll()
//                .anyRequest().authenticated()
//                .and().csrf().disable().anonymous().and().headers().frameOptions().disable()
//                .and().exceptionHandling().authenticationEntryPoint(entryPoint)
////                .and().addFilter(filter)
//                .and().logout().addLogoutHandler(securityContextLogoutHandler)
//                .logoutSuccessUrl(securityConfigProperties.getSuccessUrl())
//                .logoutSuccessHandler(new FormLogoutSuccessHandler()).permitAll();
////        ;
        http.authorizeRequests()
//                        .antMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and().logout().permitAll().invalidateHttpSession(true).deleteCookies("session")
                .logoutSuccessHandler(new FormLogoutSuccessHandler())
                .and().formLogin().successHandler(authenticationSuccessHandler).successForwardUrl("/success")
//                        .and().formLogin()//.permitAll().loginPage("/usercenter/login").successHandler(authenticationSuccessHandler)//.loginProcessingUrl("")
//                        .and().logout().permitAll()
                .and().sessionManagement().maximumSessions(100).and()//.expiredUrl("/usercenter/login");
                .and().csrf().disable().anonymous().and().headers().frameOptions().disable()
//                .and().exceptionHandling().authenticationEntryPoint(entryPoint)
        ;
    }
}
