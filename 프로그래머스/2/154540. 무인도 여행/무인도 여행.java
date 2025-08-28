import java.util.*;

class Solution {
    PriorityQueue<Integer> heap = new PriorityQueue<>();
    public int[] solution(String[] maps) {
        int lenY = maps.length;
        int lenX = maps[0].length();
        String[][] map = new String[lenY][lenX];
        int[][] direction = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < lenY; i++) {
            map[i] = maps[i].split("");
        }
        
        for (int y = 0; y < lenY; y++) {
            for (int x = 0; x < lenX; x++) {
                if (!map[y][x].equals("X")) {            
                    q.add(new int[]{x, y});
                    int day = Integer.parseInt(map[y][x]);
                    map[y][x] = "X";
                    while (!q.isEmpty()) {
                        int[] current = q.poll();
                        int cx = current[0];
                        int cy = current[1];
                        
                        for (int[] d : direction) {
                            int dx = cx + d[0];
                            int dy = cy + d[1];
                            
                            if (
                                dy >= 0 && dy < lenY &&
                                dx >= 0 && dx < lenX &&
                                !map[dy][dx].equals("X")
                            ) {
                                q.add(new int[]{dx, dy});
                                day += Integer.parseInt(map[dy][dx]);
                                map[dy][dx] = "X";
                            }
                        }
                    }
                    heap.add(day);
                }
            }
        }
        int size = heap.size();
        if (size == 0) {
            return new int[]{-1};
        } else {
            int[] answer = new int[size];
            for (int i = 0; i < size; i++) {
                answer[i] = heap.poll();
            }
            return answer;
        }
    }
}