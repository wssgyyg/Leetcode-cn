import java.util.ArrayList;
import java.util.List;

public class No17 {
    public List<String> letterCombinations(String digits) {
        String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> results = new ArrayList<>();
        if (digits.length() == 0) {
            return results;
        }

        backtrack(results, new StringBuilder(), digits, 0, letters);

        return results;
    }

    public void backtrack(List<String> results, StringBuilder temp, String digits, int index, String[] letters) {
        if (index == digits.length()) {
            results.add(temp.toString());
            return;
        }

        String letter = letters[digits.charAt(index) - '0'];
        for (int i = 0; i < letter.length(); i++) {
            temp.append(letter.charAt(i));
            backtrack(results, temp, digits, index + 1, letters);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
