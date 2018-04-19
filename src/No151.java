import java.util.ArrayList;
import java.util.List;

public class No151 {
    public String reverseWords(String s) {
        /*List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                int j = i + 1;
                while (j < s.length() && s.charAt(j) != ' ') {
                    j++;
                }
                list.add(0, s.substring(i, j));
                i = j;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(str);
            sb.append(' ');
        }

        if (sb.length() <= 0) return "";
        return sb.substring(0, sb.length() - 1);*/
        if (s == null) return null;

        char[] a = s.toCharArray();
        int n = a.length;

        reverse(a, 0, n - 1);
        reverseWords(a, n);
        return cleanSpaces(a, n);
    }

    private void reverseWords(char[] a, int n) {
        int i = 0, j = 0;
        while (i < n) {
            while (i < n && a[i] == ' ') i++;
            while (j < n && a[j] != ' ') j++;
            reverse(a, i, j);
        }
    }

    private String cleanSpaces(char[] a, int n) {
        int i = 0, j = 0;

        while (j < n) {
            while (j < n && a[j] == ' ') j++;
            while (j < n && a[j] != ' ') a[i++] = a[j++];
            while (j < n && a[j] == ' ') j++;
            if (j < n) a[i++] = ' ';
        }

        return new String(a).substring(0, i);
    }

    private void reverse(char[] a, int i, int j) {
        while (i < j) {
            char temp = a[i];
            a[i++] = a[j];
            a[j--] = temp;
        }
    }

    public static void main(String[] args) {
        String test = "  sadf df sdf asdf ";
        System.out.println(new No151().reverseWords(test));

    }
}
