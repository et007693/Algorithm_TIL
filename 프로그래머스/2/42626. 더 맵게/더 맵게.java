import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int cnt = 0;
        
        for (int s : scoville) {
            heap.add(s);
        }
        
        while (heap.peek() < K && heap.size() >= 2) {
            int mixed = heap.poll() + heap.poll() * 2;
            heap.add(mixed);
            cnt += 1;
        }
        if (heap.peek() < K) {
            return -1;
        } else {
            return cnt;
        }
    }
}