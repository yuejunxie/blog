package com.drawinds.blog.portal.security.form;

import com.drawinds.blog.portal.model.UserInfo;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.*;

/**
 * Author: JackShieh
 * Corporation: Drawinds LTD
 * WE FLY WE DREAM
 * blog
 * Created: 2019/1/29 12:23
 * Description:
 */
public class FormUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //查找用户名
//        UserInfo userInfo = null;//getByUserName(username);
//        if (userInfo == null) {
//            throw new UsernameNotFoundException("User Not Found:" + username);
//        }
//        if (userInfo.getDataValid()) {
//            throw new LockedException("User Locked:" + username);
//        }
        //查找用户角色
        List<String> roleList = Arrays.asList("admin");
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        roleList.forEach(role -> authorities.add(new SimpleGrantedAuthority(role)));
        return new User(username, new BCryptPasswordEncoder().encode("123456"), authorities);
    }
}
