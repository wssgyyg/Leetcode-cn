import java.util.Stack;

public class No388 {
    public static void main(String[] args) {
        String s = "\t\thello";
        System.out.println(s.length());
        System.out.println(s.lastIndexOf('\t') + 1);
    }

    public int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int maxLength = 0;
        for (String s : input.split("\n")) {
            int level = s.lastIndexOf("\t") + 1;
            while (level + 1 < stack.size()) {
                stack.pop();
            }
            int len = stack.peek() + s.length() - level + 1;
            stack.push(len);
            if (s.contains(".")) {
                maxLength = Math.max(maxLength, len - 1);
            }
        }
        return maxLength;
    }
}
