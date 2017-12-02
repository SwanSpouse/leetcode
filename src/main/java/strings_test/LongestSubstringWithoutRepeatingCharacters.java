package strings_test;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> position = new HashMap<Character, Integer>();
        int maxLen = 0, curLen = 0;
        for (int i=0; i < s.length(); i ++ ) {
            if (position.containsKey(s.charAt(i))) {
                maxLen = maxLen > curLen ? maxLen : curLen;
                i = position.get(s.charAt(i)) + 1;
                position.clear();
                curLen = 1;
            } else {
                curLen += 1;
            }
            position.put(s.charAt(i), i);
        }
        return maxLen > curLen ? maxLen : curLen;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
