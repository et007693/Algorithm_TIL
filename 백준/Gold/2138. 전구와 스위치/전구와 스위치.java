import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
첫 경우의 수 나누는 것 고려하기
* */
public class Main {
    static int N;
    static int[] bulb, target;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        bulb = new int[N];
        target = new int[N];

        String num = br.readLine();
        for (int i = 0; i < N; i++) {
            bulb[i] = num.charAt(i) - '0';
        }

        String num2 = br.readLine();
        for (int i = 0; i < N; i++) {
            target[i] = num2.charAt(i) - '0';
        }

        int result1 = simulate(bulb, target, true);
        int result2 = simulate(bulb, target, false);

        int ans = Math.min(result1, result2);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    static int simulate(int[] init, int[] goal, boolean startPressFirst) {
        int[] tmp = Arrays.copyOf(init, init.length);
        int cnt = 0;

        if (startPressFirst) {
            tmp[0] ^= 1;
            tmp[1] ^= 1;
            cnt++;
        }

        for (int i = 1; i < N; i++) {
            if (tmp[i - 1] != goal[i - 1]) {
                tmp[i] ^= 1;
                tmp[i-1] ^= 1;
                if (i + 1 < N) tmp[i+1] ^= 1;
                cnt++;
            }
        }

        if (tmp[N - 1] == goal[N - 1]) return cnt;
        else return Integer.MAX_VALUE;
    }
}