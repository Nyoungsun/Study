package multi;

import java.util.Scanner;

public class MultiArray05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("학생 수 입력: ");
        int cnt = scanner.nextInt();

        String[] name = new String[cnt]; //학생 수 만큼
        String[][] subject = new String[cnt][]; //학생 별 과목, 열은 가변적
        int[][] score = new int[cnt][]; //학생 별 점수, 열은 가변적

        for (int i = 0; i < cnt; i++) {
            System.out.print("이름입력: ");
            name[i] = scanner.next();

            System.out.print("과목수 입력: ");
            int subjectCnt = scanner.nextInt();
            subject[i] = new String[subjectCnt]; // 각 행에 과목 수 만큼 열 생성
            score[i] = new int[subjectCnt]; // 각 행에 과목 수 만큼 열 생성

            for (int j = 0; j < subjectCnt; j++) {
                System.out.print("과목명 입력: ");
                subject[i][j] = scanner.next();
            }

            for (int j = 0; j < subjectCnt; j++) {
                System.out.printf("%s 점수 입력: ", subject[i][j]);
                score[i][j] = scanner.nextInt();
            }
            System.out.println("-------------------------");
        }

        System.out.printf("인원수: %d\n\n", cnt);
        for (int i = 0; i < cnt; i++) {
            int total = 0;
            double avg;
            System.out.print("이름\t\t");
            for (int j = 0; j < subject[i].length; j++) {
                System.out.print(subject[i][j] + "\t\t");
            }
            System.out.println("총점\t\t평균");
            System.out.print(name[i] + "\t");

            for (int j = 0; j < score[i].length; j++) {
                System.out.print(score[i][j] + "\t\t");
                total += score[i][j];
            }
            avg = (double) total / subject[i].length;
            System.out.printf("%d\t\t", total);
            System.out.println(String.format("%.2f", avg));
        }
    }
}


/*
인원수를 입력하여 인원수만큼 데이터를 입력받고 총점과 평균을 구하시오
평균은 소수이하 2째자리까지 출력

[실행결과]
인원수 : 2 (cnt)

이름입력 : 홍길동 (name)
과목수 입력 : 2   (subjectCnt)
과목명 입력 : 국어 (subject)
과목명 입력 : 영어
국어 점수 입력 : 95 (score)
영어 점수 입력 : 100
---------------------
이름입력 : 이기자
과목수 입력 : 3
과목명 입력 : 국어
과목명 입력 : 영어
과목명 입력 : 과학
국어 점수 입력 : 95
영어 점수 입력 : 100
과학 점수 입력 : 90
---------------------

이름     국어     영어   총점     평균
홍길동    95     100   xxx     xx.xx

이름      국어  영어   과학    총점      평균
이기자   95   100   90    xxx      xx.xx
 */