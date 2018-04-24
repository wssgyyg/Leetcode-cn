import java.util.Stack;

public class No227 {
    public int calculate(String s) {
        int res = 0;
        Stack<Integer> operands = new Stack<>();
        int num = 0;
        char sign = '+';
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            } else if (s.charAt(i) != ' '){
                if (sign == '+') {
                    operands.push(num);
                } else if (sign == '-') {
                    operands.push(-num);
                } else if (sign == '/') {
                    operands.push(operands.pop() / num);
                } else {
                    operands.push(operands.pop() * num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }

        while (!operands.isEmpty()) {
            res += operands.pop();
        }

        return res;
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}
