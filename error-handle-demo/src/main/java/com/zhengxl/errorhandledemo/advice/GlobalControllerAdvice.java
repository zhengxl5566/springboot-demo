package com.zhengxl.errorhandledemo.advice;

import com.zhengxl.errorhandledemo.common.ResultInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @description:
 * @projectName:error-handle-demo
 * @see:com.zhengxl.errorhandledemo.advice
 * @author:郑晓龙
 * @createTime:2020/8/26 10:26
 * @version:1.0
 */
@ControllerAdvice
public class GlobalControllerAdvice {
    private static final Logger logger = LoggerFactory.getLogger(GlobalControllerAdvice.class);

    @ExceptionHandler(Exception.class)
    public ResultInfo exceptionHandler(Exception e) {
        logger.error("全局异常：{}", e.getMessage());
        return new ResultInfo().error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "服务器出错了，请联系管理员");
    }
}
