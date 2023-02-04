package for_;

import java.util.Scanner;

public class AddGame {
    public static void main(String[] args) {
        int count = 0;

        for (int i = 1; i <= 5; i++) {
            int a = (int) (Math.random() * 100); // (int) (Math.random() * (최댓값 - 최소값 + 1) + 최소값)
            int b = (int) (Math.random() * 100);

            Scanner scanner = new Scanner(System.in);
            System.out.printf("[%d] %d + %d = ? : ", i, a, b);
            int answer = scanner.nextInt();

            if (answer == a + b) {
                System.out.println("Correct");
                count++;
            } else {
                System.out.println("Incorrect");
                System.out.printf("[%d] %d + %d = ? : ", i, a, b);
                answer = scanner.nextInt();
                if (answer == a + b) {
                    System.out.println("Correct");
                    count++;
                } else {
                    System.out.printf("Incorrect, correct answer is %d\n", a + b);
                }
            }
        }
        System.out.printf("총 %d문제 맞추어서 %d점 입니다.", count, count * 20);
    }
}