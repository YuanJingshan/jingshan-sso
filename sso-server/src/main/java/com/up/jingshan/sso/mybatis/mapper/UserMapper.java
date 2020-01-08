package com.up.jingshan.sso.mybatis.mapper;

import com.up.jingshan.sso.mybatis.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author YuanJingshan
 * @version 1.0
 * @description UserMapper
 * @date 2019/12/19
 */
@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    User selectByUsername(String userName);
}