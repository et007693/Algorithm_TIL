import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int idx = 0;
        Arrays.sort(routes, (a, b) -> Integer.compare(b[0], a[0]));
        
        for (int[]r : routes) {
            if (!(r[0] <= idx && idx <= r[1])) {
                idx = r[0];
                answer++;
            }
        }

        return answer;
    }
}