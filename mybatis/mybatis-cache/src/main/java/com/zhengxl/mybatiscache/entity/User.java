package com.zhengxl.mybatiscache.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @projectName:mybatiscache
 * @see:com.zhengxl.mybatiscache.entity
 * @author:郑晓龙
 * @createTime:2019/11/15 16:01
 * @version:1.0
 */
@Data
public class User implements Serializable {
    /**
     * 用户Id自增主键
     **/
    Integer id;
    /**
     * 姓名
     **/
    String name;
    /**
     * 密码
     **/
    String passWord;
}
