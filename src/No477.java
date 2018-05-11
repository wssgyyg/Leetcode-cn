public class No477 {
    public int totalHammingDistance(int[] nums) {
        int res = 0, n = nums.length;
        for (int i = 0; i < 32; i++) {
            int temp = 0;
            for (int j = 0; j < n; j++) {
                temp += (nums[j] >> i) & 1;
            }
            res += temp * (n - temp);
        }
        return res;
    }
}
