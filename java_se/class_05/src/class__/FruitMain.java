package class__;

public class FruitMain {
    public static void main(String[] args) {
        Fruit[] fruits = {
                new Fruit("사과", 100, 80, 75),
                new Fruit("포도", 30, 25, 10),
                new Fruit("딸기", 25, 30, 90)
        };
//        fruits[0] = new Fruit("사과", 100, 80, 75);
//        fruits[1] = new Fruit("포도", 30, 25, 10);
//        fruits[2] = new Fruit("딸기", 25, 30, 90);

        System.out.println("=================================");
        System.out.print("CATEGORY\t" + "JAN\t" + "FEB\t" + "MAR\t\t" + "TOTAL\n");
        System.out.println("---------------------------------");
        for (Fruit data : fruits) {
            data.calc();
            data.display();
        }
//        for (int i =0; i < fruits.length; i++) {
//            fruits[i].calc();
//            fruits[i].display();
//        }
        System.out.println("---------------------------------");
        Fruit.output();
    }
}

/*
과일 판매량 구하기
월별 매출합계도 구하시오
(객체 배열 사용)

클래스 : Fruit

필드: category, jan, feb, mar, total
      sumJan, sumFeb, sumMar

메소드: 생성자(카테고리, 1월, 2월, 3월) -> Scanner X
        calcTotal()
        display()
        public static void output()

클래스 : FruitMain

[실행결과]
---------------------------------
PUM      JAN   FEB   MAR     TOT
---------------------------------
사과     100    80    75     255
포도      30    25    10      65
딸기      25    30    90     145
---------------------------------
        xxx   xxx   xxx            output()로 처리
 */