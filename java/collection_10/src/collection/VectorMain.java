package collection;

import java.util.Iterator;
import java.util.Vector;

public class VectorMain {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        System.out.println("벡터 크기: " + vector.size()); // 0이라서 밑줄
        System.out.println("벡터 용량: " + vector.capacity());
        System.out.println();

        System.out.println("항목 추가");
        for (int i = 0; i < 10; i++) {
            vector.add(String.valueOf(i + 1)); // 또는 + ""
            System.out.print(vector.get(i) + " ");
        }
        System.out.println();
        System.out.println();
        System.out.println("벡터 크기: " + vector.size());
        System.out.println("벡터 용량: " + vector.capacity());
        System.out.println();

        System.out.println("항목 추가");
        vector.addElement(5 + "");
        for (int i = 0; i < vector.size(); i++) {
            System.out.print(vector.get(i) + " ");
        }
        System.out.println();
        System.out.println("벡터 크기: " + vector.size());
        System.out.println("벡터 용량: " + vector.capacity());
        System.out.println();

        System.out.println("마지막 항목 삭제");
        vector.remove(vector.size() - 1);
        Iterator<String> iterator = vector.iterator(); // Iterator는 인터페이스이므로 메소드 이용


        while (iterator.hasNext()) { // 항목이 있으면 T, 없으면 F
            String data = iterator.next(); // 항목을 꺼내옴 -> 버퍼에 임시저장, 다음 인덱스로 이동
            System.out.print(data + " ");
        }
        System.out.println();
        System.out.println("벡터 크기: " + vector.size());
        System.out.println("벡터 용량: " + vector.capacity());
    }
}
