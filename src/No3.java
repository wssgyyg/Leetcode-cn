import java.util.HashMap;

public class No3 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] charArray = s.toCharArray();
        int maxLength = 0;
        int left = 0, right = 0;

        while (right < charArray.length) {
            char c = charArray[right];
            if (map.containsKey(c)) {
                left = Math.max(map.get(c) + 1, left);
            }
            map.put(c, right);
            maxLength = Math.max(maxLength, right - left + 1);
            ++right;
        }

        return maxLength;
    }
}
