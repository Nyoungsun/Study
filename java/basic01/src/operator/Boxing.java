package operator;

public class Boxing {

    public static void main(String[] args) {
        int a = 25;
        double b = (double) a /3;     // 캐스팅(강제형변환, 자동형변환)
        System.out.println(b);

        String c = "25";              // c = 객체형(String)
        int d = Integer.parseInt(c);  // d = 기본형(int)
        System.out.println(d);

        int e = 5;
//        Integer f = e;               // AutoBoxing(기본형 → 객체형)
        Integer f = new Integer(e);

        Integer g = 5;
//        int h = g;                     // Unboxing(객체형 → 기본형)
        int h = g.intValue();
    }
}
