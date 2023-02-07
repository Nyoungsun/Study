package switch_;

import java.util.Scanner;

public class Switch02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("정수 2개 입력: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.print("연산자 입력: ");
        char op = scanner.next().charAt(0);

        switch (op) {
            case '+':
                System.out.printf("%d %c %d = %d", a, op, b, a + b);
                break;
            case '-':
                System.out.printf("%d %c %d = %d", a, op, b, a - b);
                break;
            case  '*':
                System.out.printf("%d %c %d = %d", a, op, b, a * b);
                break;
            case '/' :
                System.out.printf("%d %c %d = %f", a, op, b, (float)a / b);
                break;
            default:
                System.out.println("연산자 error");
        }
    }
}


/*
[문제] 2개의 정수형 숫자와 연산자(+,-,*,/)를 입력하여 계산하시오

[실행결과]
a의 값 : 25
b의 값 : 36
연산자(+,-,*,/)를 입력 : +

25 + 36 = xx

a의 값 : 25
b의 값 : 36
연산자(+,-,*,/)를 입력 : /

25 / 36 = 0.6944444444444444

a의 값 : 25
b의 값 : 36
연산자(+,-,*,/)를 입력 : #

연산자 error
 */