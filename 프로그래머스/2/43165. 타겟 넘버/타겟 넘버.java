class Solution {
    int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(numbers, target, 0, 0);
        return answer;
    }
    
    public void dfs(int[] numbers, int target, int sum, int idx) {
        if (idx == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        dfs(numbers, target, sum+numbers[idx], idx+1);
        dfs(numbers, target, sum-numbers[idx], idx+1);
    }
}