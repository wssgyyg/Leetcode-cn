import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class No464 {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int maxSum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if (maxSum < desiredTotal) return false;
        if (desiredTotal <= 0) return true;

        Map<String, Boolean> map = new HashMap<>();
        boolean[] used = new boolean[maxChoosableInteger + 1];
        return helper(map, used, desiredTotal);
    }

    public boolean helper(Map<String, Boolean> map, boolean[] used, int desiredTotal) {
        if (desiredTotal <= 0) return false;
        String key = Arrays.toString(used);
        if (!map.containsKey(key)) {
            for (int i = 1; i < used.length; i++) {
                if (!used[i]) {
                    used[i] = true;

                    if (!helper(map, used, desiredTotal - i)) {
                        map.put(key, true);
                        used[i] = false;
                        return true;
                    }

                    used[i] = false;
                }
            }
            map.put(key, false);
        }

        return map.get(key);
    }
}
