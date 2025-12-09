import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/*

* */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];
        int left = 0, right = N - 1;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = {nums[left], nums[right]};
        int sum = nums[left] + nums[right];

        while (left < right) {
            int curSum = nums[left] + nums[right];
            if (Math.abs(sum) > Math.abs(curSum)) {
                answer[0] = nums[left];
                answer[1] = nums[right];
                sum = curSum;
            }
            if (curSum < 0) {
                left++;
            } else {
                right--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int x : answer) {
            sb.append(x).append(" ");
        }
        System.out.println(sb);
    }
}