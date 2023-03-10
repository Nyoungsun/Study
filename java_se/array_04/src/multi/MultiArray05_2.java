package multi;

import java.util.Scanner;

public class MultiArray05_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("학생 수 입력: ");
        int cnt = scanner.nextInt();

        String[] name = new String[cnt]; //학생 수 만큼 열 생성
        String[][] subject = new String[cnt][]; //학생 별 과목, 열은 가변적
        int[][] score = new int[cnt][]; //학생 별 점수, 열은 가변적
        double[] avg = new double[cnt]; //학생 수 만큼 열 생성

        for (int i = 0; i < cnt; i++) { // 인원 수 만큼 반복
            System.out.print("이름입력: ");
            name[i] = scanner.next();

            System.out.print("과목수 입력: ");
            int subjectCnt = scanner.nextInt();
            subject[i] = new String[subjectCnt]; // 각 행에 과목 수 만큼 열 생성
            score[i] = new int[subjectCnt + 1]; // // 각 행에 과목 수 만큼 열 생성, 총점을 위한 +1

            for (int j = 0; j < subjectCnt; j++) {
                System.out.print("과목명 입력: ");
                subject[i][j] = scanner.next();
            }

            for (int j = 0; j < subjectCnt; j++) {
                System.out.printf("%s 점수 입력: ", subject[i][j]);
                score[i][j] = scanner.nextInt();
                score[i][subjectCnt] += score[i][j]; // 마지막 열에 총점 추가
            } // for j
            avg[i] = (double) score[i][subjectCnt] / subjectCnt; // 평균 = 마지막 열의 값을 과목수로 나눈다
            System.out.println("-------------------------");
        } // for i

        System.out.printf("인원수: %d\n\n", cnt);
        for (int i = 0; i < cnt; i++) { // 인원 수 만큼 반복
            System.out.print("이름\t\t");
            for (int j = 0; j < subject[i].length; j++) { //과목 수 만큼 반복
                System.out.print(subject[i][j] + "\t\t");
            } // for j
            System.out.println("총점\t\t평균");
            System.out.print(name[i] + "\t");

            for (int j = 0; j < score[i].length; j++) { //과목 수 + 총점 만큼 반복
                System.out.print(score[i][j] + "\t\t"); // 과목 별 성적과 총점까지
            } // for j
            System.out.println(String.format("%.2f", avg[i]));
        } // for i
    }
}
