package com.up.jingshan.client.auth.user.mapper;

import com.up.jingshan.client.auth.user.model.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author YuanJingshan
 * @version 1.0
 * @description PermissionMapper
 * @date 2019/12/19
 */
@Repository
public interface PermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    Permission selectByPrimaryKey(Integer id);

    List<Permission> selectAll();

    int updateByPrimaryKey(Permission record);

    List<Permission> selectChildrens(Integer id);
}