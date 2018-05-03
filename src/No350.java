import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class No350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> resList = new LinkedList<>();
        Arrays.stream(nums1).forEach(
                num -> {
                    if (map.containsKey(num)) {
                        map.put(num, map.get(num) + 1);
                    } else {
                        map.put(num, 1);
                    }
                }
        );

        Arrays.stream(nums2).forEach(
                num -> {
                    if (map.containsKey(num) && map.get(num) != 0) {
                        map.put(num, map.get(num) - 1);
                        resList.add(num);
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
