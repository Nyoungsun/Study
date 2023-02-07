package array;

public class Array02 {
    public static void main(String[] args) {
        String[] ar = {"호랑이", "사자", "원숭이", "치타", "하이에나", "반달가슴곰"};
        for (int i = 0; i < ar.length; i++) {
            System.out.printf("ar[%d]: %s\n", i, ar[i]);
        }
        System.out.println("--------------------");
        System.out.printf("ar의 크기: %d\n", ar.length);
        System.out.println("--------------------");
        for (int i = 0; i < ar.length; i++) {
            System.out.printf("ar[%d]의 크기: %d\n", i, ar[i].length());
        }
        System.out.println("--------------------");
        for (int i = 0; i < ar.length; i++) {
            System.out.printf("ar[%d]의 첫번째 문자: %s\n", i, ar[i].charAt(0));
        }
        System.out.println("--------------------");
        for (int i = 0; i < ar.length; i++) {
            System.out.printf("ar[%d]의 마지막 문자: %s\n", i, ar[i].charAt(ar[i].length() - 1));
        }
        System.out.println("--------------------");
        for (String data : ar) {
            System.out.println(data);
        }
    }
}