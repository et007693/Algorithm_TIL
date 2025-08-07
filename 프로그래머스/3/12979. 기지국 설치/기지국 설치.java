class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int start = 1; 
        int coverage = 2 * w + 1;
        
        for (int station : stations) {
            int left = station - w;
            int right = station + w;
            
            if (start < left) {
                answer += (int) Math.ceil((double)(left - start) / coverage);
            }
            start = right + 1;
            
        }
        if (start <= n) {
            int gap = n - start + 1;
            answer += (int) Math.ceil((double) gap / coverage);
        }

        return answer;
    }
}
