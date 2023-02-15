package collection;

class GenericTest<T> { //컴파일 시 타입 결정
    private T a;

    public void setA(T a) {
        this.a = a;
    }

    public T getA() {
        return a;
    }
}


public class GenericMain {
    public static void main(String[] args) {
        GenericTest<String> genericTest = new GenericTest<>(); // Generic은 반드시 클래스 객체형으로
        genericTest.setA("하하");

        GenericTest<Integer> genericTest2 = new GenericTest<>(); // <int>: 불가
        genericTest2.setA(6);

        System.out.println(genericTest.getA() + "," + genericTest2.getA());

    }
}