package while_;

public class Do_while02 {
    public static void main(String[] args) {
        // 1 2 3 4 5 6 7 8 9 10
        int i = 0;
        do {
            i++;
            System.out.print(i + " ");
        } while (i < 10);

        System.out.println();

        char c = 'A';
        int count = 0;
        do {
            System.out.print(c + " ");
            c++;
            count++;
            if (count % 7 == 0) {
                System.out.println();
            }
        } while (c <= 'Z');
    }
}