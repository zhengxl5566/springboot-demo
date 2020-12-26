package com.zhengxl.freemarker.controller;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @projectName:freemarker
 * @see:com.zhengxl.freemarker.controller
 * @author:郑晓龙
 * @createTime:2020/12/22 11:35
 * @version:1.0
 */
@RestController
public class MyRestController {
    @GetMapping("hi/{name}")
    @Cacheable("hi")
    public String test(@PathVariable String name){
        return name;
    }
}
