package com.javahelper.top.transactional.controller;

import com.javahelper.top.transactional.exception.RollBackException;
import com.javahelper.top.transactional.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * @param name
     * @param anotherName
     * @return void
     * @description 演示 被 try catch 包裹的事务照样回滚了
     * 两个方法的事务都会回滚，并且抛出如下异常：
     * Transaction rolled back because it has been marked as rollback-only
     * @author 郑晓龙
     * @createTime 2021/9/1 19:27
     **/
    @PostMapping("rollBackWithTryCatch")
    public void rollBackWithTryCatch(String name, String anotherName) {
        userService.tryCatchRollBackSuccess(name, anotherName);
//        return "user table count(*):" + userService.countAll()+"city table count(*):"+cityService.countAll();
    }

    /**
     * 演示 被 try catch 包裹的事务未回滚
     *
     * @param name
     * @return
     * @throws RollBackException
     */
    @PostMapping("insertThenRollBack")
    public void insertThenRollBack(String name) {
        try {
            userService.tryCatchRollBackFail(name);
        } catch (RollBackException e) {

        }
//        return userService.countAll();
    }

    /**
     * @param name
     * @return void
     * @description 演示类内部未开启事务的方法调用开启事务的方法，事务不生效
     * @author 郑晓龙
     * @createTime 2021/9/1 18:47
     **/
    @PostMapping("methodInvokeTransactionFail")
    public void methodInvokeTransactionFail(String name) {
        try {
            userService.innerInvokeRollBackFail(name);
        } catch (RollBackException e) {

        }
//        return userService.countAll();
    }

    /**
     * @param name
     * @return void
     * @description 演示类内部未开启事务的方法调用开启事务的方法，事务生效
     * @author 郑晓龙
     * @createTime 2021/9/1 18:47
     **/
    @PostMapping("methodInvokeTransactionSuccess")
    public void methodInvokeTransactionSuccess(String name) {
        try {
            userService.innerInvokeRollBackSuccess(name);
        } catch (RollBackException e) {

        }
//        return userService.countAll();
    }

    /**
     * @param name
     * @return void
     * @description 演示类内部未开启事务的方法调用开启事务的方法，事务生效
     * @author 郑晓龙
     * @createTime 2021/9/1 18:47
     **/
    @PostMapping("nestedTransaction")
    public void nestedTransaction(String name, String anotherName) {

        userService.invokeNestedTx(name, anotherName);
    }


}
