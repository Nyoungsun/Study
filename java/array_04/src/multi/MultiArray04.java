package multi;

import java.util.Scanner;

public class MultiArray04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] name = {"홍길동", "죠르디", "프로도"};
        int[][] score = {
                {90, 90, 100, 0},
                {100, 89, 75, 0},
                {75, 80, 48, 0}
        };
        float[] avg = new float[3];
        char[] grade = new char[3];

        for (int i = 0; i < score.length; i++) { // 총점
            for (int j = 0; j < score[i].length - 1; j++) {
                score[i][3] += score[i][j];
            }

            avg[i] = (float) score[i][3] / 3; // 평균

            if (avg[i] >= 90) {
                grade[i] = 'A';
            } else if (avg[i] >= 80) {
                grade[i] = 'B';
            } else if (avg[i] >= 70) {
                grade[i] = 'C';
            } else if (avg[i] >= 60) {
                grade[i] = 'D';
            } else {
                grade[i] = 'F';
            }
        }

        System.out.println("----------------------------------------------------");
        System.out.printf("이름\t\t국어\t\t영어\t\t수학\t\t총점\t\t평균\t\t학점\n");
        System.out.println("----------------------------------------------------");
        for (int i = 0; i < name.length; i++) {
            System.out.printf("%s\t%d\t\t%d\t\t%d\t\t%d\t\t%s\t %c", name[i], score[i][0], score[i][1], score[i][2], score[i][3], String.format("%.1f", avg[i]), grade[i]);
            System.out.println();
        }
        System.out.println("---------------------------------------------------");

    }
}



/*
----------------------------------------------------
이름      국어      영어      수학      총점      평균      학점
----------------------------------------------------
홍길동   90      95      100
프로도   100      89      75
죠르디   75      80      48
----------------------------------------------------
 */
