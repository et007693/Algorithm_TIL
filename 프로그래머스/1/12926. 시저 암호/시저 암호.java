class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) ((ch - 'A' + n) % 26 + 'A');
            } else if (ch >= 'a' && ch <= 'z') {
                ch = (char) ((ch - 'a' + n) % 26 + 'a');
            }
            answer.append(ch);
        }

        return answer.toString();
    }
}