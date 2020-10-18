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
 * @createTime:2020/7/10 11:47
 * @version:1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * @description Controller不组织 model 数据
     * 演示freemarker的tag功能，参考 list-users-tag.ftlh 的 <@myTag></@myTag>标签
     * @param model
     * @return java.lang.String
     * @author 郑晓龙
     * @createTime 2020/9/10 19:27
     **/
    @GetMapping("/all")
    public String getUsers(Model model) {
        return "list-users-tag";
    }
}
