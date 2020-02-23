package stack;

import java.util.Stack;

public class ValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < popped.length; ) {
            if (index < pushed.length && pushed[index] == popped[i]) {
                index++;
                i++;
            } else if (!stack.empty() && popped[i] == stack.peek()) {
                stack.pop();
                i++;
            } else if (index < pushed.length) {
                stack.push(pushed[index++]);
            } else {
                return false;
            }
        }
        return true;
    }
}
