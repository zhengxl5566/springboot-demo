package com.zhengxl.mybatissample.service;

import com.zhengxl.mybatissample.model.UserInfo;

/**
 * @description:
 * @projectName:mybatis-sample
 * @see:com.zhengxl.mybatissample.service
 * @author:郑晓龙
 * @createTime:2020/12/31 11:32
 * @version:1.0
 */
public interface UserInfoService {
    int createUser(UserInfo userInfo);
}
