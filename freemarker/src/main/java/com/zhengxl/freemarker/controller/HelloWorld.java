package com.zhengxl.freemarker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @description:
 * @projectName:freemarker
 * @see:com.zhengxl.freemarker.controller
 * @author:郑晓龙
 * @createTime:2020/12/17 14:34
 * @version:1.0
 */
@Controller
public class HelloWorld {
    @GetMapping("hello")
    public String hello(){
        return "hello";
    }
}
