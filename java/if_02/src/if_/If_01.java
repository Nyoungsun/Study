package if_;

import java.util.Scanner;

public class If_01 {
    public static void main(String[] args) {
        while (true) {

            Scanner scanner = new Scanner(System.in);

            System.out.print("숫자 입력: ");
            int a = scanner.nextInt();

            if (a > 50) {
                System.out.println("50보다 크다");
            } else if (a == 50) {
                System.out.println("50이다");
            } else if (a < 50){
                System.out.println("50보다 작다");
            }

            if (a >='A' && a <= 'c') {
                System.out.println("a는 대문자로: " + (char)a);
            } else if (a >= 'a' && a <= 'c') {
                System.out.println("a는 소문자로: " + (char)a);
            }
        }
    }
}