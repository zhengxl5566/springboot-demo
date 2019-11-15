package com.zhengxl.mybatiscache;

import com.zhengxl.mybatiscache.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:
 * @projectName:mybatiscache
 * @see:com.zhengxl.mybatiscache
 * @author:郑晓龙
 * @createTime:2019/11/15 16:20
 * @version:1.0
 */
@SpringBootTest
public class UserTest {
    @Autowired
    UserMapper userMapper;
    /**
     * 开启事务，测试一级缓存效果
     **/
    @Test
    @Transactional(rollbackFor = Throwable.class)
    public void testFistCache(){
        // 第一次查询，缓存到一级缓存
        userMapper.selectById(1);
        // 第二次查询，直接读取一级缓存
        userMapper.selectById(1);

    }
    /**
     * 开启事务，测试二级缓存效果
     * 需要*Mapper.xml开启二级缓存
     **/
    @Test
    public void testSecondCache(){
        userMapper.selectById(1);
        userMapper.selectById(1);
        userMapper.selectById(1);

    }
}
