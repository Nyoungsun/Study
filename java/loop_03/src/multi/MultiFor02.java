package multi;

public class MultiFor02 {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.printf("[%d * %d = %d]\n", i, j, i * j);
            }
            System.out.println();
        }
    }
}
