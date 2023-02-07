package operator;

public class Operator04 {
    public static void main(String[] args) {
        int num1 = 0, num2 = 0;
        boolean result = ((num1+=10) < 0 && (num2+=10) > 0);
        System.out.println(result);
        System.out.println(num1);
        System.out.println(num2);

        boolean result2 = ((num1+=10) > 0 || (num2+=10) > 0);
        System.out.println(result2);
        System.out.println(num1);
        System.out.println(num2);
    }
}