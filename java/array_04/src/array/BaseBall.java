package array;

import java.util.Scanner;

public class BaseBall {
    public static void main(String[] args) {

        int[] random = new int[3];
        int[] input = new int[3];
        String user;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("게임을 실행하시겠습니까? (Y/N): ");
            char start = scanner.next().charAt(0);

            if (start == 'y' || start == 'Y') {
                System.out.println("==== Game Start ====");
                // 난수 발생
                for (int i = 0; i < random.length; i++) {
                    random[i] = (int) ((Math.random() * 9) + 1);
                    // 중복 제거
                    for (int j = 0; j < i; j++) {
                        if (random[i] == random[j]) {
                            i--;
                            break;
                        }
                    } // for j
                } // for i

                // 난수 확인
                System.out.print("힌트: ");
                for (int x : random) {
                    System.out.print(x);
                }
                System.out.println();

                while (true) {
                    int strike = 0;
                    int ball = 0;

                    System.out.print("중복되지 않게 숫자 입력: ");
                    user = scanner.next();
                    for (int i = 0; i < input.length; i++) {
                        input[i] = user.charAt(i) - 48;
                    }
                    // 입력값 확인
                    for (int y : input) {
                        System.out.print(y);
                    }

                    System.out.println();
                    for (int i = 0; i < random.length; i++) {
                        for (int j = 0; j < input.length; j++) {
                            if (random[i] == input[j] && i == j) {
                                strike++;
                            } else if (random[i] == input[j] && i != j) {
                                ball++;
                            }
                        }
                    }
                    System.out.printf("%d 스트라이크, %d 볼\n", strike, ball);
                    if (strike == 3) {
                        System.out.println("게임이 끝났습니다.");
                        break;
                    }
                }
            } else if (start == 'n' || start == 'N') {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }
}



/*
[문제] 야구게임
크기가 3개인 정수형 배열을 잡고 1~9사이의 난수를 발생한다
발생한 숫자를 맞추는 게임
중복은 제거한다
숫자만 맞으면 볼
위치와 숫자가 맞으면 스트라이크

[실행결과]
게임을 실행하시겠습니까(Y/N) : w
게임을 실행하시겠습니까(Y/N) : u
게임을 실행하시겠습니까(Y/N) : y

게임을 시작합니다

숫자입력 : 123

0스트라이크 0볼

숫자입력 : 567
0스트라이크 2볼

숫자입력 : 758
1스트라이크 2볼
...

숫자입력 : 785
3스트라이크 0볼

프로그램을 종료합니다.
 */