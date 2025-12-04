import java.sql.Array;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
경로 저장은 노드 방식이 적합
도착지부터 시작
* */
public class Main {
    static int N, K;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] cnt = new int[100001];
        Arrays.fill(cnt, Integer.MAX_VALUE);
        cnt[N] = 0;

        int[] route = new int[100001];
        Arrays.fill(route, -1);

        Queue<Integer> q = new LinkedList<>();
        q.offer(N);

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == K) break;

            for (int next : new int[]{cur - 1, cur + 1, cur * 2}) {
                if (next < 0 || next > 100000) continue;
                if (cnt[cur] + 1 < cnt[next]) {
                    cnt[next] = cnt[cur] + 1;
                    q.offer(next);
                    route[next] = cur;
                }
            }
        }
        System.out.println(cnt[K]);
        List<Integer> path = new ArrayList<>();
        int cur = K;
        while (cur != -1) {
            path.add(cur);
            cur = route[cur];
        }
        Collections.reverse(path);
        StringBuilder sb = new StringBuilder();
        for (int v : path) sb.append(v).append(' ');
        System.out.println(sb.toString().trim());
    }
}