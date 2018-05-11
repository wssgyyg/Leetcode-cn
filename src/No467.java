import java.util.stream.IntStream;

public class No467 {
    public int findSubstringInWraproundString(String p) {
        int[] count = new int[26];
        int maxCurLength = 0;
        for (int i = 0; i < p.length(); i++) {
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || (p.charAt(i - 1) - p.charAt(i)) == 25)) {
                maxCurLength++;
            } else {
                maxCurLength = 1;
            }

            int index =  p.charAt(i) - 'a';
            count[index] = Math.max(count[index], maxCurLength);
        }

        int sum = 0;

        for (int i : count) {
            sum += i;
        }

        return sum;
    }
}
