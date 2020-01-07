package com.up.jingshan.client.auth.auditlog.controller;

import com.up.jingshan.client.auth.auditlog.service.LogService;
import com.up.jingshan.client.auth.common.response.MapResult;
import com.up.jingshan.client.auth.common.response.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jingshan
 * @version 1.fontawesome
 * @description 日志服务 控制
 * @date 2019/5/22
 */
@Slf4j
@Controller
@RequestMapping(value = "faq/auditlog")
public class LogController {
    private final String URL_LOGGER_LOG = "faq/auditlog/log";

    @Autowired
    private LogService logService;

    @RequestMapping(value = "log", method = RequestMethod.GET)
    public String log() {
        return URL_LOGGER_LOG;
    }

    @RequestMapping(value = "list", method = RequestMethod.POST)
    @ResponseBody
    public PageResult list(Integer page, Integer limit, String uri) {
        return logService.queryByPage(page, limit, uri);
    }

    @ResponseBody
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public MapResult delete(@PathVariable Long id) {
        try {
            logService.deleteByID(id);
        } catch (Exception e) {
            log.info("desc: {}, params: {}, execption: {}", "删除失败", id, e);
            return new MapResult().error("删除失败!");
        }
        return new MapResult().ok();
    }
}