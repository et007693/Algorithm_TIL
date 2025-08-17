class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        int mid = s/n;
        System.out.print(mid);
        for (int i=0; i<n; i++) {
            answer[i] = mid;
        }
        for (int i=0; i<s%n; i++) {
            answer[n-i-1] = answer[n-i-1]+1;
        }
        
        return s >= n ? answer : new int[]{-1};
    }
}