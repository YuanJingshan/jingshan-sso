package com.up.jingshan.client.platform.log.config;

import com.up.jingshan.client.interceptor.LogInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author jingshan
 * @version 1.fontawesome
 * @description 日志配置
 * @date 2019/5/23
 */
@Configuration
public class LogConfguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor()).addPathPatterns("/faq/**").excludePathPatterns("/faq/login");
    }
}