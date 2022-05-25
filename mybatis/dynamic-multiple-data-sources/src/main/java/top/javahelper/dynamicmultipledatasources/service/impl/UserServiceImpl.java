package top.javahelper.dynamicmultipledatasources.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.javahelper.dynamicmultipledatasources.mapper.UserMapper;
import top.javahelper.dynamicmultipledatasources.model.User;
import top.javahelper.dynamicmultipledatasources.service.UserService;

import java.util.List;

/**
 * @author :Java课代表
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }

    @Override
    public void insertWithTx(User user) {
        userMapper.insert(user);
//        throw new RuntimeException("just for rollBack");
    }


    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }
}
