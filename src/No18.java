import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                for (int j = i + 1; j < nums.length - 2; j++) {
                    if (j == i + 1 || nums[j] != nums[j - 1]) {
                        int left = j + 1, right = nums.length - 1;
                        int remain = target - nums[i] - nums[j];
                        while (left < right) {
                            int temp = nums[left] + nums[right];
                            if (temp > remain) {
                                --right;
                            } else if (temp < remain) {
                                ++left;
                            } else {
                                result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                                --right;
                                ++left;
                                while (left < right && nums[left] == nums[left - 1]) ++left;
                                while (left < right && nums[right] == nums[right + 1]) --right;
                            }
                        }
                    }
                }
            }
        }

        return result;
    }
}
