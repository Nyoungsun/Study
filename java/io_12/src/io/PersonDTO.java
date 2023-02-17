package io;

import java.io.Serializable;

public class PersonDTO implements Serializable { // 객체 직렬화

    private String name;
    private int age;
    private double height;

    public PersonDTO(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(double heigth) {
        this.height = heigth;
    }
}
