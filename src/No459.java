public class No459 {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                String target = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n / i; j++) {
                    sb.append(target);
                }

                if (sb.toString().equals(s)) {

                    return true;
                }
            }
        }
        return false;
    }
}
