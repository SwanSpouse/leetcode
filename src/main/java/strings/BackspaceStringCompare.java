package strings;

import java.util.Stack;

public class BackspaceStringCompare {

    public String operate(String input) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.add(input.charAt(i));
            }
        }
        return stack.toString();
    }

    public boolean backspaceCompare(String S, String T) {
        return operate(S).equals(operate(T));
    }

    public static void main(String[] args) {
        System.out.println(new BackspaceStringCompare().backspaceCompare("y#fo##f", "y#f#o##f"));
    }
}

