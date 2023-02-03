package operator;

public class Operator05 {
    public static void main(String[] args) {
        boolean a = 25 > 36;
        System.out.println("a = " + a);      // F
        System.out.println("!a = " + !a);    // T

        String b = "apple";     // literal 생성
        String c = new String("apple");

        boolean result = b == c ? true : false; // 주소가 같은지
        System.out.println("b add == c add: " + result);

        System.out.println("b add == c add: " + (b != c ? true : false));

        boolean result2 = b.equals(c) ? true : false; // 내용이 같은지
        System.out.println("b == c: " + result2);
    }
}