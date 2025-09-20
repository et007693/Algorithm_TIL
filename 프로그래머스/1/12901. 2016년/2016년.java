import java.util.*;

class Solution {
    public String solution(int a, int b) {
        int day = 0;
        
        Map<Integer, Integer> map = Map.ofEntries(
            Map.entry(1, 31),
            Map.entry(2, 29),
            Map.entry(3, 31),
            Map.entry(4, 30),
            Map.entry(5, 31),
            Map.entry(6, 30),
            Map.entry(7, 31),
            Map.entry(8, 31),
            Map.entry(9, 30),
            Map.entry(10, 31),
            Map.entry(11, 30),
            Map.entry(12, 31)
        );
        
        for (int i = 1; i < a; i++) {
            day += map.get(i);
        }

        day += b - 1;
        String[] days = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        
        return days[day % 7];
    }
}
