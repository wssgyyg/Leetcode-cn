import java.util.ArrayList;
import java.util.List;

public class No22 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), n, n);
        return result;
    }

    public void backtrack(List<String> result, StringBuilder temp, int leftNumRemain, int rightNumRemain) {
        if (leftNumRemain == 0 && rightNumRemain == 0) {
            result.add(temp.toString());
            return;
        }

        if (leftNumRemain > 0) {
            temp.append('(');
            backtrack(result, temp, leftNumRemain - 1, rightNumRemain);
            temp.deleteCharAt(temp.length() - 1);
        }

        if (leftNumRemain < rightNumRemain) {
            temp.append(')');
            backtrack(result, temp, leftNumRemain, rightNumRemain - 1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
