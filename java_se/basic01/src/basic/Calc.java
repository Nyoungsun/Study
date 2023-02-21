package basic;

public class Calc {
    public static void main(String[] args) {

        int a = 320, b = 258;
        int add = a + b, sub = a - b, mul = a * b;
        float div = (float) a / b;

        System.out.println("add = " + add + "\nsub = " + sub + "\nmul = " + mul + "\ndiv = " + String.format("%.2f", div));

    }
}
