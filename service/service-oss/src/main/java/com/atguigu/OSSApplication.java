package com.atguigu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @auther: zzzgyu
 */

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class OSSApplication {
    public static void main(String[] args) {
        SpringApplication.run(OSSApplication.class, args);
    }
}
