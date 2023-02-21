package inheritance;

enum Color { // enum: 상수 집합체
    RED, GREEN, BLUE // 변수명 앞엔 public static final이 생략되어있는것
}

class Final {
    public final String FRUIT = "사과";
    public final String FRUIT2;
    public static final String ANIMAL = "기린"; // static 변수는 생성자에서 초기화 X
    public static final String ANIMAL2;
    public static final int RED = 0;
    public static final int GREEN = 1;
    public static final int BLUE = 2;


    static {
        System.out.println("static 초기화 영역");
        ANIMAL2 = "사자";
    }

    Final() { // 생성자 (기본)
        FRUIT2 = "딸기";
    }
}

public class FinalMain {
    public static void main(String[] args) {
        final int A = 10;
//        A = 20; // final을 선언한 변수는 값을 변경할 수 없음
        System.out.printf("A = %d\n", A);

        final int B;
        B = 30;
//        B = 40; // error
        System.out.printf("B = %d\n", B);

        Final final_ = new Final();
        System.out.printf("FRUIIT = %s\n", final_.FRUIT); // 또는 FRUIT를 static으로 선언하여 객체 생성없이 접근 가능
        System.out.printf("FRUIIT2 = %s\n", final_.FRUIT2);
        System.out.printf("ANIMAL = %s\n", Final.ANIMAL); // static을 선언한 변수이므로 객체 생성없이 접근 가능
        System.out.printf("ANIMAL2 = %s\n", Final.ANIMAL2);
        System.out.printf("RED = %s\n", Color.RED);
        System.out.printf("RED = %s\n", Color.RED.ordinal());
        System.out.printf("RED = %s\n", Final.RED);

        for (Color data : Color.values()) {
            System.out.print(data);
            System.out.println(" " + data.ordinal());
        }
    }
}
