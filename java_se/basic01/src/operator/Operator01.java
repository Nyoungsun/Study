package operator;

import java.util.Scanner;

public class Operator01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("점수(100점 만점): ");
        int score = scanner.nextInt();

//        String str = score >= 80 && score <= 100 ? "합격" : "불합격";
//        System.out.println(str);

        if (score >= 80 && score <= 100) {
            System.out.println("합격");
        } else System.out.println("불합격");
    }
}
