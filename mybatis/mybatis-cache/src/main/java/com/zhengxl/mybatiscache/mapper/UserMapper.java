package com.zhengxl.mybatiscache.mapper;

import com.zhengxl.mybatiscache.entity.User;

import java.util.List;

/**
 * @description:
 * @projectName:mybatiscache
 * @see:com.zhengxl.mybatiscache.mapper
 * @author:郑晓龙
 * @createTime:2019/11/15 16:14
 * @version:1.0
 */
public interface UserMapper {
    /**
     * description 根据用户Id查询用户
     **/
    User selectById(Integer id);
    /**
     * description 联查user_order表
     **/
    List<User> selectJoin();
    /**
     * description 添加用户
     **/
    Integer saveUser(User user);
}
