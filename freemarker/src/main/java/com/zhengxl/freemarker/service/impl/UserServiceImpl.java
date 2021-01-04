package com.zhengxl.freemarker.service.impl;

import com.zhengxl.freemarker.entity.User;
import com.zhengxl.freemarker.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @projectName:freemarker
 * @see:com.zhengxl.freemarker.service.impl
 * @author:郑晓龙
 * @createTime:2020/12/17 16:33
 * @version:1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public List<User> getAllUser() {
        List<User> users = new ArrayList<>();
        users.add(new User("zxl", 18));
        users.add(new User("ls", 19));
        users.add(new User("zs", 16));
        return users;
    }

    @Override
    public Integer insert(User user) {
        System.out.println("Insert OK!");
        return 1;
    }

    @Override
    public User getUser(String userName) {
        return new User(userName, 20);
    }

}
