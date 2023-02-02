package basic;

class Test {
    int a = 10;
    static int b = 20;
    String s;
    boolean bo;
}

public class Variable02 { // public class = main class → main method를 갖고있음
    int a; // global variable = java: field, 0으로 초기화 되어있음
    double b;
    char c;
    static int a2; // static: 실행하자마자 메모리에 할당됨

    public static void main(String[] args) {
        // int a; // local variable: garbage value → initialize 필요
        // System.out.println(a);

        int a = 5;
        System.out.println("지역변수 a = " + a);

        Variable02 v = new Variable02(); // 클래스 타입의 인스턴스(객체)를 생성
        System.out.println("객체 = " + v); // <classname>@<HEX>
        System.out.println("필드 a = " + v.a);
        System.out.println("필드 b = " + v.b);
        System.out.println("필드 c = " + v.c);
        System.out.println("스태틱 필드 a2 = " + a2); // v.a2

        Test t = new Test();
        System.out.println("Test 클래스의 a = " + t.a);
        System.out.println("Test 클래스의 b = " + t.b);
        System.out.println("Test 클래스의 s = " + t.s);
        System.out.println("Test 클래스의 bo = " + t.bo);

    }
}
