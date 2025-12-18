import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
* */
public class Main {
    static int N, answer;
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        stack.push(0);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            while (stack.peek() > h) {
                stack.pop();
            }

            if (stack.peek() < h) {
                answer++;
                stack.push(h);
            }
        }
        System.out.println(answer);
    }
}