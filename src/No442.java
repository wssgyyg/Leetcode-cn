import java.util.LinkedList;
import java.util.List;

public class No442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new LinkedList<>();
        for (int num : nums) {
            if (nums[num - 1] == -1) {
                res.add(num);
            } else {
                nums[num - 1] = -1;
            }
        }
        return res;
    }
}
