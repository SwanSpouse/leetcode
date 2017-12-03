package strings;

public class RegularExpressionMatching {

    /**
     * s: a*b*c*
     * p: aab
     */

    public static boolean isMatch(String s, String p) {
        if (p.equals(s)) {
            return true;
        }
        if (p.length() == 0) {
            return s.length() == 0;
        }
        if (p.length() == 1) {
            return s.length() == 1 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');
        }
        if (p.charAt(1) == '*') {
            // 相等或者不相等 1. 把a*过滤掉
            // 相等             2. 吞掉p的一个a
            // 相等             3. 过滤a*, 同时吞掉一个a
            if (s.length() == 0) {
                return isMatch(s, p.substring(2, p.length()));
            }
            if (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0)) {
                return isMatch(s, p.substring(2, p.length())) || isMatch(s.substring(1, s.length()), p) || isMatch(s.substring(1, s.length()), p.substring(2, p.length()));
            } else {
                return isMatch(s, p.substring(2, p.length()));
            }
        } else {
            if (s.length() == 0) {
                return false;
            }
            if (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0)) {
                return isMatch(s.substring(1, s.length()), p.substring(1, p.length()));
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a*"));
    }
}
