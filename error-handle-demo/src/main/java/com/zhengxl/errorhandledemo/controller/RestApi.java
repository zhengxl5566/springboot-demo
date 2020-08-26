package com.zhengxl.errorhandledemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @projectName:error-handle-demo
 * @see:com.zhengxl.errorhandledemo.controller
 * @author:郑晓龙
 * @createTime:2020/8/26 10:34
 * @version:1.0
 */
@RestController
@RequestMapping("api")
public class RestApi {
    @GetMapping
    public String test(){
        return "";
    }
}
