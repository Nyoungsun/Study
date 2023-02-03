package if_;

import java.util.Scanner;

public class If_03 {
    public static void main(String[] args) {

        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("\n 숫자 3개를 입력: ");
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();

            if (a < b && a < c) {
                if (b < c) {
                    System.out.printf("%d %d %d", a, b, c);
                } else {
                    System.out.printf("%d %d %d", a, c, b);
                }
            }
        }
    }
}

//        int result1, result2, result3;
//        if (a > b && b > c) {
//            result1 = a;
//        } else if (b > a && b > c && (b > c || c > b)) {
//            result1 = b;
//        } else {
//            result1 = c;
//        }
//        if ((a < b && a > c) || (a > b && a < c)) {
//            result2 = a;
//        } else if ((b < a && b > c) || (b > a && b < c)) {
//            result2 = b;
//        } else {
//            result2 = c;
//        }
//        if (a < b && a < c && (b < c || c < b)) {
//            result3 = a;
//        } else if (b < a && b < c && (a < c || c < a)) {
//            result3 = b;
//        } else {
//            result3 = c;
//        }
//        System.out.printf("%d %d %d ", result1, result2, result3);
