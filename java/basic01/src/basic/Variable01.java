package basic;

public class Variable01 {

    public static void main(String[] args) { //main
        System.out.println(Integer.MIN_VALUE + " " + Integer.MAX_VALUE); //sout
        System.out.println(Long.MIN_VALUE + " " + Long.MAX_VALUE);
        System.out.println();

        int a = 65; // 0100 0001
        System.out.println("a = "+ a);

        int b = 36;

        boolean c = a > b;
        System.out.println("c = " + c);

        char d = 'A'; // 65 = 0100 0001
        System.out.println("d = " + d);

        char e = 65;
        System.out.println("e = " + e);

        char f = 0x41;
        System.out.println("f = " + f);

        byte g = 0; // 1byte = 8bit: -128 ~ +127
        //byte g = 128; error
        System.out.println("g = " + g);

        int h = 'A';
        System.out.println("h = " + h);

        long i = 25L; //Long형
        System.out.println("i = " + i);

        float j = 43.8F; //Float형
        System.out.println("j= " + j);

        float j2 = (float)43.8; //Float형
        System.out.println("j= " + j2);

        double k = 43.8;
        System.out.println("k= " + k);
    }
}