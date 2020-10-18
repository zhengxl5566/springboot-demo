package com.zhengxl.filterdemo.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@Component
//@Order(2)
//@WebFilter(urlPatterns = "/*")
public class MyAnotherFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("my another filter in");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("my another filter out");

    }
}
