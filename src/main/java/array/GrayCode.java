package array;


import utils.Print;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 利用HashMap来记录出现的就好了。
 */
public class GrayCode {

    public static List<Integer> convertStringListToIntegerList(List<String> input) {
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < input.size(); i++) {
            int cur = 1;
            int curRet = 0;
            for (int index = 0; index < input.get(i).length(); index++) {
                curRet = curRet + cur * (input.get(i).charAt(index) - '0');
                cur = cur * 2;
            }
            ret.add(curRet);
        }
        return ret;
    }

    public static String nextGrayCode(String last, HashSet<String> visited) {
        StringBuffer input = new StringBuffer(last);
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '0') {
                input.setCharAt(i, '1');
            } else {
                input.setCharAt(i, '0');
            }
            if (!visited.contains(input.toString())) {
                visited.add(input.toString());
                return input.toString();
            }
            if (input.charAt(i) == '0') {
                input.setCharAt(i, '1');
            } else {
                input.setCharAt(i, '0');
            }
        }
        return "";
    }

    public static List<Integer> generateGrayCode(String input) {
        HashSet<String> visited = new HashSet<String>();
        List<String> ret = new LinkedList<String>();

        String cur = input;
        visited.add(cur);

        for (int i = 0; i < Math.pow(2, input.length()); i++) {
            ret.add(cur);
            cur = nextGrayCode(cur, visited);
        }
        return convertStringListToIntegerList(ret);
    }

    public static List<Integer> grayCode(int n) {
        String start = "";
        for (int i = 0; i < n; i++) {
            start += "0";
        }
        return generateGrayCode(start);
    }

    public static void main(String[] args) {
        Print.PrintList(grayCode(5));
        Print.PrintList(grayCode(0));
    }
}
