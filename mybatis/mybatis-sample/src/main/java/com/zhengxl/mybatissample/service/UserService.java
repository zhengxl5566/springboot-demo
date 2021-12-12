package com.zhengxl.mybatissample.service;

import com.zhengxl.mybatissample.model.User;

import java.util.List;

/**
 * @description:
 * @author:Java课代表
 * @createTime:2021/12/12 21:25
 */
public interface UserService {
    int create(User User);
    List<User> queryAll();
}
