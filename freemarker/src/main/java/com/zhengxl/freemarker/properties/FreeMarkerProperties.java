package com.zhengxl.freemarker.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @projectName:freemarker
 * @see:com.zhengxl.freemarker.properties
 * @author:郑晓龙
 * @createTime:2021/1/5 14:57
 * @version:1.0
 */
@Component
@Primary
@ConfigurationProperties(prefix = "spring.freemarker")
public class FreeMarkerProperties extends org.springframework.boot.autoconfigure.freemarker.FreeMarkerProperties{
    /**
     * 需要引入的静态工具类的包路径
     */
    private String[] staticToolPackagePath;

    public String[] getStaticToolPackagePath() {
        return staticToolPackagePath;
    }

    public void setStaticToolPackagePath(String[] staticToolPackagePath) {
        this.staticToolPackagePath = staticToolPackagePath;
    }
}
