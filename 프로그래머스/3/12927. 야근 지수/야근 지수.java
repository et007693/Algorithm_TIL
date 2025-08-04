import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int w : works) {
            heap.offer(w);
        }
        
        while (n > 0) {
            int max = heap.remove();
            if (max > 0) {
                heap.add(max - 1);   
            } else {
                return 0;
            }
            n -= 1;
        }

        for (int w: heap) {
            answer += Math.pow(w, 2);
        }
        return answer;
    }
}