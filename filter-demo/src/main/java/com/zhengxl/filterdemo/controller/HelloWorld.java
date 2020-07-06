package com.zhengxl.filterdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
    @GetMapping("hello")
    public String helloWorld(){
        return "Hello world!";
    }
    @GetMapping("hi")
    public String helloChina(){
        return "Hi world!";
    }
}
