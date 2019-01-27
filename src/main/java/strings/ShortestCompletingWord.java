package strings;

import java.util.Arrays;

public class ShortestCompletingWord {

    public boolean isCompletingWord(String word, int[] dict) {
        for (int i = 0; i < word.length(); i++) {
            if ('a' <= word.charAt(i) && word.charAt(i) <= 'z') {
                dict[word.charAt(i) - 'a'] -= 1;
            } else if ('A' <= word.charAt(i) && word.charAt(i) <= 'Z') {
                dict[word.charAt(i) - 'A'] -= 1;
            }
        }
        for (int i = 0; i < dict.length; i++) {
            if (dict[i] > 0) {
                return false;
            }
        }
        return true;
    }

    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] dict = new int[26];
        for (int i = 0; i < licensePlate.length(); i++) {
            if ('a' <= licensePlate.charAt(i) && licensePlate.charAt(i) <= 'z') {
                dict[licensePlate.charAt(i) - 'a'] += 1;
            } else if ('A' <= licensePlate.charAt(i) && licensePlate.charAt(i) <= 'Z') {
                dict[licensePlate.charAt(i) - 'A'] += 1;
            }
        }
        String ret = "";
        for (String word : words) {
            if (ret.length() == 0 || ret.length() > word.length()) {
                if (isCompletingWord(word, Arrays.copyOfRange(dict, 0, dict.length))) {
                    ret = word;
                }
            }
        }
        return ret;
    }
}
