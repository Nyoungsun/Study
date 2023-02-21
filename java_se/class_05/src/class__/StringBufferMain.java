package class__;

import java.util.Scanner;

public class StringBufferMain {
    private int dan;

    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("원하는 단 입력 : ");
        dan = scanner.nextInt();
    }

    public void output() {
        StringBuffer stringBuffer = new StringBuffer();
//		StringBuffer stringbuffer = " " // X

        for (int i = 1; i < 10; i++) {
            stringBuffer.append(dan); //append 메소드: 붙이기(이어쓰기)
            stringBuffer.append("*");
            stringBuffer.append(i);
            stringBuffer.append("=");
            stringBuffer.append(dan * i);
            System.out.println(stringBuffer.toString()); //StringBuffer -> String 변환
            stringBuffer.delete(0, stringBuffer.length()); //delete 메소드: (시작 index, 끝 index)
        }
    }

    public static void main(String[] args) {
        StringBufferMain stringBufferMain = new StringBufferMain();

        while (true) {
            stringBufferMain.input();
            stringBufferMain.output();
        }
    }
}
/*
[문제] 구구단
원하는 단을 입력 : 5      input()
------------------------------------
5*1=5               output()
5*2=10
5*3=15
5*4=20
5*5=25
5*6=30
5*7=35
5*8=40
5*9=45
*/