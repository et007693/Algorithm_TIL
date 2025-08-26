import java.util.*;

class Solution {
    public int solution(String[] board) {
        int answer = -1;
        int lenY = board.length;
        int lenX = board[0].length();
        char[][] map = new char[lenY][lenX];
        for (int i=0; i<lenY; i++) {
            map[i] = board[i].toCharArray();
        }
        Queue<int[]> q = new LinkedList<>();
        int[][] visited = new int[lenY][lenX];
        int[][] direction = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        
        for (int y=0; y < lenY; y++) {
            for (int x=0; x < lenX; x++) {
                if (map[y][x] == 'R') {
                    q.add(new int[]{x, y});
                }
            }
        }
        
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            
            // System.out.print(""+x+y);
            for (int[] d : direction) {
                int nx = x + d[0];
                int ny = y + d[1]; 
                while(true) {
                    if (nx < 0 || nx >= lenX || ny < 0 || ny >= lenY) {
                        break;
                    }
                    visited[ny][nx] = visited[y][x] + 1;
                    if (map[ny][nx] == 'G') {
                        return visited[ny][nx];
                    } else if (
                        map[ny][nx] == 'D' ||
                        nx == 0 || ny == 0 ||
                        nx == lenX-1 || ny == lenY-1
                    ) {
                        q.add(new int[]{nx, ny});
                        break;
                    }
                    nx += d[0];
                    ny += d[1];
                }
            }
            for (int[] visit:visited) {
                System.out.println(Arrays.toString(visit));
            }
            
        }
        return answer;
    }
}