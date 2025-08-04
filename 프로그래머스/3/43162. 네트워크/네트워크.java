import java.util.*;

class Solution {
    public boolean[] visited;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer = 0;
        
        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                dfs(i, n, computers);
                answer += 1;
            }
        }
        return answer;
    }
    
    public void dfs(int node, int n, int[][]computers) {
        for (int i=0; i < n; i++) {
            if (!visited[i] && computers[node][i] == 1) {
                visited[i] = true;
                dfs(i, n, computers);
            }
        }
    }
}