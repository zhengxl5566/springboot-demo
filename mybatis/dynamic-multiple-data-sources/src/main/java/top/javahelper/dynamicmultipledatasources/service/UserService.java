package top.javahelper.dynamicmultipledatasources.service;

import top.javahelper.dynamicmultipledatasources.model.User;

import java.util.List;

/**
 * @author :郑晓龙
 */
public interface UserService {

    void insert(User user);

    void insertWithTx(User user);

    List<User> selectAll();
}
