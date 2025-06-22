class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        int smail = Math.min(a, b);
        int big = Math.max(a, b);
        
        for (int i=smail; i<=big; i++) {
            answer += i;
        }
        return answer;
    }
}