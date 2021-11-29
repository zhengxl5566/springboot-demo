package top.javahelper.multipledatasources.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
@MapperScan(basePackages = "top.javahelper.multipledatasources.mapper.first", sqlSessionTemplateRef = "firstSqlSessionTemplate")
public class FirstDataSourceConfig {

    @Bean
    @Primary
    // 读取配置，创建数据源
    @ConfigurationProperties(prefix = "spring.datasource.first")
    public DataSource firstDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    // 创建 SqlSessionFactory
    public SqlSessionFactory firstSqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        // 设置 xml 的扫描路径
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/first/*.xml"));
        bean.setTypeAliasesPackage("top.javahelper.multidatasources.entity");
        org.apache.ibatis.session.Configuration config = new org.apache.ibatis.session.Configuration();
        config.setMapUnderscoreToCamelCase(true);
        bean.setConfiguration(config);
        return bean.getObject();
    }

    @Bean
    @Primary
    // 创建 SqlSessionTemplate
    public SqlSessionTemplate firstSqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    @Primary
    // 创建 DataSourceTransactionManager 用于事务管理
    public DataSourceTransactionManager firstTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
