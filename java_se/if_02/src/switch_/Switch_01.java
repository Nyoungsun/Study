package switch_;

import java.util.Scanner;

public class Switch_01 {
    public static void main(String[] args) {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("월 입력: ");
            int months = scanner.nextInt();
            int days;

            switch (months) {
                case 1 :
                case 3 :
                case 5 :
                case 7 :
                case 8 :
                case 10 :
                case 12 :
                    days = 31;
                    break;
                case 2:
                    days = 28;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    days = 30;
                    break;
                default:
                    days = 0;
            }
            System.out.printf("%d월은 %d일 입니다.\n", months, days);
        }
    }
}
