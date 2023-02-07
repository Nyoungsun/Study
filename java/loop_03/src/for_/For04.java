package for_;

import java.util.Scanner;

public class For04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("x값과 y값 입력: ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        int i, pow = 1;
        for (i=1; i<=y; i++) {
            pow *= x;
        }
        System.out.printf("%d의 %d승은 %d", x, y, pow);
    }
}
