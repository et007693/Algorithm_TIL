import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<int[]> q = new PriorityQueue<>(
        (a, b) -> {
            if (a[1] != b[1]) return a[1] - b[1];
            if (a[0] != b[0]) return a[0] - b[0];
            return a[2] - b[2];
        }
        );
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));
        int time = 0;
        int idx = 0;
        int answer = 0;
        
        while (!q.isEmpty() || idx < jobs.length) {            
            while (idx < jobs.length && jobs[idx][0] <= time) {
                q.add(new int[] {jobs[idx][0], jobs[idx][1], idx});
                idx++;
            }
            
            if (!q.isEmpty()) {
                int[] job = q.poll();
                time += job[1];
                answer += time - job[0];
            } else {
                time = jobs[idx][0];
            }
        }
        return answer / jobs.length;
    }
}