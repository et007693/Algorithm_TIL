import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*

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

        Queue<Integer> q = new LinkedList<>();
        q.offer(N);

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : new int[]{cur - 1, cur + 1, cur * 2}) {
                if (next < 0 || next > 100000) continue;
                int curCnt = cnt[cur];
                if (curCnt + 1 < cnt[next]) {
                    if (next == cur * 2) {
                        cnt[next] = cnt[cur];
                    } else {
                        cnt[next] = cnt[cur] + 1;
                    }
                    q.offer(next);
                }
            }
        }
        System.out.println(cnt[K]);
    }
}