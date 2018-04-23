import java.util.HashSet;
import java.util.Set;

public class No202 {
    public boolean isHappy(int n) {
        Set<Integer> loopSet = new HashSet<>();
        while (!loopSet.contains(n)) {
            loopSet.add(n);
            if (n == 1) {
                return true;
            }
            n = squareSum(n);
        }
        return false;
    }

    public boolean isHappyFloydCycleDetection(int n) {
        int fast = n;
        int slow = n;

        do {
            slow = squareSum(slow);
            fast = squareSum(squareSum(fast));
            if (slow == 1 || fast == 1) return true;
        } while (slow != fast);

        return slow == 1;
    }

    public int squareSum(int n) {
        int res = 0;
        while (n != 0) {
            int remain = n % 10;
            res += (remain * remain);
            n = n / 10;
        }
        return res;
    }
}
