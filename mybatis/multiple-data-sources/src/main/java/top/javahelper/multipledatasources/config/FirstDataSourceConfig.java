package top.javahelper.multipledatasources.config;

import org.springframework.boot.autoconfigure.jdbc.JdbcProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @description:
 * @author:Java课代表
 * @createTime:2021/11/3 23:13
 */
@Configuration
public class FirstDataSourceConfig {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.first")
    public DataSource firstDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    JdbcTemplate firstJdbcTemplate(DataSource firstDataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(firstDataSource);
        System.out.println(firstDataSource);
        JdbcProperties.Template template = new JdbcProperties.Template();
        jdbcTemplate.setFetchSize(template.getFetchSize());
        jdbcTemplate.setMaxRows(template.getMaxRows());
        if (template.getQueryTimeout() != null) {
            jdbcTemplate.setQueryTimeout((int) template.getQueryTimeout().getSeconds());
        }
        return jdbcTemplate;
    }
}
