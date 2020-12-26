package com.zhengxl.freemarker.tools;

import com.zhengxl.freemarker.entity.User;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @projectName:freemarker
 * @see:com.zhengxl.freemarker.tools
 * @author:郑晓龙
 * @createTime:2020/12/24 16:56
 * @version:1.0
 */
public class UserStaticTool {
    public static User getUser(String userName){
        Map<String,User> userMap = new HashMap<>();
        userMap.put("zhangsan",new User("zhangsan", 18));
        userMap.put("lisi",new User("lisi", 19));
        userMap.put("wangwu",new User("wangwu", 20));
        return userMap.get(userName);
    }
}
