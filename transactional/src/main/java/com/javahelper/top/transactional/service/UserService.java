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
    void tryCatchRollBackFail(String name) throws RollBackException;

    /**
     * @param userName
     * @param cityName
     * @return void
     * @description 演示 被 try catch 包裹的事务照样回滚了
     * 两个方法的事务都会回滚，并且抛出如下异常：
     * Transaction rolled back because it has been marked as rollback-only
     * @author 郑晓龙
     * @createTime 2021/9/1 18:56
     **/
    void tryCatchRollBackSuccess(String userName, String cityName);

    /**
     * @param
     * @return void
     * @description 类内部方法调用带事务方法
     * @author 郑晓龙
     * @createTime 2021/9/1 17:26
     **/
    void innerInvokeRollBackFail(String name) throws RollBackException;

    /**
     * @param name
     * @return void
     * @description 演示 类内部方法调用开启事务的方法，事务生效
     * 结果：插入成功，事务回滚未生效
     * @author 郑晓龙
     * @createTime 2021/9/1 18:58
     **/
    void innerInvokeRollBackSuccess(String name) throws RollBackException;

    /**
     * @param
     * @return void
     * @description 只抛出异常
     * @author 郑晓龙
     * @createTime 2021/9/1 14:49
     **/
    void methodThrowsException() throws RollBackException;

    /**
     * @param name
     * @return void
     * @description 带事务插入
     * @author 郑晓龙
     * @createTime 2021/9/1 18:57
     **/
    void insertWithTx(String name);

    /**
     * @param name
     * @return void
     * @description 带事务插入并抛出异常
     * @author 郑晓龙
     * @createTime 2021/9/1 18:57
     **/
    void insertWithTxThrowException(String name) throws RollBackException;


    void insertWithTxNested(String name) throws RollBackException;

    void invokeNestedTx(String name, String otherName);

    /**
     * @param
     * @return java.lang.Long
     * @description 查询总条数
     * @author 郑晓龙
     * @createTime 2021/9/1 18:58
     **/
    Long countAll();
}
