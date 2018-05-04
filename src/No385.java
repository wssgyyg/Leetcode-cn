import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class No385 {
    //Given s = "[123,[456,[789]]]",
    //
    //Return a NestedInteger object containing a nested list with 2 elements:
    //
    //1. An integer containing value 123.
    //2. A nested list containing two elements:
    //    i.  An integer containing value 456.
    //    ii. A nested list with one element:
    //         a. An integer containing value 789.
    class Solution {
        public NestedInteger deserialize(String s) {
            if (s.charAt(0) != '[')
                return new NestedInteger(Integer.valueOf(s));
            Stack<NestedInteger> stack = new Stack<>();
            char[] charArray = s.toCharArray();
            NestedInteger result = null;
            for(int i = 0; i < charArray.length; i++) {
                char ch = charArray[i];
                if (ch == '[') {
                    NestedInteger ni = new NestedInteger();
                    if (!stack.isEmpty()) {
                        stack.peek().add(ni);
                    }
                    stack.push(ni);
                } else if (ch == ']') {
                    if (!stack.isEmpty()) {
                        result = stack.pop();
                    }
                } else if (Character.isDigit(ch) || ch == '-') {
                    String num = "" + ch;
                    while (i < s.length() - 1 && Character.isDigit(s.charAt(i + 1))) {
                        num = num + s.charAt(++i);
                    }
                    stack.peek().add(new NestedInteger(Integer.valueOf(num)));
                }
            }
            return result;
        }
    }

    class NestedInteger {
        public NestedInteger(){

        }

        public NestedInteger(int value){

        }

        public boolean isInteger() {
            return false;
        }

        public Integer getInteger() {
            return null;
        }

        public void setInteger(int value){

        }

        public void add(NestedInteger nestedInteger) {

        }

        public List<NestedInteger> getList() {
            return null;
        }
    }
}
