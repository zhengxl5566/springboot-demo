package com.zhengxl.validationdemo.validator.constraint;

import com.zhengxl.validationdemo.validator.annotation.HaveNoBlank;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @description:
 * @projectName:validation-demo
 * @see:com.zhengxl.validationdemo.validator.constraint
 * @author:郑晓龙
 * @createTime:2020/7/29 11:30
 * @version:1.0
 */
public class HaveNoBlankValidator implements ConstraintValidator<HaveNoBlank, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // null 不做检验
        if (value == null) {
            return true;
        }
        if (value.contains(" ")) {
            // 校验失败
            return false;
        }
        // 校验成功
        return true;
    }
}
