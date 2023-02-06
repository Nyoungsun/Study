package while_;

public class While01 {
    public static void main(String[] args) {
        // 1 2 3 4 5 6 7 8 9 10
        int i = 0;
        while (i < 10) {
            i++;
            System.out.print(i + " ");
        }
        System.out.println();

        i = 0;
        while (true) {
            i++;
            System.out.print(i + " ");
            if (i >= 10) {
                break;
            }
        }
    }
}
