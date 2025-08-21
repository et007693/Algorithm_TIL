// 배열은 주소값이므로 set에는 부적합
import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        int x = 0;
        int y = 0;
        Set<String> pathSet = new HashSet<>();
        
        for (char dir : dirs.toCharArray()) {
            int nx = x;
            int ny = y;

            switch (dir) {
                case 'U': ny++; break;
                case 'D': ny--; break;
                case 'L': nx--; break;
                case 'R': nx++; break;
            }
            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) {
                continue;
            }
            
            String path = x + "," + y + ":" + nx + "," + ny;
            String reversePath = nx + "," + ny + ":" + x + "," + y;
            
            pathSet.add(path);
            pathSet.add(reversePath);
            
            x = nx;
            y = ny;
        }
        return pathSet.size() / 2; // 양방향 저장했으므로 2로 나눔
    }
}