public class No334 {
    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE, median = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= small) {
                small = num;
            } else if (num <= median) {
                median  = num;
            } else {
                return true;
            }
        }

        return false;
    }
}
