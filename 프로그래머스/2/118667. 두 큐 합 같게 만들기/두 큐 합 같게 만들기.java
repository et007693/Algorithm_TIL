import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0, sum2 = 0;
        
        for (int i = 0; i < queue1.length; i++) {
            q1.offer(queue1[i]);
            sum1 += queue1[i];
            q2.offer(queue2[i]);
            sum2 += queue2[i];
        }
        
        int maxCount = queue1.length * 3;
        int count = 0;

        while (count <= maxCount) {
            if (sum1 == sum2) return count;
            
            if (sum1 > sum2) {
                int num = q1.poll();
                sum1 -= num;
                sum2 += num;
                q2.offer(num);
            } else {
                int num = q2.poll();
                sum2 -= num;
                sum1 += num;
                q1.offer(num);
            }
            count++;
        }

        return -1;
    }
}
