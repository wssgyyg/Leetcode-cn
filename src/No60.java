import java.util.ArrayList;
import java.util.List;

public class No60 {

    public String getPermutation(int n, int k) {
        StringBuilder result = new StringBuilder();
        List<Integer> notUsedNums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            notUsedNums.add(i);
        }
        int fact = 1;
        for (int i = 2; i < n; i++) {
            fact *= i;
        }

        k = k - 1;
        for (;n > 1; n--) {
            result.append(notUsedNums.remove(k / fact));
            k %= fact;
            fact /= (n - 1);
        }
        result.append(notUsedNums.get(0));

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new No60().getPermutation(3, 3));
    }
}
