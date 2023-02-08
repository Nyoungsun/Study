package class_;

public class ScoreMain2 {
    public static void main(String[] args) {
//        Score a = new Score(); // 1 : 1
//        Score b = new Score();
//        Score c = new Score(); // 객체

        Score[] score = new Score[3];            // 배열 생성
//        System.out.println(scores[0]);         // null
        for (int i = 0; i < score.length; i++) {
            score[i] = new Score();
//            System.out.println(scores[i]);     // 객체 생성, 주소값
        }
        score[0].setData("홍길동", 90, 100, 100);
        score[1].setData("프로도", 70, 10, 50);
        score[2].setData("죠르디", 80, 90, 30);

        System.out.print("이름\t\t국어\t\t영어\t\t수학\t\t총점\t\t평균\t\t학점\n");
        System.out.println("----------------------------------------------------");

        for (int i = 0; i < score.length; i++) {
            System.out.printf("%s\t%d\t\t%d\t\t%d\t\t%d\t\t%s\t%c\n",
                    score[i].getName(),
                    score[i].getKor(),
                    score[i].getEng(),
                    score[i].getMath(),
                    score[i].getTotal(),
                    score[i].getAvg(),
                    score[i].getGrade());
        }
    }
}
