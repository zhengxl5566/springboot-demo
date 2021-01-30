package com.zhengxl.freemarker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @description:展示FTL中调用Java静态方法的用法
 * @projectName:freemarker
 * @see:com.zhengxl.freemarker.controller
 * @author:郑晓龙
 * @createTime:2020/12/28 14:13
 * @version:1.0
 */
@Controller
public class StaticMethodController {
    @GetMapping("static")
    public String staticMethodView(){
        return "static-method-view";
    }
}
