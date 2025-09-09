// HashMap을 사용해서 값을 저장해놓기
import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        
        for (String call : callings) {
            int currentIdx = map.get(call);
            int frontIdx = currentIdx - 1;

            if (frontIdx >= 0) {
                String front = players[frontIdx];
                players[frontIdx] = call;
                players[currentIdx] = front;

                map.put(call, frontIdx);
                map.put(front, currentIdx);
            }
        }
        
        return players;
    }
}