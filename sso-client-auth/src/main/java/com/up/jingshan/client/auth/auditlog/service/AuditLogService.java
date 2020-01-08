package com.up.jingshan.client.auth.auditlog.service;

import com.up.jingshan.client.auth.auditlog.model.AuditLog;
import com.up.jingshan.client.auth.common.response.PageResult;

/**
 * @author jingshan
 * @version 1.0
 * @description 日志服务接口
 * @date 2019/5/22
 */
public interface AuditLogService {

    /**
     * 分页查询
     *
     * @param page
     * @param limit
     * @param url
     * @return
     */
    PageResult<AuditLog> queryByPage(int page, int limit, String url);

    /**
     * 根据id删除
     *
     * @param id
     */
    void deleteByID(int id);
}
