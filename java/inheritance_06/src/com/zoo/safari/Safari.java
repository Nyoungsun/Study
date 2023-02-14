package com.zoo.safari;

import com.zoo.Zoo;

public class Safari extends Zoo {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        zoo.tiger(); // 패키지가 다르면 public만 접근 가능

        Safari safari = new Safari(); // 상속 받았으면 sub 클래스에서 접근해야함
        safari.tiger();
        safari.giraffe(); // protected 접근 가능
    }
}