// 일수를 다 계산하려고 하지말고, 남은 시간 배열을 만든 후, 최적해 찾기
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int max = (int)Math.ceil((100.0 - progresses[0]) / speeds[0]);
        int cnt = 1;
        List<Integer> result = new ArrayList<>();
        
        for (int i=1; i<progresses.length; i++) {
            int time = (int)Math.ceil((100.0 - progresses[i]) / speeds[i]);
            if (time <= max) {
                cnt++;
            } else if (time > max) {
                result.add(cnt);
                max = time;
                cnt = 1;
            }
        }
        result.add(cnt);
        
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}