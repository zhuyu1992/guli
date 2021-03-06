package com.atguigu.eduservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @auther: zzzgyu
 */

@SpringBootApplication
@MapperScan("com.atguigu.eduservice.mapper")
@ComponentScan(basePackages = {"com.atguigu"})
public class EduServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduServiceApplication.class, args);
    }
}
