package multi;

public class MultiArray04 {
    public static void main(String[] args) {
        int[][] arr = new int[3][];
        arr[0] = new int[2];
        arr[1] = new int[3];
        arr[2] = new int[4];

        int num = 10;
        for (int i = 0; i < arr.length; i++) {
            System.out.println("행 arr[" + i + "] = " + arr[i]);
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = 10;
                num += 10;

                System.out.printf("arr[%d][%d] = %d\n", i, j, arr[i][j]);
            }
            System.out.println();
        }
    }
}
