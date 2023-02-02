package operator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Salary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("이름 입력: ");
        String name = scanner.next();
        System.out.print("직급 입력: ");
        String position = scanner.next();
        System.out.print("기본급 입력: ");
        int base = scanner.nextInt();
        System.out.print("수당 입력: ");
        int benefit = scanner.nextInt();

        int total = base + benefit;
        double tax = total >= 5000000 ? tax = total * 0.03 : total >= 3000000 ? tax = total * 0.02 : 0.01;
        double salary = total - tax;

        DecimalFormat DF = new DecimalFormat();
        System.out.println("*** " + name + " " + position + " 월급 ***");
        System.out.println("기본급: " + DF.format(base) + "원");
        System.out.println("수당: " + DF.format(benefit) + "원");
        System.out.println("합계: " + DF.format(total) + "원");

        if (total >= 5000000) {
            System.out.println("세율: 3%");
        } if (total >= 3000000 && total <= 5000000) {
            System.out.println("세율: 2%");
        } else System.out.println("세율 1%");

        System.out.println("세금: " + tax);
        System.out.println("월급: " + salary);
    }
}

/*
[문제] 월급 계산 프로그램 - 조건 연산자
이름, 직급, 기본급, 수당을 입력하여 합계, 세금, 월급을 출력하시오
단 합계가 5,000,000원 이상이면 세금 3%
       3,000,000원 이상이면 세금 2%
       아니면 세금 1%

합계 = 기본급 + 수당
세금 = 합계 * 세율
월급 = 합계 - 세금

[실행결과]
이름 입력    : 홍길동
직급 입력    : 부장
기본급 입력   : 4900000
수당 입력    : 200000

*** 홍길동 부장 월급 ***
기본급  : 4,900,000원
수당   : 200,000원
합계   : 5,100,000원
세율   : 3%
세금   : 153,000원
월급   : 4,947,000원
 */
