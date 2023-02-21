package exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionMain {
    public static void main(String[] args) throws IOException {
        if (args.length >= 2) {
            System.out.println(args[0]);
            System.out.println(args[1]); // 0번, 1번만 가능
        }
        System.out.println();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            int num = Integer.parseInt(args[0]); // Program argument 첫번째에 String을 입력하면 NumberFormatException

            System.out.print("숫자 입력: ");
            int num2 = Integer.parseInt(bufferedReader.readLine());

            System.out.println(num);
            System.out.println(num2);
            System.out.println(num / num2);
        } catch (NumberFormatException e) {
            System.out.println("Program argument 첫번째에 문자를 입력하면 NumberFormatException이 발생하므로 반드시 숫자를 입력하세요");
            e.printStackTrace(); // error massage
        } catch (ArithmeticException e) {
            System.out.println("0으로는 나눌 수 없습니다.");
            e.printStackTrace();
        } finally {
            System.out.println("error 상관없이 무조건 실행");
        }
        System.out.println();

        System.out.print("문자열 입력: ");
        String str = bufferedReader.readLine();
        System.out.println(str);
    }
}