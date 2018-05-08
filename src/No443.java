public class No443 {
    public int compress(char[] chars) {
        int index = 0;

        for (int i = 0; i < chars.length;) {
            int count = 0;
            char curr = chars[i];
            while (i < chars.length && chars[i] == curr) {
                count++;
                i++;
            }
            chars[index++] = curr;
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[index++] = c;
                }
            }
        }

        return index;
    }
}
