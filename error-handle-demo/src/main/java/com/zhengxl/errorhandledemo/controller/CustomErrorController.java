package com.zhengxl.errorhandledemo.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

/**
 * @description:
 * @projectName:error-handle-demo
 * @see:com.zhengxl.errorhandledemo.controller
 * @author:郑晓龙
 * @createTime:2020/8/24 18:08
 * @version:1.0
 */
@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                return "my404";
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "my500";
            }

            // 这里后期可以扩展其他错误页面
        }
        return "my404";
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}
