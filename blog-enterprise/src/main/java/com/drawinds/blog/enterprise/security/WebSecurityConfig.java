package com.drawinds.blog.enterprise.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2019/4/5 16:41
 * Description:
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private DataSource dataSource;

    @Bean
    public CustomUserService customUserService() {
        return new CustomUserService();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new CustomPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("").password("").roles("")
//                .and().withUser("").password("").roles("");
//        auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("")
//                .authoritiesByUsernameQuery("");
        auth.authenticationProvider(authenticationProvider())
                .userDetailsService(customUserService());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/admin").hasRole("ADMIN")
//                .antMatchers("/user").hasRole("ADMIN")
//                .anyRequest().authenticated();
//        http.formLogin().loginPage("/login").defaultSuccessUrl("/index").failureUrl("/login?error").permitAll()
//                .and().rememberMe().tokenValiditySeconds(1209600).key("cook")
//                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/logout?success").permitAll();
//        super.configure(http);
        http.authorizeRequests().antMatchers("/**/api/*").permitAll().anyRequest().authenticated()
                .and().formLogin().defaultSuccessUrl("/index").permitAll().and().rememberMe().alwaysRemember(false).tokenValiditySeconds(10).key("cook")
                .and().logout().permitAll();

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
//        super.configure(web);
    }

}
