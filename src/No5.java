public class No5 {
    public String longestPalindrome(String s) {
        String result = "";
        int longestLength = 0;
        for (int i = 0; i < s.length(); i++) {
            int length1 = longestPalindromeLengthAround(s, i, i + 1);
            int length2 = longestPalindromeLengthAround(s, i, i);
            String temp;
            if (length1 >= length2) {
                temp = s.substring(i - length1 + 1, i + length1 + 1);
            } else {
                temp = s.substring(i - length2 + 1, i + length2);
            }
            if (temp.length() > longestLength) {
                result = temp;
                longestLength = result.length();
            }
        }

        return result;
    }

    public int longestPalindromeLengthAround(String s, int left, int right) {
        int length = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            ++length;
            --left;
            ++right;
        }

        return length;
    }

    public static void main(String[] args) {
        System.out.println(new No5().longestPalindrome("babad"));
    }
}
