package com.up.jingshan.client.auth.auditlog.mapper;

import com.up.jingshan.client.auth.auditlog.model.AuditLog;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditLogMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(AuditLog record);

    AuditLog selectByPrimaryKey(Integer id);

    List<AuditLog> selectAll();

    int updateByPrimaryKey(AuditLog record);

    /**
     * 分页查询
     *
     * @param curIndex
     * @param pageSize
     * @return
     */
    List<AuditLog> selectByPage(int curIndex, int pageSize, String uri);

    /**
     * 查询总数
     * @return
     */
    int selectCount();
}