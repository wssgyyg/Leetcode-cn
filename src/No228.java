import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class No228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new LinkedList<>();
        if (nums.length == 0)
            return result;
        if (nums.length == 1) {
            result.add(nums[0] + "");
            return result;
        }

        int start = nums[0];
        int end = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == (end + 1)) {
                end++;
            } else {
                if (start == end) {
                    result.add(start + "");
                } else {
                    result.add(start + "->" + end);
                }
                start = nums[i];
                end = nums[i];
            }
        }

        if (start == end) {
            result.add(start + "");
        } else {
            result.add(start + "->" + end);
        }

        return result;
    }
}
