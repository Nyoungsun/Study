package class_;

public class ScoreMain {
    public static void main(String[] args) {

        Score score = new Score();
        score.setData("홍길동", 90, 100, 100);
        System.out.println("----------------------------------------------------");
        System.out.print("이름\t\t국어\t\t영어\t\t수학\t\t총점\t\t평균\t\t학점\n");
        System.out.printf("%s\t%d\t\t%d\t\t%d\t\t%d\t\t%s\t%c\n",
                score.getName(),
                score.getKor(),
                score.getEng(),
                score.getMath(),
                score.getTotal(),
                score.getAvg(),
                score.getGrade());

        Score score2 = new Score();
        score2.setData("프로도", 80, 20, 30);
        System.out.printf("%s\t%d\t\t%d\t\t%d\t\t%d\t\t%s\t%c\n",
                score2.getName(),
                score2.getKor(),
                score2.getEng(),
                score2.getMath(),
                score2.getTotal(),
                score2.getAvg(),
                score2.getGrade());

        Score score3 = new Score();
        score3.setData("죠르디", 90, 70, 60);
        System.out.printf("%s\t%d\t\t%d\t\t%d\t\t%d\t\t%s\t%c\n",
                score3.getName(),
                score3.getKor(),
                score3.getEng(),
                score3.getMath(),
                score3.getTotal(),
                score3.getAvg(),
                score3.getGrade());
        System.out.println("----------------------------------------------------");
    }
}
