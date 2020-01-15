package com.zhengxl.mybatissample;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zhengxl.mybatissample.mapper")
public class MybatisSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisSampleApplication.class, args);
    }

}
