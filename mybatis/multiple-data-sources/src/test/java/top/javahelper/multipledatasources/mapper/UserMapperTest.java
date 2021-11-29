package top.javahelper.multipledatasources.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
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

        firstUserMapper.insert(user1);
        List<User> firstUsers = firstUserMapper.selectAll();

        System.out.println(firstUsers);

        User user2 = new User();
        user2.setName("zhengxl");

        secondUserMapper.insert(user2);
        List<User> secondUsers = secondUserMapper.selectAll();

        System.out.println(secondUsers);
    }

}
