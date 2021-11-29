package top.javahelper.multipledatasources.service;

import top.javahelper.multipledatasources.entity.User;

import java.util.List;

/**
 * @description:
 * @author:Java课代表
 * @createTime:2021/11/29 23:49
 */
public interface UserService {

    void insertTwoDBWithTX(String name);

    List<User> getAllFirstDBUsers();

    List<User> getAllSecondDBUsers();


}
