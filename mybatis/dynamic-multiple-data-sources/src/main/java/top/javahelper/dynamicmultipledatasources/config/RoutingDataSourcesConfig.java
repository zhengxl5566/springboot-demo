package top.javahelper.dynamicmultipledatasources.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import top.javahelper.dynamicmultipledatasources.common.RoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @projectName:dynamic-multiple-data-sources
 * @see:top.javahelper.dynamicmultipledatasources.config
 * @author:郑晓龙
 * @createTime:2021/12/2 11:24
 * @version:1.0
 */
@Configuration
public class RoutingDataSourcesConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.first")
    public DataSource firstDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.second")
    public DataSource secondDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean
    public RoutingDataSource dataSource() {
        RoutingDataSource dynamicDataSource = new RoutingDataSource();
        dynamicDataSource.setDefaultTargetDataSource(firstDataSource());
        Map<Object, Object> dataSourceMap = new HashMap<>();
        dataSourceMap.put("first", firstDataSource());
        dataSourceMap.put("second", secondDataSource());
        dynamicDataSource.setTargetDataSources(dataSourceMap);
        return dynamicDataSource;
    }
}
