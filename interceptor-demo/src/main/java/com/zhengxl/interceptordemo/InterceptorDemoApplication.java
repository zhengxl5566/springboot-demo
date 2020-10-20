package com.zhengxl.interceptordemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
public class InterceptorDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(InterceptorDemoApplication.class, args);
    }

}
