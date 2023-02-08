package for_;

import java.text.DecimalFormat;

public class For03 {
    public static void main(String[] args) {

        int i, sum = 0, mul = 1;

        for (i = 1; i <= 10; i++) {
            sum += i;
            mul *= i;

            System.out.printf("%d %d %d\n", i, sum, mul);
        }
    }
}
