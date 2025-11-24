import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
플로이드 워셜 : 출발지에서 도착지 거리를 계산할 때,
경유지를 경유할 경우 더 짧을 수 있으므로 이를 완전 탐색(3중 for문)
* */
public class Main {
    public static int N, K, time = Integer.MAX_VALUE;
    public static int[][] dist;
    public static boolean[] visited;

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
        visited[K] = true;
        dfs(K, 0, 0);
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