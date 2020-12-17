package com.zhengxl.freemarker.service.impl;

import com.zhengxl.freemarker.entity.UserDO;
import com.zhengxl.freemarker.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @projectName:freemarker
 * @see:com.zhengxl.freemarker.service.impl
 * @author:郑晓龙
 * @createTime:2020/12/17 16:33
 * @version:1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public List<UserDO> getAllUser() {
        List<UserDO> users = new ArrayList<>();
        users.add(new UserDO("zxl",18));
        users.add(new UserDO("ls",19));
        users.add(new UserDO("zs",16));
        return users;
    }
}
