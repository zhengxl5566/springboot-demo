package com.zhengxl.freemarker.entity;

/**
 * @description:
 * @projectName:freemarker
 * @see:com.zhengxl.freemarker.entity
 * @author:郑晓龙
 * @createTime:2020/12/17 16:31
 * @version:1.0
 */
public class User {
    private String name;
    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "UserDO{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
