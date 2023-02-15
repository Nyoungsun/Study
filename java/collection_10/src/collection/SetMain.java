package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetMain {
    public static void main(String[] args) {
        // Set 인터페이스의 메소드(추상 메소드)는 Collection 인터페이스의 메소드와 메소드가 동일함
        // Set과 Collection의 차이: 중복 불허, 순서 없음

        Set<Object> set = new HashSet<>(); // set은 인터페이스이므로 new로 선언 불가
        set.add("호랑이");
        set.add("사자");
        set.add("호랑이"); // 중복 X, 순서 X
        set.add(1);
        set.add(2.4);

        Iterator iterator = set.iterator(); // 메소드 이용
        System.out.println(iterator.hasNext()); // 항목있으면 true, 없으면 false

        System.out.println();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
