package top.javahelper.dynamicmultipledatasources.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.javahelper.dynamicmultipledatasources.common.WithDataSource;
import top.javahelper.dynamicmultipledatasources.model.User;
import top.javahelper.dynamicmultipledatasources.service.UserService;

import java.util.List;

/**
 * @description:
 * @projectName:dynamic-multiple-data-sources
 * @see:top.javahelper.dynamicmultipledatasources.controller
 * @author:郑晓龙
 * @createTime:2021/12/7 11:04
 * @version:1.0
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    /**
     * 向第一个数据源插入用户
     * 并返回数据库中的所有用户列表
     * @param name
     * @return
     */
    @PostMapping("first/add")
    @WithDataSource("first")
    public List<User> addUserFirstDataSource(String name) {
        User user = new User();
        user.setName(name);
        userService.addUser(user);
        return userService.selectAll();
    }


    @GetMapping("/first/all")
    @WithDataSource("first")
    public List<User> getAllUsersWithFirstDataSource() {
        List<User> users = userService.selectAll();
        return users;
    }

    /**
     * 向第二个数据源插入用户
     * 并返回数据库中的所有用户列表
     * @param name
     * @return
     */
    @PostMapping("second/add")
    @WithDataSource("second")
    public List<User> addUserSecondDataSource(String name) {
        User user = new User();
        user.setName(name);
        userService.addUser(user);
        return userService.selectAll();
    }

    @GetMapping("/second/all")
    @WithDataSource("second")
    public List<User> getAllUsersWithSecondDataSource() {
        List<User> users = userService.selectAll();
        return users;
    }
}
