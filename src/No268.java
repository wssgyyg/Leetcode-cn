public class No268 {
    public int missingNumber(int[] nums) {
        int res = 0;
        int i = 0;
        for (;i < nums.length; i++) {
            res = res ^ i ^ nums[i];
        }

        return res ^ i;
    }
}
