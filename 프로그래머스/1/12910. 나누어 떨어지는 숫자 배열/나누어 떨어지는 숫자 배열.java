import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> answer = new ArrayList<>();

        for (int num : arr) {
            if (num % divisor == 0) {
                answer.add(num);
            }
        }

        if (answer.isEmpty()) {
            return new int[] { -1 };
        }

        Collections.sort(answer);

        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }
}
