package com.up.jingshan.client.platform.config;

import com.up.jingshan.client.platform.interceptor.LogInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author YuanJingshan
 * @version 1.0
 * @description 审计日志配置
 * @date 2020/1/8
 */
@Configuration
public class AuditLogConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor()).addPathPatterns("/**").excludePathPatterns("/login");
    }
}