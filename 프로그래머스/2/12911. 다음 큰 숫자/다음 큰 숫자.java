class Solution {
    public int solution(int n) {
        int oneCount = Integer.bitCount(n);

        int next = n + 1;
        while (true) {
            if (Integer.bitCount(next) == oneCount) {
                return next;
            }
            next++;
        }
    }
}