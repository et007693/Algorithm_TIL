// 메모이제이션
import java.util.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    Set<String> set = new HashSet<>();
    
    public int solution(int[][] info, int n, int m) {
        dfs(info, n, m, 0, 0, 0);
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    
    public void dfs(int[][] info, int n, int m, int idx, int sumA, int sumB) {
        if (sumA > answer || sumA >= n || sumB >= m) return;
        String key = "" + idx + sumA + sumB;
        if (set.contains(key)) return;
        set.add(key);
        
        if (idx == info.length) {
            if (sumA < answer) {
                answer = sumA;
            }
            return;
        }
        dfs(info, n, m, idx+1, sumA, sumB+info[idx][1]);
        dfs(info, n, m, idx+1, sumA+info[idx][0], sumB);
    }
}