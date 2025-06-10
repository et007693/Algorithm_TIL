import java.util.*;

class Solution {
    public String solution(String s) {
        String[] nums = s.split(" ");
        int max = Integer.parseInt(nums[0]);
        int min = max;
        
        for (String n : nums) {
            int num = Integer.parseInt(n);
            if (num > max) max = num;
            if (num < min) min = num;
        }
        
        return min + " " + max;
    }
}
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
//         String answer = "";
//         String[] nums = s.split(" ");
//         List<String> list = Arrays.asList(nums);
//         // List<String> list = Arrays.asList(array);
//         System.out.println(list);  // [apple, banana, orange]

//         // System.out.print(list);
        
//         return answer;
//     }
// }