import java.util.*;

class Solution {
    public String solution(String s) {
        List<String> str = new ArrayList<>(Arrays.asList(s.split("")));
        Collections.sort(str, Collections.reverseOrder());
        String answer = String.join("", str);
        return answer;
    }
}