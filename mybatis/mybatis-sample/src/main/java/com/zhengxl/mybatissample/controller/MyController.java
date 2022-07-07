package com.zhengxl.mybatissample.controller;

import com.zhengxl.mybatissample.model.User;
import com.zhengxl.mybatissample.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    private static final Logger log = LoggerFactory.getLogger(MyController.class);

    @Autowired
    UserService userService;

    @GetMapping("/hello")
    public String hello(){
        return "hello!";
    }

    @GetMapping("all")
    public List<User> getAll(){
        log.debug("=== 执行queryAll ===");
        return userService.queryAll();
    }

    @PostMapping("add")
    public int add(@RequestBody User user){
        return userService.create(user);
    }

}
