import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = -1;
        int[] visited = new int[y+1];
        visited[x] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        
        while (!q.isEmpty()) {
            int current = q.poll();
            
            for(int next : new int[]{current+n, current*2, current*3}) {
                if (next <= y) {
                    if (visited[next] == 0) {
                        visited[next] = visited[current] + 1;
                        q.add(next);
                    }                   
                }
            }
        }
        if (visited[y] != 0) {
            answer = visited[y]-1;
        }
        return answer;
    }
}