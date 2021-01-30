package com.zhengxl.freemarker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @description: 展示用户自定义指令的用法
 * @projectName:freemarker
 * @see:com.zhengxl.freemarker.controller
 * @author:郑晓龙
 * @createTime:2020/12/28 14:14
 * @version:1.0
 */
@Controller
public class UserDefinedDirectiveController {
    @GetMapping("directive")
    public String userDefinedDirective(){
        return "directive";
    }
}
