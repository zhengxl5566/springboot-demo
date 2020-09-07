package com.zhengxl.unittestdemo.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @description:
 * @projectName:unittest-demo
 * @see:com.zhengxl.unittestdemo.controller
 * @author:郑晓龙
 * @createTime:2020/9/3 9:25
 * @version:1.0
 */
@SpringBootTest
public class UserControllerTest {

    @BeforeAll
    public static void beforeAll(){
        System.out.println("beforeAll");
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println("before each");
    }


    @Test
    public void test1(){
        System.out.println(111);
        assertEquals(111,Integer.valueOf(111));
    }

    @Test
    public void test2(){
        System.out.println(22);
    }

}
