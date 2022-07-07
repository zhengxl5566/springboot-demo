package com.zhengxl.interceptordemo.config;

import com.zhengxl.interceptordemo.interceptor.HiInterceptor;
import com.zhengxl.interceptordemo.interceptor.HelloInterceptor;
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
public class WebMVCConfig implements WebMvcConfigurer {
    @Autowired
    HelloInterceptor helloInterceptor;
    @Autowired
    HiInterceptor hiInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(helloInterceptor);
        registry.addInterceptor(hiInterceptor);
    }
}
