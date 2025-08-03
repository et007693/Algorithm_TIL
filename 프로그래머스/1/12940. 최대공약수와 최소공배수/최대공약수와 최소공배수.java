class Solution {
    public int[] solution(int n, int m) {
        int max = Math.max(n, m);
        System.out.print(max);
        for (int i=max; i >= 1; i--) {
            if (n % i == 0 && m % i == 0) {
                return new int[]{i, ((n*m) / i)};
            }
        }
        return new int[]{1, n * m};
    }
}