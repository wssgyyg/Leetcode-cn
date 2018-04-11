import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        backtrack(result, new ArrayList<>(), nums, visited);
        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums, boolean[] visited) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i])
                continue;
            if (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1])
                continue;

            temp.add(nums[i]);
            visited[i] = true;
            backtrack(result, temp, nums, visited);
            visited[i] = false;
            temp.remove(temp.size() - 1);

        }
    }
}
