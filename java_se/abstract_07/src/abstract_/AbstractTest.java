package abstract_;

public abstract class AbstractTest { //추상 클래스 -> 추상 메소드를 가졌을 땐 반드시 추상 클래스여야 한다.
    protected String name;

    public AbstractTest() {

    }

    public AbstractTest(String name) {
        super();
        this.name = name;
    }

    public abstract void SetName(String name); //추상 메소드

    public String getName() {
        return name;
    }
}