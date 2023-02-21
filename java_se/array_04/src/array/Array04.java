package array;

import java.util.Scanner;

public class Array04 {
    public static void main(String[] args) {
        int location;
        boolean[] parking = new boolean[5];
        Scanner scanner = new Scanner(System.in);

        entire:
        while (true) {
            System.out.println("******************");
            System.out.println("\t1. 입차");
            System.out.println("\t2. 출차");
            System.out.println("\t3. 리스트");
            System.out.println("\t4. 종료");
            System.out.println("******************");
            System.out.print("메뉴 입력: ");
            int menu = scanner.nextInt();

            menu:
            while (true) {
                if (menu == 1) {
                    System.out.print("1, 2, 3, 4, 5 중 위치 입력: ");
                    System.out.println("\n******************");
                    location = scanner.nextInt();

                    if (parking[location - 1]) {
                        System.out.println("이미 주차되어있습니다. 다른 자리를 입력하세요.");
                    } else {
                        parking[location - 1] = true;
                        System.out.println(location + "번 째 위치에 입차");
                        break menu;
                    }
                } else if (menu == 2) {
                    System.out.print("1, 2, 3, 4, 5 중 위치 입력: ");
                    location = scanner.nextInt();

                    if (parking[location - 1]) {
                        System.out.println("출차되었습니다.");
                        parking[location - 1] = false;
                        break;
                    } else {
                        System.out.println("주차되어 있지 않습니다. 다른 자리를 입력하세요");
                    }
                } else if (menu == 3) {
                    for (int i = 0; i < parking.length; i++) {
                        System.out.print(parking[i] + " ");
                    }
                    System.out.println();
                    break menu;
                } else
                    break entire;
            }
        }
    }
}