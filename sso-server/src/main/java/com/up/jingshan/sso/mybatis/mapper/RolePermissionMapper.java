package com.up.jingshan.sso.mybatis.mapper;


import com.up.jingshan.sso.mybatis.model.Permission;
import com.up.jingshan.sso.mybatis.model.RolePermission;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author YuanJingshan
 * @version 1.fontawesome
 * @description RolePermissionMapper
 * @date 2019/12/19
 */
@Repository
public interface RolePermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RolePermission record);

    RolePermission selectByPrimaryKey(Integer id);

    List<RolePermission> selectAll();

    int updateByPrimaryKey(RolePermission record);

    /**
     * 根据角色查询权限
     *
     * @param roleId
     * @return
     */
    List<Permission> selectPermissionByRoleId(String roleId);
}