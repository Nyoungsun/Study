package array;

import java.util.Scanner;

public class BaseBall {
    public static void main(String[] args) {

        int strike = 0;
        int ball = 0;
        int[] random = new int[3];
        int[] input = new int[3];
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("게임을 실행하시겠습니까? (Y/N): ");
            char start = scanner.next().charAt(0);

            if (start == 'y' || start == 'Y') {
                System.out.println("------------------------------");
                System.out.println("Game Start");
                System.out.println("------------------------------");
                for (int i = 0; i < random.length; i++) {
                    random[i] = (int) ((Math.random() * 9) + 1);
                    for (int j = 0; j < i; j++) {
                        if ((random[i] == random[j])) {
                            i--;
                            break; // Back 21 line
                        }
                    }
                }
//                for (int x : random) {
//                    System.out.print(x);
//                }
//                System.out.println();
                while (true) {
                    System.out.print("숫자 입력 (space bar 구분): ");
                    for (int i = 0; i < input.length; i++) {
                        input[i] = scanner.nextInt();
                        for (int j = 0; j < i; j++) {
                            if ((input[i] == input[j])) {
                                System.out.println("중복 값이 있습니다. 다시 입력하세요.");
                                i--;
                                break;
                            }
                        }
                    }
//                    for (int y : input) {
//                        System.out.println(y);
//                    }
//                System.out.println();
                    for (int i = 0; i < random.length; i++) {
                        for (int j = 0; j < input.length; j++) {
                            if (random[i] == input[j] && i == j) {
                                strike++;
                            } else if (random[i] == input[j] && i != j) {
                                ball++;
                            }
                        }
                    }
                    System.out.printf("%d스트라이크, %d볼\n", strike, ball);

                    if (strike == 3) {
                        break;
                    }
                }
                strike = 0;
                ball = 0;
            } else if (start == 'n' || start == 'N') {
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