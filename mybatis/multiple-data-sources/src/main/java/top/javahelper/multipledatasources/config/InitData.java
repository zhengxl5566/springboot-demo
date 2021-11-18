package top.javahelper.multipledatasources.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import top.javahelper.multipledatasources.entity.User;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @description:
 * @author:Java课代表
 * @createTime:2021/11/3 23:13
 */
@Configuration
public class InitData {

    @Autowired
    @Qualifier("firstJdbcTemplate")
    private JdbcTemplate firstJdbcTemplate;

    @Autowired
    @Qualifier("secondJdbcTemplate")
    private JdbcTemplate secondJdbcTemplate;

    @PostConstruct
    public void init() {
        initSchema(firstJdbcTemplate);
        initData(firstJdbcTemplate, "ZhangSan1", "LiSi1");

        initSchema(secondJdbcTemplate);
        initData(secondJdbcTemplate, "ZhangSan2", "LiSi2");
    }

    private void initData(JdbcTemplate jdbcTemplate, String... names) {
        for (String s : names) {
            jdbcTemplate.update("insert into user (name) values (?)", s);
        }
        List<User> query = jdbcTemplate.query("select * from user;", new BeanPropertyRowMapper<>(User.class));
        System.out.println(query);
    }

    private void initSchema(JdbcTemplate jdbcTemplate) {
        jdbcTemplate.execute("DROP TABLE IF EXISTS user");
        jdbcTemplate.execute("CREATE TABLE user ("
                + "id VARCHAR(50) NOT NULL AUTO_INCREMENT,"
                + "name VARCHAR(50) NOT NULL,"
                + "PRIMARY KEY (id))");
    }
}
