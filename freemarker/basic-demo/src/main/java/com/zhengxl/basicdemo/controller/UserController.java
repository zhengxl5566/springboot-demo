package com.zhengxl.basicdemo.controller;

import com.zhengxl.basicdemo.entity.User;
import com.zhengxl.basicdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

/**
 * @description:
 * @projectName:basic-demo
 * @see:com.zhengxl.basicdemo.controller
 * @author:郑晓龙
 * @createTime:2020/7/10 11:47
 * @version:1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/all")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "list-users";
    }
}
