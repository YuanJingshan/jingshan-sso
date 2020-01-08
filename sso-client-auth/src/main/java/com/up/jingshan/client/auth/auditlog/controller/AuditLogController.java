package com.up.jingshan.client.auth.auditlog.controller;

import com.up.jingshan.client.auth.auditlog.service.AuditLogService;
import com.up.jingshan.client.auth.common.response.MapResult;
import com.up.jingshan.client.auth.common.response.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jingshan
 * @version 1.0
 * @description 日志服务 控制
 * @date 2019/5/22
 */
@Slf4j
@Controller
@RequestMapping(value = "audit")
public class AuditLogController {
    private final String URL_LOGGER_LOG = "auditlog/log";

    @Autowired
    @Qualifier("auditLogServiceImpl")
    private AuditLogService auditLogService;

    @RequestMapping(value = "log", method = RequestMethod.GET)
    public String log() {
        return URL_LOGGER_LOG;
    }

    @RequestMapping(value = "log/list", method = RequestMethod.POST)
    @ResponseBody
    public PageResult list(Integer page, Integer limit, String uri) {
        return auditLogService.queryByPage(page, limit, uri);
    }

    @ResponseBody
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public MapResult delete(@PathVariable int id) {
        try {
            auditLogService.deleteByID(id);
        } catch (Exception e) {
            log.info("desc: {}, params: {}, execption: {}", "删除失败", id, e);
            return new MapResult().error("删除失败!");
        }
        return new MapResult().ok();
    }
}