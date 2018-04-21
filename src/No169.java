public class No169 {
    public int majorityElement(int[] nums) {
        int target = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
            } else if (count == 1) {
                target = nums[i];
                count = 1;
            } else {
                count = count - 1;
            }
        }
        return target;
    }
}
