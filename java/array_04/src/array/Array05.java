package array;

public class Array05 {
    public static void main(String[] args) {

        char[] word = new char[50];
        int[] count = new int[26]; // count array의 인덱스 0 ~ 25 = A ~ Z로 생각

        for (int i = 0; i < 50; i++) {
            word[i] = (char) ((Math.random() * ('Z' - 'A' + 1)) + 'A');

            System.out.printf("%c ", word[i]);

            if ((i+1) % 10 == 0) {
                System.out.println();
            }
        }

        for (int j = 0; j < word.length; j++) {        // A = 65, Z = 90, word.length = 50, i = 0 ~ 49
//            System.out.println(word[j]);
            count[word[j] - 'A']++;                    // word 배열의 각 위치의 문자의 아스키값에서 65(A)를
        }                                              //뺀 값(0 ~ 25 = A ~ Z)을 인덱스로 설정하여 해당 인덱스의 값들을 ++
//            System.out.println(count.length);

        for (int k =0; k < count.length; k++){       // count.length = 26, k = 0 ~ 25
            System.out.printf("[%c: %d]\t", (char)k + 'A', count[k]); // (char)k + 65 = A ~ Z
        }
    }
}


/*
[문제] 배열 크기가 50개인 문자배열을 잡아서 65~90사이의 난수를 발생하여 저장 후 출력하시오
- 1줄에 10개씩 출력
- A의 개수? B의 개수? C의 개수? ~~~ Z의 개수 ?

[실행결과]
D F A G H I J K L T
O P W E R F V A S B
P Y R O L E E Z L I
F E U Z T U P P P A
S P G B F F O W J C

A : 2
B : 3
...
X : 0
Y : 1
Z : 0
 */
