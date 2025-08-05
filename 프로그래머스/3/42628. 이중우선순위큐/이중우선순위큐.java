import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        PriorityQueue<Integer> maxq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minq = new PriorityQueue<>();
        
        for (String o : operations) {
            String[] oper = o.split(" ");
            
            if (oper[0].equals("I")) {
                maxq.add(Integer.parseInt(oper[1]));
                minq.add(Integer.parseInt(oper[1]));
                
            } else if (oper[0].equals("D") && oper[1].equals("1")) {
                minq.remove(maxq.peek());
                maxq.poll();
            } else {
                maxq.remove(minq.peek());
                minq.poll();
            }
         
        }
        if (!maxq.isEmpty()) {
            return new int[]{maxq.peek(), minq.peek()};
        } else {
            return new int[]{0, 0};
        }
    }
}