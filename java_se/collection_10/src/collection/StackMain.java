package collection;

import java.util.Stack;

import static java.lang.System.out;

public class StackMain {
    public static void main(String[] args) {
        String[] groupA = {"우즈벡", "쿠웨이트", "사우디", "한국"};
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < groupA.length; i++) {
            stack.push(groupA[i]);
        } // for
        while (!stack.isEmpty()) { // 비어있으면 T, 내용이 있으면 F
            out.println(stack.pop());
        } //while
    }
}
