package constructor;

public class ConstructorMain {
    private int age;
    String name;

    public ConstructorMain() { // default 생성자
        System.out.println("default 생성자"); // default 생성자로 객체가 생성될 때 마다 출력됨
    }

    public ConstructorMain(String name) { // default 생성자
        this();
        System.out.println("name 생성자");
        this.name = name; // default 생성자로 객체가 생성될 때 마다 출력됨
    }

    public ConstructorMain(int age) { // 생성자 오버로드
        this("코난");   // 오버로드된 다른 생성자를 호출할 수 있음, 반드시 첫 째줄에
        System.out.println("age 생성자");
        this.age = age;
    }

    public static void main(String[] args) {
        ConstructorMain constructorMain = new ConstructorMain(); // 생성자는 사용자가 호출하는 것이 아니라 객체를 생성해야함
        System.out.println(constructorMain.age + ", " + constructorMain.name);

        ConstructorMain constructorMain2 = new ConstructorMain("홍길동");
        System.out.println(constructorMain2.name);

        ConstructorMain constructorMain3 = new ConstructorMain(30);
        System.out.println(constructorMain3.age);
    }
}
