package com.javahelper.top.transactional.service.impl;

import com.javahelper.top.transactional.exception.RollBackException;
import com.javahelper.top.transactional.service.CityService;
import com.javahelper.top.transactional.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:
 * @projectName:transactional
 * @see:com.javahelper.top.transactional.service.impl
 * @author:郑晓龙
 * @createTime:2021/8/22 20:14
 * @version:1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    UserService userService;

    @Autowired
    CityService cityService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertWithTxAndRollBack(String name) throws RollBackException {
        jdbcTemplate.execute("INSERT INTO USER (NAME) VALUES ('" + name + "')");

        throw new RollBackException("Just For Roll Back");
    }

    /**
     * 类内部未开启事务的方法调用开启事务的方法，事务不生效
     *
     * @param name
     * @throws RollBackException
     */
    @Override
    public void invokeInsertWithTxRollBackFail(String name) throws RollBackException {
        insertWithTxAndRollBack(name);
    }

    /**
     * 类内部未开启事务的方法调用开启事务的方法，生效
     * 将当前的 service 作为实例字段，自己注入
     *
     * @param name
     * @throws RollBackException
     */
    @Override
    public void invokeInsertWithTxRollBackSuccess(String name) throws RollBackException {
        userService.insertWithTxAndRollBack(name);
    }

    /**
     * 演示 被 try catch 包裹的事务照样回滚了
     * 两个方法的事务都会回滚，并且抛出如下异常：
     * Transaction rolled back because it has been marked as rollback-only
     *
     * @param userName
     * @param cityName
     */
    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void userInsertTxInvokeCityInsert(String userName, String cityName) {
        jdbcTemplate.execute("INSERT INTO USER (NAME) VALUES ('" + userName + "')");
        try {
            // 带事务，抛异常回滚
            cityService.insertWithTxAndRollBack(cityName);
        } catch (RollBackException e) {
            // do nothing
        }
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void insertWithTx(String name) {
        jdbcTemplate.execute("INSERT INTO USER (NAME) VALUES ('" + name + "')");
    }

    @Override
    public Long countAll() {
        return (long) jdbcTemplate.queryForList("SELECT COUNT(*) AS CNT FROM USER")
                .get(0).get("CNT");
    }
}
