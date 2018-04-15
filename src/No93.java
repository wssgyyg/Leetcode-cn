import java.util.ArrayList;
import java.util.List;

public class No93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        backtrack(res, new StringBuilder(), s, 0, 0);
        return res;
    }

    public void backtrack(List<String> res, StringBuilder temp, String s, int numSegment, int startIndex) {
        if (numSegment == 4 && startIndex == s.length()) {
            res.add(temp.substring(0, temp.length() - 1));
            return;
        }

        if (numSegment == 4 || startIndex == s.length()) {
            return;
        }

        for (int i = 1; i < Math.min(s.length() - startIndex + 1, 4); i++) {
            String tempString = s.substring(startIndex, startIndex + i);
            if ((tempString.startsWith("0") && tempString.length() > 1) || !(Integer.parseInt(tempString) <= 255)) continue;
            temp.append(tempString + ".");
            backtrack(res, temp, s, numSegment + 1, startIndex + i);
            temp.delete(temp.length() - i - 1, temp.length());
        }
    }

    public static void main(String[] args) {
        System.out.println(new No93().restoreIpAddresses("1111"));
    }
}
