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
 * 数据源配置
 * 把多个数据源，装配到一个 RoutingDataSource 里
 * @author :郑晓龙
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
    public RoutingDataSource routingDataSource() {
        RoutingDataSource routingDataSource = new RoutingDataSource();
        routingDataSource.setDefaultTargetDataSource(firstDataSource());
        Map<Object, Object> dataSourceMap = new HashMap<>();
        dataSourceMap.put("first", firstDataSource());
        dataSourceMap.put("second", secondDataSource());
        routingDataSource.setTargetDataSources(dataSourceMap);
        return routingDataSource;
    }
}
