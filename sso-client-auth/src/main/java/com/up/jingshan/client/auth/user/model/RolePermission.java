package com.up.jingshan.client.auth.user.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author YuanJingshan
 * @version 1.0
 * @description 角色对应的权限
 * @date 2019/12/19
 */
@Data
public class RolePermission implements Serializable {
    private Integer id;

    private Integer roleId;

    private Integer permissionId;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", roleId=").append(roleId);
        sb.append(", permissionId=").append(permissionId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}