import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long left = 1;
        long maxTime = Arrays.stream(times).max().getAsInt();
        long right = (long) n * maxTime;
        long answer = 0;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            long cnt = 0;
            for (int time : times) {
                 cnt += mid / time;
            }
            if (cnt >= n) {
                answer = mid;
                right = mid-1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}