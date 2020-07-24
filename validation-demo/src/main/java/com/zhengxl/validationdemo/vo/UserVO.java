package com.zhengxl.validationdemo.vo;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @description:
 * @projectName:validation-demo
 * @see:com.zhengxl.validationdemo.vo
 * @author:郑晓龙
 * @createTime:2020/7/24 13:15
 * @version:1.0
 */
public class UserVO {
    @NotNull(message = "name不能为null")
    private String name;
    private Integer age;
    @Email
    @NotNull(message = "email 不能为null")
    private String email;
    @NotNull(message = "用户手机号不能为null")
    @Pattern(regexp = "^1\\d{10}$",message = "手机号不合法")
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
