package top.javahelper.dynamicmultipledatasources.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;

/**
 * @description:
 * @projectName:dynamic-multiple-data-sources
 * @see:top.javahelper.dynamicmultipledatasources.config
 * @author:郑晓龙
 * @createTime:2021/12/1 17:35
 * @version:1.0
 */
@Configuration
public class H2DataBaseInit {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        jdbcTemplate.execute("CREATE TABLE user ("
                + "id VARCHAR(50) NOT NULL AUTO_INCREMENT,"
                + "name VARCHAR(50) NOT NULL COMMENT '姓名',"
                + "status VARCHAR(50) NOT NULL COMMENT '用户状态',"
                + "PRIMARY KEY (id))");
    }
}
