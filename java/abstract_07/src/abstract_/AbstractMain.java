package abstract_;

public abstract class AbstractMain extends AbstractTest {
    public static void main(String[] args) {
        AbstractTest abstractTest = new AbstractTest() {
            @Override
            public void SetName(String name) {
                this.name = name;
            }
        };
        abstractTest.SetName("홍길동");
        System.out.println(abstractTest.getName());
    }
}
