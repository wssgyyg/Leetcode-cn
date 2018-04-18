public class No137 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int bitSum = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] >> i & 1) == 1) {
                    bitSum++;
                }
            }
            res |= (bitSum % 3 << i);
        }
        return res;
    }
}
