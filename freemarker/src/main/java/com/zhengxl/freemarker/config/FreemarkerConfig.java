package com.zhengxl.freemarker.config;


import com.zhengxl.freemarker.properties.FreeMarkerProperties;
import freemarker.ext.beans.BeansWrapper;
import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateHashModel;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private FreeMarkerProperties freeMarkerProperties;
    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;
    @Autowired
    private WebApplicationContext webApplicationContext;

    private Logger logger = LoggerFactory.getLogger(FreemarkerConfig.class);

    @PostConstruct
    public void freemarkerConfigurer() throws TemplateModelException {
        freemarker.template.Configuration configuration = freeMarkerConfigurer.getConfiguration();
        // 关闭空值自动向上查找
        configuration.setFallbackOnNullLoopVariable(false);

        // 暴露静态方法
        exposeStaticMethod(configuration);
        // 暴露自定义指令
        exposeUserDefinedDirectives(configuration);


//        System.out.println(zxl);
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
        String[] packagePaths = freeMarkerProperties.getStaticToolPackagePath();
        if (packagePaths == null || packagePaths.length <= 0) {
            logger.info("no static method class need to be exposed");
            return;
        }
        for (String packagePath : packagePaths) {
            String className = StringUtils.substringAfterLast(packagePath, ".");
            TemplateModel templateModel = staticModels.get(packagePath);
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

        if (directiveModelMap.size() <= 0) {
            logger.info("no user defined directives need to be exposed");
            return;
        }

        directiveModelMap.entrySet().forEach(
                entry -> configuration.setSharedVariable(entry.getKey(), entry.getValue())
        );
    }
}
