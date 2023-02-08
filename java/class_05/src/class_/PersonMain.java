package class_;

class Person {
    private String name; //필드, 초기화되어있음 = null
    private int age; // = 0

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setData(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setData() { // Method Overload
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class PersonMain {
    public static void main(String[] args) {
        // 생성
        Person person1 = new Person(); // 객체 (클래스형 변수)
        System.out.println("객체 person1 = " + person1);
        person1.setName("NYS");
        person1.setAge(20);
        System.out.printf("이름: %s, 나이: %d\n", person1.getName(), person1.getAge());

        Person person2 = new Person();
        System.out.println("객체 person2 = " + person2);
        person2.setName("홍길동");
        person2.setAge(30);
        System.out.printf("이름: %s, 나이: %d\n", person2.getName(), person2.getAge());

        Person person3 = new Person();
        System.out.println("객체 person3 = " + person3);
        person3.setData("둘리", 200);
        System.out.printf("이름: %s, 나이: %d\n", person3.getName(), person3.getAge());

        Person person4 = new Person();
        System.out.println("객체 person4 = " + person4);
        person3.setData();
        System.out.printf("이름: %s, 나이: %d\n", person4.getName(), person4.getAge());
    }
}