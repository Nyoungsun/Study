package class__;

import static java.lang.Math.pow;
import static java.lang.Math.random;

public class ImportStatic {
    public static void main(String[] args) {
        System.out.println(random());
        System.out.println(pow(2, 5));
        System.out.printf("%.2f%n", 45.5678);
    }
}