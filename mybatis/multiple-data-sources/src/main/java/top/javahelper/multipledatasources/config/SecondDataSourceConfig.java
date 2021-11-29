package top.javahelper.multipledatasources.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @description:
 * @author:Java课代表
 * @createTime:2021/11/3 23:13
 */
@Configuration
//配置 mapper 的扫描位置，指定相应的 sqlSessionTemplate
@MapperScan(basePackages = "top.javahelper.multipledatasources.mapper.second", sqlSessionTemplateRef = "secondSqlSessionTemplate")
public class SecondDataSourceConfig {

    @Bean
    // 读取配置，创建数据源
    @ConfigurationProperties(prefix = "spring.datasource.second")
    public DataSource secondDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    // 创建 SqlSessionFactory
    public SqlSessionFactory secondSqlSessionFactory(@Qualifier("secondDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        // 设置 xml 的扫描路径
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/second/*.xml"));
        bean.setTypeAliasesPackage("top.javahelper.multidatasources.entity");
        org.apache.ibatis.session.Configuration config = new org.apache.ibatis.session.Configuration();
        config.setMapUnderscoreToCamelCase(true);
        bean.setConfiguration(config);
        return bean.getObject();
    }

    @Bean
    // 创建 SqlSessionTemplate
    public SqlSessionTemplate secondSqlSessionTemplate(@Qualifier("secondSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    // 创建 DataSourceTransactionManager 用于事务管理
    public DataSourceTransactionManager secondTransactionManager(@Qualifier("secondDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
