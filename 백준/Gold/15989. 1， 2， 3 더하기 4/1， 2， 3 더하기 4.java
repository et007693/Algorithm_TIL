import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*

* */
public class Main {
    static int[] coins = {1,2,3};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            System.out.println(countN(n));
        }
    }

    public static int countN(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= n; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[n];
    }
}