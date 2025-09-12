import java.util.*;

public class Solution {
    static int[][] keypad = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9},
        {-1, 0, -1}
    };
    static Map<Integer, int[]> posMap = new HashMap<>();
    static int[][] cost = new int[10][10]; // 0~9 거리 저장

    static int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    static int[][] diagonals = {{-1,-1}, {-1,1}, {1,-1}, {1,1}};

    public int solution(String numbers) {
        buildPosMap();
        buildCostTable();

        int len = numbers.length();
        int[][][] dp = new int[len + 1][10][10];

        for (int[][] d1 : dp) {
            for (int[] d2 : d1) {
                Arrays.fill(d2, Integer.MAX_VALUE);
            }
        }

        dp[0][4][6] = 0;

        for (int i = 0; i < len; i++) {
            int target = Character.getNumericValue(numbers.charAt(i));

            for (int l = 0; l < 10; l++) {
                for (int r = 0; r < 10; r++) {
                    if (dp[i][l][r] == Integer.MAX_VALUE) continue;

                    // 왼손으로 누를 수 있는 경우
                    if (target != r) {
                        int moveCost = cost[l][target];
                        int newCost = dp[i][l][r] + moveCost;
                        dp[i + 1][target][r] = Math.min(dp[i + 1][target][r], newCost);
                    }

                    // 오른손으로 누를 수 있는 경우
                    if (target != l) {
                        int moveCost = cost[r][target];
                        int newCost = dp[i][l][r] + moveCost;
                        dp[i + 1][l][target] = Math.min(dp[i + 1][l][target], newCost);
                    }
                }
            }
        }

        // 정답: 마지막 숫자를 누른 후의 최소 비용
        int answer = Integer.MAX_VALUE;
        for (int l = 0; l < 10; l++) {
            for (int r = 0; r < 10; r++) {
                answer = Math.min(answer, dp[len][l][r]);
            }
        }

        return answer;
    }

    private void buildPosMap() {
        for (int i = 0; i < keypad.length; i++) {
            for (int j = 0; j < keypad[0].length; j++) {
                int num = keypad[i][j];
                if (num != -1) {
                    posMap.put(num, new int[]{i, j});
                }
            }
        }
    }

    private void buildCostTable() {
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                cost[i][j] = getMinCost(i, j);
            }
        }
    }

    private int getMinCost(int a, int b) {
        if (a == b) return 1;

        int[] start = posMap.get(a);
        int[] end = posMap.get(b);

        boolean[][] visited = new boolean[4][3];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], cost = cur[2];
            if (x == end[0] && y == end[1]) return cost;

            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if (isValid(nx, ny) && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, cost + 2});
                }
            }

            for (int[] d : diagonals) {
                int nx = x + d[0], ny = y + d[1];
                if (isValid(nx, ny) && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, cost + 3});
                }
            }
        }

        return Integer.MAX_VALUE;
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < 4 && y >= 0 && y < 3 && keypad[x][y] != -1;
    }
}
