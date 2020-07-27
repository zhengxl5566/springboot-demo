package com.zhengxl.validationdemo.advice;

import com.zhengxl.validationdemo.common.ResultInfo;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @description: RestControllerAdvice
 * @projectName:validation-demo
 * @see:com.zhengxl.validationdemo.advice
 * @author:郑晓龙
 * @createTime:2020/7/27 13:58
 * @version:1.0
 */
@RestControllerAdvice
public class ApiControllerAdvice {
    /**
     * @param e
     * @return com.zhengxl.validationdemo.common.ResultInfo
     * @description JavaBean参数校验异常处理
     * JavaBean参数校验错误会抛出 BindException
     * @author 郑晓龙
     * @createTime 2020/7/27 13:45
     **/
    @ExceptionHandler(BindException.class)
    public ResultInfo validationExceptionHandler(BindException e) {
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        List<String> collect = allErrors.stream()
                .map(o -> o.getDefaultMessage())
                .collect(Collectors.toList());
        return new ResultInfo().success("400", "请求参数错误", collect);
    }

    /**
     * @param e
     * @return com.zhengxl.validationdemo.common.ResultInfo
     * @description 单个参数校验异常处理
     * 单个参数校验错误会抛出 ConstraintViolationException
     * @author 郑晓龙
     * @createTime 2020/7/27 13:53
     **/
    @ExceptionHandler(ConstraintViolationException.class)
    public ResultInfo validationSingleParamExceptionHandler(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        List<String> collect = constraintViolations.stream()
                .map(o -> o.getMessage())
                .collect(Collectors.toList());
        return new ResultInfo().success("400", "请求参数错误", collect);
    }
}
