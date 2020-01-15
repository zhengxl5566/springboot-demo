package com.zhengxl.mybatissample;

import com.zhengxl.mybatissample.mapper.UserInfoMapper;
import com.zhengxl.mybatissample.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @description:
 * @projectName:mybatis-sample
 * @see:com.zhengxl.mybatissample
 * @author:郑晓龙
 * @createTime:2020/1/15 15:12
 * @version:1.0
 */
@SpringBootTest
public class UserInfoTest {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Test
    public void selectTest(){
        List<UserInfo> userInfos = userInfoMapper.selectAll();
        System.out.println(userInfos);
    }
}
