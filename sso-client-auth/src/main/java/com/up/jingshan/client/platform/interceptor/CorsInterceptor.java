package com.up.jingshan.client.platform.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Yuanjingshan
 * @version 1.0
 * @description 常量
 * @date 2019/8/29
 */
@Configuration
public class CorsInterceptor implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedMethods("*")
                .allowedOrigins("*")
                .maxAge(3600);
    }
}
