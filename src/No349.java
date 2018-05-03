import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class No349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> resList = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        Arrays.stream(nums1).forEach(
                x -> set.add(x)
        );

        Arrays.stream(nums2).forEach(
                x -> {
                    if (set.contains(x)) {
                        resList.add(x);
                    }
                }
        );

        int[] res = new int[resList.size()];
        int i = 0;
        for (Integer integer : resList) {
            res[i++] = integer;
        }
        return res;
    }
}
