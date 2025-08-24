import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        String[] order = skill.split("");

        for (String tree : skill_trees) {
            int idx = 0;
            boolean isValid = true;

            for (char s : tree.toCharArray()) {
                String current = String.valueOf(s);
                
                if (Arrays.asList(order).contains(current)) {
                    if (s == skill.charAt(idx)) {
                        idx++;
                    } else {
                        isValid = false;
                        break;
                    }
                }
            }

            if (isValid) {
                answer++;
            }
        }

        return answer;
    }
}
