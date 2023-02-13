package abstract_;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class NumberMain {
    public static void main(String[] args) {
//        NumberFormat numberFormat = new NumberFormat(); // 추상 클래스이므로 객체 생성 불가
        NumberFormat numberFormat = new DecimalFormat("#,###.##원"); // Sub class를 이용하여 생성
        System.out.println(numberFormat.format(12345678.123456));
        System.out.println(numberFormat.format(12345678));
        System.out.println();

        NumberFormat numberFormat2 = new DecimalFormat("#,###.00원"); // Sub class를 이용하여 생성
        System.out.println(numberFormat.format(12345678.123456));
        System.out.println(numberFormat.format(12345678));
        System.out.println();

//        NumberFormat numberFormat3 = NumberFormat.getInstance(); //메소드를 이용하여 생성
        NumberFormat numberFormat3 = NumberFormat.getCurrencyInstance();  // ₩
        numberFormat3.setMaximumFractionDigits(2);
        numberFormat3.setMinimumFractionDigits(2);
        System.out.println(numberFormat3.format(12345678.123456));
        System.out.println(numberFormat3.format(12345678));
        System.out.println();

//        NumberFormat numberFormat5 = NumberFormat.getInstance(Locale.US); // US 숫자 표기법 적용
        NumberFormat numberFormat5 = NumberFormat.getCurrencyInstance(Locale.US); // $

        numberFormat5.setMaximumFractionDigits(2);
        numberFormat5.setMinimumFractionDigits(2);
        System.out.println(numberFormat5.format(12345678.123456));
        System.out.println(numberFormat5.format(12345678));
        System.out.println();
    }
}
