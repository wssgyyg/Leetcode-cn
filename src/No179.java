import java.util.Arrays;
import java.util.Comparator;

public class No179 {
    public String largestNumber(int[] nums) {
        String[] s = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            s[i] = String.valueOf(nums[i]);
        }

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String integer, String t1) {
                return ("" + t1+ integer).compareTo("" + integer + t1);
            }
        };

        Arrays.sort(s, comparator);

        if (s[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String str : s) {
            sb.append(str);
        }
        return sb.toString();

    }
}
