package collection;

import java.util.ArrayList;
import java.util.Objects;

public class CollectionMain2 {
    public static void main(String[] args) {
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add("호랑이");
        arrayList.add("사자");
        arrayList.add("호랑이"); // 중복 허용
        arrayList.add(1);
        arrayList.add(2.3);

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
        System.out.println();

        for (Object data : arrayList) {
            System.out.println(data);
        }
    }
}
