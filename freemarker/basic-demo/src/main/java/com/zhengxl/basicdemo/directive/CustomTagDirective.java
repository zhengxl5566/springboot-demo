package com.zhengxl.basicdemo.directive;

import com.zhengxl.basicdemo.service.UserService;
import freemarker.core.Environment;
import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * @description:
 * @projectName:basic-demo
 * @see:com.zhengxl.basicdemo.config
 * @author:郑晓龙
 * @createTime:2020/9/10 15:50
 * @version:1.0
 */
@Component
public class CustomTagDirective implements TemplateDirectiveModel {
    @Autowired
    UserService userService;

    private static final String METHOD_KEY = "method";

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        String methodName = params.get(METHOD_KEY) == null ? "" : params.get(METHOD_KEY).toString();
        DefaultObjectWrapperBuilder defaultObjectWrapperBuilder = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_0);
        if("getUsers".equals(methodName)){
            TemplateModel wrap = defaultObjectWrapperBuilder.build().wrap(userService.getAllUsers());
            env.setVariable("tagList",wrap);
        }
        body.render(env.getOut());
    }
}
