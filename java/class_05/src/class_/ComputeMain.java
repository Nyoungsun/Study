package class_;

import java.util.Scanner;

public class ComputeMain {
    public static void main(String[] args) {

        int count;
        int x, y;

        Scanner scanner = new Scanner(System.in);
        System.out.print("횟수 입력: ");
        count = scanner.nextInt();
        System.out.println();

        Compute[] compute = new Compute[count];
        for (int i = 0; i < count; i++) {
            compute[i] = new Compute();
        }
        for (int i = 0; i < count; i++) {
            System.out.printf("[%d번째]\n", i+1);
            System.out.print("x 입력: ");
            x = scanner.nextInt();
            System.out.print("y 입력: ");
            y = scanner.nextInt();
            System.out.println();
            compute[i].setData(x, y);
        }

        System.out.print("x\t\ty\t\tsum\t\tsub\t\tmul\t\tavg\n");
        System.out.println("----------------------------------------------------");

        for (int i = 0; i < compute.length; i++) {
            System.out.printf("%d\t\t%d\t\t%d\t\t%d\t\t%d\t\t%s\n",
                    compute[i].getX(),
                    compute[i].getY(),
                    compute[i].getSum(),
                    compute[i].getSub(),
                    compute[i].getMul(),
                    compute[i].getDiv());
        }
    }
}

/*
문제] 사칙연산
x, y를 입력하여 합, 차, 곱, 몫을 구하시오

클래스명 : Compute (1인분)
필드 : x, y, sum, sub, mul, div
메소드 : setData(x의 값, y의 값)
        calc()
        getX()
        getY()
        getSum()
        getSub()
        getMul()
        getDiv()

클래스명 : ComputeMain

[실행결과]
횟수 입력 : 2

[1번째]
x 입력 : 25
y 입력 : 36

[2번째]
x 입력 : 35
y 입력 : 12

x   y   sum      sub      mul      div
25   36
35   12
 */
