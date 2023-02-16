package Score;

public class ScoreDTO { // implements Comparable<ScoreDTO> {
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
        return number + "\t\t" + name + "\t\t" +
                kor + "\t\t" + eng + "\t\t" + math + "\t\t" +
                total + "\t\t" + String.format("%.2f", avg);
    }

//    @Override
//    public int compareTo(ScoreDTO scoreDTO) {
//        // total을 기준으로 내림차순 정렬
//        if (this.total > scoreDTO.total) {
//            return -1;
//        } else if (this.total < scoreDTO.total) {
//            return 1;
//        } else {
//            return 0;
//        }
//    }
}
