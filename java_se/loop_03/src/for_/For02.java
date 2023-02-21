package for_;

import java.util.Scanner;

public class For02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("원하는 단 입력: ");
        int dan = scanner.nextInt();

        int i;
        if (dan == 1) {
            for (i = 1; i <= 9; i++) {
                System.out.printf("%d * %d = %d\n", dan, i, dan);
            }
        } else if (dan == 2) {
            for (i = 1; i <= 9; i++) {
                System.out.printf("%d * %d = %d\n", dan, i, dan);
            }
        }
    }
}


