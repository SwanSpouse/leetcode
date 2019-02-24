package strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LetterCasePermutation {

    public void dfs(HashSet<String> set, StringBuffer sb, int index) {
        if (index >= sb.length()) {
            return;
        }
        set.add(sb.toString());
        if (sb.charAt(index) >= 'a' && sb.charAt(index) <= 'z') {
            dfs(set, sb, index + 1);
            int diff = 'A' - 'a';
            sb.setCharAt(index, (char) (sb.charAt(index) + diff));
            set.add(sb.toString());
            dfs(set, sb, index + 1);
            sb.setCharAt(index, (char) (sb.charAt(index) - diff));
        } else if (sb.charAt(index) >= 'A' && sb.charAt(index) <= 'Z') {
            dfs(set, sb, index + 1);
            int diff = 'a' - 'A';
            sb.setCharAt(index, (char) (sb.charAt(index) + diff));
            set.add(sb.toString());
            dfs(set, sb, index + 1);
            sb.setCharAt(index, (char) (sb.charAt(index) - diff));
        } else {
            dfs(set, sb, index + 1);
        }
    }


    public List<String> letterCasePermutation(String S) {
        List<String> ret = new ArrayList<String>();
        HashSet<String> set = new HashSet<String>();

        set.add(S);
        dfs(set, new StringBuffer(S), 0);

        for (String item : set) {
            ret.add(item);
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new LetterCasePermutation().letterCasePermutation("a1b2"));
        System.out.println(new LetterCasePermutation().letterCasePermutation("A1b2"));
    }
}
