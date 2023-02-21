package class__;

public class StringMain {

    public static void main(String[] args) {
        String a = "apple";
        String b = "apple";
        if (a == b) { // 주소
            System.out.println("a와 b의 참조값은 같다.");
        } else {
            System.out.println("a와 b의 참조값은 다르다.");
        }

        if (a.equals(b)) { // 값
            System.out.println("a와 b의 문자열은 같다.");
        } else {
            System.out.println("a와 b의 문자열은 다르다.");
        }
        System.out.println();


        String c = new String("apple");
        String d = new String("apple");
        if (c == d) { //주소
            System.out.println("c와 d의 참조값은 같다.");
        } else {
            System.out.println("c와 d의 참조값은 다르다.");
        }

        if (c.equals(d)) {
            System.out.println("c와 d의 문자열은 같다.");
        } else {
            System.out.println("c와 d의 문자열은 다르다.");
        }
        System.out.println();


        String e = "오늘 날짜는 " + 2023 + 02 + 10;
        System.out.println(e); //오늘 날짜는 2023210
        String f = "오늘 날짜는 " + (2023 + 02 + 10);
        System.out.println(f); //오늘 날짜는 2035
        //문자열은 편집 X (한번 만들어진 문자열은 불변) -> 메모리에 4번의 생성이 일어난다 -> StringBuffer(편집가능)

        System.out.println("e 문자열 크기 = " + e.length()); // 14

        for (int i = 0; i < e.length(); i++) {
            System.out.println(i + " : " + e.charAt(i));
        }
        System.out.println("부분 문자열 추출: " + e.substring(7));
        System.out.println("부분 문자열 추출: " + e.substring(7, 11)); // 7부터 10까지

        System.out.println("대문자 변경: " + "Hello".toUpperCase());
        System.out.println("소문자 변경: " + "Hello".toLowerCase());

        System.out.println("문자열 검색(인덱스): " + e.indexOf("짜"));     //.indexOf("찾을 특정 문자" , 시작할 위치)
        System.out.println("문자열 검색(인덱스): " + e.indexOf("날짜"));   //생략할 경우 0번 째 부터 찾음
        System.out.println("문자열 검색(인덱스): " + e.indexOf("칼하트")); //찾지 못했을 경우: -1

        System.out.println("문자열 치환: " + e.replace("날짜", "일자"));


    }

}