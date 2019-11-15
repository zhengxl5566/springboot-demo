package com.zhengxl.mybatiscache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.zhengxl.mybatiscache.mapper"})
public class MybatiscacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatiscacheApplication.class, args);
    }

}
