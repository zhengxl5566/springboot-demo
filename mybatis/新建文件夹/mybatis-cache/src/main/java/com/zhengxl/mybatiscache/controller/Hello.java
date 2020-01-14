package com.zhengxl.mybatiscache.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @projectName:mybatiscache
 * @see:com.zhengxl.mybatiscache.controller
 * @author:郑晓龙
 * @createTime:2019/11/16 15:48
 * @version:1.0
 */
@RestController
public class Hello {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
