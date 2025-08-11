import java.util.*;

class Solution {
    
    public long solution(int[] sequence) {
        int n = sequence.length;
        long max = 0;
        long currentMax = 0;
        long max2 = 0;
        long currentMax2 = 0;
        long[] sum1 = new long[n];
        long[] sum2 = new long[n];
        
        for (int i=0; i<n; i++) {
            if (i % 2 == 0) {
                sum1[i] = sequence[i];
                sum2[i] = -sequence[i];
            } else {
                sum1[i] = -sequence[i];
                sum2[i] = sequence[i];
            }
        }
        
        for (int i=0; i < n; i++) {
            currentMax = Math.max(sum1[i], currentMax + sum1[i]);
            max = Math.max(currentMax, max);
        }
        
        for (int i=0; i < n; i++) {
            currentMax2 = Math.max(sum2[i], currentMax2 + sum2[i]);
            max = Math.max(currentMax2, max);
        }
        
        long answer = Math.max(max, max2);
        return answer;
        
    }
}