package stack;

import java.util.Stack;

/**
 *  input = "([])" 这种也算是合理的。很惊讶。看来不是必须小括号在里面。
 *
 *  堆栈方面最经典的习题还是数据结构书上的那个：带括号的四则运算。
 */

public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            if (s.charAt(i) == ')') {
                if (stack.peek() != '(') {
                    return false;
                }
                stack.pop();
            }
            if (s.charAt(i) == ']') {
                if (stack.peek() != '[') {
                    return false;
                }
                stack.pop();
            }
            if (s.charAt(i) == '}') {
                if (stack.peek() != '{') {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
