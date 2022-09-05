package com.jbr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Author zxw
 * @Date 2022/8/15 19:24
 * @Description:
 * @Version 1.0
 */
@SpringBootApplication
@MapperScan("com.jbr.mapper")
public class JbrBlogApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(JbrBlogApplication.class, args);
    }
}
