package interface_;

import java.util.Scanner;

public class ComputeService {
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        Compute compute;
        int num;

        while (true) {
            System.out.println("===== MENU =====");
            System.out.println(" 1. SUM");
            System.out.println(" 2. SUB");
            System.out.println(" 3. MUL");
            System.out.println(" 4. DIV");
            System.out.println(" 5. FINISH");
            System.out.println("================");
            System.out.print("SELECT NUMBER: ");
            num = scanner.nextInt();
            System.out.println();

            if (num == 5) {
                System.out.println("FINISH");
                break;
            } else if (num == 1) {
                compute = new Sum();
                compute.disp();
            } else if (num == 2) {
                compute = new Sub();
                compute.disp();
            } else if (num == 3) {
                compute = new Mul();
                compute.disp();
            } else if (num == 4) {
                compute = new Div();
                compute.disp();
            }
        } // while
    }
}
