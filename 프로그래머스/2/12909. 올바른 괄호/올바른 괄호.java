import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char i : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == '(' && i == ')') {
                stack.pop();
            } else {
                stack.push(i);
            }
        }
        return stack.isEmpty();
    }
}