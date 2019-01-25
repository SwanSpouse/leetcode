package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString {

    public boolean isSame(char[] a1, char[] a2) {
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i]) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        char[] pArr = p.toCharArray();
        Arrays.sort(pArr);

        ArrayList<Integer> ret = new ArrayList<>();
        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            char[] sub = s.substring(i, i + p.length()).toCharArray();
            Arrays.sort(sub);
            if (isSame(sub, pArr)) {
                ret.add(i);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new FindAllAnagramsInAString().findAnagrams("cbaebabacd", "abc"));
        System.out.println(new FindAllAnagramsInAString().findAnagrams("abab", "ab"));
    }
}
