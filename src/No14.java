public class No14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        String result = strs[0];
        for (int i = 0; i < strs.length; i++) {
            result = commonPrefix(strs[i], result);
        }
        return result;
    }

    public String commonPrefix(String s1, String s2) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < Math.min(s1.length(), s2.length()) && s1.charAt(i) == s2.charAt(i); i++) {
            result.append(s1.charAt(i));
        }
        return result.toString();
    }
}
