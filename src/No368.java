import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class No368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {

        List<Integer>[] a = new List[nums.length];
        a[0] = new LinkedList<>();
        a[0].add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int size = 0;
            a[i] = new LinkedList<>();
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 || nums[j] % nums[i] == 0) {
                    if (a[j].size() > size) {
                        a[i].clear();
                        a[i].addAll(a[j]);
                        size = a[j].size();
                    }
                }
            }
            a[i].add(nums[i]);
        }

        return a[nums.length - 1];
    }
}
