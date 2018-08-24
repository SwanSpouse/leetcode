package stack;

import java.util.ArrayList;

public class BasicCalculatorII {

    public int calculate(String s) {
        s = s.replaceAll(" ", "");
        if (s.length() == 0) {
            return 0;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Character> op = new ArrayList<Character>();

        int curNum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                list.add(curNum);
                curNum = 0;
                op.add(s.charAt(i));
            } else if (s.charAt(i) == '*' || s.charAt(i) == '/') {
                char operator = s.charAt(i);
                int numB = 0;
                for (i = i + 1; i < s.length(); i++) {
                    if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                        numB = numB * 10 + s.charAt(i) - '0';
                    } else {
                        break;
                    }
                }
                i -= 1;
                if (operator == '*') {
                    curNum = curNum * numB;
                } else {
                    curNum = curNum / numB;
                }
            } else {
                curNum = curNum * 10 + s.charAt(i) - '0';
            }
        }
        list.add(curNum);

        int ret = list.get(0);
        for (int i = 0, j = 1; i < op.size(); i++, j++) {
            int numB = list.get(j);
            char operator = op.get(i);
            if (operator == '+') {
                ret = ret + numB;
            } else {
                ret = ret - numB;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new BasicCalculatorII().calculate("3+2*2"));
        System.out.println(new BasicCalculatorII().calculate(" 3/2 "));
        System.out.println(new BasicCalculatorII().calculate(" 3+5 / 2 "));
        System.out.println(new BasicCalculatorII().calculate("0"));
        System.out.println(new BasicCalculatorII().calculate("1 + 1"));
        System.out.println(new BasicCalculatorII().calculate("1-1+1"));
        System.out.println(new BasicCalculatorII().calculate("2*3+4"));
    }
}
