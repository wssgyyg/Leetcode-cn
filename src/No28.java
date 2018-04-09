public class No28 {
    public int strStr(String haystack, String needle) {
        int needleLength = needle.length();
        int left = 0, right = needleLength;
        while (right <= haystack.length()) {
            if (haystack.substring(left, right).equals(needle)) {
                return left;
            }
            ++left;
            right = left + needleLength;
        }

        return -1;
    }
}
