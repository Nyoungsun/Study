package interface_;

import java.util.Scanner;

public class Mul implements Compute { //인터페이스를 implements한 클래스는 반드시 추상 메소드를 오버라이드해야한다.
    int a, b;

    public Mul() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("숫자 2개를 입력(space bar로 구분): ");
        a = scanner.nextInt();
        b = scanner.nextInt();
    }

    @Override
    public void disp() {
        System.out.printf("Mul: %d\n\n", a * b);
    }
}
