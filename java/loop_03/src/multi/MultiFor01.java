package multi;

public class MultiFor01 {
    public static void main(String[] args) {
        for (int i = 2; i <= 4; i+=2) {
            for (int j = 1; j <= 3; j++) {
                System.out.printf("i = %d j = %d\n", i, j);
            } //for j
            System.out.println();
        } //for i;
    }
}
