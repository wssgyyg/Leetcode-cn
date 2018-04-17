import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> searchSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        int len = 1;
        Set<String> visited = new HashSet<>();
        searchSet.add(beginWord);
        endSet.add(endWord);

        Set<String> wordDict = new HashSet<>(wordList);

        while (!searchSet.isEmpty() && !endSet.isEmpty()) {
            if (searchSet.size() > endSet.size()) {
                Set<String> set = searchSet;
                searchSet = endSet;
                endSet = set;
            }

            Set<String> temp = new HashSet<>();
            for (String word : searchSet) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chars[i];
                        chars[i] = c;
                        String newWord = String.valueOf(chars);

                        if (endSet.contains(newWord)) {
                            return len + 1;
                        }

                        if (wordDict.contains(newWord) && !visited.contains(newWord)) {
                            temp.add(newWord);
                            visited.add(newWord);
                        }
                        chars[i] = old;
                    }
                }

            }
            searchSet = temp;
            len++;
        }

        return 0;
    }
}
