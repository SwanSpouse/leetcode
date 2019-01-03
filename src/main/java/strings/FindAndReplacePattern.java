package strings;

import utils.Print;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class FindAndReplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ret = new ArrayList<>();
        if (words.length == 0) {
            return ret;
        }

        for (String word : words) {
            HashMap<Character, Character> dict = new HashMap<>();
            HashSet<Character> set = new HashSet<>();
            int i;
            for (i = 0; i < word.length(); i++) {
                if (!dict.containsKey(word.charAt(i))) {
                    if (set.contains(pattern.charAt(i))) {
                        break;
                    }
                    dict.put(word.charAt(i), pattern.charAt(i));
                    set.add(pattern.charAt(i));
                } else {
                    if (dict.get(word.charAt(i)) != pattern.charAt(i)) {
                        break;
                    }
                }
            }
            if (i == word.length()) {
                ret.add(word);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Print.printList(new FindAndReplacePattern().findAndReplacePattern(new String[]{"Abb", "deq", "mee", "aqq", "dkd", "ccc"}, "abb"));
    }
}
