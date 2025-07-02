class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int size = absolutes.length;
        int plus = 0;
        int minus = 0;
        
        for (int i=0; i < size; i++) {
            if (signs[i]) {
                plus += absolutes[i];
            } else {
                minus += absolutes[i];
            }
        }
        
        return plus - minus;
    }
}