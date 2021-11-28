package top.javahelper.multipledatasources.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.JdbcProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import javax.xml.bind.SchemaOutputResolver;

/**
 * @description:
 * @author:Java课代表
 * @createTime:2021/11/3 23:14
 */
@Configuration
public class SecondDataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.second")
    public DataSource secondDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    JdbcTemplate secondJdbcTemplate(@Qualifier("secondDataSource") DataSource secondDataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(secondDataSource);
        System.out.println(secondDataSource);
        JdbcProperties.Template template = new JdbcProperties.Template();
        jdbcTemplate.setFetchSize(template.getFetchSize());
        jdbcTemplate.setMaxRows(template.getMaxRows());
        if (template.getQueryTimeout() != null) {
            jdbcTemplate.setQueryTimeout((int) template.getQueryTimeout().getSeconds());
        }
        return jdbcTemplate;
    }
}
