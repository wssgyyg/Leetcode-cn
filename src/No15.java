import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int target = -nums[i];
                int left = i + 1, right = nums.length - 1;
                while (left < right) {
                    int temp = nums[left] + nums[right];
                    if (temp < target) {
                        ++left;
                    } else if (temp > target) {
                        --right;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        ++left;
                        --right;
                        while (left < nums.length && nums[left] == nums[left - 1]) ++left;
                        while (right >= 0 && nums[right] == nums[right + 1]) --right;
                    }
                }
            }
        }
        return result;
    }
}
