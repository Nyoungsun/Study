package class__;

import java.util.Scanner;

public class StringReplace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int index, count = 0;
        char input;

        while (true) {
            System.out.print("문자열 입력: ");
            String origin = scanner.next().toLowerCase();

            while (true) {
                System.out.print("찾을 문자열 입력: ");
                String source = scanner.next().toLowerCase();
                index = origin.indexOf(source); // fromindex를 생략할 경우 0번 째 부터 찾음
                if (index == -1) {
                    System.out.println("없는 문자열이므로 치환할 수 없습니다.");
                    continue;
                }

                System.out.print("바끌 문자열 입력: ");
                String target = scanner.next().toLowerCase();
                index = origin.indexOf(target);

                System.out.println(origin.replace(source, target));
                count++;
                System.out.printf("%d번 치환\n", count);
                break;
            } // while

            System.out.print("계속하시겠습니까? (Y/N): ");
            input = scanner.next().charAt(0);
            if (input == 'n' || input == 'N') {
                return; // System.exit(0);
            }
        }
    }
}

/*
치환하는 프로그램을 작성하시오 - indexOf(?, ?), replace()
String 클래스의 메소드를 이용하시오
대소문자 상관없이 개수를 계산하시오
[실행결과]
문자열 입력 : aabba
현재 문자열 입력 : aa
바꿀 문자열 입력 : dd
ddbba
1번 치환

문자열 입력 : aAbbA
현재 문자열 입력 : aa
바꿀 문자열 입력 : dd
ddbba
1번 치환

문자열 입력 : aabbaa
현재 문자열 입력 : aa
바꿀 문자열 입력 : dd
ddbbdd
2번 치환

문자열 입력 : AAccaabbaaaaatt
현재 문자열 입력 : aa
바꿀 문자열 입력 : dd
ddccddbbddddatt
4개 치환

문자열 입력 : aabb
현재 문자열 입력 : aaaaa
바꿀 문자열 입력 : ddddd
입력한 문자열의 크기가 작습니다
치환 할 수 없습니다
*/
