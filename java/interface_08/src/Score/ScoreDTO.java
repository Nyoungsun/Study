package Score;

public class ScoreDTO {
    private int number, kor, eng, math, total;
    private String name;
    private double avg;

    public ScoreDTO(int number, String name, int kor, int eng, int math) {
        this.number = number;
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    public void calc() {
        total = kor + eng + math;
        avg = (double) total / 3;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public int getKor() {
        return kor;
    }

    public int getEng() {
        return eng;
    }

    public int getMath() {
        return math;
    }

    public int getTotal() {
        return total;
    }

    public double getAvg() {
        return avg;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public void setMath(int math) {
        this.math = math;
    }


    @Override
    public String toString() {
        return name + "\t" + kor + "\t" + eng + "\t" + math + "\t" + total + "\t" + String.format("%.2f", avg);
    }
}
