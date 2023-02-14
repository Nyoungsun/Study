package interface_;

import java.util.Scanner;

public class Sub implements Compute {
    int a, b;

    public Sub() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("숫자 2개를 입력(space bar로 구분): ");
        a = scanner.nextInt();
        b = scanner.nextInt();
    }

    @Override
    public void disp() {
        System.out.printf("Sub: %d\n\n", a - b);
    }
}
