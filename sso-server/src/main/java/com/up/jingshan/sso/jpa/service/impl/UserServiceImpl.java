package com.up.jingshan.sso.jpa.service.impl;

import com.up.jingshan.sso.jpa.entity.SysUser;
import com.up.jingshan.sso.jpa.repository.SysUserRepository;
import com.up.jingshan.sso.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author YuanJingshan
 * @version 1.0
 * @description
 * @date 2019/12/19
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserRepository sysUserRepository;

    @Override
    public SysUser getByUsername(String username) {
        return sysUserRepository.findByUsername(username);
    }
}
