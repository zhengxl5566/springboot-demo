package com.zhengxl.freemarker.config;


import freemarker.ext.beans.BeansWrapper;
import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateHashModel;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.annotation.PostConstruct;
import java.util.Map;

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
    @Autowired
    private WebApplicationContext webApplicationContext;

    @PostConstruct
    public void freemarkerConfigurer() throws TemplateModelException {
        freemarker.template.Configuration configuration = freeMarkerConfigurer.getConfiguration();
        // 暴露静态方法
        exposeStaticMethod(configuration);
        // 暴露自定义指令
        exposeUserDefinedDirectives(configuration);

    }

    /**
     * @param configuration
     * @return void
     * @description 将静态方法包装到共享变量中
     * @author 郑晓龙
     * @createTime 2020/12/28 14:40
     **/
    private void exposeStaticMethod(freemarker.template.Configuration configuration) throws TemplateModelException {
        BeansWrapperBuilder beansWrapperBuilder = new BeansWrapperBuilder(freemarker.template.Configuration.VERSION_2_3_30);
        BeansWrapper beansWrapper = beansWrapperBuilder.build();
        TemplateHashModel staticModels = beansWrapper.getStaticModels();
        TemplateModel templateModel = staticModels.get("com.zhengxl.freemarker.tools.UserStaticTool");
        configuration.setSharedVariable("UserStaticTool", templateModel);

    }

    /**
     * @param configuration
     * @return void
     * @description 将用户自定义指令包装到共享变量中
     * @author 郑晓龙
     * @createTime 2020/12/28 14:40
     **/
    private void exposeUserDefinedDirectives(freemarker.template.Configuration configuration) throws TemplateModelException {
        Map<String, TemplateDirectiveModel> directiveModelMap = webApplicationContext.getBeansOfType(TemplateDirectiveModel.class);
        configuration.setSharedVariables(directiveModelMap);
    }
}
