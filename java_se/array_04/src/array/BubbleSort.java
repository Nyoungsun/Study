package array;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {25, 40, 32, 78, 56};

        // sort 전
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // ascending sort
        for (int i = 0; i < arr.length - 1; i++) { // 총 라운드 = 배열 크기 - 1: 한 번의 반복이 완료될 때 마다 가장 큰 수는
                                                    // 배열의 마지막 부분으로 밀리는 것이 보장됨, 따라서 한 번의 라운드마다 가장 뒤의
                                                     // 인덱스는 비교 X
            for (int j = 0; j < arr.length - 1 - i; j++) { // 라운드 별 비교 횟수
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
