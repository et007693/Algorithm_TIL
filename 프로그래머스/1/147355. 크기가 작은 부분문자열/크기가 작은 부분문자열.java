class Solution {
    public int solution(String t, String p) {
        int len_t = t.length();
        int len_p = p.length();
        int answer = 0;
        
        for (int i=0; i < len_t - len_p + 1; i++) {
            long sub = Long.parseLong(t.substring(i, i+len_p));
            
            if (sub <= Long.parseLong(p)) {
                answer += 1;
            }
        }
        return answer;
    }
}