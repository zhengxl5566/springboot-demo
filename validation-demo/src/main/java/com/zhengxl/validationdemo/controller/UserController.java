package com.zhengxl.validationdemo.controller;

import com.zhengxl.validationdemo.common.ResultInfo;
import com.zhengxl.validationdemo.validategroup.Create;
import com.zhengxl.validationdemo.validategroup.Update;
import com.zhengxl.validationdemo.vo.UserVO;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;
import java.util.List;
import java.util.stream.Collectors;

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
@Valid
public class UserController {

    /**
     * @param userVO
     * @return java.lang.String
     * @description 手工校验参数 不优雅，不专业
     * @author 郑晓龙
     * @createTime 2020/7/28 19:41
     **/
    @PostMapping("add")
    public String add(UserVO userVO) {
        if (userVO.getAge() == null) {
            return "年龄不能为空";
        }
        if (userVO.getAge() > 120) {
            return "年龄不能超过120";
        }
        if (userVO.getName().isEmpty()) {
            return "用户名不能为空";
        }
        // 省略一堆参数校验
        return "OK";
    }

    @PostMapping("add1")
    public String add1(@Validated UserVO userVO, BindingResult result) {
        List<FieldError> fieldErrors = result.getFieldErrors();
        if (!fieldErrors.isEmpty()) {
            return fieldErrors.get(0).getDefaultMessage();
        }
        return "OK";
    }
    @PostMapping("add2")
    public ResultInfo add2(@Validated UserVO userVO, BindingResult result) {
        List<FieldError> fieldErrors = result.getFieldErrors();
        List<String> collect = fieldErrors.stream()
                .map(o -> o.getDefaultMessage())
                .collect(Collectors.toList());
        return new ResultInfo<>().success(400, "请求参数错误", collect);
    }

//    /**
//     * @param userVO
//     * @return com.zhengxl.validationdemo.common.ResultInfo
//     * @description 校验JavaBean
//     * @author 郑晓龙
//     * @createTime 2020/7/27 14:17
//     **/
//    @PostMapping("add2")
//    public ResultInfo add2(@Validated UserVO userVO) {
//        return new ResultInfo().success(userVO);
//    }
//
//    /**
//     * @param userId
//     * @return com.zhengxl.validationdemo.common.ResultInfo
//     * @description 校验单个参数
//     * @author 郑晓龙
//     * @createTime 2020/7/28 18:11
//     **/
//    @PostMapping("add3")
//    public ResultInfo add3(@NotNull(message = "userId不能为空") Long userId) {
//        return new ResultInfo().success(userId);
//    }
//
//    /**
//     * @param userId
//     * @return com.zhengxl.validationdemo.common.ResultInfo
//     * @description 校验路径参数
//     * @author 郑晓龙
//     * @createTime 2020/7/28 18:14
//     **/
//    @PostMapping("add4/{userId}")
//    public ResultInfo add4(@PathVariable("userId") @NotNull Long userId) {
//        return new ResultInfo().success(userId);
//    }
//
//    /**
//     * @param userVO
//     * @return com.zhengxl.validationdemo.common.ResultInfo
//     * @description 校验Json请求体
//     * @author 郑晓龙
//     * @createTime 2020/7/28 18:15
//     **/
//    @PostMapping("add5")
//    public ResultInfo add5(@RequestBody @Validated UserVO userVO) {
//        return new ResultInfo().success(userVO);
//    }

    /**
     * @param userVO
     * @return com.zhengxl.validationdemo.common.ResultInfo
     * @description 校验分组规则-更新
     * @author 郑晓龙
     * @createTime 2020/7/28 18:17
     **/
    @PostMapping("update")
    public ResultInfo update(@Validated({Update.class, Default.class}) UserVO userVO) {
        return new ResultInfo().success(userVO);
    }

    /**
     * @param userVO
     * @return com.zhengxl.validationdemo.common.ResultInfo
     * @description 校验分组规则-新增
     * @author 郑晓龙
     * @createTime 2020/7/28 18:18
     **/
    @PostMapping("create")
    public ResultInfo create(@Validated(Create.class) UserVO userVO) {
        return new ResultInfo().success(userVO);
    }
}
