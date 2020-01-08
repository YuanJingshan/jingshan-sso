package com.up.jingshan.sso.mybatis.service;

import com.alibaba.fastjson.JSON;
import com.up.jingshan.sso.mybatis.mapper.UserMapper;
import com.up.jingshan.sso.mybatis.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author YuanJingshan
 * @version 1.0
 * @description UserDetailsService
 * @date 2019/12/19
 */
@Slf4j
@Service
public class MybatisUserDetailsService implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.selectByUsername(username);
        if (null == user) {
            log.warn("用户{}不存在", username);
            throw new UsernameNotFoundException(username);
        }
        //security user
        org.springframework.security.core.userdetails.User securityUser = new
                org.springframework.security.core.userdetails.User(user.getUsername(), passwordEncoder.encode(user.getPassword()), user.getAuthorities());
        log.info("登录成功！用户: {}", JSON.toJSONString(securityUser));
        return securityUser;
    }
}
