package com.zhengxl.mybatiscache.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @projectName:mybatiscache
 * @see:com.zhengxl.mybatiscache
 * @author:郑晓龙
 * @createTime:2019/11/16 22:10
 * @version:1.0
 */
@Data
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 8031791326949440737L;
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
    /**
     * 货物名称
     **/
    String goodName;
}
