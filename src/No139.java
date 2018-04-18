import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        String test = "leetcode";
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        System.out.println(new No139().wordBreak(test, list));
    }
}
