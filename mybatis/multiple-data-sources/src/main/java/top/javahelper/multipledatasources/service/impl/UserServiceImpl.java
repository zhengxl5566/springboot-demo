package top.javahelper.multipledatasources.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.javahelper.multipledatasources.entity.User;
import top.javahelper.multipledatasources.mapper.first.FirstUserMapper;
import top.javahelper.multipledatasources.mapper.second.SecondUserMapper;
import top.javahelper.multipledatasources.service.UserService;

import java.util.List;

/**
 * @description:
 * @author:Java课代表
 * @createTime:2021/11/29 23:23
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    FirstUserMapper firstUserMapper;
    @Autowired
    SecondUserMapper secondUserMapper;

    @Override
    // 不显式指定参数 transactionManager 则会使用设置为 Primary 的 firstTransactionManager
    // 如下代码只会回滚 firstUserMapper.insert， secondUserMapper.insert(user2);会正常插入
    @Transactional(rollbackFor = Throwable.class,transactionManager = "firstTransactionManager")
    public void insertTwoDBWithTX(String name) {
        User user = new User();
        user.setName(name);
        // 会回滚
        firstUserMapper.insert(user);
        // 不会回滚
        secondUserMapper.insert(user);

        // 主动触发回滚
        int i = 1/0;
    }

    @Override
    public List<User> getAllFirstDBUsers() {
        return firstUserMapper.selectAll();
    }

    @Override
    public List<User> getAllSecondDBUsers() {
        return secondUserMapper.selectAll();
    }

}
