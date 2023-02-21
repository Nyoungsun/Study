package basic;

import java.util.Arrays;
import java.util.Random;

public class Method02 {
    public static void main(String[] args) {
        double ran = Math.random(); // 0 ~ 1 사이의 값
        System.out.println(ran);

        Random random = new Random(); // nextDouble()이 static 메소드가 아니므로 객체 생성해야함
        double ran2 = random.nextDouble(); // 0 ~ 1 사이의 값
        System.out.println(ran2);

        int a[] = new int[5];
        a[0] = 4;
        a[1] = 1;
        a[2] = 2;
        a[3] = 5;
        a[4] = 3;
        Arrays.sort(a);
        System.out.println(a[0]+","+a[1]+","+a[2]+","+a[3]+","+a[4]);

//        int i;
//        for (i=0; i<5; i++) {
//            a[i] = i+1;
//        }

        int b[] = {6, 7, 8, 9, 10};

        int i;
        for (i=0; i<5; i++) {
            System.out.println(b[i]);
        }
    }
}