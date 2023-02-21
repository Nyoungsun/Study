package operator;

import java.util.Scanner;

public class Operator02 {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("정수를 입력하세요: ");
            int num = scanner.nextInt();

            String result = num % 2 == 0 ? "짝수" : "홀수";
            System.out.println(result);

//            String result2 = num % 6 == 0 ? "공배수O" : "공배수X";
            String result2 = num % 2 == 0 && num % 3 == 0 ? "공배수O" : "공배수X";
            System.out.println(result2);
        }
    }
}
