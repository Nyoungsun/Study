package abstract_;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarEx {
    private int year, month, day, end;
    Calendar calendar = Calendar.getInstance(); // Calendar는 추상클래스이므로 메소드를 이용

    public CalendarEx() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("년도 입력: ");
        year = scanner.nextInt();
        System.out.print("월 입력: ");
        month = scanner.nextInt();
        calendar.set(year, month - 1, 1);

        calc();
    }

    public void calc() {
        day = calendar.get(Calendar.DAY_OF_WEEK);          // 매달 1일의 요일 (return type = int)
        end = calendar.getActualMaximum(Calendar.DATE);    // 매달 마지막 날

        display();
    }

    public void display() {
        System.out.println();
        System.out.printf("\t\t[%d년 %d월]\n", year, month);
        System.out.println("  일  월  화  수  목  금  토");
        for (int i = 1; i <= end; i++) {
            if (i == 1) {
                for (int j = 1; j < day; j++) { // 매달 1일의 요일만큼 공백
                    System.out.print("\t");
                }
            }
            if (i < 10) { // 한 자릿수일 경우 공백 추가하여 열 맞춤
                System.out.print(" ");
            }
            System.out.print(" " + i + " ");
            if (day % 7 == 0) { //한줄에 7일씩
                System.out.println();
            }
            day++;
        }
        System.out.println("\n-----------------------------");
    }
}
