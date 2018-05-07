public class No424 {
    public int characterReplacement(String s, int k) {
        int start = 0, end = 0, maxLength = 0;
        int[] count = new int[26];
        int maxCount = 0;
        for (; end < s.length(); end++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
            if ((end - start + 1 - maxCount) > k) {
                count[s.charAt(start++) - 'A']--;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
