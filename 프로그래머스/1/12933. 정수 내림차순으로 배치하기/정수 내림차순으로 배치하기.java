import java.util.*;

class Solution {
    public long solution(long n) {
        String[] nums = String.valueOf(n).split("");
        Arrays.sort(nums, Collections.reverseOrder());
        long answer = Long.parseLong(String.join("", nums));
        return answer;
    }
}