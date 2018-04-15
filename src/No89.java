import java.util.ArrayList;
import java.util.List;

public class No89 {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        if (n == 0)
            return result;

        backtrack(result, n);
        return result;
    }

    public void backtrack(List<Integer> result, int n) {
        if (result.size() == 1 << n) {
            return;
        }

        for (int i = 0; i < n; i++) {
            int temp = result.get(result.size() - 1) ^ (1 << i);
            if (!result.contains(temp)) {
                result.add(temp);
                backtrack(result, n);
                if (result.size() == 1 << n) {
                    return;
                }
                result.remove(result.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new No89().grayCode(2));
    }
}
