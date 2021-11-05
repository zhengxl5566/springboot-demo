package top.javahelper.multipledatasources;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import top.javahelper.multipledatasources.entity.User;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class MultipleDataSourcesApplicationTests {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Test
    void contextLoads() throws SQLException {
        List<User> query = jdbcTemplate.query("select * from user", new BeanPropertyRowMapper<>(User.class));
        System.out.println(query);
    }

}
