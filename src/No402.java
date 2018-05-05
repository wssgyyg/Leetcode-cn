import java.util.Stack;

public class No402 {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            while (!stack.isEmpty() && k > 0 && stack.peek() > (ch - '0')) {
                stack.pop();
                k--;
            }
            stack.push(ch - '0');
        }
        char[] digits = new char[stack.size()];
        for (int i = digits.length; i >= 0; i--) {
            digits[i] = (char) (stack.pop() + '0');
        }
        int i = 0;
        while (i < digits.length && digits[i] == '0') i++;
        return i == digits.length ? "0" : new String(digits, i, digits.length);
    }
}
