import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class No187 {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        Set<String> findedSet = new HashSet<>();

        for (int i = 0; i <= s.length() - 10; i++) {
            String target = s.substring(i, i + 10);
            if (set.contains(target) && !findedSet.contains(target)) {
                findedSet.add(target);
            }
            set.add(target);
        }

        List<String> res = new LinkedList<>();
        for (String str : findedSet) {
            res.add(str);
        }

        return res;
    }

    public List<String> findRepeatedDnaSequencesWithCompression(String s) {
        Set<Integer> wordSet = new HashSet<>();
        Set<Integer> repeatedSet = new HashSet<>();
        List<String> res = new LinkedList<>();

        char[] map = new char[26];
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;

        for (int i = 0; i <= s.length() - 10; i++) {
            int target = 0;
            for (int j = i; j < i + 10; j++) {
                target <<= 2;
                target |= map[s.charAt(j) - 'A'];
            }

            if (!wordSet.add(target) && repeatedSet.add(target)) {
                res.add(s.substring(i, i + 10));
            }
        }

        return res;
    }
}
