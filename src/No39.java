import java.util.ArrayList;
import java.util.List;

public class No39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), target, candidates, 0);
        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> temp, int remain, int[] candidates, int startIndex) {
        if (remain == 0) {
            result.add(new ArrayList<>(temp));;
            return;
        }
        if (remain < 0) {
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            temp.add(candidates[i]);
            backtrack(result, temp, remain - candidates[i], candidates, i);
            temp.remove(temp.size() - 1);
        }
    }
}
