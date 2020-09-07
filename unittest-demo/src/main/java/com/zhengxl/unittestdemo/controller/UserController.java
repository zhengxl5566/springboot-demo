package com.zhengxl.unittestdemo.controller;

import com.zhengxl.unittestdemo.vo.UserVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @projectName:unittest-demo
 * @see:com.zhengxl.unittestdemo.controller
 * @author:郑晓龙
 * @createTime:2020/9/3 9:08
 * @version:1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/list")
    public List<UserVO> listAllUsers() throws InterruptedException {
        UserVO userVO1 = new UserVO();
        userVO1.setAge(10);
        userVO1.setName("name1");

        UserVO userVO2 = new UserVO();
        userVO2.setAge(20);
        userVO2.setName("name2");

        List<UserVO> resList = new ArrayList<>();
        resList.add(userVO1);
        resList.add(userVO2);
        return resList;
    }
}
