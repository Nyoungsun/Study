package operator;

public class Operator03 {
    public static void main(String[] args) {
        int a = 5;
        a = a + 2;
        a *= 3;
        a /= 5;
        System.out.println("a: " + a); //4

        a++;
        System.out.println("a: " + a); //5

        int b = a++; // int b = a를 한 뒤 a++ 수행
        System.out.println("b = " + b + "a= " + a); // b=5, a=6

        int c = ++a * b--; // ++a를 한 뒤 a와 b를 곱해서 c에 넣고 b-- 수행
        System.out.println("c= " + c + ", " + "b =" + b); // a=7, c=35, b=4

        System.out.println("a++: " + a++); // a 출력을 먼저하고 a++, a=7
        System.out.println("a: " + a); // a=8
    }
}