import java.util.TreeSet;

public class No220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }

        TreeSet<Integer> bst = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            long right = nums[i] + (long)t;
            if (right > Integer.MAX_VALUE) {
                right = Integer.MAX_VALUE;
            }

            long left = nums[i] - (long)t;
            if (left < Integer.MIN_VALUE) {
                left = Integer.MIN_VALUE;
            }
            Integer floor = bst.floor((int) right);
            if (floor != null && floor >= left) {
                return true;
            }

            bst.add(nums[i]);
            if (i >= k) {
                bst.remove(nums[i - k]);
            }
        }

        return false;
    }
}
