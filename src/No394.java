import java.util.Stack;

public class No394 {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        String res = "";

        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int count = 0;
                while (Character.isDigit(ch)) {
                    count = count * 10 + ch - '0';
                    ch = s.charAt(++i);
                }
                countStack.push(count);
            } else if (ch == '[') {
                stringStack.push(res);
                res = "";
                i++;
            } else if (ch == ']') {
                StringBuilder sb = new StringBuilder(stringStack.pop());
                int count = countStack.pop();
                for (int j = 0; j < count; j++) {
                    sb.append(res);
                }
                res = sb.toString();
                i++;
            } else {
                res += ch;
                i++;
            }
        }
        return res;
    }
}
