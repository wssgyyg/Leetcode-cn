import java.util.Stack;

public class No331 {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        Stack<String> stack = new Stack<>();
        for (String node : nodes) {
            while (node.equals("#") && !stack.isEmpty() && stack.peek().equals("#")) {
                stack.pop();
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
            stack.push(node);
        }

        return stack.size() == 1 && stack.peek().equals("#");
    }

    public boolean isValidSerializationByDegree(String preorder) {
        String[] nodes = preorder.split(",");
        int diff = 1;
        for (String node : nodes) {
            if (--diff < 0) return false;
            if (!node.equals("#")) diff += 2;
        }

        return diff == 0;
    }

}
