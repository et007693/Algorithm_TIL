import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int t: tangerine) {
            map.put(t, map.getOrDefault(t, 0)+1);
        }
        List<Integer> cnt = new ArrayList<>(map.values());
        cnt.sort(Collections.reverseOrder());
        
        for (int c: cnt) {
            if (sum < k) {
                sum += c;
                answer++;
                }
            else {
                return answer;
            }
        }
        return answer;
    }
}