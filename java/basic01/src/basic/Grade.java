package basic;

public class Grade {
    public static void main(String[] args) {

        char name = 'L';

        int kor = 85, eng = 78, math = 100, total = kor + eng + math;

        float avg = (float) total/3;

        System.out.println("\t\t\t*** "+name+"성적표 ***");
        System.out.println("국어\t\t영어\t\t수학\t\t총점\t\t평균");
        System.out.print(kor+"\t\t"+eng+"\t\t"+math+"\t\t"+total+"\t\t"+String.format("%.2f", avg));
    }
}
