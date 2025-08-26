// 한 칸 이동하기 전에, 검사하는 로직으로 작성하기
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
                    visited[y][x] = 1;
                }
            }
        }
        
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            
            for (int[] d : direction) {
                int dx = x;
                int dy = y;
                
                while(true) {
                    int nx = dx + d[0];
                    int ny = dy + d[1]; 
                    if (nx < 0 || nx >= lenX || ny < 0 || ny >= lenY || map[ny][nx] == 'D') {
                        break;
                    }
                    dx = nx;
                    dy = ny;
                }
                if (visited[dy][dx] == 0) {
                    visited[dy][dx] = visited[y][x] + 1;
                    if (map[dy][dx] == 'G') {
                        return visited[dy][dx]-1;
                    }
                    q.add(new int[]{dx, dy});
                }
            }        
        }
        return answer;
    }
}