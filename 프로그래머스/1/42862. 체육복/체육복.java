import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();

        for (int l : lost) lostSet.add(l);
        for (int r : reserve) reserveSet.add(r);

        Set<Integer> overlap = new HashSet<>(lostSet);
        overlap.retainAll(reserveSet);

        lostSet.removeAll(overlap);
        reserveSet.removeAll(overlap);

        List<Integer> sortedLost = new ArrayList<>(lostSet);
        Collections.sort(sortedLost);

        for (int student : sortedLost) {
            if (reserveSet.contains(student - 1)) {
                reserveSet.remove(student - 1);
            } else if (reserveSet.contains(student + 1)) {
                reserveSet.remove(student + 1);
            } else {
                continue;
            }
            lostSet.remove(student);
        }

        return n - lostSet.size();
    }
}
