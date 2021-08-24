package com.javahelper.top.transactional.controller;

import com.javahelper.top.transactional.exception.RollBackException;
import com.javahelper.top.transactional.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @projectName:transactional
 * @see:com.javahelper.top.transactional.controller
 * @author:郑晓龙
 * @createTime:2021/8/23 13:53
 * @version:1.0
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    /**
     * 数据未插入，事务回滚生效
     * @param name
     * @return
     * @throws RollBackException
     */
    @PostMapping("insertThenRollBack")
    public Long insertThenRollBack(String name) {
        try {
            userService.insertWithTxAndRollBack(name);
        } catch (RollBackException e) {

        }
        return userService.countAll();
    }

    /**
     * 数据插入成功，事务回滚未生效
     * @param name
     * @return
     * @throws RollBackException
     */
    @PostMapping("methodInvokeTransactionFail")
    public Long methodInvokeTransactionFail(String name) {
        try {
            userService.invokeInsertWithTxRollBackFail(name);
        } catch (RollBackException e) {

        }
        return userService.countAll();
    }
    /**
     * 数据插入失败，事务回滚生效
     * @param name
     * @return
     * @throws RollBackException
     */
    @PostMapping("methodInvokeTransactionSuccess")
    public Long methodInvokeTransactionSuccess(String name) {
        try {
            userService.invokeInsertWithTxRollBackSuccess(name);
        } catch (RollBackException e) {

        }
        return userService.countAll();
    }

    @PostMapping("invokeAnotherTransaction")
    public Long invokeAnotherTransaction(String name){
        userService.userInsertTxInvokeCityInsert(name);
        return userService.countAll();
    }

    /**
     * 演示 被 try catch 包裹的事务依然回滚了
     * @param name
     * @return
     */
    @PostMapping("rollBackWithTryCatch")
    public Long rollBackWithTryCatch(String name){
        userService.userInsertTxInvokeCityInsert(name);
        return userService.countAll();
    }
}
