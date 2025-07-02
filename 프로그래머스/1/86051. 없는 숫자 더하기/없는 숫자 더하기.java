import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        Set<Integer> set = new HashSet<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        int answer = 0;
        
        for (int num : numbers) {
            if (set.contains(num)) {
                set.remove(num);
            }
        }
        
        for (int num : set) {
            answer += num;
        }
        
        return answer;
    }
}