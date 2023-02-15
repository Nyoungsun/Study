package class__;

public class Fruit {
    private String category;
    private int jan, feb, mar;
    private static int total, sumJan, sumFeb, sumMar;

    public Fruit(String category, int jan, int feb, int mar) { // 생성자로 받은 데이터를 필드에 저장
        this.category = category;
        this.jan = jan;
        this.feb = feb;
        this.mar = mar;
    }

    public void calc() {
        total = jan + feb + mar;
        sumJan += jan;
        sumFeb += feb;
        sumMar += mar;
    }

    public static void output() {
        System.out.printf("%s\t\t\t%d\t%d\t%d\n", "SUM", sumJan, sumFeb, sumMar);
        System.out.println("=================================");
    }

    public void display() {
        System.out.printf("%s\t\t\t%d\t%d\t%d\t\t%d\n", category, jan, feb, mar, total);
    }
}
