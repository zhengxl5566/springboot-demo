package com.zhengxl.basicdemo;

import com.zhengxl.basicdemo.directive.CustomTagDirective;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @description:
 * @projectName:basic-demo
 * @see:com.zhengxl.basicdemo
 * @author:郑晓龙
 * @createTime:2020/9/10 16:42
 * @version:1.0
 */
@Configuration
public class FreemarkerConfig {
    @Autowired
    protected freemarker.template.Configuration configuration;
    @Autowired
    protected CustomTagDirective customTagDirective;

    @PostConstruct
    public void setSharedVariable(){
        configuration.setSharedVariable("myTag",customTagDirective);
    }
}
