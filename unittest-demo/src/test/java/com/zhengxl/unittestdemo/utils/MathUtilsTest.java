package com.zhengxl.unittestdemo.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @description:
 * @projectName:unittest-demo
 * @see:com.zhengxl.unittestdemo.utils
 * @author:郑晓龙
 * @createTime:2020/9/7 16:20
 * @version:1.0
 */
@SpringBootTest
public class MathUtilsTest {
    @Test
    public void test(){
        Assertions.assertEquals(6L,MathUtils.factorial(3L));
    }
}
