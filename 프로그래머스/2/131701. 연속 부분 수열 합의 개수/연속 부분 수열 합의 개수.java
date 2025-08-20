import java.util.*;

class Solution {
    public int solution(int[] elements) {
        HashSet<Integer> set = new HashSet<>();
        for (int i=0; i < elements.length; i++) {
            int sum = 0;
            int idx = i;
            for (int j=0; j < elements.length; j++) {
                sum += elements[idx];
                set.add(sum);
                idx = (idx+1) % elements.length;
            }
        }
        return set.size();
    }
}