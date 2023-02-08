package for_;

import java.util.Scanner;

public class For06 {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("1 ~ 10 사이의 숫자 입력: ");
            int input = scanner.nextInt();

            if (input < 1 || input > 10) {
                System.out.println("1 ~ 10 사이의 값만 입력하세요");
                continue;
            } else {
                int factorial = 1;
                for (int i = 1; i <= input; i++) {      // for (int i=input; i>=1; i--)
                    factorial *= i;
                }
                System.out.printf("%d! = %d \n", input, factorial);
                System.out.println("--------------------");
            }
        }
    }
}

/*
[문제] 팩토리얼을 구하시오 (for)
- 입력되는 숫자는 1 ~ 10 사이만 입력한다.

[실행결과]
숫자 입력 : 3
3! = 6 (1*2*3)
---------------------

숫자 입력 : 5
5! = 120 (1*2*3*4*5)
 */
