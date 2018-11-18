package strings;

import java.util.HashMap;

public class LongestPalindrome {

    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        boolean containsOdd = false;
        int length = 0;
        for (Character c : map.keySet()) {
            int cur = map.get(c);
            if (cur % 2 == 0) {
                length += cur;
            } else {
                length += cur - 1;
                containsOdd = true;
            }
        }
        return containsOdd == true ? length + 1 : length;
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome(""));
        System.out.println(new LongestPalindrome().longestPalindrome("abccccdd"));
    }
}
