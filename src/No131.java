import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class No131 {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        partition(result, new ArrayList<>(), s);
        return result;
    }

    public void partition(List<List<String>> result, List<String> temp, String s) {
        if (s == null || s.length() == 0) {
            result.add(new LinkedList<>(temp));
        }

        for (int i = 1; i <= s.length(); i++) {
            String tempString = s.substring(0, i);
            if (isPalindrome(tempString)) {
                temp.add(s.substring(0, i));
                partition(result, temp, s.substring(i, s.length()));
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            ++left;
            --right;
        }

        return true;
    }
}
