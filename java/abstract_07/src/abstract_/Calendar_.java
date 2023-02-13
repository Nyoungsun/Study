package abstract_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Calendar_ {
    private int year, month, day;
    Calendar calendar = Calendar.getInstance();

    public void CalendarEx() throws IOException {

//        Scanner scanner = new Scanner(System.in);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("년도 입력: ");
        year = Integer.parseInt(bufferedReader.readLine());

        System.out.print("월 입력: ");
        month = Integer.parseInt(bufferedReader.readLine());

        calendar.set(year, month - 1, 1);
    }

    public void calc() {
        day = calendar.get(Calendar.DAY_OF_WEEK);
    }

    public void display() {
        System.out.println();
        System.out.println("\t[ " + year + "년 " + month + "월 ]\n");
        System.out.println("  일  월  화  수  목  금  토");
        for (int i = 1; i < day; i++) {
            System.out.print(" ");
            for (i = 1; i < calendar.getActualMaximum(Calendar.DATE); i++) {
                day++;
                if (day % 7 == 1) {
                    System.out.println();
                }
            }
            if (day % 7 != 1) {
                System.out.println();
            }
        }
    }
}
