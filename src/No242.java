import java.util.HashMap;
import java.util.Map;

public class No242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (map.containsKey(ch) && map.get(ch) != 0) {
                map.put(ch, map.get(ch) - 1);
            } else {
                return false;
            }
        }

        return true;
    }

    public boolean isAnagramNoHashMap(String s, String t) {
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) map[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) map[t.charAt(i) - 'a']--;
        for (int i = 0; i < 26; i++) {
            if (map[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
