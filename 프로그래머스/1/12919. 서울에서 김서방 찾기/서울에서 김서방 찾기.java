import java.util.*;

class Solution {
    public String solution(String[] seoul) {
        List<String> list = Arrays.asList(seoul);
        String answer = "김서방은 " + list.indexOf("Kim") + "에 있다";
        return answer;
    }
}