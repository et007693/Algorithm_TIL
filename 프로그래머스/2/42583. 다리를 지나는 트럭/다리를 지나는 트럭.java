import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        int time = 0;
        int totalWeight = 0;
        int idx = 0;
        
        for (int j = 0; j < bridge_length; j++) {
            bridge.offer(0);
        }
        
        while (idx < truck_weights.length) {
            time++;
            totalWeight -= bridge.poll();
            
            if (truck_weights[idx] <= weight - totalWeight) {
                bridge.offer(truck_weights[idx]);
                totalWeight += truck_weights[idx];
                idx++;
            } else {
                bridge.offer(0);
            }
        }
        time += bridge_length;

        return time;
    }
}