package com.zhengxl.interceptordemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @projectName:interceptor-demo
 * @see:com.zhengxl.interceptordemo.controller
 * @author:郑晓龙
 * @createTime:2020/9/26 10:04
 * @version:1.0
 */
@RestController
public class HelloWorldController {
    @GetMapping("hello")
    public String Hello(){
        return "hello,world!";
    }
}
