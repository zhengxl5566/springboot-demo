package com.zhengxl.interceptordemo.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description:
 * @projectName:interceptor-demo
 * @see:com.zhengxl.interceptordemo.interceptor
 * @author:郑晓龙
 * @createTime:2020/9/26 11:19
 * @version:1.0
 */
@Component
public class AnotherInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("AnotherInterceptor preHandle");
        return true;
    }
}
