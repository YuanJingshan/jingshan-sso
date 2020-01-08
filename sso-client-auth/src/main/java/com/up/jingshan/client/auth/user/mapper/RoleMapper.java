package com.up.jingshan.client.auth.user.mapper;


import com.up.jingshan.client.auth.user.model.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author YuanJingshan
 * @version 1.0
 * @description RoleMapper
 * @date 2019/12/19
 */
@Repository
public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    Role selectByPrimaryKey(Integer id);

    List<Role> selectAll();

    int updateByPrimaryKey(Role record);
}