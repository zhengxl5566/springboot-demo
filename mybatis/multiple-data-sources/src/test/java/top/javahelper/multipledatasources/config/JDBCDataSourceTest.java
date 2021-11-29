//package top.javahelper.multipledatasources.config;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import top.javahelper.multipledatasources.entity.User;
//
//import javax.annotation.Resource;
//import javax.sql.DataSource;
//import java.util.List;
//
///**
// * @description:
// * @author:Java课代表
// * @createTime:2021/11/6 23:47
// */
//@SpringBootTest
//public class JDBCDataSourceTest {
//    @Autowired
//    @Qualifier("firstDataSource")
//    DataSource firstDataSource;
//    @Autowired
//    @Qualifier("secondDataSource")
//    DataSource secondDataSource;
//
//    @Test
//    void DataSourceTest() {
//        System.out.println(firstDataSource);
//        System.out.println(secondDataSource);
//    }
//}
