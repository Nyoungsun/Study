package collection;

import java.util.HashMap;
import java.util.Map;

public class MapMain {
    public static void main(String[] args) {
        // Map: Collection의 일종
        // Map<key, value>
        Map<String, String> map = new HashMap<>();
        map.put("book01", "백설공주");
        map.put("book02", "백설공주"); // value 중복 허용
        map.put("book03", "인어공주");
        map.put("book01", "엄지공주"); // key 중복 허용

        System.out.println(map.get("book01"));
        System.out.println(map.get("book02"));
        System.out.println(map.get("book05")); // null
    }
}
