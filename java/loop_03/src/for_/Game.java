package for_;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        int coin, balance, com;
        char enter;
        String result;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Insert coin(최소 300원):  ");
        coin = scanner.nextInt();

        for (balance = coin; balance > 300; ) {
            System.out.print("가위(1), 바위(2), 보자기(3) 중 번호 입력: ");
            int user = scanner.nextInt();
            if (user > 3 || user < 1) {
                System.out.println("1 ~ 3 사이의 숫자만 입력하세요");
                continue;
            } else {
                com = (int) ((Math.random() * 3) + 1);
                System.out.printf("computer: %s, user: %s\n",
                        (com == 1 ? "가위" : com == 2 ? "바위" : "보자기"),
                        (user == 1 ? "가위" : user == 2 ? "바위" : "보자기"));
                if (com == 1) {
                    if (user == 1) {
                        result = "Draw";
                    } else if (user == 2) {
                        result = "You win";
                    } else {
                        result = "You lose";
                    }
                    System.out.println(result);
                }
                if (com == 2) {
                    if (user == 1) {
                        result = "You lose";
                    } else if (user == 2) {
                        result = "Draw";
                    } else {
                        result = "You win";
                    }
                    System.out.println(result);
                }
                if (com == 3) {
                    if (user == 1) {
                        result = "You win";
                    } else if (user == 2) {
                        result = "You lose";
                    } else {
                        result = "Draw";
                    }
                    System.out.println(result);
                }

            }
            balance -= 300;
        }
    }
}


/*
[문제] 가위, 바위, 보 게임
- 가위(1), 바위(2), 보자기(3) 지정한다.
- 컴퓨터(com)는 1 ~ 3까지 난수로 나온다
- 1게임당 300원으로 한다.
[실행결과]
insert coin : 1000
가위(1), 바위(2), 보(3) 중 번호 입력 : 3 (user, 사용자)
컴퓨터 : 바위   나 : 보자기
You Win!!
가위(1),바위(2),보(3) 중 번호 입력 : 1 (user)
컴퓨터 : 가위   나 : 가위
You Draw!!
가위(1),바위(2),보(3) 중 번호 입력 : 3 (user)
컴퓨터 : 가위   나 : 보자기
You Lose!!
 */