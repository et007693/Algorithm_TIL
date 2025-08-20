import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        HashSet<String> map = new HashSet<>();
        map.add(words[0]);
        String before = words[0];
        
        for (int i=1; i < words.length; i++) {
            int bl = map.size();
            String word = words[i];
            map.add(word);
            int al = map.size();
            
            if (before.charAt(before.length()-1) == word.charAt(0) && bl != al) {
                before = word;
            } else {
                answer[0] = (i%n)+1;
                answer[1] = (int)(Math.ceil((double)(i+1)/n));
                return answer;
            }
        }
        return answer;
    }
}