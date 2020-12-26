package com.zhengxl.freemarker.config;


import freemarker.ext.beans.BeansWrapper;
import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.template.TemplateHashModel;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.annotation.PostConstruct;

/**
 * @description:
 * @projectName:freemarker
 * @see:com.zhengxl.freemarker.config
 * @author:郑晓龙
 * @createTime:2020/12/17 17:10
 * @version:1.0
 */
@Configuration
public class FreemarkerConfig {
    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @PostConstruct
    public void freemarkerConfigurer() throws TemplateModelException {
        freemarker.template.Configuration configuration1 = freeMarkerConfigurer.getConfiguration();
        BeansWrapperBuilder beansWrapperBuilder = new BeansWrapperBuilder(freemarker.template.Configuration.VERSION_2_3_30);
        BeansWrapper beansWrapper = beansWrapperBuilder.build();
        TemplateHashModel staticModels = beansWrapper.getStaticModels();
        TemplateModel templateModel = staticModels.get("com.zhengxl.freemarker.tools.UserStaticTool");
        configuration1.setSharedVariable("UserStaticTool",templateModel);

    }
}
