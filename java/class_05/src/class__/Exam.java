package class__;

public class Exam {
    private String name, dap;
    private char[] ox = {'X', 'X', 'X', 'X', 'X'};
    private int score = 0;
    private final String answer = "11111";

    public Exam(String name, String dap) {
        this.name = name;
        this.dap = dap;
    }

    public void compare() {
        for (int i = 0; i < answer.length(); i++) {
            if (dap.charAt(i) == answer.charAt(i)) {
                ox[i] = 'O';
                score += 20;
            }
        }
    }

    public String getName() {
        return name;
    }

    public char[] getOx() {
        return ox;
    }

    public int getScore() {
        return score;
    }
}

