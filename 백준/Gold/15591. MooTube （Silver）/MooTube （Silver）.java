import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
인접리스트, 노드 저장
* */
public class Main {
    static class Edge {
        int to;
        int w;
        Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        ArrayList<Edge>[] graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            graph[p].add(new Edge(q, r));
            graph[q].add(new Edge(p, r));
        }

        for (int qi = 0; qi < Q; qi++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            boolean[] visited = new boolean[N+1];
            Queue<Integer> q = new LinkedList<>();
            q.offer(v);
            visited[v] = true;

            int cnt = 0;
            while (!q.isEmpty()) {
                int cur = q.poll();
                for (Edge e : graph[cur]) {
                    if (!visited[e.to] && e.w >= k) {
                        visited[e.to] = true;
                        q.offer(e.to);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}