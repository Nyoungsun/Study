package abstract_;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarEx {
    private int year, month, firstday, lastday;

    public CalendarEx() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("년도 입력: ");
        year = scanner.nextInt();
        System.out.print("월 입력: ");
        month = scanner.nextInt();
    }

    public void calc() {
        Calendar calendar = Calendar.getInstance(); // Calendar는 추상클래스이므로 메소드를 이용

        calendar.set(year, month - 1, 1); // 1월이 0부터 시작하므로 month - 1

        firstday = calendar.get(Calendar.DAY_OF_WEEK);               // 1일의 요일 (return type = int)
        lastday = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);  // 마지막 날 (또는 DATE)
    }

    public void display() {
        System.out.println();
        System.out.printf("\t\t[%d년 %d월]\n", year, month);
        System.out.println("일\t월\t화\t수\t목\t금\t토");
        for (int i = 1; i <= lastday; i++) {
            if (i == 1) {
                for (int j = 1; j < firstday; j++) { // 1일의 요일만큼 공백
                    System.out.print("\t");
                }
            }
            if (i < 10) { // 한 자릿수일 경우 공백 추가하여 열 맞춤
                System.out.print(" ");
            }
            System.out.print(" " + i + " ");
            if (firstday % 7 == 0) { //한줄에 7일씩
                System.out.println();
            }
            firstday++;
        }
        System.out.println("\n-----------------------------");
    }
}
