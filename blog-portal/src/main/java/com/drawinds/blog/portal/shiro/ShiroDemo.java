package com.drawinds.blog.portal.shiro;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;

import javax.sql.DataSource;

/**
 * Author: JackShieh
 * Corporation: Drawinds LTD
 * WE FLY WE DREAM
 * blog
 * Created: 2019/1/30 10:05
 * Description:
 */
@Slf4j
public class ShiroDemo {

    public static void main(String[] args) {
        //Simple Realm
        SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();
        simpleAccountRealm.addAccount("admin", "123456", "admin");
        //IniRealm
        IniRealm iniRealm = new IniRealm("classpath:user.ini");
        //JDBC Realm
        JdbcRealm jdbcRealm = new JdbcRealm();
        DataSource dataSource = new HikariDataSource();
        ((HikariDataSource) dataSource).setJdbcUrl("jdbc:mysql://localhost:3306/blog");
        ((HikariDataSource) dataSource).setUsername("JackyShieh");
        ((HikariDataSource) dataSource).setPassword("1001");
        jdbcRealm.setDataSource(dataSource);
        jdbcRealm.setSaltStyle(JdbcRealm.SaltStyle.NO_SALT);
        jdbcRealm.setAuthenticationQuery("select password from uc_user_info where username = ?");
        jdbcRealm.setPermissionsQuery("select permission from uc_user_info where username = ?");
        jdbcRealm.setUserRolesQuery("select role from uc_user_info where username = ?");
        jdbcRealm.setPermissionsLookupEnabled(true);
//        jdbcRealm.set
        //SecurityManager
        SecurityManager securityManager = new DefaultSecurityManager();
        ((DefaultSecurityManager) securityManager).setRealm(simpleAccountRealm);
        ((DefaultSecurityManager) securityManager).getRealms().add(iniRealm);
        ((DefaultSecurityManager) securityManager).getRealms().add(jdbcRealm);
        //
        SecurityUtils.setSecurityManager(securityManager);
        //Subject
        Subject subject = SecurityUtils.getSubject();
        //认证
        UsernamePasswordToken token = new UsernamePasswordToken("xyj", "123456");
        subject.login(token);
        log.info("认证成功" + subject.isAuthenticated());
        //授权
        subject.checkRole("admin");
        //        subject.logout();
        subject.checkPermission("user:update");//, "user:update");
    }
}
