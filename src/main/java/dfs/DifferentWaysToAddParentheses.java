package dfs;

import utils.Print;

import java.util.*;

public class DifferentWaysToAddParentheses {

    public int calc(int numA, int numB, char op) {
        switch (op) {
            case '+':
                return numA + numB;
            case '-':
                return numA - numB;
            case '*':
                return numA * numB;
            case '/':
                return numA / numB;
        }
        return 0;
    }

    public void dfs(Set<Integer> ret, LinkedList<Integer> nums, LinkedList<Character> ops, String input) {
        if (input.length() <= 0) {
            while (!ops.isEmpty()) {
                char op = ops.getFirst();
                ops.removeFirst();
                int numA = nums.getFirst();
                nums.removeFirst();
                int numB = nums.getFirst();
                nums.removeFirst();
                nums.addFirst(calc(numA, numB, op));
            }
            ret.add(nums.getFirst());
            return;
        }
        // get a op
        int i = 0;
        ops.addLast(input.charAt(i++));

        // get a number
        int num = 0;
        for (; i < input.length(); i++) {
            if (input.charAt(i) >= '0' && input.charAt(i) <= '9') {
                num = num * 10 + input.charAt(i) - '0';
            } else {
                break;
            }
        }
        nums.addLast(num);
        input = input.substring(i);

        // 这里有两种选择，一种是把刚刚拿到的op和num进行计算， 一种是不算
        // 首先是不算
        dfs(ret, new LinkedList<Integer>(nums), new LinkedList<Character>(ops), input);

        // 然后是算
        char op = ops.getLast();
        ops.removeLast();
        int numB = nums.getLast();
        nums.removeLast();
        int numA = nums.getLast();
        nums.removeLast();
        nums.addLast(calc(numA, numB, op));
        dfs(ret, new LinkedList<Integer>(nums), new LinkedList<Character>(ops), input);
    }

    public List<Integer> diffWaysToCompute(String input) {
        Set<Integer> ret = new HashSet<Integer>();
        LinkedList<Integer> nums = new LinkedList<Integer>();
        LinkedList<Character> ops = new LinkedList<Character>();

        input = input.replace(" ", "");
        if (input.length() == 0) {
            return new ArrayList<Integer>();
        }

        // 先放一个操作数
        int num = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) >= '0' && input.charAt(i) <= '9') {
                num = num * 10 + input.charAt(i) - '0';
            } else {
                nums.addLast(num);
                input = input.substring(i);
                break;
            }
        }
        dfs(ret, nums, ops, input);
        return new ArrayList<Integer>(ret);
    }

    public static void main(String[] args) {
        Print.PrintList(new DifferentWaysToAddParentheses().diffWaysToCompute("2*3-4*5"));
//        Print.PrintList(new DifferentWaysToAddParentheses().diffWaysToCompute("2*3"));
    }
}
