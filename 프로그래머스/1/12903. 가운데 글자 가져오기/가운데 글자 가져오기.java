class Solution {
    public String solution(String s) {
        int length = (s.length())/2;
        if (s.length() % 2 == 0) {
            return s.substring(length-1, length+1);
        } else {
            return String.valueOf(s.charAt(length));
        }
    }
}