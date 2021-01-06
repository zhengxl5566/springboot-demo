package com.zhengxl.freemarker.config;


import com.zhengxl.freemarker.properties.FreeMarkerProperties;
import freemarker.ext.beans.BeansWrapper;
import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateHashModel;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.Set;

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
    private FreeMarkerProperties freeMarkerProperties;
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
     * @description 将类静态模型包装到共享变量中
     * @author 郑晓龙
     * @createTime 2020/12/28 14:40
     **/
    private void exposeStaticMethod(freemarker.template.Configuration configuration) throws TemplateModelException {
        BeansWrapperBuilder beansWrapperBuilder = new BeansWrapperBuilder(freemarker.template.Configuration.VERSION_2_3_30);
        BeansWrapper beansWrapper = beansWrapperBuilder.build();
        // 返回一个 TemplateHashModel ,包含所有类名，通过它可以调用类的静态方法
        TemplateHashModel staticModels = beansWrapper.getStaticModels();

        String[] staticClassLocation = freeMarkerProperties.getStaticClassLocation();

        if (staticClassLocation == null || staticClassLocation.length <= 0) {
            return;
        }

        for (String location : staticClassLocation) {
            String className = StringUtils.substringAfterLast(location, ".");
            TemplateModel templateModel = staticModels.get(location);
            configuration.setSharedVariable(className, templateModel);
        }
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
        directiveModelMap.entrySet().forEach(
                entry -> configuration.setSharedVariable(entry.getKey(), entry.getValue())
        );
    }
}
