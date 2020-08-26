package com.zhengxl.errorhandledemo.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
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
public class DemoController {
    @GetMapping("hello")
    public String hello(String flag) throws Exception {
        if(flag.equals("1")){
            throw new Exception("12");
        }
        return "hello,world";
    }
}
