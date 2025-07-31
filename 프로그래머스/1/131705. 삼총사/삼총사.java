class Solution {
    int answer = 0;
    public int solution(int[] number) {
        dfs(number, 0, 0, 0);
        return answer;
    }
    
    private void dfs(int[] number, int idx, int cnt, int sum) {
        if (idx == number.length) {
            if (sum == 0 && cnt == 3) {
                answer += 1;
            }
            return;
        }
        dfs(number, idx + 1, cnt + 1, sum + number[idx]);
        dfs(number, idx + 1, cnt, sum);
    }
}