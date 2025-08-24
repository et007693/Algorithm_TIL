import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int lenY = maps.length;
        int lenX = maps[0].length;
        int[][] visited = new int[lenY][lenX];
        int[][] direction = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{0, 0});
        visited[0][0] = 1;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int y = current[0];
            int x = current[1];

            for (int[] d : direction) {
                int ny = y + d[0];
                int nx = x + d[1];

                if (
                    ny >= 0 && ny < lenY &&
                    nx >= 0 && nx < lenX &&
                    maps[ny][nx] == 1 &&
                    visited[ny][nx] == 0
                ) {
                    visited[ny][nx] = visited[y][x] + 1;
                    q.add(new int[]{ny, nx});
                }
            }
        }

        return visited[lenY - 1][lenX - 1] == 0 ? -1 : visited[lenY - 1][lenX - 1];
    }
}
