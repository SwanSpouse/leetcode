package stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for (String item : tokens) {
            if (item.equals("+")) {
                Integer num2 = stack.pop();
                Integer num1 = stack.pop();
                stack.push(num1 + num2);
            } else if (item.equals("-")) {
                Integer num2 = stack.pop();
                Integer num1 = stack.pop();
                stack.push(num1 - num2);
            } else if (item.equals("*")) {
                Integer num2 = stack.pop();
                Integer num1 = stack.pop();
                stack.push(num1 * num2);
            } else if (item.equals("/")) {
                Integer num2 = stack.pop();
                Integer num1 = stack.pop();
                stack.push(num1 / num2);
            } else {
                stack.push(Integer.parseInt(item));
            }
        }
        return stack.pop();
    }

}
