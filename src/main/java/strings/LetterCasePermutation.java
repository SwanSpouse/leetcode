package strings;

import java.util.*;

public class LetterCasePermutation {
    public void generate(HashSet<String> set, int length, int index) {
        if (index >= length) {
            return;
        }
        for (String cur : set) {
            StringBuffer sb = new StringBuffer(cur);
            if ('a' <= sb.charAt(index) && sb.charAt(index) <= 'z') {
                set.add(sb.toString());
                sb.setCharAt(index, (char) (sb.charAt(index) - 'a' + 'A'));
                set.add(sb.toString());
            } else if ('A' <= sb.charAt(index) && sb.charAt(index) <= 'Z') {
                set.add(sb.toString());
                sb.setCharAt(index, (char) (sb.charAt(index) - 'A' + 'a'));
                set.add(sb.toString());
            }
        }
        generate(set, length, index + 1);
    }

    public List<String> letterCasePermutation(String S) {
        List<String> ret = new ArrayList<String>();
        HashSet<String> set = new HashSet<String>();
        set.add(S);
        generate(set, S.length(), 0);

        for (String item : set) {
            ret.add(item);
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new LetterCasePermutation().letterCasePermutation("a1b2"));
    }
}
