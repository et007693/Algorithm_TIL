import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
* */
public class Main {
    static int N, K;
    static int[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new int[100001];
        Arrays.fill(visited, Integer.MAX_VALUE);

        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        visited[N] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == K) break;
            for (int i : new int[]{cur + 1, cur - 1, cur * 2}) {
                if (i < 0 || i > 100000) continue;
                if (visited[i] > visited[cur]) {
                    q.offer(i);
                    visited[i] = visited[cur] + 1;
                }
            }
        }
        System.out.println(visited[K]);
    }
}