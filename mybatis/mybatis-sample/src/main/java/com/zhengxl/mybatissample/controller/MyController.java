package com.zhengxl.mybatissample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @projectName:mybatis-sample
 * @see:com.zhengxl.mybatissample.controller
 * @author:郑晓龙
 * @createTime:2020/1/15 14:39
 * @version:1.0
 */
@RestController
public class MyController {
    @GetMapping("/hello")
    public String hello(){
        return "hello!";
    }
}
