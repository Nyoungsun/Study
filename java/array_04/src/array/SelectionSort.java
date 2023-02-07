package array;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {25, 40, 32, 78, 56};

        // sort 전
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // ascending sort
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) { // +1을 하는 이유: 자신과 비교할 필요 X
                if (arr[i] > arr[j]) { // >: 오름차순, <: 내림차순
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}


