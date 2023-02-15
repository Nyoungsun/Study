package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionMain {
    @SuppressWarnings("all") // 강압적으로 waring 억제
    public static void main(String[] args) {
        // Collection은 interface이므로 Collection의 모든 메소드는 추상메소드임

        Collection collection = new ArrayList(); // 대신 오버라이드: ArrayList 클래스에서 Collection 인터페이스의 추상메소드를 오버라이드함
        collection.add("호랑이");
        collection.add("호랑이"); // 중복 허용
        collection.add(1);
        collection.add(2.4);


        Iterator iterator = collection.iterator(); // 메소드 이용
        System.out.println(iterator.hasNext()); // 항목있으면 true, 없으면 false

        System.out.println();
        while (iterator.hasNext()) {
//        collection.get(); -> Collection 인터페이스에는 get메소드가 없음
            System.out.println(iterator.next()); // 항목을 꺼내고 다음 항목으로 이동, for문을 사용할 수 없으므로 while 사용
        }
    }
}