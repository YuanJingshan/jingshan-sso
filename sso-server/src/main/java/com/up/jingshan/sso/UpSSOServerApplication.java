package com.up.jingshan.sso;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.up.jingshan.sso.mybatis")
public class UpSSOServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UpSSOServerApplication.class, args);
    }

}

