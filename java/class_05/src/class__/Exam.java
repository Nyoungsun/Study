package class__;

import java.util.Scanner;

public class Exam {
    private String name, dap;
    private char[] ox = {'X', 'X', 'X', 'X', 'X'};
    private int score = 0;
    private final String answer = "11111";
    Scanner scanner = new Scanner(System.in);

    public Exam() {
            System.out.print("이름 입력: ");
            name = scanner.next();

            System.out.print("답 입력: ");
            dap = scanner.next();
        }

        public void compare () {
            for (int i = 0; i < answer.length(); i++) {
                if (dap.charAt(i) == answer.charAt(i)) {
                    ox[i] = 'O';
                    score += 20;
                }
            }
        }

        public String getName () {
            return name;
        }

        public char[] getOx () {
            return ox;
        }

        public int getScore () {
            return score;
        }
    }