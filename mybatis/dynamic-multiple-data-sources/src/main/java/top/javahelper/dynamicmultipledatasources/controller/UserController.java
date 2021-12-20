package top.javahelper.dynamicmultipledatasources.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.javahelper.dynamicmultipledatasources.common.RoutingDataSourceContext;
import top.javahelper.dynamicmultipledatasources.common.WithDataSource;
import top.javahelper.dynamicmultipledatasources.model.User;
import top.javahelper.dynamicmultipledatasources.service.UserService;

import java.util.List;

/**
 * @author :Java课代表
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
     * @return List<User>
     */
    @PostMapping("first")
    // 注解标明使用"first"数据源
    @WithDataSource("first")
    public List<User> addUserFirstDataSource(String name) {
        User user = new User();
        user.setName(name);
        userService.insert(user);
        return userService.selectAll();
    }

    /**
     *
     * @return List<User>
     */
    @GetMapping("first/all")
    // 注解标明使用"first"数据源
    @WithDataSource("first")
    public List<User> getAllUsersFromFirst() {
        List<User> users = userService.selectAll();
        return users;
    }

    /**
     * 向第二个数据源插入用户
     * 并返回数据库中的所有用户列表
     * @param name
     * @return List<User>
     */
    @PostMapping("second")
    // 注解标明使用"second"数据源
    @WithDataSource("second")
    public List<User> addUserToSecond(String name) {
        User user = new User();
        user.setName(name);
        userService.insert(user);
        // 添加完用户后接着返回表中所有数据，方便观察数据变化
        return userService.selectAll();
    }

    @GetMapping("second/all")
    // 注解标明使用"second"数据源
    @WithDataSource("second")
    public List<User> getAllUsersFromSecond() {
        List<User> users = userService.selectAll();
        return users;
    }

    @PostMapping("dynamic")
    public List<User> addWithDynamic(String name,String dataSource) {
        User user = new User();
        user.setName(name);

        // 设置为参数中指定的数据源
        RoutingDataSourceContext.setRoutingKey(dataSource);
        userService.insert(user);
        List<User> users = userService.selectAll();
        RoutingDataSourceContext.reset();

        return users;
    }

    /**
     * 演示事务
     */
    @Transactional("first")
    public void insertIntoTwoDataSourceWithTX(){

    }
}
