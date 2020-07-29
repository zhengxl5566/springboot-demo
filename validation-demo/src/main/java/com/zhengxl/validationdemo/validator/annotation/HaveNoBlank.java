package com.zhengxl.validationdemo.validator.annotation;

import com.zhengxl.validationdemo.validator.constraint.HaveNoBlankValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotBlank;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @description: 校验字符串中不能有空格
 * @projectName:validation-demo
 * @see:com.zhengxl.validationdemo.validator.annotation
 * @author:郑晓龙
 * @createTime:2020/7/29 11:27
 * @version:1.0
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {HaveNoBlankValidator.class})// 标明由哪个类执行校验逻辑
public @interface HaveNoBlank {

    // 校验出错时默认返回的消息
    String message() default "字符串中不能含有空格";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * 同一个元素上指定多个该注解时使用
     */
    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
    @Retention(RUNTIME)
    @Documented
    public @interface List {
        NotBlank[] value();
    }
}
