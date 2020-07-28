package com.zhengxl.validationdemo.vo;

import com.zhengxl.validationdemo.validategroup.Create;
import com.zhengxl.validationdemo.validategroup.Update;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import java.math.BigDecimal;

/**
 * @description:
 * @projectName:validation-demo
 * @see:com.zhengxl.validationdemo.vo
 * @author:郑晓龙
 * @createTime:2020/7/24 13:15
 * @version:1.0
 */
public class UserVO {
//    ,groups = {Update.class}
    @NotBlank(message = "name 不能为空")
    private String name;
    @Range(min = 1,max = 120)
    @NotNull(message = "age 不能为空")
    private Integer age;
    @NotNull(message = "email 不能为空")
    @Email(message = "email 格式错误")
    private String email;
    @Pattern(regexp = "^1\\d{10}$", message = "phoneNumber 格式错误", groups = Create.class)
    private String phoneNumber;
    @Digits(integer = 3,fraction = 1)
    private BigDecimal bg;

    public BigDecimal getBg() {
        return bg;
    }

    public void setBg(BigDecimal bg) {
        this.bg = bg;
    }

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
