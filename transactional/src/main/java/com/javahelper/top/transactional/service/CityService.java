package com.javahelper.top.transactional.service;

import com.javahelper.top.transactional.exception.RollBackException;

/**
 * @description:
 * @projectName:transactional
 * @see:com.javahelper.top.transactional.service
 * @author:郑晓龙
 * @createTime:2021/8/23 11:54
 * @version:1.0
 */
public interface CityService {
    /**
     * 带事务，抛异常回滚
     * @param name
     */
    void insertWithTxAndRollBack(String name) throws RollBackException;

    Long countAll();
}
