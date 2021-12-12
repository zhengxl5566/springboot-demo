package com.zhengxl.mybatissample.service.impl;

import com.zhengxl.mybatissample.mapper.UserMapper;
import com.zhengxl.mybatissample.model.User;
import com.zhengxl.mybatissample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author:Java课代表
 * @createTime:2021/12/12 21:26
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public int create(User user) {
        int i = userMapper.insert(user);
        return i;
    }

    @Override
    public List<User> queryAll() {
        return userMapper.selectAll();
    }
}
