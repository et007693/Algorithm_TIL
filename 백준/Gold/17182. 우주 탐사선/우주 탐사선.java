import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
플로이드 워셜
출발지에서 도착지 거리를 계산할 때 경유지를 경유할 경우 더 짧을 수 있으므로 이를 완전 탐색(3중 for문)

비트마스킹
방문 여부는 2가지(방문했다, 안했다) -> 그래서 dp의 길이는 1<<N
따라서 현재의 마스크는 방문한 행성 정보(1, 2, 4를 방문했다면 1101 이 되므로)
따라서 다음 방문할 index와 and 연산을 통해 방문 여부 확인
최종 값은 FULL - 1만 확인하면 되는 이유는 모든 노드를 방문했을 때 1111이 되므로
* */
public class Main {
    static final int INF = 1_000_000_000;
    static int N, K, time = Integer.MAX_VALUE;
    static int[][] dist, dp;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dist = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        floydWarshall();

//        visited[K] = true;
//        dfs(K, 0, 0);

        // 비트마스크 + dp
        int FULL = 1 << N;
        dp = new int[FULL][N];

        for (int mask = 0; mask < FULL; mask++) {
            Arrays.fill(dp[mask], INF);
        }

        dp[1 << K][K] = 0;

        for (int mask = 0; mask < FULL; mask++) {
            for (int u = 0; u < N; u++) {
                if (dp[mask][u] == INF) continue;
                for (int v = 0; v < N; v++) {
                    if ((mask & (1 << v)) == 0) {
                        int nextMask = mask | (1 << v);
                        int nextCost = dp[mask][u] + dist[u][v];

                        if (dp[nextMask][v] > nextCost) {
                            dp[nextMask][v] = nextCost;
                        }
                    }
                }
            }
        }
        for (int u = 0; u < N; u++) {
            time = Math.min(time, dp[FULL - 1][u]);
        }

        System.out.println(time);
    }

    static void floydWarshall() {
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
    }

    // dfs
    static void dfs(int idx, int cnt, int d) {
        if (cnt == N-1) {
            time = Math.min(time, d);
            return;
        }

        if (d >= time) return;

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, cnt+1, d+dist[idx][i]);
                visited[i] = false;
            }
        }
    }
}