package class_;

class This {
    private int b; // b = 필드
    private static int c; // static이지만 private이므로 getter, setter 필요
    static int d; // public이면 클래스명으로 접근가능

    public void setB(int b) { // b = argument / parameter
        System.out.println("this = " + this); //객체를 생성할 때 마다 새로운 주소를 참조
        this.b = b;
    }

    public void setC(int c) { // b = argument / parameter
        this.c = c;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }
}

public class ThisMain {
    private int a;

    public static void main(String[] args) { // static에는 this X
//        a = 10; // error
//       모든 클래스는 반드시 생성해야 한다. → New

        ThisMain thisMain = new ThisMain();
        thisMain.a = 10; // 같은 class내에 있으므로 접근 가능
        System.out.println(thisMain.a);

        This this_ = new This();
        System.out.println("객체 this_: " + this_); // class_.This@1a407d53
        this_.setB(20); // 호출한 메소드는 반드시 돌아온다.
        System.out.println(this_.getB());
        this_.setC(30);
        System.out.println(this_.getC());

        This.d = 40; // static에는 this X
        System.out.println(This.d);

        This this__ = new This();
        System.out.println("객체 this__: " + this__); // class_.This@3d8c7aca
        this__.setB(50);
        this__.setC(60);
        System.out.println(this__.getB());
        System.out.println(this__.getC());
    }
}

