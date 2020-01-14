package com.zhengxl.multidatasource.dao.second;

import com.zhengxl.multidatasource.entity.UserInfoDO;

import java.util.List;

/**
 * @description:
 * @projectName:multidatasource
 * @see:com.zhengxl.multidatasource.dao
 * @author:郑晓龙
 * @createTime:2019/11/8 9:14
 * @version:1.0
 */
public interface SecondUserDAO {
    List<UserInfoDO> queryAll();
}
