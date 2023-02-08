package operator;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Money {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("만원 아래로 돈 내놔: ");
        int Money = scanner.nextInt();

        int a = Money / 10 / 10 / 10; // /1000
        int b = Money / 10 / 10 % 10; // /100 % 10
        int c = Money / 10 % 10 ;
        int d = Money % 10;

        DecimalFormat DF = new DecimalFormat();
        System.out.println("현금: " + DF.format(Money) + "원");
        System.out.println("천원: " + a + "장");
        System.out.println("백원: " + b + "개");
        System.out.println("십원: " + c + "개");
        System.out.println("일원: " + d + "개");

        ArrayList<Integer> arr = new ArrayList<>();
        while(Money > 0) {
            arr.add(Money % 10);
            Money = Money / 10;
        }
        System.out.println("\n[일, 십, 백, 천]");
        System.out.println(arr);
    }
}