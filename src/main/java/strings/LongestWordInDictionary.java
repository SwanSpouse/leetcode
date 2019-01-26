package strings;

import java.util.Arrays;
import java.util.HashSet;

public class LongestWordInDictionary {

    public String longestWord(String[] words) {
        Arrays.sort(words);
        String maxLengthStr = "";
        HashSet<String> dict = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == 1) {
                maxLengthStr = words[i].length() <= maxLengthStr.length() ? maxLengthStr : words[i];
                dict.add(words[i]);
            } else if (dict.contains(words[i].substring(0, words[i].length() - 1))) {
                maxLengthStr = words[i].length() <= maxLengthStr.length() ? maxLengthStr : words[i];
                dict.add(words[i]);
            }
        }
        return maxLengthStr;
    }

    public static void main(String[] args) {
        System.out.println(new LongestWordInDictionary().longestWord(new String[]{"ts","e","x","pbhj","opto","xhigy","erikz","pbh","opt","erikzb","eri","erik","xlye","xhig","optoj","optoje","xly","pb","xhi","x","o"}));
    }
}


