package top.javahelper.dynamicmultipledatasources.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.javahelper.dynamicmultipledatasources.model.User;

/**
 * @author:郑晓龙
 */
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void test(){
        User user = new User();
        user.setName("zxl");
        userMapper.insert(user);

    }
}
