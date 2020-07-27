package com.zhengxl.validationdemo.vo;

import com.zhengxl.validationdemo.validategroup.Create;
import com.zhengxl.validationdemo.validategroup.Update;

import javax.swing.*;
import javax.validation.constraints.*;
import javax.validation.groups.Default;

/**
 * @description:
 * @projectName:validation-demo
 * @see:com.zhengxl.validationdemo.vo
 * @author:郑晓龙
 * @createTime:2020/7/24 13:15
 * @version:1.0
 */
public class UserVO {
    @NotBlank(message = "name不能为空",groups = {Update.class})
    private String name;
    @Min(value = 1,message = "年龄最小为1岁")
    @Max(value = 120,message = "年龄最大为120岁")
    @NotNull(message = "年龄不能为空")
    private Integer age;
    @Email(message = "email 格式错误")
    private String email;
    @Pattern(regexp = "^1\\d{10}$", message = "手机号格式错误", groups = Create.class)
    private String phoneNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
