package com.up.jingshan.sso.jpa.service;

import com.up.jingshan.sso.jpa.entity.SysUser;

/**
 * @author YuanJingshan
 * @version 1.0
 * @description 用户接口
 * @date 2019/12/19
 */
public interface UserService {

    SysUser getByUsername(String username);
}
