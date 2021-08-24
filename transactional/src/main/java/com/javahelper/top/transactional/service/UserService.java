package com.javahelper.top.transactional.service;

import com.javahelper.top.transactional.exception.RollBackException;

/**
 * @description:
 * @projectName:transactional
 * @see:com.javahelper.top.transactional.service
 * @author:郑晓龙
 * @createTime:2021/8/22 20:14
 * @version:1.0
 */
public interface UserService {

    /**
     * 演示事务插入并回滚
     * 结果：没有数据插入 User 表，事务回滚生效
     *
     * @param name
     */
    void insertWithTxAndRollBack(String name) throws RollBackException;

    /**
     * 演示 类内部非事务方法调用需要回滚方法
     * 结果：插入成功，事务回滚未生效
     *
     * @param name
     */
    void invokeInsertWithTxRollBackFail(String name) throws RollBackException;

    /**
     * 演示 类内部非事务方法调用需要回滚方法
     * 结果：插入失败，事务回滚生效
     *
     * @param name
     */
    void invokeInsertWithTxRollBackSuccess(String name) throws RollBackException;

    /**
     * 演示 被 try catch 包裹的事务照样回滚了
     * @param userName
     * @param cityName
     */
    void userInsertTxInvokeCityInsert(String userName,String cityName);

    /**
     * 带事务插入成功
     * @param name
     * @throws RollBackException
     */
    void insertWithTx(String name);
    /**
     * 查询总条数
     */
    Long countAll();
}
