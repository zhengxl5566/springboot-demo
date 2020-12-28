package com.zhengxl.freemarker.controller;

import com.zhengxl.freemarker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @Autowired
    UserService userService;


    @GetMapping("hello")
    public String hello(String name, Model model) {
//        model.addAttribute("name",name);
//        model.addAttribute("myDate",new Date());
//
//        model.addAttribute("timeStamp",1608535755L);


        System.out.println("executing" + name);

        String content = "&lt;p&gt;2222222222222222222&lt;/p&gt;";
        String content2 = "<p>2222222222222222222</p>";

        model.addAttribute("content", content);
        model.addAttribute("content2", content2);
        model.addAttribute("userService",userService);
        return "hello.ftlh";
    }
}
