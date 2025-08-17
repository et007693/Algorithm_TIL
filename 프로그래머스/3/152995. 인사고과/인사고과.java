import java.util.*;

// 정렬을 한 두 집단의 비교는 N log N
class Solution {
    public int solution(int[][] scores) {
        int[] wanho = scores[0];
        int answer = 1;
        Arrays.sort(scores, (a, b) -> {
            if (a[0] != b[0]) return b[0] - a[0];
            return a[1] - b[1];
        });
        int max = 0;
        
        for (int[] score : scores) {
            int sum = score[0] + score[1];
            if (score[1] < max) {
                if (score[0] == wanho[0] && score[1] == wanho[1]) {
                    return -1;
                }
                continue;
            }
            max = score[1];
            if (score[0] + score[1] > wanho[0] + wanho[1]) answer++;
        }
        return answer;
    }
}