package com.wjl.entity;

public class student {
    private int id;
    private String sut_num;
    private String name;
    private int age;

    public student(int id, String sut_num, String name, int age) {
        this.id = id;
        this.sut_num = sut_num;
        this.name = name;
        this.age = age;
    }

    public student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSut_num() {
        return sut_num;
    }

    public void setSut_num(String sut_num) {
        this.sut_num = sut_num;
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
}
