package com.up.jingshan.client.auth.user.mapper;

import com.up.jingshan.client.auth.user.model.Role;
import com.up.jingshan.client.auth.user.model.User;
import com.up.jingshan.client.auth.user.model.UserRole;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author YuanJingshan
 * @version 1.0
 * @description UserRoleMapper
 * @date 2019/12/19
 */
@Repository
public interface UserRoleMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(UserRole record);

    UserRole selectByPrimaryKey(Integer id);

    List<UserRole> selectAll();

    int updateByPrimaryKey(UserRole record);

    List<User> selectUserByRoleId(int roleId);

    List<Role> selectRoleByUserId(int userId);
}