package com.zhengxl.validationdemo.advice;

import com.zhengxl.validationdemo.common.ResultInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
public class GlobalControllerAdvice {

    private static final Logger logger = LoggerFactory.getLogger(GlobalControllerAdvice.class);
    /**
     * 客户端参数错误时返回信息
     **/
    private static final String BAD_REQUEST_MSG = "客户端请求参数错误";

    @ExceptionHandler(Exception.class)
    public ResultInfo exceptionHandler(Exception e) {
        logger.error("全局异常：{}", e.getMessage());
        return new ResultInfo().error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "服务器出错了，请联系管理员");
    }

    /**
     * @param e
     * @return com.zhengxl.validationdemo.common.ResultInfo
     * @description 请求方法不支持 异常处理
     * @author 郑晓龙
     * @createTime 2020/7/28 18:49
     **/
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResultInfo httpRequestMethodNotSupportedExceptionHandler(HttpRequestMethodNotSupportedException e) {
        return new ResultInfo().success(HttpStatus.BAD_REQUEST.value(), "不支持' " + e.getMethod() + "'请求");
    }

    /**
     * @param e
     * @return com.zhengxl.validationdemo.common.ResultInfo
     * @description JavaBean参数校验异常处理
     * JavaBean参数校验错误会抛出 BindException
     * @author 郑晓龙
     * @createTime 2020/7/27 13:45
     **/
    @ExceptionHandler(BindException.class)
    public ResultInfo bindExceptionHandler(BindException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        List<String> collect = fieldErrors.stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        return new ResultInfo().success(HttpStatus.BAD_REQUEST.value(), BAD_REQUEST_MSG, collect);
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
    public ResultInfo constraintViolationExceptionHandler(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        List<String> collect = constraintViolations.stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());
        return new ResultInfo().success(HttpStatus.BAD_REQUEST.value(), BAD_REQUEST_MSG, collect);
    }

    /**
     * @param e
     * @return com.zhengxl.validationdemo.common.ResultInfo
     * @description RequestBody为 json 的参数校验异常捕获
     * @author 郑晓龙
     * @createTime 2020/7/28 18:07
     **/
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultInfo methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        List<String> collect = fieldErrors.stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        return new ResultInfo().success(HttpStatus.BAD_REQUEST.value(), BAD_REQUEST_MSG, collect);
    }
}
