import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int cnt = new HashSet<>(Arrays.asList(gems)).size();
        HashMap<String, Integer> map = new HashMap<>();

        int start = 0, end = 0;
        int[] answer = new int[]{0, Integer.MAX_VALUE};

        map.put(gems[0], 1);
        while (start <= end && end < gems.length) {
            if (map.size() == cnt) {
                if (end - start < answer[1] - answer[0]) {
                    answer[0] = start + 1;
                    answer[1] = end + 1;
                }
                map.put(gems[start], map.get(gems[start]) - 1);
                if (map.get(gems[start]) == 0) {
                    map.remove(gems[start]);
                }
                start++;
            } else {
                end++;
                if (end < gems.length) {
                    map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);
                }
            }
        }

        return answer;
    }
}
