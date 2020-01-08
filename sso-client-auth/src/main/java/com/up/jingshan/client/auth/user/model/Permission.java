package com.up.jingshan.client.auth.user.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author YuanJingshan
 * @version 1.0
 * @description 权限
 * @date 2019/12/19
 */
@Data
public class Permission implements Serializable, Comparable<Permission>{
    private Integer id;

    private Integer pid;

    private Byte type;

    private String name;

    private String code;

    private String icon;

    private String uri;

    private Integer seq;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    private List<Permission> childrens;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pid=").append(pid);
        sb.append(", type=").append(type);
        sb.append(", name=").append(name);
        sb.append(", code=").append(code);
        sb.append(", icon=").append(icon);
        sb.append(", uri=").append(uri);
        sb.append(", seq=").append(seq);
        sb.append(", createUser=").append(createUser);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public int compareTo(Permission o) {
        return this.seq.compareTo(o.getSeq());
    }
}