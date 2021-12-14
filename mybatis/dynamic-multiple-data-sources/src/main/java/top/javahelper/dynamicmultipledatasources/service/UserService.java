package top.javahelper.dynamicmultipledatasources.service;

import top.javahelper.dynamicmultipledatasources.model.User;

import java.util.List;

/**
 * @description:
 * @projectName:dynamic-multiple-data-sources
 * @see:top.javahelper.dynamicmultipledatasources.service
 * @author:郑晓龙
 * @createTime:2021/12/6 16:22
 * @version:1.0
 */
public interface UserService {

    void insert(User user);

    void insertWithTx(User user);

    List<User> selectAll();
}
