package multi;

public class MultiArray02 {
    public static void main(String[] args) {
        int[][] arr = new int[10][10];

//        가로로 입력
//        int num = 1;
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                arr[i][j] = num++;
//            }
//        }

//        세로로 입력
//        int num = 1;
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                arr[j][i] = num++;
//            }
//        }

//        거꾸로 입력
        int num = 100;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = num--;
            }
        }


        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("\tarr[%d][%d]: %d\t", i, j, arr[i][j]);
                if ((j + 1) % 10 == 0) {
                    System.out.println();
                }
            }
        }
    }
}
