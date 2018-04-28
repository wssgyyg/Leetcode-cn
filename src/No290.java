import java.util.HashMap;
import java.util.Map;

public class No290 {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            if (map1.containsKey(str.charAt(i))) {
                if (!map1.get(str.charAt(i)).equals(words[i])) {
                    return false;
                }
            }

            if (map2.containsKey(words[i]) && !map2.get(words[i]).equals(str.charAt(i))) {
                return false;
            }

            map1.put(str.charAt(i), words[i]);
            map2.put(words[i], str.charAt(i));
        }

        return true;
    }
}
