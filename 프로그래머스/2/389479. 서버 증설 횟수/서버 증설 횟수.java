// 누적합

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int current = 0;
        int[] capacity = new int[players.length + k + 1];
        
        for (int i=0; i<players.length; i++) {
            current += capacity[i];
            
            if (players[i] > current) {
                int share = (int)Math.ceil((double)((players[i] - current) / m));
                answer += share;
                current += share * m;
                capacity[i] += share * m;
                capacity[i+k] -= share * m;
            }
        }
        
        return answer;
    }
}