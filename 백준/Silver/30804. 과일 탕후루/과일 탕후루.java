import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] fruits = new int[n];
        for (int i = 0; i < n; i++) {
            fruits[i] = sc.nextInt();
        }

        Map<Integer, Integer> map = new HashMap<>();
        int start = 0, end = 0, answer = 0;

        while (end < n) {
            map.put(fruits[end], map.getOrDefault(fruits[end], 0) + 1);

            while (map.size() > 2) {
                int count = map.get(fruits[start]);
                if (count == 1) {
                    map.remove(fruits[start]);
                } else {
                    map.put(fruits[start], count - 1);
                }
                start++;
            }

            answer = Math.max(answer, end - start + 1);
            end++;
        }

        System.out.println(answer);
    }
}
