package top.javahelper.dynamicmultipledatasources.common;

import java.lang.annotation.*;

/**
 * @author :郑晓龙
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WithDataSource {
    String value() default "";
}
