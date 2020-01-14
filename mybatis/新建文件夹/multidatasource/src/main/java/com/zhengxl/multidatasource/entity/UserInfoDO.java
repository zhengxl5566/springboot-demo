package com.zhengxl.multidatasource.entity;

import lombok.Data;

/**
 * @description:
 * @projectName:oilprice
 * @see:com.zhengxl.oilprice.entity
 * @author:郑晓龙
 * @createTime:2019/10/30 15:20
 * @version:1.0
 */
@Data
public class UserInfoDO {
    /**
     * 主键id自增
     */
    private Integer id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 哈希后密码
     */
    private String hashedPassword;
    /**
     * 手机号
     */
    private String phoneNumber;
}
