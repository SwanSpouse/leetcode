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

    // 这个质数数组巧妙
    private static final int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};

    public String shortestCompletingWord2(String licensePlate, String[] words) {
        long charProduct = getCharProduct(licensePlate.toLowerCase());
        String shortest = "aaaaaaaaaaaaaaaaaaaa"; // 16 a's
        for(String word : words)
            if (word.length() < shortest.length() && getCharProduct(word) % charProduct == 0)
                shortest = word;
        return shortest;
    }

    private long getCharProduct(String plate) {
        long product = 1L;
        for(char c : plate.toCharArray()) {
            int index = c - 'a';
            if (0 <= index && index <= 25)
                product *= primes[index];
        }
        return product;
    }
}
