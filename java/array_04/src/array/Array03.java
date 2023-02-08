package array;

import java.util.Scanner;

public class Array03 {
    public static void main(String[] args) {

        while (true) {
            int sum = 0;

            Scanner scanner = new Scanner(System.in);
            System.out.print("배열 사이즈 입력: ");
            int size = scanner.nextInt();
            int[] arr = new int[size];
            System.out.println("---------------------");

            for (int i = 0; i < arr.length; i++) {
                System.out.printf("arr[%d] = ", i);
                arr[i] = scanner.nextInt();
            }
            System.out.println("--------------------");

            System.out.print("[ ");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
                sum += arr[i];
            }
            System.out.println("]");

            int max = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if(arr[i] > max) {
                    max = arr[i];
                }
            }

            int min = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if(arr[i] < min) {
                    min = arr[i];
                }
            }
            System.out.println("---------------------");
            System.out.printf("최소값 = %d\n", min);
            System.out.println("---------------------");
            System.out.printf("최대값 = %d\n", max);
            System.out.println("---------------------");
            System.out.printf("합 = %d\n", sum);
            System.out.println("---------------------");
        }
    }
}