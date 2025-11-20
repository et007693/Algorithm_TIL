import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
* 방을 부신다 -> 맞닿아 있는 방의 크기를 더한다
* */
public class Main {
    public static int[][] wall, visited;
    public static Map<Integer, Integer> map = new HashMap<>();
    public static int N, M, roomNum, maxSize, brokenSize = 0;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] bit = {1, 2, 4, 8};

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        wall = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                wall[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();
        destroy();

        System.out.println(roomNum);
        System.out.println(maxSize);
        System.out.println(brokenSize);
    }

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        roomNum = 0;

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (visited[y][x] == 0) {
                    roomNum++;
                    int roomSize = 0;

                    visited[y][x] = roomNum;
                    q.offer(new int[]{x, y});

                    while (!q.isEmpty()) {
                        int[] p = q.poll();
                        int cx = p[0];
                        int cy = p[1];

                        roomSize++;

                        for (int d = 0; d < 4; d++) {
                            int nx = cx + dx[d];
                            int ny = cy + dy[d];

                            if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;

                            if ((wall[cy][cx] & (1 << d)) == 0 && visited[ny][nx] == 0) {
                                visited[ny][nx] = roomNum;
                                q.offer(new int[]{nx, ny});
                            }
                        }
                    }

                    map.put(roomNum, roomSize);
                    maxSize = Math.max(maxSize, roomSize);
                }
            }
        }
    }

    public static void destroy() {
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                int now = visited[y][x];

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;

                    if (visited[ny][nx] != now) {
                        brokenSize = Math.max(
                                brokenSize,
                                map.get(now) + map.get(visited[ny][nx])
                        );
                    }
                }
            }
        }
    }
}