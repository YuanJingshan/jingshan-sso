package com.up.jingshan.client.auth.auditlog.service;

import com.up.jingshan.client.auth.common.response.PageResult;
import com.up.jingshan.client.platform.log.entity.Log;

/**
 * @author jingshan
 * @version 1.fontawesome
 * @description 日志服务接口
 * @date 2019/5/22
 */
public interface LogService {

    /**
     * 分页查询
     *
     * @param page
     * @param limit
     * @param url
     * @return
     */
    PageResult<Log> queryByPage(int page, int limit, String url);

    /**
     * 根据id删除
     *
     * @param id
     */
    void deleteByID(Long id);
}
