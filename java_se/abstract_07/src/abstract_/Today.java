package abstract_;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Today {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        System.out.println("오늘 날짜: " + date);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("y년 MM월 dd일 E요일 HH:mm:ss");
        System.out.println("오늘 날짜: " + simpleDateFormat.format(date));

        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyyMMddHHmmss");

        Date birth = simpleDateFormat2.parse("19980819120000");
        System.out.println("내 생일: " + simpleDateFormat.format(birth));
        System.out.println("내 생일: " + simpleDateFormat2.format(birth));

        Calendar calendar1 = Calendar.getInstance(); // methode
        Calendar calendar2 = new GregorianCalendar(); // subclass

        int year = calendar1.get(Calendar.YEAR);
        int month = calendar1.get(Calendar.MONTH);          // 1월: 0, 2월: 1이므로 month + 1
        int day = calendar1.get(Calendar.DAY_OF_MONTH);     // 한달에 몇 일
        int dayName = calendar1.get(Calendar.DAY_OF_WEEK);  // 1주 7일 (일요일: 1, 월요일: 2)
        int hour = calendar2.get(Calendar.HOUR_OF_DAY);     // 24시간제
        int min = calendar2.get(Calendar.MINUTE);
        int sec = calendar2.get(Calendar.SECOND);

        String DayName = " ";
        switch (dayName) {
            case 1:
                DayName = "일요일";
                break;
            case 2:
                DayName = "월요일";
                break;
            case 3:
                DayName = "화요일";
                break;
            case 4:
                DayName = "수요일";
                break;
            case 5:
                DayName = "목요일";
                break;
            case 6:
                DayName = "금요일";
                break;
            case 7:
                DayName = "토요일";
        }
        System.out.printf("%d년 %d월 %d일 %s %d:%d:%d", year, month + 1, day, DayName, hour, min, sec);
    }
}
