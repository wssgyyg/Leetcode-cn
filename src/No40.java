import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, 0, target);
        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> temp, int[] candidates, int startIndex, int remain) {
        if (remain == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        if (startIndex >= candidates.length || remain < 0) {
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if (i == startIndex || candidates[i] != candidates[i - 1]) {
                temp.add(candidates[i]);
                backtrack(result, temp, candidates, i + 1, remain - candidates[i]);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
