package while_;

import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int user, count = 0;
        char input;
//        String input;

        Entire:
        while (true) {
            int com = (int) ((Math.random() * 100) + 1);

            Game:
            while (true) {
                System.out.printf("1 ~ 100 사이의 숫자 입력 (힌트 %d): ", com);
                user = scanner.nextInt();
                if (user < 1 || user > 100) {
                    count++;
                    System.out.println("1 ~ 100 사이의 숫자만 입력하세요.");
                } else {
                    if (com > user) {
                        count++;
                        System.out.printf("%d 보다 큽니다.\n", user);
//                        continue;
//                        continue Game;
                    } else if (com < user) {
                        count++;
                        System.out.printf("%d 보다 작습니다.\n", user);
//                        continue;
//                        continue Game;
                    } else {
                        count++;
                        System.out.printf("정답. %d번 만에 맞추셨습니다.\n", count);
                        break Game;
                    }
                }
            }
            System.out.print("다시 하시겠습니까? [Y/N]: ");
            input = scanner.next().charAt(0);
//            input = scanner.next();
            if (input == 'Y' || input == ('y')) {
//            if (input.equals("Y") || input.equals("y")) {
                count = 0;
//                continue;
//                continue Entire;
            } else {
                break Entire;
            }
        }
    }
}

/*
[문제] 숫자 맞추기 게임
- 컴퓨터가 1 ~ 100사이의 난수를 발생하면, 발생한 난수를 맞추는 게임
- 몇 번만에 맟주었는지 출력한다.

[실행결과]
1 ~ 100사이의 숫자를 맞추세요 (70)

숫자 입력 : 50
50보다 큰 숫자입니다.

숫자 입력 : 85
85보다 작은 숫자입니다.

~~~

숫자 입력 : 70
딩동뎅...x번만에 맞추셨습니다
 */