package strings;

public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }
        int maxLen = 0;
        String ret = "";
        // 找 bab型
        for (int i = 0; i < s.length(); i++) {
            String cur = "" + s.charAt(i);
            int curLen = 1;
            for (int offset = 1; i + offset < s.length() && i - offset >= 0; offset++) {
                if (s.charAt(i - offset) != s.charAt(i + offset)) {
                    break;
                }
                cur = s.charAt(i - offset) + cur + s.charAt(i + offset);
                curLen += 2;
            }
            if (curLen > maxLen) {
                maxLen = curLen;
                ret = cur;
            }
        }
        if (s.length() == 1) {
            return ret;
        }
        // 找 abba型
        for (int i = 0, j = i + 1; j < s.length(); i++, j++) {
            if (s.charAt(i) != s.charAt(j)) {
                continue;
            }
            String cur = "" + s.charAt(i) + s.charAt(j);
            int curLen = 2;
            for (int offset = 1; i - offset >= 0 && j + offset < s.length(); offset++) {
                if (s.charAt(i - offset) != s.charAt(j + offset)) {
                    break;
                }
                cur = s.charAt(i - offset) + cur + s.charAt(j + offset);
                curLen += 2;
            }
            if (curLen > maxLen) {
                maxLen = curLen;
                ret = cur;
            }
        }
        return ret;
    }
}
