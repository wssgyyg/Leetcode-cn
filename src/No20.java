import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class No20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> maps = new HashMap<>();
        maps.put(')', '(');
        maps.put(']', '[');
        maps.put('}', '{');
        for (int i = 0; i < s.length(); i++) {
            char nowChar = s.charAt(i);
            switch (nowChar) {
            case '(':
            case '[':
            case '{':
                stack.push(nowChar);
                break;

            default:
                if (!stack.isEmpty() && stack.peek() == maps.get(nowChar)) {
                    stack.pop();
                } else {
                    return false;
                }
                break;
            }
        }

        return stack.isEmpty();
    }
}
