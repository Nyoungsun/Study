package operator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Salary {
    public static void main(String[] args) {

        while (true) {
            String name, position;
            int base, benefit, total, tax, salary;

            Scanner scanner = new Scanner(System.in);
            System.out.print("\n이름 입력: ");
            name = scanner.next();
            System.out.print("직급 입력: ");
            position = scanner.next();
            System.out.print("기본급 입력: ");
            base = scanner.nextInt();
            System.out.print("수당 입력: ");
            benefit = scanner.nextInt();

            total = base + benefit;
            tax = (int) (total >= 5000000 ?
                    total * 0.03 :
                    total >= 3000000 ?
                            total * 0.02 :
                            total * 0.01);
//        if (total >= 5000000) {
//            tax = (int) (total * 0.03);
//        } else if (total >= 3000000) {
//            tax = (int) (total * 0.02);
//        } else {
//            tax = (int) (total * 0.01);
//        }
            salary = total - tax;

            DecimalFormat DF = new DecimalFormat();
            System.out.println("\n*** " + name + " " + position + " 월급 ***");
            System.out.println("기본급: " + DF.format(base) + "원");
            System.out.println("수당: " + DF.format(benefit) + "원");
            System.out.println("합계: " + DF.format(total) + "원");
            String taxRate = total >= 5000000 ?
                    "세율: 3%" :
                    total >= 3000000 ?
                            "세율 2%" :
                            "세율 1%";
            System.out.println(taxRate);
//        if (total >= 5000000) {
//            System.out.println("세율: 3%");
//        } else if (total >= 3000000) {
//            System.out.println("세율: 2%");
//        } else {
//            System.out.println("세율 1%");
//        }
            System.out.println("세금: " + DF.format(Math.floor(tax)) + "원");
            System.out.println("월급: " + DF.format(salary) + "원");
        }
    }
}

/*
[문제] 월급 계산 프로그램 - 조건 연산자
이름, 직급, 기본급, 수당을 입력하여 합계, 세금, 월급을 출력하시오
단 합계가 5,000,000원 이상이면 세율 3%
       3,000,000원 이상이면 세율 2%
       아니면 세율 1%

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