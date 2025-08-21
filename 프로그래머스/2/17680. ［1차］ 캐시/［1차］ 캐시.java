import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> q = new LinkedList<>();
        
        for (String city: cities) {
            city = city.toLowerCase();
            if (q.contains(city)) {
                answer++;
                q.remove(city);
                q.add(city);
            } else {
                answer += 5;
                q.add(city);
                if (q.size() > cacheSize) {
                    q.remove();
                }
            }
        }
        return answer;
    }
}