package com.up.jingshan.sso.jpa.repository;

import com.up.jingshan.sso.jpa.entity.SysUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author YuanJingshan
 * @version 1.0
 * @description
 * @date 2019/12/19
 */
public interface SysUserRoleRepository extends JpaSpecificationExecutor<SysUserRole>, JpaRepository<SysUserRole, Integer> {

    List<SysUserRole> findByUserId(Integer userId);
}
