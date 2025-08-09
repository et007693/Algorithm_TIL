import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        Queue<Integer> q = new LinkedList<Integer>();
        // 인접 리스트
        List<List<Integer>> graph = new ArrayList<>();
        int[] visited = new int[n+1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        visited[1] = 1;
        q.add(1);
        
        while (!q.isEmpty()) {
            int current = q.poll();
            
            for (int next : graph.get(current)) {
                if (visited[next] == 0) {
                    q.add(next);
                    visited[next] = visited[current] + 1;
                }
            }
        }
        int max = 0;
        int answer = 0;
        
        for (int v : visited) {
            if (v > max) {
                max = v;
                answer = 0;
            };
            if (v == max) answer++;
        }
    
        return answer;
    }
}