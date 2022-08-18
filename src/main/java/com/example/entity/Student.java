package com.example.entity;

import org.springframework.stereotype.Component;

public class Student {
    String name;
    Integer age;

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
}
