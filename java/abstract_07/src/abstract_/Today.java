package abstract_;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    }
}
