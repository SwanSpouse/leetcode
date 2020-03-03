package array;

import java.util.Stack;

public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int[] ret = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ret[i] = -1;
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length * 2; i += 1) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % nums.length]) {
                ret[stack.pop()] = nums[i % nums.length];
            }
            stack.push(i % nums.length);
        }
        return ret;
    }
}
