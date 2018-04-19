import java.util.Stack;

public class No150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (!isOperand(token)) {
                stack.push(Integer.valueOf(token));
            } else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();

                if (token.equals("+")) {
                    stack.push(operand1 + operand2);
                } else if (token.equals("-")) {
                    stack.push(operand1 - operand2);
                } else if (token.equals("*")) {
                    stack.push(operand1 * operand2);
                } else {
                    stack.push(operand1 / operand2);
                }
            }
        }

        return stack.peek();
    }

    public boolean isOperand(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

}
