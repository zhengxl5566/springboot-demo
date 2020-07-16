package com.zhengxl.basicdemo.controller;

import com.zhengxl.basicdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:
 * @projectName:basic-demo
 * @see:com.zhengxl.basicdemo.controller
 * @author:郑晓龙
 * @createTime:2020/7/9 11:10
 * @version:1.0
 */
@Controller
@RequestMapping("/hello")
public class HelloWorld {
    @Autowired
    UserService userService;

    @GetMapping("/world")
    public String hello(Model model){
        model.addAttribute("name","zhengxl");
        return "hello-world";
    }
}
