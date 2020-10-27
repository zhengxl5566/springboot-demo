package com.zhengxl.redisdemo.controller;

import com.zhengxl.redisdemo.core.ObjectRedisTemplate;
import com.zhengxl.redisdemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @projectName:redis-demo
 * @see:com.zhengxl.redisdemo.controller
 * @author:郑晓龙
 * @createTime:2020/10/27 11:47
 * @version:1.0
 */
@RestController
public class UserController {

    @Autowired
    ObjectRedisTemplate objectRedisTemplate;

    @GetMapping("string")
    public String string(String value){
        objectRedisTemplate.opsForValue().set("zxl",value);
        return (String)objectRedisTemplate.opsForValue().get("zxl");
    }

    @GetMapping("object")
    public User object(User user){
        objectRedisTemplate.opsForValue().set("user",user);
        return (User)objectRedisTemplate.opsForValue().get("user");
    }

}
