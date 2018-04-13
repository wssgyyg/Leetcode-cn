import java.util.ArrayList;
import java.util.List;

public class No77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        backtrack(result, new ArrayList<>(), nums, k, 0);
        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> temp, List<Integer> nums, int k, int startIndex) {
        if (k == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = startIndex; i < nums.size(); i++) {
            temp.add(nums.get(i));
            backtrack(result, temp, nums, k - 1, i );
            temp.remove(temp.size() - 1);
        }
    }
}
