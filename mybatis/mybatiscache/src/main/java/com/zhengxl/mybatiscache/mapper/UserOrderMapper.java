package com.zhengxl.mybatiscache.mapper;

import com.zhengxl.mybatiscache.entity.User;
import com.zhengxl.mybatiscache.entity.UserOrder;

/**
 * @description:
 * @projectName:mybatiscache
 * @see:com.zhengxl.mybatiscache.mapper
 * @author:郑晓龙
 * @createTime:2019/11/15 16:14
 * @version:1.0
 */
public interface UserOrderMapper {
    /**
     * description 根据用户Id查询用户
     **/
    UserOrder selectById(Integer id);

    Integer saveOrder(UserOrder userOrder);
}
