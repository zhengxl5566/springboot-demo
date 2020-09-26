package com.zhengxl.interceptordemo.config;

import com.zhengxl.interceptordemo.interceptor.AnotherInterceptor;
import com.zhengxl.interceptordemo.interceptor.LogInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description:
 * @projectName:interceptor-demo
 * @see:com.zhengxl.interceptordemo.config
 * @author:郑晓龙
 * @createTime:2020/9/26 10:06
 * @version:1.0
 */
@Configuration
public class CustomWebMvcConfigurer implements WebMvcConfigurer {
    @Autowired
    LogInterceptor logInterceptor;
    @Autowired
    AnotherInterceptor anotherInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(anotherInterceptor);
        registry.addInterceptor(logInterceptor);
    }

}
