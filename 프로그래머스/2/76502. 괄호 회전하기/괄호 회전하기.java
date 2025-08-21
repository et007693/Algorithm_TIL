import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Queue<String> q = new LinkedList<>();
        int idx = 0;
        for (String c: s.split("")) {
            q.add(c);
        }
        
        for (int i=0; i<s.length(); i++) {
            Stack<String> stack = new Stack<>();
            for (String c: q) {
                if (!stack.isEmpty() &&
                    ((stack.peek().equals("{") && c.equals("}")) ||
                     (stack.peek().equals("[") && c.equals("]")) ||
                     (stack.peek().equals("(") && c.equals(")")))) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
            if (stack.isEmpty()) {
                answer++;  
            } 
            q.add(q.poll());
        }
        return answer;
    }
}