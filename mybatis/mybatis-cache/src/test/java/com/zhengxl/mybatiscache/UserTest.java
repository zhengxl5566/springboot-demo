package com.zhengxl.mybatiscache;

import com.zhengxl.mybatiscache.entity.User;
import com.zhengxl.mybatiscache.entity.UserOrder;
import com.zhengxl.mybatiscache.mapper.UserMapper;
import com.zhengxl.mybatiscache.mapper.UserOrderMapper;
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
    @Autowired
    UserOrderMapper userOrderMapper;
    /**
     * 开启事务，测试一级缓存效果
     * 缓存命中顺序：二级缓存---> 一级缓存---> 数据库
     **/
    @Test
    @Transactional(rollbackFor = Throwable.class)
    public void testFistCache(){
        // 第一次查询，缓存到一级缓存
        System.out.println(userMapper.selectById(1));
        // 第二次查询，直接读取一级缓存
        System.out.println(userMapper.selectById(1));

    }
    /**
     * 测试二级缓存效果
     * 需要*Mapper.xml开启二级缓存
     **/
    @Test
    public void testSecondCache(){
        userMapper.selectById(1);
        userMapper.selectById(1);
    }

    /**
     * 测试多表联查的二级缓存效果
     * 需要*Mapper.xml设定引用空间
     **/
    @Test
    public void testJoin(){
        System.out.println(userMapper.selectJoin());
        System.out.println(userMapper.selectJoin());
        UserOrder userOrder = new UserOrder();
        userOrder.setGoodName("myGoods");
        userOrder.setUserId(1);
        userOrderMapper.saveOrder(userOrder);
        System.out.println(userMapper.selectJoin());

    }

    @Test
    public void saveUser(){
        User user = new User();
        user.setName("zhangxin");
        user.setPassWord("123456");
        userMapper.saveUser(user);
        System.out.println(user.getId());
        System.out.println(user.getPassWord());
    }
}
