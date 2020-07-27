package com.zhengxl.validationdemo.controller;

import com.zhengxl.validationdemo.common.ResultInfo;
import com.zhengxl.validationdemo.validategroup.Create;
import com.zhengxl.validationdemo.validategroup.Update;
import com.zhengxl.validationdemo.vo.UserVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

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
@Validated
public class UserController {
    /**
     * @description 校验JavaBean
     * @param userVO
     * @return com.zhengxl.validationdemo.common.ResultInfo
     * @author 郑晓龙
     * @createTime 2020/7/27 14:17
     **/
    @PostMapping("add")
    public ResultInfo addUser(@Validated UserVO userVO) {
        return new ResultInfo().success(userVO);
    }

    /**
     * @description 校验单个参数
     * @param userId
     * @return com.zhengxl.validationdemo.common.ResultInfo
     * @author 郑晓龙
     * @createTime 2020/7/27 14:17
     **/
    @GetMapping("get")
    public ResultInfo getUser(@NotNull(message = "userId不能为空") Long userId) {
        return new ResultInfo().success(userId);
    }

    @GetMapping("get/{age}")
    public ResultInfo getUser2(@PathVariable("age") @Max(120) Long age) {
        return new ResultInfo().success(age);
    }

    @PostMapping("update")
    public ResultInfo update(@Validated({Update.class,Default.class}) UserVO userVO){
        return new ResultInfo().success(userVO);
    }

    @PostMapping("create")
    public ResultInfo create(@Validated(Create.class) UserVO userVO){
        return new ResultInfo().success(userVO);
    }
}
