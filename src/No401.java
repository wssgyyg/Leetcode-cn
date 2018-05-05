import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class No401 {
    class Solution {
        public List<String> readBinaryWatch(int num) {
            List<String> result = new ArrayList<>();
            int[] nums = new int[] { 1, 2, 4, 8, 1, 2, 4, 8, 16, 32 };
            helper(result, nums, num, 0, 0, 0);
            return result;
        }

        public void helper(List<String> result, int[] nums, int remain, int index, int hour, int minute) {
            if (hour > 12 || minute >= 60 || hour == 12 && minute == 0 || (nums.length - index) < remain || index > nums.length) {
                return;
            }
            if (remain == 0) {
                StringBuilder sb = new StringBuilder(String.valueOf(hour));
                sb.append(":");
                if (minute < 10) {
                    sb.append(0);
                }
                sb.append(minute);
                result.add(sb.toString());
                return;
            }

            helper(result, nums, remain, index + 1, hour, minute);
            if (index < 4) {
                helper(result, nums, remain - 1, index + 1, hour + nums[index], minute);
            } else {
                helper(result, nums, remain - 1, index + 1, hour, minute + nums[index]);
            }
        }
    }
}
