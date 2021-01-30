package com.zhengxl.freemarker.controller;

import com.zhengxl.freemarker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @projectName:freemarker
 * @see:com.zhengxl.freemarker.controller
 * @author:郑晓龙
 * @createTime:2020/12/17 14:34
 * @version:1.0
 */
@Controller
public class IndexController {
    @Autowired
    private UserService userService;

    @GetMapping(value={"/","index"})
    public String index(Model model) {
        // 放入单个值
        model.addAttribute("userName","Java 课代表");

        // 放入集合
        model.addAttribute("allUsers",userService.getAllUser());

        // 放入日期
        model.addAttribute("currentTime",new Date());


        List<String> xs = new ArrayList<>();
        xs.add("1");
        xs.add("2");
        xs.add("3");
        xs.add(null);
        model.addAttribute("xs",xs);

        // 返回模板名称
        return "index";

    }

    @GetMapping("built-ins")
    public String builtIns(){
        return "built-ins";
    }

}

//        model.addAttribute("user",new User("zhengxl5566",18));
//
//        model.addAttribute("userService",userService);

//        model.addAttribute("timeStamp",1608535755L);
//        System.out.println("executing" + name);
//        String content = "&lt;p&gt;2222222222222222222&lt;/p&gt;";
//        String content2 = "<p>2222222222222222222</p>";