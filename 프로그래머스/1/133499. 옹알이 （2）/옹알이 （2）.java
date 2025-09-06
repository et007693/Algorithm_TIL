public class Solution {
    public int solution(String[] babbling) {
        String[] sounds = {"aya", "ye", "woo", "ma"};
        int count = 0;

        for (String word : babbling) {
            String prev = "";  // 이전 발음
            int idx = 0;
            boolean isValid = true;

            while (idx < word.length()) {
                boolean matched = false;

                for (String sound : sounds) {
                    if (word.startsWith(sound, idx)) {
                        if (sound.equals(prev)) {
                            isValid = false;
                            break;
                        }

                        prev = sound;
                        idx += sound.length();
                        matched = true;
                        break;
                    }
                }

                if (!matched) {
                    isValid = false;
                    break;
                }

                if (!isValid) break;
            }

            if (isValid) count++;
        }

        return count;
    }
}
