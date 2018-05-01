import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class No341 {
}

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class NestedIterator implements Iterator<Integer> {

    private List<Integer> list;
    private Iterator<Integer> iterator;
    public NestedIterator(List<NestedInteger> nestedList) {
        list = new ArrayList<>();
        Stack<NestedInteger> stack = new Stack<>();
        for (int i = nestedList.size() - 1; i >= 0; i++) {
            stack.push(nestedList.get(i));
        }
        while (!stack.isEmpty()) {
            NestedInteger nestedInteger = stack.pop();
            if (nestedInteger.isInteger()) {
                list.add(nestedInteger.getInteger());
            } else {
                List<NestedInteger> nestedIntegerList = nestedInteger.getList();
                for (int i = nestedIntegerList.size() - 1; i >= 0; i--) {
                    stack.push(nestedIntegerList.get(i));
                }
            }
        }

        iterator = list.iterator();
    }

    @Override
    public Integer next() {
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
