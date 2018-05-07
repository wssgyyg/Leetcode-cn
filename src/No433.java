import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class No433 {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> searchSet = new HashSet<>();
        searchSet.add(start);
        Set<String> endSet = new HashSet<>();
        endSet.add(end);
        Set<String> visited = new HashSet<>();
        visited.add(start);
        visited.add(end);
        Set<String> wordBank = new HashSet<>();
        char[] candidates = new char[] { 'A', 'T', 'G', 'C' };
        Arrays.stream(bank).forEach(k -> wordBank.add(k));
        if (!wordBank.contains(end)) return -1;
        int len = 0;
        while (!searchSet.isEmpty() && !endSet.isEmpty()) {
            if (endSet.size() < searchSet.size()) {
                Set<String> replace = searchSet;
                searchSet = endSet;
                endSet = replace;
            }
            Set<String> temp = new HashSet<>();
            for (String searchWord : searchSet) {
                char[] searchWordCharArray = searchWord.toCharArray();
                for (int i = 0; i < searchWordCharArray.length; i++) {
                    for (int j = 0; j < candidates.length; j++) {
                        if (candidates[j] != searchWordCharArray[i]) {
                            char copy = searchWordCharArray[i];
                            searchWordCharArray[i] = candidates[j];
                            String newWord = new String(searchWordCharArray);
                            if (endSet.contains(newWord)) {
                                return len + 1;
                            }

                            if (wordBank.contains(newWord) && !visited.contains(newWord)) {
                                temp.add(newWord);
                                visited.add(newWord);

                            }
                            searchWordCharArray[i] = copy;
                        }
                    }
                }
            }
            searchSet = temp;
            len++;
        }
        return -1;
    }
}
