package operator;

import java.util.Scanner;

public class Comp {
    public static void main(String[] args) {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("영문자 1개 입력: ");
            char input = scanner.next().charAt(0);
            int word = input;
            char result = ' ';

            // 대 → 소
            if ((word >= 'A') && (word <= 'Z')) {
                result = (char) (word + 32);
            }
            // 소 → 대
            if ((word >= 'a') && (word <= 'z')) {
                result = (char) (word - 32);
            }
            System.out.println(input + " → " + result);

            char result2 = (char) (word >= 'A' && word <= 'Z' ? word+32 : word-32);
            System.out.println(input + " → " + result2);

        }

    }
}

/*
[문제] 변수의 값이 대문자이면 소문자로 변환해서 출력, 소문자이면 대문자로 변환해서 출력하시오

[실행결과]
B → b
e → E
 */