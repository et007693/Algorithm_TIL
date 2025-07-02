class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        long sum = 0;
        String[] nums = String.valueOf(x).split("");
        
        for (String num : nums) {;
            sum += Integer.parseInt(num);
        }
        
        if (x % sum == 0) {
            return true;
        } else {
            return false;
        }
    }
}