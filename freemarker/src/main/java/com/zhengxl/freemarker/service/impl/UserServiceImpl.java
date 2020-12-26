package com.zhengxl.freemarker.service.impl;

import com.zhengxl.freemarker.entity.User;
import com.zhengxl.freemarker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
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
    @Autowired
    CacheManager cacheManager;
    @Override
    @Cacheable("users")
    public List<User> getAllUser() {
        List<User> users = new ArrayList<>();
        users.add(new User("zxl",18));
        users.add(new User("ls",19));
        users.add(new User("zs",16));
        return users;
    }

    @Override
    @CacheEvict("users")
    public Integer insert() {
        return null;
    }

    @Override
    public String cache() {
        Cache usersCache = cacheManager.getCache("helloCache");
        Object nativeCache = usersCache.getNativeCache();
        Collection<String> cacheNames = cacheManager.getCacheNames();

        return nativeCache.toString();
    }


}
