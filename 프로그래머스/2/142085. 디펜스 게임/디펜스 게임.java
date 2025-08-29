import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = enemy.length;
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0;
        
        for (int i = 0; i < enemy.length; i++) {
            sum += enemy[i];
            heap.add(enemy[i]);
            if (sum > n) {
                if (k > 0) {
                    sum -= heap.poll();
                    k--;
                } else {
                    return i;
                }
            }
        }
        return answer;
    }
}