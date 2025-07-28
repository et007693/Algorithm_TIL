class Solution {
    static int answer = 0;
    static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];     
        dfs(k, dungeons, 0);
        return answer;
    }
    
    private void dfs(int fatigue, int[][]dungens, int count) {
        answer = Math.max(answer, count);
        
        for (int i=0; i < dungens.length; i++) {
            int min = dungens[i][0];
            int cost = dungens[i][1];
                if (!visited[i] && fatigue >= min) {
                    visited[i] = true;
                    dfs(fatigue-cost, dungens, count+1);
                    visited[i] = false;
                }
        }
    }
}