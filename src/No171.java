public class No171 {
    public int titleToNumber(String s) {
        int res = 0;
        int mul = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            res += mul * (s.charAt(i) - 64);
            mul *= 26;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new No171().titleToNumber("BA"));
    }
}
