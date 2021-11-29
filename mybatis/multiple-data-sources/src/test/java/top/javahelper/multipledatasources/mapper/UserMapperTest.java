package top.javahelper.multipledatasources.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.javahelper.multipledatasources.entity.User;
import top.javahelper.multipledatasources.mapper.first.FirstUserMapper;
import top.javahelper.multipledatasources.mapper.second.SecondUserMapper;

import java.util.List;

@SpringBootTest
public class UserMapperTest {
    @Autowired
    FirstUserMapper firstUserMapper;
    @Autowired
    SecondUserMapper secondUserMapper;

    @Test
    public void test() {
        User user1 = new User();
        user1.setName("Java 课代表");

        secondUserMapper.insert(user1);
        List<User> users1 = secondUserMapper.selectAll();
        System.out.println(users1);

        User user2 = new User();
        user2.setName("zhengxl");

        firstUserMapper.insert(user2);
        List<User> users2 = firstUserMapper.selectAll();
        System.out.println(users2);
    }

}
