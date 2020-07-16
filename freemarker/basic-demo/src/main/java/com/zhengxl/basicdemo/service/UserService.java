package com.zhengxl.basicdemo.service;

import com.zhengxl.basicdemo.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @projectName:basic-demo
 * @see:com.zhengxl.basicdemo.service
 * @author:郑晓龙
 * @createTime:2020/7/9 11:28
 * @version:1.0
 */
@Service
public class UserService {
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("zhengxl", 18));
        users.add(new User("zhangsan", 20));
        users.add(new User("lisi", 20));
        users.add(new User("wangwu", 20));
        users.add(new User("zhaoliu", 20));
        return users;
    }
}
