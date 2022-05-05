package top.javahelper.dynamicmultipledatasources.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    @Transactional(rollbackFor = Throwable.class)
    public void insertWithTx(User user) {
        userMapper.insert(user);
    }


    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }
}
