package com.zhengxl.freemarker.service;

import com.zhengxl.freemarker.entity.User;

import java.util.List;

/**
 * @description:
 * @projectName:freemarker
 * @see:com.zhengxl.freemarker.service
 * @author:郑晓龙
 * @createTime:2020/12/17 16:31
 * @version:1.0
 */
public interface UserService {
    List<User> getAllUser();
    Integer insert();
    String cache();

}
