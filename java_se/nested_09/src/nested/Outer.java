package nested;

public class Outer {
    private String name;

    public void output() {
        Inner inner = new Inner();
        System.out.printf("이름: %s, 나이: %d", this.name, inner.age);  // 중첩되어있기 때문에 직접 접근 가능, this 키워드 생략 가능
    }

    class Inner { // Outer$Inner.closs
        private int age;

        public void disp() {
            System.out.printf("이름: %s, 나이: %d", Outer.this.name, this.age);  // 중첩되어있기 때문에 직접 접근 가능, Outer.this, this 키워드 생략 가능
        }
    }

    public static void main(String[] args) {
        Outer outer = new Outer(); // Inner 안만듦
        outer.name = "홍길동";
        System.out.printf("이름: %s", outer.name);
        System.out.println();

        Outer.Inner inner = outer.new Inner(); // Inner 는 Outer 안에 있기 때문
        inner.age = 25;
        inner.disp();
        System.out.println();

        Outer.Inner inner2 = outer.new Inner(); // Inner 는 Outer 안에 있기 때문
        inner2.age = 30;
        inner2.disp();
        System.out.println();

        Outer.Inner inner3 = new Outer().new Inner(); // Inner 는 Outer 안에 있기 때문
//        inner3.name = "코난"; -> error
        inner3.age = 25;
        inner3.disp();
        System.out.println();
    }
} // Outer