import java.util.ArrayList;
import java.util.List;

public class No46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(result, new ArrayList<>(), nums, visited);
        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums, boolean[] visited) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                temp.add(nums[i]);
                visited[i] = true;
                backtrack(result, temp, nums, visited);
                visited[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }
}
