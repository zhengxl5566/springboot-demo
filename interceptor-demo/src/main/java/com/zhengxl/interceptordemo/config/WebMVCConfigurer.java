package com.zhengxl.interceptordemo.config;

import com.zhengxl.interceptordemo.interceptor.AnotherInterceptor;
import com.zhengxl.interceptordemo.interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description:
 * @projectName:interceptor-demo
 * @see:com.zhengxl.interceptordemo.config.CustomWebMVCConfigurer
 * @author:郑晓龙
 * @createTime:2020/9/26 10:04
 * @version:1.0
 */
@Configuration
public class WebMVCConfigurer implements WebMvcConfigurer {
    @Autowired
    MyInterceptor myInterceptor;
    @Autowired
    AnotherInterceptor anotherInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor);
        registry.addInterceptor(anotherInterceptor);
    }
}
