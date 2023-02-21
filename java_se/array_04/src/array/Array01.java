package array;

public class Array01 {
    public static void main(String[] args) {
        int[] ar;
        ar = new int[5];
//        System.out.println("ar =" + ar); // 주소
        ar[0] = 1;
        ar[1] = 2;
        ar[2] = 3;
        ar[3] = 4;
        ar[4] = 5;

        for (int i = 0; i <= 4; i++) {
            System.out.printf("ar[%d] = %d\n", i, ar[i]);
        }
        System.out.printf("ar 크기 = %d\n\n", ar.length);

        int[] ar2 = {25, 37, 55, 42, 30, 60};

        for (int i = 0; i < 5; i++) {
            System.out.printf("ar2[%d] = %d\n", i, ar2[i]);
        }
        System.out.printf("ar2 크기 = %d\n\n", ar2.length);

        System.out.println("[ar 거꾸로 출력]");
        for (int i = ar.length - 1; i >= 0; i--) {
            System.out.printf("ar[%d] = %d\n", i, ar[i]);
        }
        System.out.println();

        System.out.println("[ar2 홀수 데이터만 출력]");
        for (int i = 0; i < ar2.length; i++) {
            if (ar2[i] % 2 == 1) {
                System.out.printf("ar2[%d] = %d\n", i, ar2[i]);
            }
        }
        System.out.println("\n확장 for");
        for(int data : ar) { // ar 크기만큼 반복
            System.out.println(data);
        }
    }
}