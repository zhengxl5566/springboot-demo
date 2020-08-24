package com.zhengxl.errorhandledemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @projectName:error-handle-demo
 * @see:com.zhengxl.errorhandledemo.controller
 * @author:郑晓龙
 * @createTime:2020/8/24 17:05
 * @version:1.0
 */
@RestController
public class HelloWorld {
    @GetMapping("hello")
    public String hello() {
        int i = 1 / 0;
        return "hello,world";
    }
}
