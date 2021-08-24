package com.javahelper.top.transactional.service.impl;

import com.javahelper.top.transactional.exception.RollBackException;
import com.javahelper.top.transactional.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:
 * @projectName:transactional
 * @see:com.javahelper.top.transactional.service.impl
 * @author:郑晓龙
 * @createTime:2021/8/23 13:35
 * @version:1.0
 */
@Service
public class CityServiceImpl implements CityService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * 方法内手工抛异常，让事务回滚
     * @param name
     */
    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void insertWithTxAndRollBack(String name) throws RollBackException {
        jdbcTemplate.execute("INSERT INTO CITY (ADDRESS) VALUES ('" + name + "')");
        throw new RollBackException("Just For Roll Back");
    }

    @Override
    public Long countAll() {
        return (long) jdbcTemplate.queryForList("SELECT COUNT(*) AS CNT FROM CITY")
                .get(0).get("CNT");
    }
}
