import java.util.Stack;

public class No155 {
    class MinStack {

        private Stack<Integer> valueStack;
        private Stack<Integer> minStack;

        /** initialize your data structure here. */
        public MinStack() {
            valueStack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            valueStack.push(x);
            if (minStack.isEmpty()) {
                minStack.push(x);
            } else {
                if (x < minStack.peek()) {
                    minStack.push(x);
                } else {
                    minStack.push(minStack.peek());
                }
            }

        }

        public void pop() {
            minStack.pop();
            valueStack.pop();
        }

        public int top() {
            return valueStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
