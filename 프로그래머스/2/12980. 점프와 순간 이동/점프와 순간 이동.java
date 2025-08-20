// dp 풀 때 목적지에서 처음으로 가는 것도 고려하기
public class Solution {
    public int solution(int n) {
        int answer = 0;
        while(n > 0) {
            if (n%2 == 0) {
                n /= 2;
            } else {
                n -= 1;
                answer++;
            }
        }
        return answer;
    }
}