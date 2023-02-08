package multi;

public class MultiArray01 {
    public static void main(String[] args) {
        int[][] arr = new int[3][2]; //고정길이
//        int[][] arr = new int[3][]; //가변길이
//        System.out.println(arr.length); //3
//        System.out.println(arr[0].length); //2
//        System.out.println(arr[1].length); //2
//        System.out.println(arr[2].length); //2

//        arr[0][0] = 10;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int) ((Math.random() * 10) + 1);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("\tarr[%d][%d]: %d\t", i, j, arr[i][j]);
                if ((j + 1) % 2 == 0) {
                    System.out.println();
                }
            }
        }
    }
}