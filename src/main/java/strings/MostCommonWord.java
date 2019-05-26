package strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedWords = new HashSet<>();
        for (String word : banned) {
            bannedWords.add(word);
        }
        HashMap<String, Integer> dict = new HashMap<>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < paragraph.length(); i++) {
            if (paragraph.charAt(i) == '?' || paragraph.charAt(i) == '!' || paragraph.charAt(i) == '.' ||
                    paragraph.charAt(i) == ';' || paragraph.charAt(i) == '\'' || paragraph.charAt(i) == ',') {
                sb.append(' ');
            } else {
                sb.append(paragraph.charAt(i));
            }
        }
        paragraph = sb.toString();

        String[] words = paragraph.split(" ");
        for (String word : words) {
            word.trim();
            if (word.length() == 0) {
                continue;
            }
            word = word.toLowerCase();
            if (bannedWords.contains(word)) {
                continue;
            }
            if (!dict.containsKey(word)) {
                dict.put(word, 1);
            } else {
                dict.put(word, dict.get(word) + 1);
            }
        }

        int max = 0;
        String ret = "";
        for (String key : dict.keySet()) {
            if (max < dict.get(key)) {
                max = dict.get(key);
                ret = key;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new MostCommonWord().mostCommonWord("a, a, a, a, b,b,b,c, c", new String[]{"a"}));
    }
}
