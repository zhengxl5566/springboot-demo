package top.javahelper.dynamicmultipledatasources.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.javahelper.dynamicmultipledatasources.common.RoutingDataSourceContext;
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

    @PostMapping("/add")
    public void addUser(String name,String dataSourceName) {
        User user = new User();
        user.setName(name);
//        RoutingDataSourceContext.setRoutingKey(dataSourceName);
        userService.addUser(user);
//        RoutingDataSourceContext.reset();
    }
    @GetMapping("all")
    public List<User> getAllUsers(String dataSourceName){
//        RoutingDataSourceContext.setRoutingKey(dataSourceName);
        List<User> users = userService.selectAll();
//        RoutingDataSourceContext.reset();
        return users;
    }
}
