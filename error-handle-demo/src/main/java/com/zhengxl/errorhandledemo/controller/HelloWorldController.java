package com.zhengxl.errorhandledemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @description:
 * @projectName:error-handle-demo
 * @see:com.zhengxl.errorhandledemo.controller
 * @author:郑晓龙
 * @createTime:2020/8/24 17:05
 * @version:1.0
 */
@Controller
public class HelloWorldController {
    @GetMapping("hello")
    public String hello() {
        // 制造一个 500 错误
//        int error= 1/0;
        return "hello";
    }
}
