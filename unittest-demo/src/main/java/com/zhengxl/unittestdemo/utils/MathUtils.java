package com.zhengxl.unittestdemo.utils;

/**
 * @description:
 * @projectName:unittest-demo
 * @see:com.zhengxl.unittestdemo.utils
 * @author:郑晓龙
 * @createTime:2020/9/7 16:11
 * @version:1.0
 */
public class MathUtils {
    public static Long factorial(Long n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        long result = 1;
        for (long i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }

}
