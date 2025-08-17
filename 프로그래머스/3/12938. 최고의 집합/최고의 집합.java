import java.util.*;

// 같은 값으로 배열 채울 땐 fill 사용하기
class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        Arrays.fill(answer, s/n);
        
        for (int i=0; i<s%n; i++) {
            answer[n-i-1] = answer[n-i-1]+1;
        }
        
        return s >= n ? answer : new int[]{-1};
    }
}
