package com.up.jingshan.client.platform.log.mapper;

import com.up.jingshan.client.platform.log.model.AuditLog;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditLogMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(AuditLog record);

    AuditLog selectByPrimaryKey(Integer id);

    List<AuditLog> selectAll();

    int updateByPrimaryKey(AuditLog record);
}