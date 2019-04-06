package com.drawinds.blog.enterprise.security;

import com.drawinds.blog.entity.usercenter.entity.UserInfo;
import com.drawinds.blog.repo.usercenter.repo.UserInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Arrays;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2019/4/5 17:03
 * Description:
 */
@Slf4j
public class CustomUserService implements UserDetailsService {

    @Autowired
    private UserInfoRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("查找用户信息");
        UserInfo userInfo = userRepository.getUserInfoByUsername(username);
        if (userInfo == null) return null;
        return new User(userInfo.getUsername(), "123", Arrays.asList(new SimpleGrantedAuthority("admin")));
    }
}
