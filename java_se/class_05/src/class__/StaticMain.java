package class__;

class StaticTest {
    private int a;
    private static int b; // static은 메모리에 한번만 생성됨, 모든 객체가 공유할 수 있음

    static { // 객체를 생성할 때 자동으로 호출됨
        System.out.println("static 초기화 영역");
        b = 5; //StaticTest.b = 5;
    }

    public StaticTest() {
        System.out.println("기본 생성자");
        a = 5; //this.a = 5;
    }

    public void calc() {
        a++;
        b++;
    }

    public void disp() {
        System.out.println("a=" + a + ", " + "b=" + b);
    }

    public static void output() {
        System.out.println("Static Method");
        System.out.println("b = " + b); // static method 안에서는 static 변수만 사용 가능
    }
}

public class StaticMain {
    private int a; //field, instance 변수
    private static int b; //field, class 변수

    public static void main(String[] args) {
        StaticMain staticMain = new StaticMain();
        System.out.println(staticMain.a);
        System.out.println(StaticMain.b);

        StaticTest staticTest = new StaticTest();
        staticTest.calc();
        staticTest.disp();
        System.out.println();

        StaticTest staticTest2 = new StaticTest();
        staticTest2.calc();
        staticTest2.disp();
        System.out.println();

        StaticTest staticTest3 = new StaticTest();
        staticTest3.calc();
        staticTest3.disp();
        System.out.println();

        StaticTest.output();
        staticTest3.output();
    }
}
