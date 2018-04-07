package detail;

import java.util.*;

public class UniqueMorseCodeWords {
    // 利用HashMap来进行去重
    public int uniqueMorseRepresentations(String[] words) {
        String[] alph = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        HashSet<String> set = new HashSet<String>();

        for (int i = 0; i < words.length; i++) {
            String cur = "";
            for (int j = 0; j < words[i].length(); j++) {
                cur += alph[words[i].charAt(j) - 'a'];
            }
            set.add(cur);
        }
        return set.size();
    }
}