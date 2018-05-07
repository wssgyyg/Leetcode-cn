public class No434 {
    public int countSegments(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) {
                ++count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        new No434().countSegments("love live! mu'sic forever");
    }
}
