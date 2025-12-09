import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
사이클을 저장 및 확인하는 방식 기억하기
* */
public class Main {
    static boolean[] visited;
    static int[] nums;
    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        nums = new int[N+1];
        visited = new boolean[N+1];

        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        for(int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i));
        }
    }

    static void dfs(int idx, int target) {
        int next = nums[idx];
        if (!visited[next]) {
            visited[next] = true;
            dfs(next, target);
            visited[next] = false;
        }
        if (next == target) {
            answer.add(idx);
        }
    }
}