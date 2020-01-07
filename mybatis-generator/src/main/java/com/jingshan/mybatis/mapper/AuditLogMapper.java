package com.jingshan.mybatis.mapper;

import com.jingshan.mybatis.model.AuditLog;
import java.util.List;

public interface AuditLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AuditLog record);

    AuditLog selectByPrimaryKey(Integer id);

    List<AuditLog> selectAll();

    int updateByPrimaryKey(AuditLog record);
}