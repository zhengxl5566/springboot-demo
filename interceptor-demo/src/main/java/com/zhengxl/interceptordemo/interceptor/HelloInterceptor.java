package com.zhengxl.interceptordemo.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description:
 * @projectName:interceptor-demo
 * @see:com.zhengxl.interceptordemo.interceptor
 * @author:郑晓龙
 * @createTime:2020/9/26 10:06
 * @version:1.0
 */
@Configuration
public class HelloInterceptor implements HandlerInterceptor  {
    private static Logger logger =  LoggerFactory.getLogger(HelloInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        logger.info("HelloInterceptor ---> preHandle");
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("HelloInterceptor ---> postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("HelloInterceptor ---> afterCompletion");
    }
}
