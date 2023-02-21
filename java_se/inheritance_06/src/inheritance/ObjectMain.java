package inheritance;

class Test extends Object {
}

class Sample {
    @Override
    public String toString() {
        return getClass() + "@안알려쥼";
//        return "안알려줌";
    }
    @Override
    public int hashCode() {
        return 123;
    }
}

class Exam {
    private String name = "홍길동";
    private int age = 12;

    @Override
    public String toString() {
        return name + '\t' + age;
    }
}

public class ObjectMain {
    public static void main(String[] args) {
        Test test = new Test();
        System.out.println("객체 test: " + test);
        System.out.println("객체 test: " + test.toString());
        System.out.println("객체 test: " + test.hashCode());
        System.out.println();

        Sample sample = new Sample();
        System.out.println("객체 sample: " + sample);
        System.out.println("객체 sample: " + sample.hashCode());
        System.out.println();

        Exam exam = new Exam();
        System.out.println("객체 Exam: " + exam);
        System.out.println();

        String aa = "apple";
        System.out.println("String 객체 aa: " + aa.hashCode());
        System.out.println("String 객체 aa: " + aa.toString());
        System.out.println("String 객체 aa: " + aa);
        System.out.println();

        Object ff = new String("apple");
        Object gg = new String("apple");


        System.out.println(ff == gg);
        System.out.println(ff.equals(gg));
    }
}

/*
class Object {
   public String toString() {}          클래스명@16진수
   public int hashCode() {}             10진수
   public boolean equals(Object ob){}   참조값 비교
}

class String
   public String toString() {}          문자열
   public int hashCode() {}             10진수 (믿으면 안된다) - 문자열은 무한대이므로 10진수로 표기 불가
   public boolean equals(Object ob){}   문자열 비교
}
 */