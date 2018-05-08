import java.util.LinkedList;
import java.util.List;

public class No438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();
        int[] map = new int[26];
        for (char ch : p.toCharArray()) {
            map[ch - 'a']++;
        }

        int count = p.length(), left = 0, right = 0;
        while (right < s.length()) {
            char rightChar = s.charAt(right++);
            if (map[rightChar] >= 1) {
                map[rightChar]--;
                count--;
            }

            if (count == 0) res.add(left);

            if ((right - left) == p.length() && map[s.charAt(left)] >= 0){
                count++;
                map[s.charAt(left++)]++;
            }
        }

        return res;
    }
}
