class Solution {
    boolean solution(String s) {
        int cnt_y = 0;
        int cnt_p = 0;
        
        for (char ch : s.toCharArray()) {
            char c = Character.toLowerCase(ch);
            if (c == 'y') cnt_y++;
            else if (c == 'p') cnt_p++;
        }

        return cnt_y == cnt_p;
    }
}
