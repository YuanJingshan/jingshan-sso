package com.up.jingshan.sso.jpa.service;

import com.up.jingshan.sso.jpa.entity.SysPermission;

import java.util.List;

/**
 * @author YuanJingshan
 * @version 1.0
 * @description 权限接口
 * @date 2019/12/19
 */
public interface PermissionService {

    List<SysPermission> findByUserId(Integer userId);

}
