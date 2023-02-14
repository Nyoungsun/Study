package com.apple;

import com.zoo.Zoo; // 다른 패키지에 있는 클래스는 import 해주어야함

public class Apple {
    public static void main(String[] args) {
        System.out.println("빨간 사과");

        Zoo zoo = new Zoo();
        zoo.tiger();
//        zoo.giraffe(); // protected이므로 다른 패키지, 다른 패키지 자식 클래스에서 접근 불가
//        zoo.elephant(); // default 다른 패키지에서 접근불가
//        zoo.lion(); // private이므로 같은 패키지, 다른 패키지, 다른 패키지 자식 클래스에서 접근 불가
    }
}
