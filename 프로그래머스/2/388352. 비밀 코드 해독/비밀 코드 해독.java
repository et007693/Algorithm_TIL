class Solution {
    static int n, m;
    static int[][] q;
    static int[] ans;
    static int count = 0;

    public static int solution(int n_, int[][] q_, int[] ans_) {
        n = n_;
        q = q_;
        ans = ans_;
        m = q.length;
        count = 0;

        generateCombinations(1, new int[5], 0);
        return count;
    }

    private static void generateCombinations(int start, int[] comb, int depth) {
        if (depth == 5) {
            if (isValid(comb)) {
                count++;
            }
            return;
        }
        for (int i = start; i <= n; i++) {
            comb[depth] = i;
            generateCombinations(i + 1, comb, depth + 1);
        }
    }

    private static boolean isValid(int[] code) {
        for (int i = 0; i < m; i++) {
            int match = 0;
            for (int x : code) {
                for (int y : q[i]) {
                    if (x == y) match++;
                }
            }
            if (match != ans[i]) return false;
        }
        return true;
    }
}