package top.javahelper.dynamicmultipledatasources.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import top.javahelper.dynamicmultipledatasources.common.RoutingDataSourceContext;

import javax.annotation.PostConstruct;

/**
 * 初始化两个数据源的表结构
 * 为了演示方便，使用了内存数据库 H2，所以需要初始化一下
 * 这里也演示了手工切换数据源的基本用法
 * @author :Java课代表
 */
@Configuration
@ComponentScan()
public class H2DataBaseInit {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        // 手工切换为数据源 first，初始化表
        RoutingDataSourceContext.setRoutingKey("first");
        createTableUser();
        RoutingDataSourceContext.reset();

        // 手工切换为数据源 second，初始化表
        RoutingDataSourceContext.setRoutingKey("second");
        createTableUser();
        RoutingDataSourceContext.reset();

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
