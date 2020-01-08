package com.up.jingshan.client.platform.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.up.jingshan.client.auth.auditlog.mapper.AuditLogMapper;
import com.up.jingshan.client.auth.auditlog.model.AuditLog;
import com.up.jingshan.client.auth.auditlog.util.LogUtil;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @author YuanJingshan
 * @version 1.0
 * @description 日志拦截器
 * @date 2019/8/29
 */
public class LogInterceptor implements HandlerInterceptor {
    /**
     * 请求开始时间标识
     */
    private static final String LOGGER_SEND_TIME = "_send_time";
    /**
     * 请求日志实体标识
     */
    private static final String LOGGER_ENTITY = "_logger_entity";

    /**
     * 进入SpringMVC的Controller之前开始记录日志实体
     *
     * @param request  请求对象
     * @param response 响应对象
     * @param o
     * @return
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) {
        //创建日志实体
        AuditLog auditLog = new AuditLog();
        //获取请求sessionId
        String sessionId = request.getRequestedSessionId();
        //请求路径
        String url = request.getRequestURI();
        //获取请求参数信息
        String paramData = JSON.toJSONString(request.getParameterMap(),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue);
        //设置客户端ip
        auditLog.setReqClientIp(LogUtil.getCliectIp(request));
        //设置请求方法
        auditLog.setReqMethod(request.getMethod());
        //设置请求类型（json|普通请求）
        auditLog.setReqType(LogUtil.getRequestType(request));
        //设置请求参数内容json字符串
        auditLog.setReqParamData(paramData);
        //设置请求地址
        auditLog.setReqUri(url);
        //设置sessionId
        auditLog.setSessionId(sessionId);
        auditLog.setReqTime(new Date());
        //设置请求开始时间
        request.setAttribute(LOGGER_SEND_TIME, System.currentTimeMillis());
        //设置请求实体到request内，方面afterCompletion方法调用
        request.setAttribute(LOGGER_ENTITY, auditLog);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) {
        //获取请求错误码
        int status = response.getStatus();
        //当前时间
        long currentTime = System.currentTimeMillis();
        //请求开始时间
        long time = Long.valueOf(request.getAttribute(LOGGER_SEND_TIME).toString());
        //获取本次请求日志实体
        AuditLog auditLog = (AuditLog) request.getAttribute(LOGGER_ENTITY);
        //设置请求时间差
        auditLog.setTimeConsuming(Integer.valueOf((currentTime - time) + ""));
        //设置返回时间
        auditLog.setReturnTime(new Date());
        //设置返回错误码
        auditLog.setHttpStatusCode(status + "");
        //设置返回值
        auditLog.setReturnData(JSON.toJSONString(request.getAttribute(LogUtil.LOGGER_RETURN),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue));
        //执行将日志写入数据库
        AuditLogMapper auditLogMapper = getMapper(AuditLogMapper.class, request);
        auditLogMapper.insert(auditLog);
    }

    /**
     * 根据传入的类型获取spring管理的对应dao
     *
     * @param clazz   类型
     * @param request 请求对象
     * @param <T>
     * @return
     */
    private <T> T getMapper(Class<T> clazz, HttpServletRequest request) {
        BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
        return factory.getBean(clazz);
    }
}