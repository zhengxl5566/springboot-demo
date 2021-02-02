package com.zhengxl.mybatissample.service.impl;

import com.zhengxl.mybatissample.mapper.UserInfoMapper;
import com.zhengxl.mybatissample.model.UserInfo;
import com.zhengxl.mybatissample.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @projectName:mybatis-sample
 * @see:com.zhengxl.mybatissample.service.impl
 * @author:郑晓龙
 * @createTime:2020/12/31 11:35
 * @version:1.0
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Override
    public int createUser(UserInfo userInfo) {
        return userInfoMapper.insert(userInfo);
    }
}
