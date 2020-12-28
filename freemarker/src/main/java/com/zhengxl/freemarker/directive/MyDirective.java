package com.zhengxl.freemarker.directive;

import com.zhengxl.freemarker.service.UserService;
import freemarker.core.Environment;
import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * @description:
 * @projectName:freemarker
 * @see:com.zhengxl.freemarker.directive
 * @author:郑晓龙
 * @createTime:2020/12/28 15:47
 * @version:1.0
 */
@Component
public class MyDirective implements TemplateDirectiveModel {
    @Autowired
    private UserService userService;

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {

        Iterator iterator = params.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            String paramName = (String) entry.getKey();
            String paramValue = entry.getValue().toString();
            if (paramName.equals("method")) {
                if(paramValue.equals("getAllUsers")){
                    DefaultObjectWrapper build = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_30).build();
                    TemplateModel wrap = build.wrap(userService.getAllUser());
                    loopVars[0] = wrap;
                }
                if(paramValue.equals("getUser")){
                    DefaultObjectWrapper build = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_30).build();
                    TemplateModel wrap = build.wrap(userService.getUser(params.get("userName").toString()));
                    loopVars[0] = wrap;
                }
            }
        }

        if (body != null) {
            body.render(env.getOut());
        }

    }
}
