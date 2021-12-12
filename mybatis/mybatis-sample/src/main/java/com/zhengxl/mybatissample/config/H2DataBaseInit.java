package com.zhengxl.mybatissample.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;

/**
 * @description: 初始化内存数据库的表结构，用于自动生成代码
 * @projectName:mybatis-sample
 * @see:com.zhengxl.mybatissample.controller
 * @author:郑晓龙
 * @createTime:2021/12/12 21:11
 * @version:1.0
 */
@Configuration
public class H2DataBaseInit {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        createTableUser();
    }

    private void createTableUser() {
        jdbcTemplate.update("CREATE TABLE user\n" +
                "        (\n" +
                "            id   VARCHAR(50) NOT NULL AUTO_INCREMENT,\n" +
                "            name VARCHAR(50) NOT NULL,\n" +
                "            PRIMARY KEY (id)\n" +
                "        )");
    }

}
