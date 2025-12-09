import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/*

* */
public class Main {
    static class Node implements Comparable<Node> {
        int to;
        int w;
        Node(int to, int w) {
            this.to = to;
            this.w = w;
        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.w, o.w);
        }
    }
    static int N, M;
    static ArrayList<Node>[] barn;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        barn = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            barn[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            barn[a].add(new Node(b, r));
            barn[b].add(new Node(a, r));
        }

        int[] cost = new int[N+1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[1] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.w > cost[cur.to]) continue;

            for (Node e : barn[cur.to]) {
                if (e.w + cur.w < cost[e.to]) {
                    cost[e.to] = cur.w + e.w;
                    pq.offer(new Node(e.to, e.w + cur.w));
                }
            }
        }
        System.out.println(cost[N]);
    }
}