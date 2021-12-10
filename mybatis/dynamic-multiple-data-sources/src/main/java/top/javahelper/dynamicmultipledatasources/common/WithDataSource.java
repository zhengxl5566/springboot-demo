package top.javahelper.dynamicmultipledatasources.common;

import java.lang.annotation.*;

/**
 * @description:
 * @projectName:dynamic-multiple-data-sources
 * @see:top.javahelper.dynamicmultipledatasources.common
 * @author:郑晓龙
 * @createTime:2021/12/9 17:10
 * @version:1.0
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WithDataSource {
    String value() default "";
}
