package exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionMain2 {
    private int x;
    private int y;

    public void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("x입력: ");
        x = Integer.parseInt(bufferedReader.readLine());
        System.out.print("y입력: ");
        y = Integer.parseInt(bufferedReader.readLine());
    }

    public void output() {
        System.out.printf("%d의 %d승은 %s", x, y, String.format("%.0f", Math.pow(x, y)));
        System.out.println();

        if (y >= 0) {
            int result = 1;
            for (int i = 0; i < y; i++) {
                result *= x;
            }
            System.out.printf("%d의 %d승은 %d", x, y, result);
        } else {
            try {
                System.out.println("y는 0보다 크거나 같아야함");
                throw new Exception("y는 0보다 크거나 같아야함");// 강제로 Exception 발생
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ExceptionMain2 exceptionMain2 = new ExceptionMain2();
        exceptionMain2.input();
        exceptionMain2.output();
    }
}

/*
[문제] 제곱 연산
- x의 y승을 처리 한다.

[실행결과]
x 입력 : 2
y 입력 : 10         input()
----------------------------------
2의 10승은 xxx        output()
 */
