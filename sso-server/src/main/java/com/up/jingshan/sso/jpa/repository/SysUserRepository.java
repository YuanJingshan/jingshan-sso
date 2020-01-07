package com.up.jingshan.sso.jpa.repository;

import com.up.jingshan.sso.jpa.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author YuanJingshan
 * @version 1.fontawesome
 * @description
 * @date 2019/12/19
 */
public interface SysUserRepository extends JpaSpecificationExecutor<SysUser>, JpaRepository<SysUser, Integer> {

    SysUser findByUsername(String username);
}
