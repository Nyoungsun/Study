package class__;

import java.util.StringTokenizer;

public class Token {

    public static void main(String[] args) {
        String str = "학원,,집,,게임방";

        StringTokenizer stringTokenizer = new StringTokenizer(str, ","); // 비어있는 값은 가져오지 않음 (delimiter: 구분 문자)
        System.out.println("토큰 개수 = " + stringTokenizer.countTokens());

        while (stringTokenizer.hasMoreTokens()) { // 토큰 있으면 true, 없으면 false
            System.out.println(stringTokenizer.nextToken()); // 토큰을 꺼내고 다음 토큰으로 이동
        } //while
        System.out.println("--------------------------");

        String[] array = str.split(","); //비어있는 값도 가져옴

        for (String data : array) {
            System.out.println(data);
        }
    }

}