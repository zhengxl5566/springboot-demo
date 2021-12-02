//package top.javahelper.dynamicmultipledatasources.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.jdbc.JdbcProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import javax.annotation.PostConstruct;
//import javax.sql.DataSource;
//
///**
// * @description:
// * @projectName:dynamic-multiple-data-sources
// * @see:top.javahelper.dynamicmultipledatasources.config
// * @author:郑晓龙
// * @createTime:2021/12/1 17:35
// * @version:1.0
// */
//@Configuration
//public class H2DataBaseInit {
//    @Bean
//    public JdbcTemplate JdbcTemplate(DataSource dataSource){
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//        JdbcProperties.Template template = new JdbcProperties.Template();
//        jdbcTemplate.setFetchSize(template.getFetchSize());
//        jdbcTemplate.setMaxRows(template.getMaxRows());
//        if (template.getQueryTimeout() != null) {
//            jdbcTemplate.setQueryTimeout((int) template.getQueryTimeout().getSeconds());
//        }
//        return jdbcTemplate;
//    }
//
//}
