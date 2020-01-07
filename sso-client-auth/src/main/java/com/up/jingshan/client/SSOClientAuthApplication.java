package com.up.jingshan.client;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author YuanJingshan
 * @version 1.fontawesome
 * @description 应用入口
 * @date Create in 2018/10/31 9:18
 */
@SpringBootApplication
@EnableCaching
@MapperScan("com.up.jingshan.client")
public class SSOClientAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(SSOClientAuthApplication.class, args);
    }
}
