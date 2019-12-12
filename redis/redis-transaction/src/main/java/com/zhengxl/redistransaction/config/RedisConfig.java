package com.zhengxl.redistransaction.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @description:
 * @projectName:redis-transaction
 * @see:com.zhengxl.redistransaction.config
 * @author:郑晓龙
 * @createTime:2019/12/12 16:12
 * @version:1.0
 */
@Configuration
public class RedisConfig {
    @Bean
    public StringRedisTemplate StringRedisTemplate(RedisConnectionFactory factory) {
        StringRedisTemplate template = new StringRedisTemplate(factory);
        /**
         * description 开启redis事务（仅支持单机，不支持cluster）
         **/
        template.setEnableTransactionSupport(true);
        return template;
    }

    /**
     * description 配置事务管理器
     **/
    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
