import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class No216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        int[] nums = new int[9];
        for (int i = 0; i < 9; i++) {
            nums[i] = i + 1;
        }
        combinationSum3(result, new LinkedList<>(), nums, n, 0, k);
        return result;
    }

    public void combinationSum3(List<List<Integer>> result, List<Integer> temp, int[] nums, int target, int startIndex, int k) {
        if (k == 0 && target == 0) {
            result.add(new LinkedList<>(temp));
            return;
        }

        if (k <= 0 || target <= 0) {
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            temp.add(nums[i]);
            combinationSum3(result, temp, nums, target - nums[i], i + 1, k - 1);
            temp.remove(temp.size() - 1);
        }
    }
}
