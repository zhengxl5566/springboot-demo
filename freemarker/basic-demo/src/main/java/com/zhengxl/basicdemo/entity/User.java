package com.zhengxl.basicdemo.entity;

/**
 * @description:
 * @projectName:basic-demo
 * @see:com.zhengxl.basicdemo.entity
 * @author:郑晓龙
 * @createTime:2020/7/9 11:29
 * @version:1.0
 */
public class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
