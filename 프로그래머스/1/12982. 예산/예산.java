import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int sum = 0;
        Arrays.sort(d);
        
        for (int n: d) {
            if (sum + n <= budget) {
                sum += n;
                answer++;
            } else {
                return answer;
            }
        }
        return answer;
    }
}