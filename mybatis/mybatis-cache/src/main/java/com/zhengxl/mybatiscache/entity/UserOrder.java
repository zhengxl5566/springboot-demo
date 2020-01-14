package com.zhengxl.mybatiscache.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @projectName:mybatiscache
 * @see:com.zhengxl.mybatiscache.entity
 * @author:郑晓龙
 * @createTime:2019/11/16 16:31
 * @version:1.0
 */
@Data
public class UserOrder implements Serializable {
    private static final long serialVersionUID = 6179013399637503174L;
    /**
     * 订单Id自增主键
     **/
    Integer id;
    /**
     * 用户Id
     **/
    Integer userId;
    /**
     * 货物名称
     **/
    String goodName;
}
