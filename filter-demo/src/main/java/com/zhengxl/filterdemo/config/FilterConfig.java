package com.zhengxl.filterdemo.config;

import com.zhengxl.filterdemo.filter.HiFilter;
import com.zhengxl.filterdemo.filter.HelloFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean registerMyFilter(){
        FilterRegistrationBean<HelloFilter> bean = new FilterRegistrationBean<>();
        bean.setOrder(1);
        bean.setFilter(new HelloFilter());
        // 匹配"/hello/"下面的所有url
        bean.addUrlPatterns("/hello/*");
        return bean;
    }
    @Bean
    public FilterRegistrationBean registerMyAnotherFilter(){
        FilterRegistrationBean<HiFilter> bean = new FilterRegistrationBean<>();
        bean.setOrder(2);
        bean.setFilter(new HiFilter());
        // 匹配所有url
        bean.addUrlPatterns("/hi/*");
        return bean;
    }
}
