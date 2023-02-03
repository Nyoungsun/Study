package for_;

public class For01 {
    public static void main(String[] args) {

        int i;
        for (i = 0; i < 10; i++) {
            System.out.printf("%d Hello\n", i);
        }
        System.out.println(i + " escape\n");

        for (i = 10; i >= 1; i--) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (i = 'A'; i <= 'Z'; i++) {
            System.out.print((char) i + " ");
        }
    }
}