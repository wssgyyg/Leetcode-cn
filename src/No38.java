public class No38 {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        return read(countAndSay(n - 1));
    }

    public String read(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < string.length()) {
            int j = i + 1;
            while (j < string.length() && string.charAt(j) == string.charAt(i)) ++j;
            stringBuilder.append(j - i);
            stringBuilder.append(string.charAt(i));
            i = j;
        }

        return stringBuilder.toString();
    }
}
