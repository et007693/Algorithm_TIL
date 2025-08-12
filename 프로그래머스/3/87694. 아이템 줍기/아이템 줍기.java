import java.util.*;

class Solution {
    int[][] clock = new int[][]{{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
    int[][] opClock = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] map = new int[101][101];
        boolean[][] visited = new boolean[101][101];
        Queue<int[]> q = new LinkedList<>();

        int answer = Integer.MAX_VALUE;
        for (int[] rec : rectangle) {
            for (int x = rec[0]*2; x <= rec[2]*2; x++) {
                for (int y = rec[1]*2; y <= rec[3]*2; y++) {
                    if (x == rec[0]*2 || x == rec[2]*2 || y == rec[1]*2 || y == rec[3]*2) {
                        map[x][y] = 1;                        
                    }
                }
            }
        }
        
        for (int[] rec : rectangle) {
            for (int x = rec[0]*2 + 1; x < rec[2]*2; x++) {
                for (int y = rec[1]*2 + 1; y < rec[3]*2; y++) {
                    map[x][y] = 0;
                }
            }
        }
        
        q.add(new int[]{characterX*2, characterY*2});
        
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int x = pos[0];
            int y = pos[1];
            if (x == itemX*2 && y == itemY*2) break;
            
            for (int[] c : clock) {
                int dx = c[0];
                int dy = c[1];
                if (x+dx > 0 && x+dx < 101 && y+dy > 0 && y+dy < 101) {
                    if (!visited[x+dx][y+dy] && map[x+dx][y+dy] != 0) {
                        visited[x+dx][y+dy] = true;
                        map[x+dx][y+dy] = map[x][y] + 1;
                        q.add(new int[] {x + dx, y + dy});
                    }
                }
            }
        }
        return (map[itemX*2][itemY*2]-1) / 2;
    }
}