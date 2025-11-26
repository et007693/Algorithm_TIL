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
    static int N, Q;
    static ArrayList<Edge>[] graph;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            graph[a].add(new Edge(b, r));
            graph[b].add(new Edge(a, r));
        }

        for (int qu = 0; qu < Q; qu++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            boolean[] visited = new boolean[N+1];
            Queue<Integer> q = new LinkedList<>();
            visited[V] = true;
            q.offer(V);

            int count = 0;
            while (!q.isEmpty()) {
                int cur = q.poll();
                for (Edge e : graph[cur]) {
                    if (!visited[e.to] && e.w >= K) {
                        visited[e.to] = true;
                        q.offer(e.to);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}