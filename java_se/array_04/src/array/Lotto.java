package array;

import java.util.Scanner;

public class Lotto {
    public static void main(String[] args) {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("현금 입력(최소 1000): ");
            int coin = scanner.nextInt();

            if (coin >= 1000) {
                for (int i = 1; i <= coin / 1000; i++) {
                    int[] number = new int[6];
                    for (int j = 0; j < number.length; j++) {
                        number[j] = (int) ((Math.random() * 45) + 1);
                        for (int k = 0; k < j; k++) {
                            if (number[j] == number[k]) {
                                i--;
                                break;
                            }
                        }
                    }

                    for (int k = 0; k < number.length - 1; k++) {
                        for (int h = k + 1; h < number.length; h++) {
                            if (number[k] > number[h]) {
                                int tmp = number[k];
                                number[k] = number[h];
                                number[h] = tmp;
                            }
                        }
                    }

                    for (int lotto : number) {
                        System.out.print(lotto + "\t");
//                    System.out.print(String.format("%5d", lotto));
                    }
                    System.out.println();
                    if (i % 5 == 0){
                        System.out.println();
                    }
                }
                System.out.println("---------------------");

            } else {
                System.out.println("최소 1000원입니다.");
                System.out.println("---------------------");
            }
        }
    }
}

/*
[문제] 로또 - 자동
- 크기가 6개인 배열 생성
- 1 ~ 45 사이의 난수 발생
- 숫자는 오름차순하여 출력 (Selection Sort)
- 출력시 자리수는 5자리로 지정
- 중복 숫자가 나오면 안된다

[실행결과]
    2    4   19   39   43   44
 */