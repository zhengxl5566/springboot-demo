package com.zhengxl.validationdemo.controller;

import com.zhengxl.validationdemo.vo.UserVO;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @projectName:validation-demo
 * @see:com.zhengxl.validationdemo.controller
 * @author:郑晓龙
 * @createTime:2020/7/24 10:22
 * @version:1.0
 */
@RestController
@RequestMapping("user")
public class UserController {
    @PostMapping("add")
    public ResultInfo addUser(@Validated UserVO userVO,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            fieldErrors.forEach(e-> System.out.println(e.getDefaultMessage()));
            return new ResultInfo().error("");
        }
        System.out.println(userVO);
        return new ResultInfo().success();
    }
}
