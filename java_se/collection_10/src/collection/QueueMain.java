package collection;

import java.util.LinkedList;

public class QueueMain {
    public static void main(String[] args) {
        String[] item = {"소나타", "렉스턴", "재규어"};
        LinkedList<String> queue = new LinkedList<>();

        for (String data : item) {
            queue.offer(data);
        }

        System.out.println("queue의 크기: " + queue.size() + "\n");

        String str;
        while ((str = queue.poll()) != null) { // 요소 추출, 추출할 것이 없으면 null 반환
            System.out.println(str + " 삭제");
            System.out.println("queue의 크기: " + queue.size() + "\n");
        }
    }
}

