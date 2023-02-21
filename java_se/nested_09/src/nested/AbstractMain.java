package nested;

public class AbstractMain {
    public static void main(String[] args) {
        AbstractTest abstractTest = new AbstractTest() { // 익명 내부 클래스
            @Override
            public void setName(String name) {
                this.name = name;
            }
        };
        InterA interA = new InterA() { // 인터페이스를 생성한 것이 아니라 익명 내부 클래스를 생성한 것
            @Override
            public void method1() {

            }

            @Override
            public void method2() {

            }
        };

        AbstractExam abstractExam = new AbstractExam() { // 원하는 메소드 오버라이드, 하지 않아도 됨
        };
    }
} // 익명 내부 클래스가 3개 있으므로 클래스 파일명이 AbstractMain&1.class, AbstractMain&2.class, AbstractMain&3.class가 생성됨
