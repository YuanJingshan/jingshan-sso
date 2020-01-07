package com.up.jingshan.sso.mybatis.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author YuanJingshan
 * @version 1.fontawesome
 * @description 用户角色关系
 * @date 2019/12/19
 */
@Data
public class UserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer userId;

    private Integer roleId;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", roleId=").append(roleId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}