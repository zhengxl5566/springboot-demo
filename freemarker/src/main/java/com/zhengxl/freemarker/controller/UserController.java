package com.zhengxl.freemarker.controller;

import com.zhengxl.freemarker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:
 * @projectName:freemarker
 * @see:com.zhengxl.freemarker.controller
 * @author:郑晓龙
 * @createTime:2020/12/17 16:35
 * @version:1.0
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("list")
    public String getAllUsers(Model model){
        model.addAttribute("users",userService.getAllUser());
        return "user-list";
    }

    @GetMapping("insert")
    public String insertUser(){
       userService.insert();
        return "user-list";
    }
    @GetMapping("getCache")
    public String getCache(){
        String cache = userService.cache();

        return "user-list";
    }
}
