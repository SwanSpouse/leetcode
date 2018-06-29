package dfs;

import utils.Print;

import java.util.ArrayList;
import java.util.List;

/**
 * dfs变型题。其中判断palindrome的方法还可以继续优化。
 */
public class PalindromePartitioning {
    public static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void dfs(List<List<String>> ret, List<String> cur, String s) {
        if (s.length() == 0) {
            ret.add(new ArrayList<String>(cur));
            return;
        }
        for (int i = 1; i < s.length(); i++) {
            String firstPart = s.substring(0, i);
            if (isPalindrome(firstPart)) {
                String leftPart = s.substring(i, s.length());
                cur.add(firstPart);
                dfs(ret, cur, leftPart);
                cur.remove(cur.size() - 1);
            }
        }
        if (isPalindrome(s)) {
            cur.add(s);
            ret.add(new ArrayList<String>(cur));
            cur.remove(cur.size() - 1);
        }
    }

    public static List<List<String>> partition(String s) {
        ArrayList<List<String>> ret = new ArrayList<List<String>>();
        if (s.length() == 0) {
            return ret;
        }
        ArrayList<String> cur = new ArrayList<String>();
        dfs(ret, cur, s);
        return ret;
    }

    public static void main(String[] args) {
        List<List<String>> ret = partition("abb");
        for (List list : ret) {
            Print.PrintList(list);
        }
    }
}
