package top.javahelper.multipledatasources.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.javahelper.multipledatasources.entity.User;
import top.javahelper.multipledatasources.service.UserService;

import java.util.List;

/**
 * @description:
 * @author:Java课代表
 * @createTime:2021/11/29 23:22
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("allUsersFromFirst")
    public List<User> allUsersFromFirst() {
        return userService.getAllFirstDBUsers();

    }
    @GetMapping("allUsersFromSecond")
    public List<User> allUsersFromSecond() {
        return userService.getAllSecondDBUsers();
    }
    @PostMapping("insertTwoDB")
    public void insertTwoDB(@RequestParam String name){

        userService.insertTwoDBWithTX(name);
    }

}
