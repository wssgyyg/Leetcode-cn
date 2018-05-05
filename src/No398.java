import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class No398 {
    class Solution {

        Map<Integer, List<Integer>> map;
        Random random = new Random();
        public Solution(int[] nums) {
            map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
            }
        }

        public int pick(int target) {
            List<Integer> indexList = map.get(target);
            int index = random.nextInt(indexList.size());
            return indexList.get(index);
        }
    }

    class SolutionBetter {
        int[] nums;
        Random random;

        public SolutionBetter(int[] nums) {
            this.nums = nums;
            this.random = new Random();
        }

        public int pick(int target) {
            int count = 0;
            int result = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != target) {
                    continue;
                }
                if (random.nextInt(++count) == 0) {
                    result = i;
                }
            }
            return result;
        }
    }
}
