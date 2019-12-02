package com.zhengxl.mybatiscache;

import com.zhengxl.mybatiscache.mapper.UserOrderMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @description:
 * @projectName:mybatiscache
 * @see:com.zhengxl.mybatiscache
 * @author:郑晓龙
 * @createTime:2019/11/16 16:35
 * @version:1.0
 */
@SpringBootTest
public class UserOrderTest {
    @Autowired
    UserOrderMapper userOrderMapper;
    @Test
    public void selectById(){
        System.out.println(userOrderMapper.selectById(1));
        System.out.println(userOrderMapper.selectById(1));
        System.out.println(userOrderMapper.selectById(1));
    }
    @Test
    public void saveOrder(){
        //System.out.println(userOrderMapper.saveOrder("myGood"));
    }
}
